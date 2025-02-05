import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};

        rotate(nums, 3);

        System.out.println("-------------");
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {

        Deque<Integer> queue = new ArrayDeque<>();

        for (int num : nums) queue.add(num);

        while (k > 0) {
            queue.addFirst(queue.pollLast());
            k--;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = queue.poll();
        }
    }
}