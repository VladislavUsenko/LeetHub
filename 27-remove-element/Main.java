import java.util.Arrays;

class Main {
     
    public static void main(String[] args) {
        
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        int[] expetedNums = {0, 0, 1, 3, 4};

        System.out.println("started array: " + Arrays.toString(nums));

        int k = removeElement(nums, val);

        System.out.println("updated array: " + Arrays.toString(nums));

        assert k == expetedNums.length;
        System.out.println(k);
        Arrays.sort(nums, 0,k);

        System.out.println("sorted array : " + Arrays.toString(nums));
        System.out.println("expected arr : " + Arrays.toString(expetedNums));

        for(int i = 0; i < k; i++) {
            assert nums[i] == expetedNums[i];
        }
    
    }

    public static int removeElement(int[] nums, int val) {

        int p = 0, i = 0;

        while(i < nums.length){
            if(nums[i++] != val){
                nums[p++] = nums[i-1];
            }
        }
        return p;
    }
}