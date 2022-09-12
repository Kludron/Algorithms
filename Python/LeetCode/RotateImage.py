"""
Given an *n x n* 2D matrix representing an image,
rotate the image by 90 degrees.

You must rotate the image in-place, meaning that you have to modify
matrix directly. You cannot allocate another 2D matrix and do the
rotation.

Example 1:
    matrix = [
        [1,2,3], | [3,2,1] | [3,6,9] | [9,6,3] | [7,4,1]
        [4,5,6], | [6,5,4] | [2,5,8] | [8,5,2] | [8,5,2]
        [7,8,9]] | [9,8,7] | [1,4,7] | [7,4,1] | [9,6,3]
    Answer = [
        [7,4,1], 
        [8,5,2], 
        [9,6,3]]

Example 2:
    matrix = [
        [ 5, 1, 9,11], | [11, 9, 1, 5] | [11,10, 7,16] | [16, 7,10,11] | [15,13, 2, 5]
        [ 2, 4, 8,10], | [10, 8, 4, 2] | [ 9, 8, 6,12] | [12, 6, 8, 9] | [14, 3, 4, 1]
        [13, 3, 6, 7], | [ 7, 6, 3,13] | [ 1, 4, 3,14] | [14, 3, 4, 1] | [12, 6, 8, 9]
        [15,14,12,16]] | [16,12,14,15] | [ 5, 2,13,15] | [15,13, 2, 5] | [16, 7,10,11]
    Answer = [
        [15,13, 2, 5], 
        [14, 3, 4, 1], 
        [12, 6, 8, 9], 
        [16, 7,10,11]]
"""

def RotateImage(matrix: list[list[int]]) -> list[list[int]]: #4*O(n^2) = O(n^2)
    def _reverseRows(): # O(n^2)
        for row in matrix: # O(n)
            left = 0
            right = len(row)-1
            while left < right: # O(n/2)
                temp = row[right]
                row[right] = row[left]
                row[left] = temp
                left += 1
                right -= 1
    
    def _swapRowandCol(): # O(n^2)
        for row in range(len(matrix)):
            for col in range(row+1, len(matrix)):
                temp = matrix[row][col]
                matrix[row][col] = matrix[col][row]
                matrix[col][row] = temp 

    def _reverseCols(): # O(n^2)
        # for row in range(len(matrix)):
        for col in range(len(matrix)):
            top = 0
            bottom = len(matrix[col])-1
            while (top < bottom):
                temp = matrix[top][col]
                matrix[top][col] = matrix[bottom][col]
                matrix[bottom][col] = temp
                top += 1
                bottom -= 1

    # 1. Reverse Rows
    _reverseRows()

    # 2. Flip Rows to Cols
    _swapRowandCol()

    # 3. Reverse Rows
    _reverseRows()

    # 4. Reverse Cols
    _reverseCols()

    return matrix

from tests import RotateImageTests as t

if __name__ == '__main__':
    t.RunTests(RotateImage)