import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};

        System.out.println("----------------------");
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) return -1;

        int[][] dirs = {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0},
            {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];
            int dist = grid[x][y];

            if (x == n - 1 && y == n - 1) return dist;

            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (canMove(grid, newX, newY)) {
                    queue.offer(new int[]{newX, newY});
                    grid[newX][newY] = dist + 1;
                }
            }
        }

        return -1;
    }

    public static boolean canMove(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 &&
               x < grid.length && y < grid[0].length &&
               grid[x][y] == 0;
    }
}