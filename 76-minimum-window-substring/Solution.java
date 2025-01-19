import java.util.HashMap;

class Solution {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String p = "ABC";
        System.out.println(minWindow(s, p));
    }

    public static String minWindow(String s, String p) {

        if (p.length() > s.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int begin = 0, end = 0, head = 0;
        int count = map.size();
        int minLen = Integer.MAX_VALUE;

        while (end < s.length()) {

            char c = s.charAt(end);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    count--;
                }
            }
            end++;

            while (count == 0) {

                if (end - begin < minLen) {
                    head = begin;
                    minLen = end - begin;
                }

                c = s.charAt(begin);

                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if (map.get(c) > 0) {
                        count++;
                    }
                }
                begin++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(head, head + minLen);
    }
}