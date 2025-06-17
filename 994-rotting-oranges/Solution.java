import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dir = {
            { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }
        };

        Queue<int[]> rottenOranges = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    rottenOranges.offer(new int[] { i, j });
                }
                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) return 0;

        int minuteCount = 0;

        while (!rottenOranges.isEmpty()) {
            int size = rottenOranges.size();
            minuteCount++;

            for (int i = 0; i < size; i++) {
                int[] curr = rottenOranges.poll();

                for (int[] d : dir) {
                    int x = curr[0] + d[0];
                    int y = curr[1] + d[1];

                    if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshOranges--;
                        rottenOranges.offer(new int[] { x, y });
                    }
                }
            }
        }

        return freshOranges == 0 ? minuteCount - 1 : -1;
    }
}
