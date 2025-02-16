import java.util.*;

class Solution {

    public static void main(String[] args) {
        
        String s = "badc", t = "baba";

        System.out.println("----------------");
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        
        if(s.length() != t.length()) return false;

        HashMap<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if(map.containsKey(charS)) {
                if (map.get(charS) != charT) return false;
            } else {
                if (set.contains(charT)) return false;

                set.add(charT);
                map.put(charS, charT);
            }
        }

        return true;
    }
}