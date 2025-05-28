import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};

        System.out.println("-------------------");
        System.out.println(circularArrayLoop(nums));

    }

    public static boolean circularArrayLoop(int[] nums) {

        HashSet<Integer> curLoop = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {

            int j = i;
            boolean positive = nums[i] > 0;
            boolean curPositive = positive;

            while (positive == curPositive && nums[j] != 0) {
                System.out.println("j = " + j);
                if (curLoop.contains(j)) {
                    return true;
                }

                curLoop.add(j);

                int nextIdx = getNextIdx(j, nums);
                System.out.println("nextIdx = " + nextIdx);
                if (nextIdx == j) {
                    System.out.println("nextIdx == j");
                    break;
                }

                j = nextIdx;
                curPositive = nums[j] > 0;

            }

            curLoop.clear();
        }

        
        return false;
    }

    public static int getNextIdx(int curIdx, int[] nums) {

        int nextIdx = curIdx + nums[curIdx] % nums.length;

        if (nextIdx >= nums.length) {
            nextIdx = nextIdx - nums.length;
        }

        if (nextIdx < 0) {
            nextIdx = nums.length + nextIdx;
        }

        return nextIdx;
    }
}