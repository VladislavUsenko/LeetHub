class Solution {
    public int search(int[] nums, int begin, int end, int x) {

        if (begin > end) return -1;

        int midIndex = (begin + end) / 2;

        int midItem = nums[midIndex];
        if (midItem == x) return midIndex;

        if (midItem > x) {
             return search(nums, begin, midIndex - 1, x);
        } else return search(nums, midIndex + 1, end, x);

    }

    public int search(int[] nums, int target) {
		
		int left = 0;
        int right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
		
         //return search(nums, 0, nums.length - 1, target);
    }
}