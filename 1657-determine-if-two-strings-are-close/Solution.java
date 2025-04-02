import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        
        String word1 = "abc";
        String word2 = "bca";

        System.out.println("==================");
        System.out.println(closeStrings(word1, word2));
    }

    public static boolean closeStrings(String word1, String word2) {

        if(word1.length() != word2.length()) return false;

        int[] word1Map = new int[26];
        int[] word2Map = new int[26];

        for(char c : word1.toCharArray()) {
            word1Map[c - 'a']++;
        }

        for(char c : word2.toCharArray()) {
            word2Map[c - 'a']++;
        }

        for(int i = 0; i < word1Map.length; i++){
            if(word1Map[i] == 0 && word2Map[i] > 0) return false;
            if(word2Map[i] == 0 && word1Map[i] > 0) return false;
        }

        Arrays.sort(word1Map);
        Arrays.sort(word2Map);
        
        return Arrays.equals(word1Map, word2Map);
    }
}