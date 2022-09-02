# https://i.redd.it/xbodtib6fq551.png
# https://pillow.readthedocs.io/en/stable/
from PIL import Image
import requests

url = "https://i.redd.it/xbodtib6fq551.png"
response = requests.get(url)
thing = open("i.redd.it", "wb")
print(thing)
thing.write(response.content)

png = Image.open("i.redd.it")
img = png.convert('RGB')
print(img.size)
width, height = img.size

px = img.load()
print(px)
for i in range(0, width, 4):
    for j in range(0, height, 4):
        r, g, b = img.getpixel((i, j))
        if (r == 255 and g == 0 and b == 0):
            print([i, j])

# px[4, 4] = (255, 0, 0)
# print(px[4, 4])
