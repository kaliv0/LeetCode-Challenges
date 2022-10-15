"""
    14. Longest Common Prefix

    Write a function to find the longest common prefix string amongst an array of strings.
    If there is no common prefix, return an empty string "".
"""


def extract(arr: [str]) -> str:
    first_word = arr[0]
    prefix = ""
    flag = False
    for i, v in enumerate(first_word):
        for j in range(1, len(arr)):
            curr_word = arr[j]
            if len(curr_word) == i or curr_word[i] != v:
                flag = True
                break
        if flag:
            break
        prefix += v
    return prefix


if __name__ == '__main__':
    strs = ["flower", "flow", "flight"]
    # strs = ["dog", "racecar", "car"]
    # strs = ["ab", "a"]
    print(extract(strs))
