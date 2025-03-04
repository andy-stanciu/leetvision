import base64
import requests
import json
import os

IMAGE_NAME = "handwritten2.jpg"

script_dir = os.path.dirname(os.path.abspath(__file__))
image_path = os.path.abspath(os.path.join(script_dir, "./sample-images/" + IMAGE_NAME))

with open(image_path, "rb") as image_file:
    encoded_string = base64.b64encode(image_file.read()).decode("utf-8")

url = "http://localhost:5000/recognize"

data = json.dumps({"image": encoded_string})
headers = {"Content-Type": "application/json"}
response = requests.post(url, data=data, headers=headers)

print(response.json())