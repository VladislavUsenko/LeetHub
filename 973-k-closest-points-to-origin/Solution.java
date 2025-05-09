import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {

        int[][] points = {{1,3},{-2,2},{3,3},{-1,-1}};
        int k = 2;

        int[][] result = kClosest(points, k);

        for (int[] xy : result) {
            System.out.println(Arrays.toString(xy));
        }
    }

    public static int[][] kClosest(int[][] points, int k) {

        Comparator<Point> comparator = Comparator.comparingDouble(point -> point.distance);

        PriorityQueue<Point> queue = new PriorityQueue<>(comparator);

        for(int[] xy : points) {
            queue.add(
                    new Point(xy[0], xy[1])
            );
        }


        int[][] res = new int[k][2];
        while (k > 0) {
            Point p = queue.poll();
            res[k-1][0] = p.x;
            res[k-1][1] = p.y;
            k--;
        }

        return res;
    }
}