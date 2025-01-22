import java.util.*;

public class Solution {

    public static void main(String[] args) {
        String s = "aaaaaaabcdc";
        List<String> workdDict = new ArrayList<>();
        workdDict.add("aaaa");
        workdDict.add("aaa");
        workdDict.add("b");
        workdDict.add("cd");

        boolean result = wordBreak(s, workdDict);
        System.out.println("Result: " + result);

    }

    static boolean[] memo;
    public static boolean wordBreak(String s, List<String> wordDict) {
          memo = new boolean[s.length() + 1];
          return wordBreak(s, wordDict, 0);
   }
   public static boolean wordBreak(String s, List<String> wordDict, int k) {
       if (k == s.length())
           return true;
       
       if (memo[k])
           return false;
       
       for (String word : wordDict) {
           if (s.startsWith(word, k)) {
               memo[k] = true;
               if(wordBreak(s, wordDict, k + word.length())) return true;
           }
       }    
       return false;
   }


}