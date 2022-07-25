class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];

        int x2 = coordinates[coordinates.length - 1][0];
        int y2 = coordinates[coordinates.length - 1][1];

        for (int i = 1; i < coordinates.length - 1; i ++) {

            int x = coordinates[i][0];
            int y = coordinates[i][1];
           if ((x2 - x1) * (y - y1) != (y2 - y1) * (x - x1)) return false;
        }

        return true;
    }
}