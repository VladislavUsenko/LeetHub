import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {

        Set<Integer> numSet = new HashSet<>();

        for (int num: nums) {
            if (!numSet.add(num)) numSet.remove(num);
        }

        return numSet.iterator().next();
    }
}