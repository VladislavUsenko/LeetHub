import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};

        System.out.println("----------------------");
        System.out.println(minCost(grid));
    }

    public static int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;

        Deque<int[]> path = new LinkedList<>();
        path.add(new int[]{0, 0});

        while (!path.isEmpty()) {
            int[] xy = path.pollFirst();
            int x = xy[0];
            int y = xy[1];

            for (int i = 0; i < 4; i++) {
                int nextX = x + dir[i][0];
                int nextY = y + dir[i][1];

                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
                    int newCost = cost[x][y] + (i == grid[x][y] - 1 ? 0 : 1);

                    if (newCost < cost[nextX][nextY]) {
                        cost[nextX][nextY] = newCost;

                        if (i == grid[x][y] - 1) {
                            path.addFirst(new int[]{nextX, nextY});
                        } else {
                            path.addLast(new int[]{nextX, nextY});
                        }
                    }
                }
            }
        }

        return cost[m - 1][n - 1];
    }
}
