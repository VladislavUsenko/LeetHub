class Solution {


    public static void main(String[] args) {
        
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        System.out.println("---------------------------");
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        
        char[] letters = word.toCharArray();

        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (letters[0] == board[i][j]) {

                    int[][] visited = new int[board.length][board[0].length];

                    if (search(board, letters, 0, i, j, dir, visited)) return true;
                }
            }
        }

        return false;
    }

    private static boolean search(
        char[][] board, 
        char[] letters, 
        int idx, int i, int j, 
        int[][] dir,
        int[][] visited) {

            if(i < board.length && i >= 0 && j < board[0].length && j >= 0 && idx < letters.length){

                //System.out.println(board[i][j] + " - " + i + ":" + j + ", idx: " + idx);

                if(board[i][j] == letters[idx] && visited[i][j] != 1) {

                    if(idx == letters.length - 1) return true;

                    visited[i][j] = 1;
                    
                    for(int[] d : dir){
                        if (search(board, letters, idx + 1, i + d[0], j + d[1], dir, visited)) {
                            return true;
                        }
                    }

                    visited[i][j] = 0;

                    return false;
                }
            }

            return false;

    }
}