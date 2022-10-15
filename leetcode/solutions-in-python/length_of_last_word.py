"""
    58. Length of Last Word

    Given a string s consisting of words and spaces,
    return the length of the last word in the string.
    A word is a maximal substring consisting of non-space characters only.
"""


def find_count(sentence: str) -> int:
    counter = 0
    # loop backwards since you only need to count the last word
    # increment the counter with every letter you "step" on
    # if you reach an empty string and the counter is greater than zero
    # you have reached the word boundary, and you should break out of the loop
    # if some reason you loop through the entire sentence
    # this means there is only one word or no words at all
    for i in range(len(sentence) - 1, -1, -1):
        if sentence[i] == " " and counter != 0:
            break
        if sentence[i] != " ":
            counter += 1
    return counter


if __name__ == '__main__':
    # s = "   fly me   to   the moon  "
    # s = "Hello World"
    s = "a"

    res = find_count(s)
    print(res)
