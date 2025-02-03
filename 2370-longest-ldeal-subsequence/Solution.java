

class Solution {

    public static void main(String[] args) {
        String s = "jxhwaysa";

        System.out.println("++++++++++++++++");
        System.out.println(longestIdealString(s, 14) );
    }

    public static int longestIdealString(String s, int k) {

        int result = 0;

        int[] dp = new int[26];

        for(char ch : s.toCharArray()) {
            int chi = ch - 'a';
            int c = 1;
            
            for (int j = 0; j <= k; j++) {
                int bel = chi - j;
                int nex = chi + j;
                if(bel >= 0) c = Math.max(c, dp[bel] + 1);
                if(nex < 26) c = Math.max(c, dp[nex] + 1);
            }
            dp[chi] = c;
            result = Math.max(result, c);  
        }
        
        return result;
    }
}