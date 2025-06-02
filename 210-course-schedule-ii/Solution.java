
import java.util.*;


class Solution {

    public static void main(String[] args) {
        
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};

        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites) {
            List<Integer> node = graph.get(prerequisite[1]);
            node.add(prerequisite[0]);
        }

        System.out.println(graph);

        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
        }

        System.out.println(Arrays.toString(indegree));

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result.add(course);

            for (int neighbor : graph.get(course)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        System.out.println(result);

        if (result.size() == numCourses) {
            return result.stream().mapToInt(i -> i).toArray();
        } else {
            return new int[0];
        }
    }
}