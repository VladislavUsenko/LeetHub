
class Solution {

    public static void main(String[] args) {
        String s = "0P";

        System.out.println("-----------------");
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        
        if (s.isEmpty()) return true;

        s = s.toLowerCase();
        s = s.trim();

        for (int i = 0, j = s.length() - 1; i < j; ) {
            if (isChar(s.charAt(i)) && isChar(s.charAt(j))) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                } else {
                    i++;
                    j--;
                    continue;
                }
            } else if (!isChar(s.charAt(i))) {
                i++;
            } else if (!isChar(s.charAt(j))) {
                j--;
            }
        }

        return true;
    }

    public static boolean isChar(char c) {

        return (c >= 'a' && c <= 'z') || c >= '0' && c <= '9';
    }
}