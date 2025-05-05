import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] heights = {1,3,3,3,1,3};

        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {

        if (heights.length == 1) return heights[0];

        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{0, heights[0]});

        int max = 0;

        for (int i = 1; i < heights.length; i++) {
            if(heights[i] > stack.peek()[1]) {
                stack.push(new int[]{i, heights[i]});
            } else if (heights[i] == stack.peek()[1]) {
                continue;
            } else {
                int idx = 0;

                while (!stack.isEmpty() && heights[i] < stack.peek()[1]) {
                    int[] data = stack.pop();
                    int rec = (i - data[0]) * data[1];
                    max = Math.max(rec, max);
                    idx = data[0];
                }

                stack.push(new int[]{idx, heights[i]});
            }
        }

        while (!stack.isEmpty()) {
            int[] data = stack.pop();

            int rec = (heights.length - data[0]) * data[1];
            max = Math.max(rec, max);
        }

        return max;
    }
}
