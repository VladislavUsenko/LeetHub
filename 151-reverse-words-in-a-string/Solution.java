import java.util.*;

class Solution {

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println("=================");
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        
        StringBuilder sb = new StringBuilder();

        s = s.trim();

        int k = 0, j = 0;
        for(; j < s.length(); j++) {
            if (s.charAt(j) == ' ') {
                sb.insert(0, s.substring(k, j + 1));
                while (s.charAt(j) == ' ') {
                    j++;
                }
                k = j;
            }
        }

        sb.insert(0, s.substring(k, j) + " ");

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }
}