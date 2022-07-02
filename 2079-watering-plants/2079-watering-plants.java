class Solution {
    public int wateringPlants(int[] plans, int capacity) {

        int steps = 0;
        int bucket = capacity;

        for (int i = 0; i < plans.length; i++) {

            if (plans[i] <= bucket) {
                steps++;
            } else {
                steps += (i * 2) + 1;
                bucket = capacity;
            }
            bucket -= plans[i];
        }

        return steps;
    }
}