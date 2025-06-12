import java.util.*;

class Solution {

    public static void main(String[] args) {
        
        String s = "babad";

        System.out.println("---------------------");
        System.out.println(longestPalindrome(s));
    }


    public static String longestPalindrome(String s) {

        char[] chars = s.toCharArray();

        String result = "";
        for(int i = 0; i < chars.length - 2; i++) {

            if(chars[i] == chars[i + 1]) {
                List<Character> palindore = new LinkedList<>();
                result = checkEvenPalindrome(chars, i, i + 1, palindore, result);
            }

            if(chars[i] == chars[i + 2]) {
                List<Character> palindore = new LinkedList<>();
                palindore.add(chars[i + 1]);
                result = checkEvenPalindrome(chars, i, i + 2, palindore, result);
            }
        }

        return result;
    }

    private static String checkEvenPalindrome(
        char[] chars, 
        int start, 
        int end, 
        List<Character> palindore,
        String result) {

        while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
            palindore.addFirst(chars[start--]);
            palindore.addLast(chars[end++]);
        }

        System.out.println(palindore);

        if (palindore.size() > result.length()) {
                    
            StringBuilder sb = new StringBuilder();
            for (Character c : palindore) sb.append(c);
            result = sb.toString();
        }

        return result;
    }
}