
class NumArray {

    int[] pref;

    public NumArray(int[] nums) {
        pref = new int[nums.length];

        pref[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            pref[i] = pref[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        
        if (left == 0) return pref[right];

        return pref[right] - pref[left - 1];
    }
}