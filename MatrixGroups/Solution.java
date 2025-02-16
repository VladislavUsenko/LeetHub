package MatrixGroups;

public class Solution {

    public static void main(String[] args) {

        char[][] matrix = {
                { '1', '0', '0', '0'},
                { '0', '1', '1', '0'},
                { '0', '1', '1', '0'},
                { '0', '0', '0', '1'},
        };

        for (char[] chars : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(chars[j] + " ");
            }
            System.out.println();
        }

        System.out.println(countGroups());

        System.out.println("matrix: ");
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.println(chars[j] + " ");
            }
            System.out.println();
        }
    }

    public static int countGroups(char[][] matrix) {

        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][i] != '0') {
                helper(matrix, i, i);
                count++;
            }
        }

        return count;
    }

    public static void helper(char[][] matrix, int i, int j) {

        if (i > matrix.length || j > matrix.length) return;
        if (matrix[i][j] != '0') {
            matrix[i][j] = '0';
            return;
        }

        helper(matrix, i + 1, j);
        helper(matrix, i, j  + 1);
    }
}
