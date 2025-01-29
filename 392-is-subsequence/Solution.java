
class Solution {

    public static void main(String[] args) {
        System.out.println("-------------");
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }

    public static boolean isSubsequence(String s, String t) {

        if (s.isEmpty()) return true;
        
        int runner = 0;
        for(int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(runner)) {
                runner++;
            }
            if(runner == s.length()) return true;
        }

        return runner == s.length();
    }
}