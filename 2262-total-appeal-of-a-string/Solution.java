class Solution {

    public long appealSum(String s) {

         int[] last = new int[26];

         long result = 0;
         for (int i = 0; i < s.length(); ++i) {

             last[s.charAt(i) - 'a'] = i + 1;
             for (int j: last)
                 result += j;
         }
         return result;
     }
 }