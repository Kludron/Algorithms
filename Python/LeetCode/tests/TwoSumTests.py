import sys

tests = [
    ([2,7,11,15], 9, [0,1]),
    ([3,2,4], 6, [1,2]),
    ([3,3], 6, [0,1]),
    ([-3, 0, 3], 0, [0,2])
]


def RunTests(Solution) -> bool:
    for nums, target, answer in tests:
        output = Solution(nums, target)
        if not output == answer: 
            sys.stderr.writelines("Test failed.\nNums: {}\nTarget: {}\nOutput: {}\nAnswer: {}\n".format(nums, target, output, answer))
            return False
    sys.stdout.writelines("PASSED: Solution successfully passed all tests\n")
    return True