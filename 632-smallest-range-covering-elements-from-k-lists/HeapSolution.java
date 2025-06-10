import java.util.*;;

class HeapSolution {

    public static void main(String[] args) {
        
        List<List<Integer>> nums = List.of(
            List.of(4,10,15,24,26),
            List.of(0,9,12,20),
            List.of(5,18,22,30)
        );

        System.out.println(Arrays.toString(smallestRange(nums)));
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        
        int maxRange = Integer.MIN_VALUE;
        
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < nums.size(); i++) {
            heap.offer(new int[]{nums.get(i).get(0), i, 0});
            maxRange = Math.max(maxRange, nums.get(i).get(0));
        }

        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        while (!heap.isEmpty()) {

            int[] curr = heap.poll();
            int minRange = curr[0];
            System.out.println(minRange + " " + maxRange);

            if (maxRange - minRange < rangeEnd - rangeStart) {
                rangeStart = minRange;
                rangeEnd = maxRange;
            }

            if(curr[2] == nums.get(curr[1]).size() - 1) break;

            int nextNum = nums.get(curr[1]).get(curr[2] + 1);
            maxRange = Math.max(nextNum, maxRange);
            heap.offer(new int[]{nextNum, curr[1], curr[2] + 1});

        }

        return new int[]{rangeStart, rangeEnd};
    }
}