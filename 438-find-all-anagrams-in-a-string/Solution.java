import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if(p.length()> s.length()) return result;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int begin = 0, end = 0;
        int count = map.size();

        while(end < s.length()) {

            char c = s.charAt(end);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) { count--; }
            }

            end++;

            while (count == 0 ) {

                c = s.charAt(begin);

                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) { count++; }
                }

                if(end-begin == p.length()){
                    result.add(begin);
                }
                begin++;
            }
        }

        return result;
    }
}