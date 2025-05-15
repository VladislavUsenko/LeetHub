import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        
        if (s.length() < 2) return s.length();

        int maxLen = 0;
        Set<Character> charSet = new HashSet<>();

        int left = 0, right = 0;
        while(right < s.length()) {
            while(charSet.contains(s.charAt(right)))
                charSet.remove(s.charAt(left++));
            charSet.add(s.charAt(right++));
            maxLen = Math.max(maxLen, right - left);
        }

        return maxLen;
    }
}