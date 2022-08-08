class Solution {
    public String tictactoe(int[][] moves) {
       List<Integer[][]> winParts = new ArrayList<>();

        winParts.add(new  Integer[][]{{0,0},{0,1},{0,2}});
        winParts.add(new  Integer[][]{{1,0},{1,1},{1,2}});
        winParts.add(new  Integer[][]{{2,0},{2,1},{2,2}});

        winParts.add(new  Integer[][]{{0,0},{1,0},{2,0}});
        winParts.add(new  Integer[][]{{0,1},{1,1},{2,1}});
        winParts.add(new  Integer[][]{{0,2},{1,2},{2,2}});

        winParts.add(new  Integer[][]{{0,0},{1,1},{2,2}});
        winParts.add(new  Integer[][]{{0,2},{1,1},{2,0}});

        for (Integer[][] part : winParts) {
            int Acount = 0;
            int Bcount = 0;
            for (int j = 0; j < part.length; j++) {
                for (int k = 0; k < moves.length; k ++) {
                    if (part[j][0] == moves[k][0] && part[j][1] == moves[k][1]) {
                        if (k % 2 == 0) {
                            ++Acount;
                        } else {
                            ++Bcount;
                        }
                    };
                }
            }
            if (Acount == 3) return "A";
            if (Bcount == 3) return "B";
        }

        return moves.length == 9 ? "Draw" : "Pending";
                
    }
    
}