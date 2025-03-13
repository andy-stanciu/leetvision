import os
from PIL import Image, ImageDraw, ImageFont

def convert_txt_to_image(input_folder, output_folder):
    """
    Converts text files in input_folder to images and saves them in output_folder.

    Args:
        input_folder (str): Path to the folder containing text files.
        output_folder (str): Path to the folder to save image files.
    """

    if not os.path.exists(output_folder):
        os.makedirs(output_folder)

    for filename in os.listdir(input_folder):
        if filename.endswith(".txt"):
            input_path = os.path.join(input_folder, filename)
            output_path = os.path.join(output_folder, os.path.splitext(filename)[0] + ".png")

            try:
                with open(input_path, "r", encoding="utf-8") as f:
                    text = f.read()

                # Basic image settings
                font_size = 20
                font = ImageFont.load_default() #Load default font.

                # Calculate text size and image dimensions
                lines = text.splitlines()
                max_width = 0
                total_height = 0

                for line in lines:
                    bbox = font.getbbox(line)
                    text_width = bbox[2] - bbox[0]
                    text_height = bbox[3] - bbox[1]
                    max_width = max(max_width, text_width)
                    total_height += text_height + 5  # Add some spacing between lines

                image_width = max_width + 20  # Add padding
                image_height = total_height + 20 # Add padding

                # Create image
                img = Image.new("RGB", (image_width, image_height), color="white")
                draw = ImageDraw.Draw(img)

                # Draw text
                y = 10
                for line in lines:
                    draw.text((10, y), line, font=font, fill="black")
                    _, text_height = font.getsize(line)
                    y += text_height + 5

                # Save image
                img.save(output_path)
                print(output_path)
                print(f"Converted {filename} to {os.path.basename(output_path)}")

            except Exception as e:
                print(f"Error processing {filename}: {e}")

if __name__ == "__main__":
    current_dir = os.path.dirname(os.path.abspath(__file__))
    input_folder = os.path.join(current_dir, "test_text")
    output_folder = os.path.join(current_dir, "test_images")

    convert_txt_to_image(input_folder, output_folder)