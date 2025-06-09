import java.util.*;

class Solution {

    public static void main(String[] args) {
        
        int n = 4, distanceThreshold = 4;
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};

        System.out.println("---------------------------");
        System.out.println(findTheCity(n, edges, distanceThreshold));
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int i = 0; i < edges.length; i++) {
            graph.computeIfAbsent(edges[i][0], _ -> new ArrayList<>())
                .add(new int[]{edges[i][1], edges[i][2]});
            
            graph.computeIfAbsent(edges[i][1], _ -> new ArrayList<>())
                .add(new int[]{edges[i][0], edges[i][2]});
        }

        int minCities = Integer.MAX_VALUE;
        int result = -1;
        for(int i = 0; i < n; i++) {

            int currCities = getVisitedCities(i, graph, distanceThreshold, n);
            if(minCities >= currCities) {
                minCities = currCities;
                result = i;
            }
        }

        return result;
    }

    private static int getVisitedCities(int city, Map<Integer, List<int[]>> graph, int distanceThreshold, int n) {

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        heap.offer(new int[]{city, 0});

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[city] = 0;

        while (!heap.isEmpty()) {
            
            int[] curr = heap.poll();

            int currCity = curr[0];
            int currDist = curr[1];

            if (!graph.containsKey(currCity)) continue;

            for (int[] neighbor : graph.get(currCity)) {
                int next = neighbor[0];
                int weight = neighbor[1];
                int newDist = currDist + weight;

                if (newDist <= distanceThreshold && newDist < dist[next]) {
                    dist[next] = newDist;
                    heap.offer(new int[]{next, newDist});
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i != city && dist[i] <= distanceThreshold) count++;
        }

        return count;
    }
}