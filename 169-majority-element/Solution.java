
class Solution {

    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println("---------");
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        
        int result = 0;
        int majority = 0;

        for(int i : nums) {
            if (majority == 0) result = i;

            majority += i == result ? 1 : -1;
        }

        return result;

    }
}