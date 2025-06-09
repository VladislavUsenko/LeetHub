import java.util.*;

class Solution {


    public static void main(String[] args) {
        
        int n = 4;
        int [][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;

        System.out.println("----------------------");
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        

        Map<Integer, List<int[]>> graph = new HashMap<>();

        for(int i = 0; i < flights.length; i++) {
            graph.computeIfAbsent(flights[i][0], _ -> new ArrayList<>())
                .add(new int[]{flights[i][1], flights[i][2]});
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        heap.offer(new int[]{src, 0, 0});

        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;

        while (!heap.isEmpty()) {
            
            int[] city = heap.poll();

            int cityNum = city[0];
            int price = city[1];
            int level = city[2];

            if(cityNum == dst) return price;

            if(level <= k && graph.containsKey(cityNum)) {
     
                for (int[] neighbor : graph.get(cityNum)) {
                    int next = neighbor[0];
                    int cost = neighbor[1];
                    int newCost = cost + price;

                    if (newCost < dist[next][level + 1]) {
                        dist[next][level + 1] = newCost;
                        heap.offer(new int[]{newCost, next, level + 1});
                    }
                }
            }
        }


        return -1;
    }
}