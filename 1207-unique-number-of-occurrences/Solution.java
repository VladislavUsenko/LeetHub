import java.util.*;

class Solution {

    public static void main(String[] args) {
        
        int[] nums = {1,2,2,1,1,3};

        System.out.println("================");
        System.out.println(uniqueOccurrences(nums));
    }


    public static boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Set<Integer> set = new HashSet<>();

        for(var value: map.values()) {
            if (set.contains(value)) {
                return false;
            } else {
                set.add(value);
            }
        }

        return true;
    }
}