import requests
import base64
import json
from constants import HOST, PORT

def main():
    image_path = "images/two-sum.jpg"
    
    try:
        with open(image_path, "rb") as image_file:
            encoded_image = base64.b64encode(image_file.read()).decode("utf-8")
    except Exception as e:
        print(f"Error reading image file: {e}")
        return

    payload = {"image": encoded_image}
    classify_url = f"http://{HOST}:{PORT}/classify"
    
    try:
        response = requests.post(classify_url, json=payload)
        response.raise_for_status()
    except Exception as e:
        print(f"Request to classify failed: {e}")
        return

    try:
        data = response.json()
        print("Response from server (classify):")
        print(json.dumps(data, indent=4))
    except Exception as e:
        print(f"Error parsing JSON response from classify: {e}")
        return

    # Ensure there is at least one question in the response
    if "questions" not in data or not data["questions"]:
        print("No questions found in the classify response")
        return

    # Extract required values from the classify response
    first_question = data["questions"][0]
    code = data.get("code")
    language = data.get("language")
    question = first_question.get("question")
    question_id = first_question.get("id")

    # Prepare payload for the execute endpoint
    execute_payload = {
        "code": code,
        "language": language,
        "question": question,
        "question_id": question_id
    }
    execute_url = f"http://{HOST}:{PORT}/execute"
    
    # Call the execute endpoint
    try:
        execute_response = requests.post(execute_url, json=execute_payload)
        execute_response.raise_for_status()
    except Exception as e:
        print(f"Request to execute failed: {e}")
        return

    # Parse the execute response
    try:
        execute_data = execute_response.json()
        print("Response from server (execute):")
        print(json.dumps(execute_data, indent=4))
    except Exception as e:
        print(f"Error parsing JSON response from execute: {e}")

if __name__ == "__main__":
    main()