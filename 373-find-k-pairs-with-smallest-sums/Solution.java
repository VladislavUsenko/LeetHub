import java.util.*;

class Solution {

    public static void main(String[] args) {
        
        int[] nums1 = {1,2,3,3,3};
        int[] nums2 = {-3,22,35,56,70,100,123,200};

        System.out.println("----------------");
        System.out.println(kSmallestPairs(nums1, nums2, 10));
        //[[1,-3],[2,-3],[3,-3],[3,-3],[3,-3],[1,22],[2,22],[3,22],[3,22],[3,22]]

    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        Comparator<List<Integer>> comparator = new Comparator<List<Integer>>() {
            
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {

                if(o1.get(0) == o2.get(0)) {
                    return Integer.compare(o1.get(1), o2.get(1));
                }
                
                return Integer.compare(o1.get(0), o2.get(0));
            }  
        };

        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(comparator);

        List<List<Integer>> result = new ArrayList<>();

        for (int x : nums1) {
            queue.offer(Arrays.asList(x + nums2[0], 0));
        }
        
        while (k > 0 && !queue.isEmpty()) {
            var pair = queue.poll();
            int sum = pair.get(0); 
            int pos = pair.get(1);

            List<Integer> currentPair = new ArrayList<>();
            currentPair.add(sum - nums2[pos]);
            currentPair.add(nums2[pos]);
            result.add(currentPair);

            if (pos + 1 < nums2.length) {
                queue.offer(Arrays.asList(sum - nums2[pos] + nums2[pos + 1], pos + 1));
            }

            k--;
        }


        return result;
    }
}