class Solution {

    public static void main(String[] args) {
        
        int[] nums = {1,2,3,4,5};
        int target = 11;

        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {

        if (nums.length == 1) {
            return target <= nums[0] ? 1 : 0;
        }
        
        int count = Integer.MAX_VALUE;

        int sum = 0;
        int end = 0;
        int begin = 0;

        while (end < nums.length) {

            if (nums[end] >= target) return 1;
            sum += nums[end];

            while (sum >= target && begin < end) {
                count = Math.min(count, end - begin + 1);
                sum -= nums[begin];
                begin++;
            }            
            
            end++;
        }

        return count == Integer.MAX_VALUE ? 0 : count;
    }
}