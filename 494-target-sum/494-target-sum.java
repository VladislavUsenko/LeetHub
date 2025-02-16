class Solution {
    
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        calculate(nums, 0, 0, target);
        return count;
    }

    public void calculate(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            calculate(nums, index + 1, sum + nums[index], target);
            calculate(nums, index + 1, sum - nums[index], target);
        }
    }
}