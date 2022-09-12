import sys

t1 = ([2,3,6,7], 7, [[2,2,3], [7]])
t2 = ([2,3,5], 8, [[2,2,2,2], [2,3,3], [3,5]])
t3 = ([2], 1, [])

def RunTests(Solution) -> bool:
    for candidates, target, answer in [t1,t2,t3]:
        if not Solution(candidates, target) == answer: 
            sys.stderr.writelines("Test failed.\nCandidates: {}\n Target: {}".format(candidates, target))
            return False
    sys.stdout.writelines("PASSED: Solution successfully passed all tests")
    return True