class Solution {

    public static void main(String[] args) {
        
        int[] nums = {1,2,3,0};

        System.out.println(findPeakElement(nums));
    }

    public static int findPeakElement(int[] nums) {

        int right = 0;
        int left = nums.length - 1;

        while (right < left) {
            
            int mid = right + (left - right) / 2;
            
            if(nums[mid] > nums[mid + 1]) {
                left = mid;
            } else right = mid + 1;
                
        }

        return left;
    }
}