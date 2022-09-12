import sys

tests = [
    ([[1,2,3], [4,5,6], [7,8,9]], [[7,4,1], [8,5,2], [9,6,3]]),
    ([[5,1,9,11], [2,4,8,10], [13,3,6,7], [15,14,12,16]], [[15,13,2,5], [14,3,4,1], [12,6,8,9], [16,7,10,11]]),
    ([[1,5],[9,3]],[[9,1],[3,5]]),
    ([[1,2,3,4,5],[6,7,8,9,8],[7,6,5,4,3],[2,1,0,1,2],[3,4,5,6,7]], [[3,2,7,6,1],[4,1,6,7,2],[5,0,5,8,3],[6,1,4,9,4],[7,2,3,8,5],]),
    ([[1]], [[1]]),
    ([[]], [[]])
]


def RunTests(Solution) -> bool:
    for matrix, answer in tests:
        output = Solution(matrix.copy())
        if not output == answer: 
            sys.stderr.writelines("Test failed.\nMatrix:\t {}\nOutput:\t {}\nAnswer:\t {}\n".format(matrix, output, answer))
            return False
    sys.stdout.writelines("PASSED: Solution successfully passed all tests\n")
    return True