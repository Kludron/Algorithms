"""
Given an array of integers *nums* and an integer *target*,
return indices of the two numbers such that they add up to *target*

Example 1:
    nums = [2, 7, 11, 15]
    target = 9

    Answer = [0, 1]

Example 2:
    nums = [3,2,4]
    target = 6

    Answer = [1,2]

Example 3:
    nums = [3,3]
    target = 6

    Answer = [0,1]
"""

from tests import TwoSumTests as tTests

def TwoSum(nums: list[int], target: int) -> list[int]:
    hashmap: dict(int, int) = dict()
    for i, num in enumerate(nums):
        needed = target-num
        if needed in hashmap:
            return [hashmap[needed], i]
        hashmap[num] = i
        # print(type(hashmap))

if __name__ == '__main__':
    tTests.RunTests(TwoSum)