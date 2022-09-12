from tests import CombinationSumTests as ctests

def CombinationSum(cadidates: list[int], target: int) -> list[list[int]]:
    """
        If number is less than half of the target, see if there is a combination with it.
        If number is half than target, there is a combination with it.
        If a target % x == 0, then [x,x,..,x] is a solution
    """

if __name__ == '__main__':
    ctests.RunTests(CombinationSum)