
class Solution {

    public static void main(String[] args) {
        
        int[][] indices = {{40, 5}};

        int result = oddCells(48, 37, indices);
        System.out.println(result);
    }


    public static int oddCells(int m, int n, int[][] indices) {
        
        int row[]=new int[m];
        int col[]=new int[n];
        
        for(int i=0; i<indices.length; i++){
            row[indices[i][0]]++;
            col[indices[i][1]]++;
        }

        
        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((row[i]+col[j])%2!=0) count++;
            }
        }
        return count;
    }
}