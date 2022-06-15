class Solution {
    public int numIslands(char[][] grid) {

        int count = 0;

        for (int i =0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count += 1;
                    replaceIsland(grid, i, j);
                }
            }
        }

        return count;
    }

    public void replaceIsland(char[][] grid, int i, int j) {

        if (i >= 0 &&
            j >= 0 &&
            i < grid.length &&
            j < grid[0].length &&
            grid[i][j] == '1') {
            grid[i][j] = '2';
            replaceIsland(grid, i + 1, j);
            replaceIsland(grid, i, j + 1);
            replaceIsland(grid, i - 1, j);
            replaceIsland(grid, i, j - 1);
        }
    }
}