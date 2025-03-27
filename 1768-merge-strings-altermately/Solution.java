class Solution {

    public static void main(String[] args) {
        String word1 = "ab", word2 = "pqrs";


        System.out.println("---------------");
        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        
        int i = 0;

        StringBuilder sb = new StringBuilder();

        while (i < word1.length() && i < word2.length()) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }

        if(i < word1.length()) sb.append(word1.substring(i));
        if(i < word2.length()) sb.append(word2.substring(i));

        return sb.toString();
    }
}