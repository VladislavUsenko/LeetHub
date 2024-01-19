import java.util.Arrays;

public class Solution {

    public static int[][] snail(int[] array, int row, int col) {

        if (row * col != array.length) return new int[0][0];

        int[][] res = new int[row][col];

        for (int i = 0; i < col; i++)
            for (int j = 0; j < row; j++) {

                int index = (i % 2 == 1) ? row - j - 1 : j;
                int item = array[i * row + j];

                res[index][i] = item;
            }
        return res;
    }

    public static void main(String[] args) {
        int[] inputArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int row = 3;
        int col = 4;

        int[][] resultArray = snail(inputArray, row, col);

        // Print the result array
        for (int[] rowArray : resultArray) {
            System.out.println(Arrays.toString(rowArray));
        }
    }
}