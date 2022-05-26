class Solution {
    public int[] sumZero(int n) {
        
    int[] arr = new int[n];

        int i = 0;
        while(i < n) {
            arr[i] = i;
            arr[n-i -1] = -i;
            i++;
        }
        if (n % 2 != 0) arr[n/2] = 0;

        return arr;
    }
}