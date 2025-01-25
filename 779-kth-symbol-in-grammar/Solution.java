class Solution {

    public static void main(String[] args) {
        System.out.println(kthGrammar(2, 2));
    }

    public static int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }

        int parent = kthGrammar(n - 1, (int) Math.ceil(k / 2.0));
        boolean isOdd = k % 2 == 1;

        if (parent == 0) {
            return isOdd ? 0 : 1;
        } else {
            return isOdd ? 1 : 0;
        } 
    }
}