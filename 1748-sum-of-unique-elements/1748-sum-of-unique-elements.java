class Solution {
    public int sumOfUnique(int[] nums) {
       int sum = 0;

        Set<Integer> set = new HashSet<>();
        List<Integer> removeItem = new LinkedList<>();

        for (int i : nums) {
            if (set.contains(i)) {
                removeItem.add(i);
            } else set.add(i);
        }

        for (Integer i : removeItem) set.remove(i);
        for (Integer i : set) sum += i;

        return sum; 
    }
}