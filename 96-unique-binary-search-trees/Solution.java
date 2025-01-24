
class Solution {

    public static void main(String[] args) {
        System.out.println("----------------------");
        System.out.println(numTrees(5));
    }

    public static int numTrees(int n) {

        if (n < 3) return n;

        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        array[2] = 2;

        for(int i = 3; i <= n; i++) {
            int num = 0;
            for (int j = 1; j <= i; j++) {
                int left = j - 1;
                int right = i - j;
                num += array[left] * array[right];
            }
            array[i] = num;
        }
        

        return array[n];
    }
}