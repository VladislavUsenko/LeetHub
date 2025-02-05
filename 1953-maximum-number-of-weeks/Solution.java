

class Solution {

    public static void main(String[] args) {
        
        int[] m = {1, 2, 3};
        System.out.println("-------------");
        System.out.println(numberOfWeeks(m));
    }

    public static long numberOfWeeks(int[] milestones ) {
    
        long sum = 0;
        long max = -1;

        for (int m : milestones ) {
            sum += m;
            if (m > max) max = m;
        }

        return Math.min(sum, 2 * (sum - max) + 1);
    }
}