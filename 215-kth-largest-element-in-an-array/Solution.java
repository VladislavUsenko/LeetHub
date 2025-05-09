import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] nums = {3,2,5,6,4,9};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
        System.out.println(findKthLargest1(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        int max = nums[0];
        int min = nums[0];

        for(int n : nums) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }

        int[] map = new int[max - min + 1];

        for (int num : nums) {
            map[num - min]++;
        }

        int i = map.length - 1;
        for(; i >= 0; i--) {
            k -= map[i];

            if(k <= 0){
                break;
            }
        }

        return i + min;
    }
}