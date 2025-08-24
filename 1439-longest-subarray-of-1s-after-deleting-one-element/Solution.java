class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, j = 0, len = 0;
        int count = 0;
        while (j < nums.length) {
            if (nums[j] == 0)
                count++;
            while (count > 1) {
                if (nums[i] == 0)
                    count--;
                i++;
            }
            len = Math.max(len, j - i);
            j++;
        }
        return len;
    }
}