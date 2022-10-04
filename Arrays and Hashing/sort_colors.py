"""
    75. Sort Colors

    Given an array nums with n objects colored red, white, or blue,
    sort them in-place so that objects of the same color are adjacent,
    with the colors in the order red, white, and blue.

    We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
    You must solve this problem without using the library's sort function.
"""
from typing import List


# loop through the list and register how many 0s, 1s and 2s are contained
# we could use a helper list with indices mapped to the "color" values
# and storing the counts at those indices
# finally fill the list with the corresponding amount of "color" numbers in ascending order

def sort_colors(arr: List[int]) -> None:
    counter = [0] * 3
    for n in arr:
        counter[n] += 1

    i = 0
    for c in range(len(counter)):
        while counter[c] > 0:
            arr[i] = c
            i += 1
            counter[c] -= 1


if __name__ == '__main__':
    nums = [2, 0, 2, 1, 1, 0]
    sort_colors(nums)
    print(nums)
