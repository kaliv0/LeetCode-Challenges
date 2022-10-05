"""
    392. Is Subsequence

    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    A subsequence of a string is a new string that is formed from the original string
    by deleting some (can be none) of the characters without disturbing the relative positions
    of the remaining characters.
    (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
"""


def validate_strings(x: str, y: str) -> bool:
    if len(x) == 0:
        return True
    if len(x) > len(y) or len(y) == 0:
        return False

    # loop through both strings in parallel
    # if the letters are equal move both counters, otherwise only the counter for the "parent" string
    # at the end check if the "substring" counter has reached the end of the child strings
    
    i = 0
    j = 0
    while i < len(x) and j < len(y):
        if x[i] == y[j]:
            i += 1
        j += 1

    return i == len(x)


if __name__ == "__main__":
    # s = "abc"
    # t = "ahbgdc"

    # s = "axc"
    # t = "ahbgdc"

    s = "b"
    t = "abc"

    print(validate_strings(s, t))
