import sys

tests = [
    (3, 7, 28),
    (3, 2, 3),
]


def RunTests(Solution) -> bool:
    for m, n, answer in tests:
        output = Solution(m, n)
        if not output == answer: 
            sys.stderr.writelines("Test failed.\nM:\t {}\nN:\t {}\nOutput:\t {}\nAnswer:\t {}\n".format(m, n, output, answer))
            return False
    sys.stdout.writelines("PASSED: Solution successfully passed all tests\n")
    return True