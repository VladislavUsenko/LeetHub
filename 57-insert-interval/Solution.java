import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        
        int[][] intervals 
       // = {{1, 3},{6, 9}};
       //  = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        = {{1,5}};

        int[] newInterval 
       // = {2,5};
      //  ={4,8};
        ={6,8};

        System.out.println("---------------");

        intervals = insert(intervals, newInterval);

        for (int[] i : intervals) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
       List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));
        intervalList.add(newInterval);
        Collections.sort(intervalList, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        int[] current = intervalList.get(0);

        for (int i = 1; i < intervalList.size(); i++) {
            int[] interval = intervalList.get(i);
            
            if (current[1] >= interval[0]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                res.add(current);
                current = interval;
            }
        }

        res.add(current);
        return res.toArray(new int[res.size()][]);
    }
}