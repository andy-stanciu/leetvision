import os
import random
import traceback
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
        if filename.endswith('.txt'):
            # Load a font, or use default if no font files found
            font_size = 20
            font = ImageFont.load_default()
            font_dir = os.path.dirname(os.path.abspath(__file__)) + '/fonts'
            font_files = [f for f in os.listdir(font_dir) if f.endswith(('.ttf', '.otf'))]
            if font_files:
                random_font_file = random.choice(font_files)
                font = ImageFont.truetype(os.path.join(font_dir, random_font_file), font_size)

            input_path = os.path.join(input_folder, filename)
            output_path = os.path.join(output_folder, f'{font.getname()[0]}_{random.randint(1, 9999999999)}.png')

            try:
                with open(input_path, 'r', encoding='utf-8') as f:
                    text = f.read()

                # Calculate text size and image dimensions
                lines = text.splitlines()
                max_width = 0
                total_height = 0

                for line in lines:
                    bbox = font.getbbox(line)
                    text_width = bbox[2] - bbox[0]
                    text_height = bbox[3] - bbox[1]
                    max_width = max(max_width, text_width)
                    total_height += text_height + 5  # Add spacing between lines

                # Add padding
                padding = 20
                image_width = max_width + padding * 2
                image_height = total_height + padding * 2

                # Create image
                img = Image.new('RGB', (image_width, image_height), color='white')
                draw = ImageDraw.Draw(img)

                # Draw text
                y = padding
                for line in lines:
                    draw.text((padding, y), line, font=font, fill='black')
                    bbox = font.getbbox(line)
                    text_height = bbox[3] - bbox[1]
                    y += text_height + 5

                # Save image
                img.save(output_path)
                print(f'Converted {filename} to {os.path.basename(output_path)}')

            except Exception as e:
                print(f'Error processing {filename}: {e}')
                print(traceback.format_exc())


if __name__ == '__main__':
    current_dir = os.path.dirname(os.path.abspath(__file__))
    input_folder = os.path.join(current_dir, 'test_text')
    output_folder = os.path.join(current_dir, 'test_images')

    convert_txt_to_image(input_folder, output_folder)
