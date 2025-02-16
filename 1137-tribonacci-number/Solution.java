class Solution {

    public static void main(String[] args) {
        System.out.println();
        System.out.println(tribonacci(25));
    }

    public static int tribonacci(int n) {
        
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;

        int tn = 0;
        int tn1 = 1;
        int tn2 = 1;

        int result = 0;

        for (int i = 0; i < n - 2; i++) {
            result = tn + tn1 + tn2;
            tn = tn1;
            tn1 = tn2;
            tn2 = result;
        }


        return result;

    }
}