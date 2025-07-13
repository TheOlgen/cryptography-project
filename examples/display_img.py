import matplotlib.pyplot as plt
import imageio
import sys
import os

if len(sys.argv) < 2:
    print("Usage: python display_img.py <decrypted_file.ppm>")
    sys.exit(1)

filename = sys.argv[1]

if not os.path.exists(filename):
    print(f"File '{filename}' not found.")
    sys.exit(1)

try:
    img = imageio.imread(filename, format='PPM')
    plt.imshow(img)
    plt.axis('off')
    plt.title(f"Viewing: {os.path.basename(filename)}")
    plt.show()
except Exception as e:
    print(f"Failed to load image: {e}")
