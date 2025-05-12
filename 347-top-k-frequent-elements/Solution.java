import java.util.*;

class Solution {

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,3};

        int[] res = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(res));

    }

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0],o1[0]);
            }
        };

        PriorityQueue<int[]> heap = new PriorityQueue<>(comparator);

        for(Map.Entry<Integer, Integer> set: map.entrySet()) {
            heap.add(new int[]{set.getValue(), set.getKey()});
        }

        int idx = 0;
        int[] res = new int[k];
        while (idx < k){
            if (heap.isEmpty()) return res;
            res[idx++] = heap.poll()[1];
        }

        return res;
    }
}