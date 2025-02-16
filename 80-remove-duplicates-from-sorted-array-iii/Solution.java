

class Solution {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,2,3};

        System.out.println("-------------");
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        
        if (nums.length <= 2) return nums.length;

        int i = 2, j = 2;
        while(i < nums.length) {

            if (nums[i] != nums[j - 2]) {
                nums[j] = nums[i];
                j++;
            }

            i++;
        }


        return j;
    }
}