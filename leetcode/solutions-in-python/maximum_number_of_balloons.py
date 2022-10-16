"""
    1189. Maximum Number of Balloons

    Given a string text, you want to use the characters of text
    to form as many instances of the word "balloon" as possible.
    You can use each character in text at most once. Return the maximum number of instances
    that can be formed.
"""


def process_list(string: str) -> int:
    counts = {'b': 0, 'a': 0, 'l': 0, 'o': 0, 'n': 0}
    for ch in string:
        if ch in counts:
            counts[ch] += 1

    if 0 in counts.values():
        return 0
    min_val = min(counts.values())
    if (counts['l'] == min_val or counts['o'] == min_val) \
            or (counts['l'] < min_val * 2 or counts['o'] < min_val * 2):
        return min(counts["l"], counts["o"]) // 2
    return min_val


def process_list_opt(string: str) -> int:
    counts = {'b': 0, 'a': 0, 'l': 0, 'o': 0, 'n': 0}
    for ch in string:
        if ch in counts:
            counts[ch] += 1
    counts['l'] //= 2
    counts['o'] //= 2
    x = min(counts.values())
    return x


if __name__ == '__main__':
    text = "nlaebolko"
    # text = "leetcode"
    # text = "loonbalxballpoon"
    # text = "hpitp"
    # text = "balllllllllllloooooooooon"
    # text = "lloo"
    print(process_list_opt(text))
