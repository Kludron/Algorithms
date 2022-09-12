import sys

tests = [
    ([1,8,6,2,5,4,8,3,7], 49),
    ([1,1], 1),
    ([7,7,7,6,5,1], 20),
]


def RunTests(Solution) -> bool:
    for nums, answer in tests:
        output = Solution(nums)
        if not output == answer: 
            sys.stderr.writelines("Test failed.\nNums: {}\nOutput: {}\nAnswer: {}\n".format(nums, output, answer))
            return False
    sys.stdout.writelines("PASSED: Solution successfully passed all tests\n")
    return True