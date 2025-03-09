import google.generativeai as genai
from PIL import Image
import os

# Configure API Key
genai.configure(api_key=os.getenv("GEMINI_KEY"))

# Load your image
image_path = "./sample-images/two-sum.jpg"
image = Image.open(image_path)

# Initialize the updated Gemini model
model = genai.GenerativeModel("gemini-1.5-flash")

# Generate content (extract text from image)
response = model.generate_content([image, "Extract text from this image."])

# Print extracted text
print(response.text)