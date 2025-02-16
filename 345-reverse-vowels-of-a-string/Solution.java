
import java.util.*;

class Solution {

    public static void main(String[] args) {
       String str = "IceCreAm"; 

       System.out.println("-----------------");
        System.out.println(reverseVowels(str));
    }

    public static String reverseVowels(String s) {
        
        Set<Character> vowels = Set.of(
            'a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U'
        );

        StringBuilder sb = new StringBuilder(s);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (vowels.contains(sb.charAt(i))) {
                while (i < j) {
                    if (vowels.contains(sb.charAt(j))) {
                        char tmp = sb.charAt(i);
                        sb.setCharAt(i, sb.charAt(j));
                        sb.setCharAt(j, tmp);
                        j--;
                        break;
                    }
                    j--;
                }
            }
            i++;
        }

        return sb.toString();
    }
}