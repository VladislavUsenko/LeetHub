import collections
from typing import List

class Solution:
    def minCost(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        dirs = [(0, 1), (0, -1), (1, 0), (-1, 0)]  # right, left, down, up

        cost = [[float('inf')] * n for _ in range(m)]
        cost[0][0] = 0

        print(cost)

        dq = collections.deque()
        dq.append((0, 0))

        while dq:
            x, y = dq.popleft()
            print(x, y)
            for i, (dx, dy) in enumerate(dirs):
                nx, ny = x + dx, y + dy

                if 0 <= nx < m and 0 <= ny < n:
                    new_cost = cost[x][y] + (i != grid[x][y] - 1)
                    print('new cost:', new_cost, cost[nx][ny])
                    if new_cost < cost[nx][ny]:
                        cost[nx][ny] = new_cost
                        if i == grid[x][y] - 1:
                            dq.appendleft((nx, ny))  # cost 0
                        else:
                            dq.append((nx, ny))      # cost 1
                    print(dq)
        return cost[m - 1][n - 1]
    
obj = Solution()

grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]

minCost = obj.minCost(grid)
print(minCost)