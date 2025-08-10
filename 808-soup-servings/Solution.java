class Solution {

    public static void main(String[] args) {
        

        System.out.println("==================");
        System.out.println(soupServings(1000));
    }


    public static double soupServings(int n) {

        if (n > 4800) return 1;
        n = n / 25;
        Double[][] cache = new Double[n + 1][n + 1];

        return dfs(n, n, cache);
    }

    public static double dfs(int soupA, int soupB, Double[][] cache){

        if(soupA <= 0 && soupB <= 0) return 0.5;

        if(soupA <= 0) return 1.0;
        if(soupB <= 0) return 0.0;

        if(cache[soupA][soupB] != null) return cache[soupA][soupB];

        cache[soupA][soupB] = 0.25 * (
            dfs(soupA - 4, soupB, cache) +
            dfs(soupA - 3, soupB - 1, cache) +
            dfs(soupA - 2, soupB - 2, cache) +
            dfs(soupA - 1, soupB - 3, cache)
        );

        return cache[soupA][soupB];

    }
}