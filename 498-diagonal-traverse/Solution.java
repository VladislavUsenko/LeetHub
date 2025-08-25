import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};

        int[] result = findDiagonalOrder(mat);

        System.out.println(Arrays.toString(result));
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

        int size = n * m;
        int[] result = new int[size];

        int col = 0, row = 0;
        
        for (int i = 0; i < size; i++) {
            
            result[i] = mat[row][col];

            if((col + row) % 2 == 0) {
                if (col == n - 1) row++;
                else if (row == 0) col++;
                else {row--; col++;}
            } else {
                if (row == m - 1) col++;
                else if (col == 0) row++;
                else {row++; col--;}
            }
        }

        return result;
    }
}