import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {


        int[] arrayOne =  {1,2,3,1};
        int[] arrayTwo =  {1,0,1,1};
        int[] arrayThree =  {1,2,3,1,2,3};

        System.out.println(containsNearbyDuplicate(arrayOne, 3));
        System.out.println(containsNearbyDuplicate(arrayTwo, 1));
        System.out.println(containsNearbyDuplicate(arrayThree, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer, Integer> mp = new HashMap<>();

        int n = nums.length;

        for(int i = 0; i < n; i++) {

            if(mp.get(nums[i]) != null) {
                if(i - mp.get(nums[i]) <= k) {
                     return true;
                }
            }

            mp.put(nums[i], i);
        }


        return false;
    }
}