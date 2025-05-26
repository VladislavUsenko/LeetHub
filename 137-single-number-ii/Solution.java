import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        
        System.out.println("-------------");
        System.out.println(singleNumber(nums));
    }


    public static int singleNumber(int[] nums) {
        
        Set<Integer> numSet = new HashSet<>(); // 99 
        Set<Integer> twiceSet = new HashSet<>(); //0, 1 

        for (int num: nums) {
            if (numSet.contains(num) && !twiceSet.contains(num)) {
                    numSet.remove(num);
                    twiceSet.add(num);
            } else if (!twiceSet.contains(num)) {
                numSet.add(num);
            }
        }

        return numSet.iterator().next();
    }
}