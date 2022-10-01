"""
    49. Group anagrams

    Given an array of strings strs, group the anagrams together.
    You can return the answer in any order.
"""

# loop through given strings, put sorted string as key in dict and all anagrams as values

strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
# strs = ["a"]
anagrams = {}
for s in strs:
    sorted_str = str(sorted(s))
    if sorted_str not in anagrams:
        anagrams[sorted_str] = []
    anagrams[sorted_str].append(s)

print([val for val in anagrams.values()])
