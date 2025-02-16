class Solution {
    public double average(int[] salary) {
        
        Arrays.sort(salary);
        if (salary.length == 3) return salary[1];

        double average = 0.0;

        for (int i = 1; i < salary.length - 1; i++) {
            average += salary[i];
        }

        return average/(salary.length - 2);
    }
}