from flask import Flask, request, jsonify
import base64
from io import BytesIO
from PIL import Image
from solution_recognizer import ocr
from constants import *
from solution_classifier.model import classifier
from leetcode_client.leetcode_client import LeetCodeClient
import time

app = Flask(__name__)

@app.route("/execute", methods=["POST"])
def execute():
    try:
        data = request.get_json()
        required_keys = ["code", "language", "question", "question_id", "csrftoken", "cf_clearance", "LEETCODE_SESSION"]
        if not all(key in data for key in required_keys):
            return jsonify({
                "error": "Missing required parameters: code, language, question, question_id, csrftoken, cf_clearance, LEETCODE_SESSION"
            }), 400

        code = data["code"]
        language = data["language"]
        question = data["question"]
        question_id = data["question_id"]
        csrftoken = data["csrftoken"]
        cf_clearance = data["cf_clearance"]
        leetcode_session = data["LEETCODE_SESSION"]

        leetcode_client = LeetCodeClient(leetcode_session=leetcode_session, 
                                         cf_clearance=cf_clearance, 
                                         csrftoken=csrftoken)
        
        # Call the submit_solution function with all parameters
        success, submission_result = leetcode_client.submit_solution(question, 
                                                                 question_id, 
                                                                 language, 
                                                                 code, 
                                                                 verbose=True)
        
        if not success:
            return jsonify({
                "error": "Failed to submit solution",
                "reason": submission_result
            }), 500
        
        valid_result, submission_details = False, None
        while not valid_result:
            time.sleep(2) # await for the solution to execute

            success, submission_details = leetcode_client.view_solution(submission_result, verbose=True)
        
            if not success:
                return jsonify({
                    "error": "Failed to view submission details",
                    "reason": submission_details
                }), 500
            
            if 'data' in submission_details and \
                'submissionDetails' in submission_details['data'] and \
                'runtime' in submission_details['data']['submissionDetails']:
                
                details = submission_details['data']['submissionDetails']
                if details['runtime'] is not None: # solution execution done
                    valid_result = True

        return jsonify(submission_details), 200

    except Exception as e:
        print(e)
        return jsonify({
            "error": str(e)
        }), 500

@app.route("/classify", methods=["POST"])
def classify():
    try:
        data = request.get_json()
        provided_image = "image" in data
        provided_code = "code" in data and "language" in data

        if not provided_image and not provided_code:
            return jsonify({
                "error": "No image or code provided"
            }), 400

        language, code_block, escaped_code_block = None, None, None

        if provided_image:
            image_data = base64.b64decode(data["image"])
            image_stream = BytesIO(image_data)
            image = Image.open(image_stream)

            # step 1: ocr
            text = ocr.extract_text(image, OCR_PROMPT, verbose=True)

            # step 2: extract code blocks (should be only one)
            code_blocks = ocr.extract_code_block(text)
            if len(code_blocks) == 0:
                return jsonify({
                    "error": "Failed to detect code"
                }), 411
            
            for lang, code in code_blocks:
                language = ocr.map_language(lang)
                code_block = code
                escaped_code_block = ocr.escape_code(code)
                break  # one iteration
        else:
            language = data['language']
            code_block = ocr.unescape_code(data['code'])
            escaped_code_block = data['code']

        # step 3: parse solution as ast graph edges
        success, parse_result = classifier.parse_code_block(escaped_code_block)
        if not success or not parse_result:
            return jsonify({
                "error": "Code failed to parse",
                "reason": parse_result,
                "code": code_block,
                "language": language
            }), 412
        
        # step 4: classify solution with knn
        solution_vec = classifier.vectorize_edges(parse_result, verbose=True)
        questions = classifier.predict_question(solution_vec, verbose=True)
        question_ids = classifier.map_questions(questions)

        return jsonify({
            "code": code_block,
            "language": language,
            "questions": [
                {"question": question, "id": id_value}
                for question, id_value in question_ids
            ]
        }), 200

    except Exception as e:
        print(e)
        return jsonify({
            "error": str(e)
        }), 500

if __name__ == "__main__":
    app.run(host=HOST, port=PORT)