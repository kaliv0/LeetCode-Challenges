"""
    1299. Replace Elements with Greatest Element on Right Side

    Given an array arr, replace every element in that array
    with the greatest element among the elements to its right,
    and replace the last element with -1.
    After doing so, return the array.
"""
from typing import List


def replace_elements(arr: List[int]) -> List[int]:
    # it's guaranteed that the array will contain at least 1 element
    # if len(arr) == 1:
    #     return [-1]
    #
    # for i in range(len(arr) - 1):
    #     arr[i] = max(arr[i + 1:])
    # arr[-1] = -1
    # return arr

    # other approach looping backwards
    if len(arr) == 1:
        return [-1]

    max_val = arr[-1]
    arr[-1] = -1

    for i in range(len(arr) - 2, -1, -1):
        curr_val = arr[i]
        arr[i] = max_val
        max_val = max(curr_val, max_val)
    return arr


if __name__ == "__main__":
    # arr = [17, 18, 5, 4, 6, 1]
    arr = [400]
    result = replace_elements(arr)
    print(result)
