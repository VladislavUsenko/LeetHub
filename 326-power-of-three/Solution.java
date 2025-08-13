class Solution {
    public boolean isPowerOfThree(int n) {
        long pow3 = 1;
        while(pow3 <= Integer.MAX_VALUE) {
           if(pow3 == n) {
            return true;
           }
           pow3 *= 3;
        }
        return false;
    }
}