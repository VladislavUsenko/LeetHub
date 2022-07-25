class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        int[] first = coordinates[0];
        int[] last = coordinates[coordinates.length - 1];

        int x1 = first[0];
        int y1 = first[1];

        int x2 = last[0];
        int y2 = last[1];

        for (int i = 1; i < coordinates.length - 1; i ++) {

            int x = coordinates[i][0];
            int y = coordinates[i][1];
           if ((x2 - x1) * (y - y1) != (y2 - y1) * (x - x1)) return false;
        }

        return true;
    }
}