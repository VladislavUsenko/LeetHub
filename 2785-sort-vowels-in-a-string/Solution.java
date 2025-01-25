
import java.util.*;

class Solution {

    public static void main(String[] args) {
       String str = "lEetcOde"; 

       System.out.println("-----------------");
        System.out.println(sortVowels(str));
    }

    public static String sortVowels(String s) {
        
        Set<Character> vowels = Set.of(
            'a', 'e', 'i', 'o', 'u',
                'A', 'E', 'I', 'O', 'U'
        );

        char[] arrayVowels = new char[s.length()];

        int j = 0;
        for(int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                arrayVowels[j] = s.charAt(i);
                j++;
            }
        }

        arrayVowels = Arrays.copyOf(arrayVowels, j);
        Arrays.sort(arrayVowels);

        StringBuilder sb = new StringBuilder(s);
        j = 0;
        for(int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                sb.setCharAt(i, arrayVowels[j++]);
            }
        }

        return sb.toString();
    }
}