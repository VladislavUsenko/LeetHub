class Solution {

    public static void main(String[] args) {
        
        int[] nums = {4,5,6,7,0,1,2};

        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {

        int right = 0;
        int left = nums.length - 1;

        while (right < left) {
            
            int mid = right + (left - right) / 2;
            
            if(nums[mid] <= nums[left]) {
                left = mid;
            } else right = mid + 1;
                
        }

        return nums[left];
    }
}