import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        
        int[][] intervals = {
            {1, 3},
            {6, 9}
        };

        int[] newInterval = {2, 5};

        System.out.println("---------------");

        intervals = insert(intervals, newInterval);

        for (int[] i : intervals) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        


    }
}