import java.util.*;

class Solution {
    
    public static void main(String[] args) {

        int[][] times = {
            {2,1,1},
            {2,3,1},
            {3,4,1}
        };
        int n = 4, k = 2;
        
        System.out.println("----------");
        System.out.println(networkDelayTime(times, n, k));
    }


    public static int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] time : times) {
            graph.computeIfAbsent(time[0], _ -> new ArrayList<>())
                 .add(new int[]{time[1], time[2]});
        }

        System.out.println(graph);

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{k, 0});

        Map<Integer, Integer> dist = new HashMap<>();

        while (!queue.isEmpty()) {
            
            int[] current = queue.poll();
            int node = current[0];
            int time = current[1];
            
            if(dist.containsKey(node)) continue;

            dist.put(node, time);


            if(graph.containsKey(node)) {
                for(int[] neighbor : graph.get(node)) {
                    int nei = neighbor[0];
                    int wt = neighbor[1];
                    if (!dist.containsKey(nei)) {
                        queue.offer(new int[]{nei, time + wt});
                    }
                }
            }

        }
        System.out.println(dist);

        if (dist.size() == n) {
            return Collections.max(dist.values());
        }
        
        return -1;
    }

}