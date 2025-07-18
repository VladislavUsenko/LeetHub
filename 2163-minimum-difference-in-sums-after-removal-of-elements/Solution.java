import java.util.*;

class Solution {
    public static long minimumDifference(int[] nums) {
        int n = nums.length / 3;
        int length = nums.length;

        long[] leftSum = new long[n + 1];  // max sum of n smallest elements from left
        long[] rightSum = new long[n + 1]; // min sum of n largest elements from right

        // LEFT SIDE: max sum of n elements from first 2n elements
        PriorityQueue<Integer> maxHeapLeft = new PriorityQueue<>(Collections.reverseOrder());
        long leftRunningSum = 0;

        for (int i = 0; i < 2 * n; i++) {
            maxHeapLeft.offer(nums[i]);
            leftRunningSum += nums[i];

            if (maxHeapLeft.size() > n) {
                leftRunningSum -= maxHeapLeft.poll();
            }

            if (i >= n - 1) {
                leftSum[i - n + 1] = leftRunningSum;
            }
        }

        // RIGHT SIDE: min sum of n elements from last 2n elements
        PriorityQueue<Integer> minHeapRight = new PriorityQueue<>();
        long rightRunningSum = 0;

        for (int i = length - 1; i >= n; i--) {
            minHeapRight.offer(nums[i]);
            rightRunningSum += nums[i];

            if (minHeapRight.size() > n) {
                rightRunningSum -= minHeapRight.poll();
            }

            if (i <= 2 * n) {
                rightSum[i - n] = rightRunningSum;
            }
        }

        // Compare the differences
        long result = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            result = Math.min(result, leftSum[i] - rightSum[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {7, 9, 5, 8, 1, 3};
        System.out.println(minimumDifference(nums));  // Expected: 1
    }
}
