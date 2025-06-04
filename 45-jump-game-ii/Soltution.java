import java.util.*;;

class Solution {

    public static void main(String[] args) {
        
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};

        System.out.println("--------------------");
        System.out.println("min count: " + jump(nums));
    }

    public static int jump(int[] nums) {
        int n = nums.length;
        int[] visited = new int[n];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int maxJump = nums[pos];

            for (int i = 1; i <= maxJump && pos + i < n; i++) {
                if (visited[pos + i] > visited[pos] + 1) {
                    visited[pos + i] = visited[pos] + 1;
                    queue.offer(pos + i);
                }
            }
        }

        return visited[n - 1];
    }
}