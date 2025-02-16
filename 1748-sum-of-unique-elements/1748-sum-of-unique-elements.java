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
    
    
    public int sumOfUnique2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        if (nums.length == 1) return nums[0];
        if (nums[0] == nums[nums.length - 1]) return 0;

        int count = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                sum += nums[i];
                count = 1;
            } else {
                count++;
                if (count <= 2) sum -= nums[i + 1];
            }
        }
        return sum + nums[nums.length - 1];
    }
}