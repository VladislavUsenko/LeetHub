import java.util.*;

class Solution {

    public static void main(String[] args) {

        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        int[][] result = merge(intervals);

        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval));
        }

        System.out.println();
        
    }

    public static int[][] merge(int[][] intervals) {
        
        List<int[]> result  = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int a = intervals[0][0];
        int b = intervals[0][1];

        for(int[] interval : intervals) {
            if (interval[0] > b) {
                result.add(new int[]{a, b});
                a = interval[0];
                b = interval[1];
            } else if(interval[1] > b) {
                b = interval[1];
            }
        }

        result.add(new int[]{a, b});


        return result.toArray(new int[result.size()][]);
    }
}