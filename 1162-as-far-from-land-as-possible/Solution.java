import java.util.*;

class Solution {

    public static void main(String[] args) {
        
        int[][] grid = {{1,0,1},
                        {0,0,0},
                        {1,0,1}};

        System.out.println(maxDistance(grid));
    }

    public static int maxDistance(int[][] grid) {
        
        /*
         * 
         * 1 loop find all the nearest water
	Push to queue x, y 1

X, y 
2 while loop in queue
	Pop if have water near by
	  Push near by water disatans

Return grid[x][y]

         */

        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;

         for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    q.addAll(nearWater(grid, i, j, 2));
                }
            }
         }

         if(q.isEmpty()) return -1;

         int currX = 0;
         int currY = 0;
         while (!q.isEmpty()) {
            
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            
            currX = x;
            currY = y;

            q.addAll(nearWater(grid, x, y, grid[x][y] + 1));

         }

         return grid[currX][currY] - 1;
    }

    public static List<int[]> nearWater(int[][] grid, int x, int y, int dist) {

        int[][] dir = {{0, 1},{1, 0},{0, -1},{-1, 0}};
        
        List<int[]> waters = new ArrayList<>();

        for(int i = 0; i < dir.length; i++) {

            int newX = x + dir[i][0];
            int newY = y + dir[i][1];

            if(newX >= 0 && newX < grid.length &&
               newY >= 0 && newY < grid.length &&
               grid[newX][newY] == 0) {
                grid[newX][newY] = dist;
                waters.add(new int[]{newX, newY});
            }
        }

        return waters;
    }
}