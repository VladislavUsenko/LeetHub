import java.util.*;;

class Solution {

    public static void main(String[] args) {
        
        List<List<Integer>> nums = List.of(
            List.of(4,10,15,24,26),
            List.of(0,9,12,20),
            List.of(5,18,22,30)
        );

        System.out.println(Arrays.toString(smallestRange(nums)));
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        
        int minRange = 0;
        int maxRange = 0;
        int diff = Integer.MAX_VALUE;
        
        int[] poiters = new int[nums.size()];

        while (true) {

            int currMinRange = Integer.MAX_VALUE;
            int currMaxRange = Integer.MIN_VALUE;
            int minIdx = -1;

            for(int i = 0; i < poiters.length; i++){
                int firstVal = nums.get(i).get(poiters[i]);
                if(currMinRange > firstVal) {
                    currMinRange = firstVal;
                    minIdx = i;
                }
                currMaxRange = Math.max(currMaxRange, firstVal);
            }

            if (currMaxRange - currMinRange < diff) {
                maxRange = currMaxRange;
                minRange = currMinRange;
                diff = currMaxRange - currMinRange;
            }

            poiters[minIdx]++;

            if (poiters[minIdx] == nums.get(minIdx).size()) break;

        }
        
        return new int[]{minRange, maxRange};
    }
}