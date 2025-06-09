import java.util.*;

class Solution {

    public static void main(String[] args) {
        int numCourses = 5;
        int[][] prerequisites = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int[][] queries = {{0, 4}, {4, 0}, {1, 3}, {3, 0}};

        System.out.println(checkIfPrerequisite(numCourses, prerequisites, queries));
    }

    public static List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] p : prerequisites) {
            graph.computeIfAbsent(p[0], _ -> new HashSet<>()).add(p[1]);
        }

        
        Map<Integer, Set<Integer>> memo = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            dfs(i, graph, memo);
        }

        System.out.println(memo);
        
        List<Boolean> result = new ArrayList<>();
        for (int[] q : queries) {
            int from = q[0], to = q[1];
            result.add(memo.getOrDefault(from, Collections.emptySet()).contains(to));
        }

        return result;
    }


    private static Set<Integer> dfs(int node, Map<Integer, Set<Integer>> graph, Map<Integer, Set<Integer>> memo) {
        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        Set<Integer> reachable = new HashSet<>();
        if (graph.containsKey(node)) {
            for (int neighbor : graph.get(node)) {
                reachable.add(neighbor);
                reachable.addAll(dfs(neighbor, graph, memo));
            }
        }

        memo.put(node, reachable);
        return reachable;
    }
}
