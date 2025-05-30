from typing import List

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        self.map = grid
        result = 0

        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    result += 1
                    self.replace_grid(i, j)

        return result

    def replace_grid(self, i: int, j: int):
        if 0 <= i < len(self.map) and 0 <= j < len(self.map[0]) and self.map[i][j] != '0':
            self.map[i][j] = '0'
            self.replace_grid(i + 1, j)
            self.replace_grid(i, j + 1)
            self.replace_grid(i, j - 1)
            self.replace_grid(i - 1, j)
