# Cole Delong
# reading xlsx files
# 3-4-22

import openpyxl

alphabet = "abcdefghijklmnopqrstuvwxyz"

def main():

    # open the word freq xlsx file
    xlsx = openpyxl.load_workbook("wordFrequency.xlsx")

    # get the first sheet with the words on it
    lemmas = xlsx.get_sheet_by_name("1 lemmas")

    # put each 5 letter word on its own line in a string
    text = ""
    for i in range(5050):

        is_valid = True

        word = str(lemmas.cell(row = i+1, column = 2).value)

        # make sure da characters are all letters
        for letter in word:
            if letter not in alphabet:
                is_valid = False

        if len(word) == 5 and is_valid:
            text += word + '\n'

    # create a text file with the chosen words in it
    filtered_words = open("filtered_words.txt", "w")
    filtered_words.write(text)
    filtered_words.close()


main()