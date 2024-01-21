import random
import string
def generate():
    var = random.randint(0,2)
    if var == 0:
        return random.randint(0,10)
    if var == 1:
        return random.random()
    else:
        letters = string.ascii_lowercase
        return ''.join(random.choice(letters) for i in range(5))


with open("test3", "w") as f:
    for i in range(1000000):
        f.write(str(generate()) + "\n")
print("END")

    