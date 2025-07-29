import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[][] pairs = {{1,2}, {2,3}, {3,4}};

        System.out.println("===========================");
        System.out.println(findLongestChain(pairs));
    }

    public static int findLongestChain(int[][] pairs) {
    
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int currentEnd = Integer.MIN_VALUE;
        int length = 0;

        for (int[] pair : pairs) {
            if (pair[0] > currentEnd) {
                currentEnd = pair[1];
                length++;
            }
        }

        return length;
    }
}
