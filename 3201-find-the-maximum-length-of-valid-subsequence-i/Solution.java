class Solution {

    public static void main(String[] args) {
        
        int[] nums = {1,2,1,1,2,1,2};

        System.out.println("======================");
        System.out.println(maximumLength(nums));
    }

    public static int maximumLength(int[] nums) {
        
        int countOdd = 0;
        int countEven = 0;

        
        boolean currIsEven = nums[0] % 2 == 0;

        int alternateEvenOdd = currIsEven ? 1 : 0;
        int alternateOddEven = currIsEven ? 0 : 1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 != 0) {
                countOdd++;
            } else countEven++;
        }

        for (int i = 1; i < nums.length; i++) {

            if(currIsEven) {
                if (nums[i] % 2 != 0) {
                    currIsEven = false;
                    alternateEvenOdd++;
                    alternateOddEven++;
                }
            } else {
                if (nums[i] % 2 == 0) {
                    currIsEven = true;
                    alternateOddEven++;
                    alternateEvenOdd++;
                }
            }
        }

        return Math.max(countEven, Math.max(countOdd, Math.max(alternateEvenOdd, alternateOddEven)));
    }
}