class Solution {
    public static void main(String[] args) {
        
        int[] nums = {1,12,-5,-6,50,3};

        System.out.println("=============");
        System.out.println(findMaxAverage(nums, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {

        double res = Integer.MIN_VALUE;

        int n = nums.length;

        double temp = 0;
        for(int i = 0; i < k; i++) {
            temp += nums[i];
        }
        
        res = Math.max(res, temp / k + 0.00);

        for (int i = 0, j = k; j < n; i++, j++) {
            temp -= nums[i];
            temp += nums[j];

            res = Math.max(res, temp / k + 0.00);
        }

        return res;
    }   
}