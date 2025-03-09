import os
from Phase1_CRAFTSegmentation import phase1
from Phase2_TesseractRecognition import phase2
from Phase3_LLMTextRepair import phase3

image_path = "two-sum.jpg" 

image_name, image_extension = os.path.splitext(image_path)

# Phase 1: Run Phase1_CRAFTSegmentation.py
phase1("sample-images/" + image_path)

# Phase 2: Run Phase2_TesseractRecognition.py
raw_ocr_text = phase2(image_name)

print("\nResult of OCR\n")
print("#############################")
print(raw_ocr_text)
print("#############################\n")

# Phase 3
result = phase3(raw_ocr_text)

print("\nResult of code recognition\n")
print("#############################")
print(result)
print("#############################\n")