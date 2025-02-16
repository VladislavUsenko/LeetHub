import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[] heights = {2, 3, 7, 8, 1, 5, 6, 9, 4};
        System.out.println(Arrays.toString(solution(heights)));
    }

    public static int[] solution(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];

        LinkedList<Integer> list = new LinkedList<>();
        for (int h : heights) {
            list.add(h);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 0;

        while (!list.isEmpty()) {
            minHeap.clear();

            ListIterator<Integer> iter = list.listIterator();
            Integer prev = null, curr = null, next = null;

            if (iter.hasNext()) curr = iter.next();
            if (iter.hasNext()) next = iter.next();

            while (curr != null) {
                boolean isLocalMax = (prev == null || curr > prev) && (next == null || curr > next);
                if (isLocalMax) {
                    minHeap.add(curr);
                }

                prev = curr;
                curr = next;
                next = iter.hasNext() ? iter.next() : null;
            }

            if (minHeap.isEmpty()) break;

            int highlight = minHeap.poll();
            res[count++] = highlight;
            list.removeFirstOccurrence(highlight);
        }

        return res;
    }
}
