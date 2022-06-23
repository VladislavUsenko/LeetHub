class Solution {
    public String reverseWords(String s) {

        String[] words = s.split(" ");
        
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            String reverse = new StringBuilder(word).reverse().toString();
            result.append(reverse).append(" ");
        }

        return result.toString().trim();

    }
}