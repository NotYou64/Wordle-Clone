

with open("filtered_words.txt", "r") as file:
    text = file.read()

words = ""
for word in text.split("\n"):
    words += word.upper() + "\n"

with open("filtered_words.txt", "w") as file:
    file.write(words)