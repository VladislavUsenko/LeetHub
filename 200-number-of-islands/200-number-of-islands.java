class Solution {
    
   char[][] map;
    
   public int numIslands(char[][] grid) {

        int result = 0;

        map = grid;

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1'){
                    result += 1;
                    replaceGrid(i, j);
                }
            }
        }

        return result;
    }

    private void replaceGrid(int i, int j){

        if (i >= 0 && i < map.length
                && j >= 0 && j < map[0].length
                && map[i][j] != '0') {
            map[i][j] = '0';
            replaceGrid(i + 1, j);
            replaceGrid(i, j + 1);
            replaceGrid(i, j - 1);
            replaceGrid(i - 1, j);
        }
    }
}