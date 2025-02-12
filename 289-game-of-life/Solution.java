import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };

        System.out.println("-----------");
        gameOfLife(board);

        for (int[] is : board) {
            System.out.println(Arrays.toString(is));
        }
        
        
    }

    public static void gameOfLife(int[][] board) {
        
        int[][] newBoard = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int sum = neighborsSum(board, i, j);

                if(board[i][j] == 1) {
                    if (sum == 2 || sum == 3) newBoard[i][j] = 1;
                } else if (sum == 3) {
                    newBoard[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[0].length; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    public static int neighborsSum(int[][] board, int x, int y) {
        int res = 0;

        for(int i = x - 1; i <= x + 1; i++) {
            for(int j = y - 1; j <= y + 1; j++) {
                if (i >= 0 && j >=0 && i < board.length && j < board[0].length) {
                    res += board[i][j];
                }
            }
        }

        return res - board[x][y];
    }
}