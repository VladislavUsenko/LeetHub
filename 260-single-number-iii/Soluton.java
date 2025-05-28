import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        
        int[] nums = {1,2,1,3,2,5};
        System.out.println("----------------");
        System.out.println(Arrays.toString(singleNumber(nums)));
    }

    public static int[] singleNumber(int[] nums) {

        Set<Integer> numSet = new HashSet<>();

        for (int num: nums) {
            if (!numSet.add(num)) numSet.remove(num);
        }

        int[] res = new int[2];
        int idx = 0;
        for (var num : numSet) {
            res[idx] = num;
            idx++;
        }

        return res;
    }
}