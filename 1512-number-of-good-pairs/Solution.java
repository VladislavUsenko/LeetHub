public class Solution {
    
    public static void main(String[] args) {
        
        int[] nums = {1,2,3,1,1,3};

        int result = numIdenticalPairs(nums);
        System.out.println(result);

    }

    public static int numIdenticalPairs(int[] nums) {
        
        int result = 0;

        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j] && i < j) ++result;
            }
        }

        return result;
    }
}
