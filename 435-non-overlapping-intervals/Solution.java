import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        int[][] intervals = {{1,2},{1,2},{2,3},{3,4},{1,3}};

        System.out.println("----------");
        System.out.println(eraseOverlapIntervals(intervals));

    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int[] current = intervals[0];

        int res = 0;

        for(int i = 1; i < intervals.length; i++) {

            if(intervals[i][0] < current[1]) {
                res++;
            } else {
                current = intervals[i];
            }
        }


        return res;
    }
}