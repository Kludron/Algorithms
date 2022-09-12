
def UniquePaths(m: int, n: int) -> int:
    # Initialize an m x n grid with 0's
    grid = [[0 for i in range(n)] for j in range(m)]
    grid[m-1][n-1]=2
    for row in range(m-1, 0, -1):
        for col in range(n-2, 0, -1):
            grid[row][col] += grid[row-1][col] + grid[row][col+1] + 1
            for k in grid:
                print(k)
            print('*'*25)

    return grid[0][0]

from tests import UniquePathsTests as t

if __name__ == '__main__':
    t.RunTests(UniquePaths)