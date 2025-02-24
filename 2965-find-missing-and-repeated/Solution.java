import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        
        int[][] grid = {
            {9, 1, 7},
            {8, 9, 2},
            {3, 4, 6}
        };

        System.out.println("=============");
        System.out.println(
            Arrays.toString(
                findMissingAndRepeatedValues(grid)
            )
        );


    }

    public static int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        
        int[] map = new int[n * n + 1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map[grid[i][j]]++;
            }
        }

        int[] res = new int[2];

        for (int i = 1; i < map.length; i++) {
            if (map[i] == 0) res[1] = i;
            if (map[i] == 2) res[0] = i;
        }

        return res;
    }
}