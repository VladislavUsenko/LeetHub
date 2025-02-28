import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        
        int[] nums1 = {1, 2, 3, 3};
        int[] nums2 = {1, 1, 2, 2};

        System.out.println("==================");
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i : nums1) set1.add(i);
        for(int i : nums2) set2.add(i);

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());

        for (Integer i : set1) {
            if (!set2.contains(i)) {
                res.get(0).add(i);
            }
        }

        for (Integer i : set2) {
            if (!set1.contains(i)) {
                res.get(1).add(i);
            }
        }

        return res;
    }
}