import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        System.out.println("-----------");
        merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (m == 0) nums1 = nums2;
        if (n == 0) return;

        for(int i = 0; i < nums2.length; i++) {
            nums1[i + m] = nums2[i];
        }

        Arrays.sort(nums1);
        
    }
}