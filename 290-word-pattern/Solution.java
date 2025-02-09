import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
        

        System.out.println("-----------");
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String s) {
      
        String[] words = s.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        String[] m = new String[26];
        HashSet<String> seenWords = new HashSet<>();
        char[] chars = pattern.toCharArray();

        for (int i = 0; i < words.length; i++) {

            String str = m[chars[i] - 'a'];

            if(str != null) {
                if (!str.equals(words[i])) return false;
            } else {
                if(seenWords.contains(words[i])) return false;

                m[chars[i] - 'a'] = words[i];
                seenWords.add(str);
            }
            
        }


        return true;
        
    }
}