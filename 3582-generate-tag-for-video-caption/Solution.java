class Solution {

    public static void main(String[] args) {
        String caption = "Leetcode daily streak achieved";

        System.out.println(generateTag(caption));
    }

    public static String generateTag(String caption) {
        String[] words = caption.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();
        sb.append("#");
        sb.append(words[0].toLowerCase());
        
        for(int i = 1; i < words.length; i++) {
            String s = words[i].toLowerCase();

            sb.append(Character.toUpperCase(s.charAt(0)));
            sb.append(s.substring(1));
        }

        String result = sb.toString();

        if(result.length() > 100) {
            return result.substring(0, 99);
        }

        return result;

    }
}