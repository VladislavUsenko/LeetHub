class Solution {
    public long subArrayRanges(int[] nums) {
        
        long result = 0;
        
        for(int i = 0; i < nums.length - 1; i++) {
            
            int max = nums[i];
            int min = nums[i];
            
            for(int j = i + 1; j < nums.length; j++) {
                
                max = max > nums[j] ? max : nums[j];
                min = min < nums[j] ? min : nums[j];
                
                result += (max - min);
            }
        }
        
        return result;
    }
}