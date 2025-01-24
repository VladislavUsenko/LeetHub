
class Solution {

    public static void main(String[] args) {

        String s = "Hello World";

        System.out.println(lengthOfLastWord(s));

    }

    public static int lengthOfLastWord(String s) {
       
        String[] words = s.split(" ");

        return words[words.length - 1].length();
    }

}