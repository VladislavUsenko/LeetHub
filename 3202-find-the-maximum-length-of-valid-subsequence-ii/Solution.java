class Solution {

    public static void main(String[] args) {
        int[] nums = {1,4,2,3,1,4};

        System.out.println("===================");
        System.out.println(maximumLength(nums, 3));
    }

    public static int maximumLength(int[] nums, int k) {
        
        int countOdd = 0;
        int countEven = 0;

        
        boolean currIsEven = nums[0] % k == 0;

        int alternateEvenOdd = currIsEven ? 1 : 0;
        int alternateOddEven = currIsEven ? 0 : 1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] % k != 0) {
                countOdd++;
            } else countEven++;
        }

        for (int i = 1; i < nums.length; i++) {

            if(currIsEven) {
                if (nums[i] % k != 0) {
                    currIsEven = false;
                    alternateEvenOdd++;
                    alternateOddEven++;
                }
            } else {
                if (nums[i] % k == 0) {
                    currIsEven = true;
                    alternateOddEven++;
                    alternateEvenOdd++;
                }
            }
        }

        return Math.max(countEven, Math.max(countOdd, Math.max(alternateEvenOdd, alternateOddEven)));
    }
}