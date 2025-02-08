import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        
        int[] digits = {4, 3, 2, 1};

        System.out.println("--------------");
        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public static int[] plusOne(int[] digits) {
        
        for(int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] tmp = new int[digits.length + 1];
        tmp[0] = 1;
            
        return tmp;
    }
}
