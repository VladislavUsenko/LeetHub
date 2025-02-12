class Solution {

    public static void main(String[] args) {
        String haystrack = "sadbutsad";
        String needle = "sad";

        System.out.println("------------");
        System.out.println(strStr(haystrack, needle));
    }

    public static int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {

                
                int j = 0;
                for(; j < needle.length() && i + j < haystack.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                }

                if(j == needle.length()) return i;
            }
        }

        return -1;
    }
}