import java.util.HashSet;
import java.util.Set;

public class Solution {
    
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};

        int k = removeDuplicates(nums);

        System.out.println(k);

        for (int i : nums) {
            System.out.print(i);
        }
        

    }

    public static int removeDuplicates(int[] nums) {
        
        int j = 0;
        for(int i  = 0; i < nums.length - 1; i++) {
            if(nums[i] != nums[i + 1]) {
                nums[++j] = nums[i + 1];
            }
        }

        return j + 1;
    }
}
