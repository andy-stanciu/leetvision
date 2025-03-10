import requests
import base64
import json
from constants import *

def main():
    image_path = "images/two-sum.jpg"
    
    try:
        with open(image_path, "rb") as image_file:
            encoded_image = base64.b64encode(image_file.read()).decode("utf-8")
    except Exception as e:
        print(f"Error reading image file: {e}")
        return

    payload = {"image": encoded_image}
    url = f"http://{HOST}:{PORT}/classify"
    
    try:
        response = requests.post(url, json=payload)
        response.raise_for_status()
    except Exception as e:
        print(f"Request failed: {e}")
        return

    try:
        data = response.json()
        print("Response from server:")
        print(json.dumps(data, indent=4))
    except Exception as e:
        print(f"Error parsing JSON response: {e}")

if __name__ == "__main__":
    main()