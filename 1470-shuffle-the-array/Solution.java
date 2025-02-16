import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 3, 4, 7, 8, 9, 10};
        int n = 3;
        int[] result = shuffle(nums, n);
        System.out.println(Arrays.toString(result));
    }

    public static int[] shuffle(int[] nums, int n) {

        int[] ans = new int[nums.length];
        int left = 0;
        int i = 0;
        int right = n;
        while (right < nums.length) {
            ans[i] = nums[left];
            i++;
            ans[i] = nums[right];
            i++;
            left++;
            right++;
        }
        return ans;
    }
}