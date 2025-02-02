import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        
        int[] nums = {0,1,0,3,12};

        moveZeroes(nums);

        System.out.println("-------------");
        System.out.println(Arrays.toString(nums));
        
    }

    public  static void moveZeroes(int[] nums) {
        

        for (int i = 0, j = 0; i < nums.length; i++) {

            if(nums[i] == 0) {
                if (j == -1) {
                    j = i;
                } else continue;
            } else if(j != -1) {
                int tmp = nums[i];
                nums[i] = 0;
                nums[j] = tmp;
                j++;
            }
        }
    }
}