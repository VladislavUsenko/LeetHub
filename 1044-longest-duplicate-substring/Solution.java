import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        String s = "banana";

        System.out.println("-----------------");
        System.out.println(longestDupSubstring(s));
    }

    public static String longestDupSubstring(String s) {
        int n = s.length();
        int left = 1, right = n;
        String result = "";

        while (left < right) {
            int mid = (left + right) / 2;
            String dup = getDuplicate(s, mid);
            if (dup != null) {
                result = dup;
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return result;
    }

    private static String getDuplicate(String s, int L) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i <= s.length() - L; i++) {
            String sub = s.substring(i, i + L);
            if (!seen.add(sub)) return sub;
        }
        return null;
    }
}