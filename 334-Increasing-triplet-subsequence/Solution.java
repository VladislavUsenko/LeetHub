class Solution {

    public static void main(String[] args) {
        int[] nums = {2,1,5,0,4,6};

        System.out.println("=================");
        System.out.println(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i : nums) {
            if (i <= first) {
                first = i;
                System.out.println("Frist is " + first);
            } else if (i <= second) {
                second = i;
                System.out.println("Second is " + second);
            } else {
                System.out.println("Third is " + i);
                return true;
            }
        }

        return false;
    }
}