"""
Given an interger array *heigh* of length *n*.
There are *n* vertical lines drawn such that the two endpoints of
the *ith* line are *(i, 0)* and *(i, height[i])*.

Find two lines that together with the x-axis form a container,
such that the container contains the most water.


Return the maximum amount of water a container can store
NOTE: You cannot slant the container

Example 1:
    height = [1,8,6,2,5,4,8,3,7]
    Answer = 49

Example 2:
    height = [1,1]
    Answer = 1

CONSTRAINTS:
    - n == height.length
    - 2 <= n <= 10^5
    - 0 <= height[i] <= 10^4
"""

from tests import ContainerWithMostWaterTests as t

def ContainerWithMostWater(height: list[int]) -> int:
    # 1. Initialise 2 pointers and maxVol variables
    left: int = 0
    right: int = len(height)-1
    maxVol: int = 0
    # 2. Loop through heights and move pointers inwards, calculating max volume
    while (left < right):
        lheight = height[left]
        rheight = height[right]
        curVol = min(lheight, rheight) * (right-left)
        maxVol = max(maxVol, curVol)
        if lheight > rheight:
            right -= 1
        else:
            left += 1

    return maxVol

if __name__ == '__main__':
    t.RunTests(ContainerWithMostWater)