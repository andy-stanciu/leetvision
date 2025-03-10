from flask import Flask, request, jsonify
import base64
from io import BytesIO
from PIL import Image
from solution_recognizer import ocr
from constants import *
from solution_classifier.model import classifier, model_constants

app = Flask(__name__)


@app.route("/classify", methods=["POST"])
def classify():
    try:
        data = request.get_json()
        if "image" not in data:
            return jsonify({"error": "No image provided"}), 400

        image_data = base64.b64decode(data["image"])
        image_stream = BytesIO(image_data)
        image = Image.open(image_stream)

        # step 1: ocr
        text = ocr.extract_text(image, OCR_PROMPT, verbose=True)

        # step 2: extract code blocks (should be only one)
        code_blocks = ocr.extract_code_block(text)
        if len(code_blocks) == 0:
            raise RuntimeError("Unexpected OCR failure")
        
        language, code_block, escaped_code_block = None, None, None
        for lang, code in code_blocks:
            language = lang.lower()
            code_block = code
            escaped_code_block = ocr.escape_code(code)
            break  # one iteration

        # step 3: parse solution as ast graph edges
        edges = classifier.parse_code_block(escaped_code_block)

        if edges is None:
            raise RuntimeError("Unexpected parser failure")
        
        # step 4: classify solution with knn
        solution_vec = classifier.vectorize_edges(edges, verbose=True)
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
        return jsonify({"error": str(e)}), 500

if __name__ == "__main__":
    app.run(host=HOST, port=PORT)