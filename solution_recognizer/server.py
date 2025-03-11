from flask import Flask, request, jsonify
import os
import uuid
import base64
import io
from PIL import Image
from Phase1_CRAFTSegmentation import phase1
from Phase2_TesseractRecognition import phase2
from Phase3_LLMTextRepair import phase3

app = Flask(__name__)
SERVER_FOLDER = "server"
os.makedirs(SERVER_FOLDER, exist_ok=True)

@app.route("/recognize", methods=["POST"])
def recognize():
    try:
        data = request.get_json()
        if "image" not in data:
            return jsonify({"error": "No image provided"}), 400
    
        image_data = base64.b64decode(data["image"])
        image_id = str(uuid.uuid4())
        image_path = os.path.join(SERVER_FOLDER, f"{image_id}.png")
        
        with open(image_path, "wb") as f:
            f.write(image_data)

        # Phase 1: Segmentation
        phase1(image_path)
        
        # Phase 2: OCR Recognition
        raw_ocr_text = phase2(image_id)

        # Phase 3: Text Repair
        result = phase3(raw_ocr_text)
        
        return jsonify({"recognized_text": result})
    
    except Exception as e:
        return jsonify({"error": str(e)}), 500
    
    finally:
        if os.path.exists(image_path):
            os.remove(image_path)

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)