import java.util.Arrays;

class NumMatrix {

    int[][] pref;

    public NumMatrix(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        
        pref = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                pref[i][j] = pref[i][j - 1] - pref[i - 1][j - 1] + pref[i - 1][j] + matrix[i - 1][j - 1];
            }
        }

        printMatrix(pref);
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {

        row1++;
        col1++;
        row2++;
        col2++;
        
        return pref[row2][col2] - pref[row1 - 1][col2] - pref[row2][col1 - 1] + pref[row1 - 1][col1 - 1];
    }

    public void printMatrix(int[][] matrix) {

        for(int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}