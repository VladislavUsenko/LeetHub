class Solution {
     public static int[] sumZero(int n) {

        int[] arr = new int[n];

        int i = 0;
        while (i < n / 2) {
            arr[i] = i + 1;
            arr[n - i - 1] = -(i + 1);
            i++;
        }

        return arr;
    }
}