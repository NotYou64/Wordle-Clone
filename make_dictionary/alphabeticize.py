

with open("valid_words.txt", "r") as file:
    text = file.read()

words = []
for word in text.split("\n"):
    words.append(word.upper())

words.sort()

new_text = ""
for word in words:
    new_text += word + "\n"

with open("valid_words.txt", "w") as file:
    file.write(new_text)