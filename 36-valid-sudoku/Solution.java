import java.util.*;

class Solution {

    public static void main(String[] args) {
        
        char[][] board = 
        {
            {'7','.','.','.','4','.','.','.','.'},
            {'.','.','.','8','6','5','.','.','.'},
            {'.','1','.','2','.','.','.','.','.'},
            {'.','.','.','.','.','9','.','.','.'},
            {'.','.','.','.','5','.','5','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','2','.','.'},
            {'.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.'}
        };

        System.out.println("------------------");
        System.out.println(isValidSudoku(board));

    }

    public static boolean isValidSudoku(char[][] board) {

        
        for(int i = 0, j = 0; i < 9; i++, j++) {

            HashSet<Character> seti = new HashSet<>();
            HashSet<Character> setj = new HashSet<>();

            for(int k = 0; k < 9; k++) {
                char cj = board[k][j];
                if (cj != '.') {
                    if (!setj.contains(cj)) {
                        setj.add(cj);
                    } else {
                        return false;
                    }
                }

                char ci = board[i][k];
                if (ci != '.') {
                    if (!seti.contains(ci)) {
                        seti.add(ci);
                    } else {
                        return false;
                    }
                }
            }
        }

        int[][] mid = {
            {1,1},{1,4},{1,7},
            {4,1},{4,4},{4,7},
            {7,1},{7,4},{7,7}
        };

        for(int[] xy : mid) {

            int x = xy[0];
            int y = xy[1];

            HashSet<Character> set = new HashSet<>();

            for(int i = x - 1; i < x + 2; i++) {
                for (int j = y - 1; j < y + 2; j++) {
                    char c = board[i][j];
                if (c == '.') continue;
                if (!set.contains(c)) {
                    set.add(c);
                } else {
                    return false;
                }
                }
            }
        }

        return true;
    }
}