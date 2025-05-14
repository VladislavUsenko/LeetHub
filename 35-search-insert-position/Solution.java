class Solution {

    public static void main(String[] args) {
        
        int[] nums = {1, 3, 5, 6};
        int target = 2;

        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        
        return helperSearch(nums, target, 0, nums.length - 1);
    }


    public static int helperSearch(int[] nums, int target, int right, int left) {

        if (left >= right) {
            int mid = right + (left - right) / 2;

            if (target == nums[mid]) return mid;
            
            if (target < nums[mid]) {
                return helperSearch(nums, target, right, mid - 1);
            }

            return helperSearch(nums, target, mid + 1, left);
        }

        return right;
    }
}