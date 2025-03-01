import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[][] grid = {
            {3,1,2,2},
            {1,4,4,5},
            {2,4,2,2},
            {2,4,2,2}
        };

        System.out.println("------------");
        System.out.println(equalPairs(grid));

    }

    public static int equalPairs(int[][] grid) {
        
        int res = 0;

        for (int i = 0; i < grid.length; i++) {

            for (int k = 0; k < grid.length; k++) {

                int j = 0;

                while (j < grid.length && grid[i][j] == grid[j][k]) {
                    j++;
                }

                if(j == grid.length) res++;
            }
        }

        return res;
    }
}