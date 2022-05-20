class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();

        int result = 0;
        int count = 0;
        Set<Character> charSet = new TreeSet<>();

         for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {
                if (charSet.contains(s.charAt(j))) {
                    result = Math.max(count, result);
                    count = 0;
                    charSet = new TreeSet<>();
                    break;
                } else {
                    charSet.add(s.charAt(j));
                    count++;
                }
            }
        }

        return  Math.max(count, result);
    }
}