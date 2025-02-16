class Solution {
    public boolean isPalindrome(int x) {
        char[] charArray = Integer.toString(x).toCharArray();
        boolean result = true;

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != charArray[charArray.length - i - 1]) {
                result = false;
                break;
            }
        }

        return result;
    }
}