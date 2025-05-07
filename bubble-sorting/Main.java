import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        int[] nums = {25, 12, 9, 30, 1, 28, 3, 24, 6, 20,
                17, 11, 5, 18, 2, 29, 4, 15, 8, 7,
                23, 19, 13, 27, 10, 21, 14, 22, 26, 16};

        //mergeSort(nums, 0, nums.length - 1);
        heapSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }

    }

    public static void selectionSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            int minIdx = i;
            int min = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    minIdx = j;
                }
            }

            int tmp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = tmp;
        }
    }

    public static void insertionSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j - 1]) {
                int tmp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = tmp;
                j--;
            }
        }
    }

    public static void mergeSort(int[] nums, int left, int right) {

        if(left >= right) return;

        int mid = (right + left) / 2;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, right, mid);
    }

    public static void merge(int[] nums, int left, int right, int middle) {

        int[] mergedNums = new int[right - left + 1];

        int i = left;
        int idx = 0;
        int j = middle + 1;

        while (i <= middle && j <= right) {
            if(nums[i] <= nums[j]) {
                mergedNums[idx] = nums[i];
                i++;
            } else {
                mergedNums[idx] = nums[j];
                j++;
            }
            idx++;
        }

        while (i <= middle) {
            mergedNums[idx] = nums[i];
            idx++;
            i++;
        }

        while (j <= right) {
            mergedNums[idx] = nums[j];
            idx++;
            j++;
        }


        for (int k = 0; k < mergedNums.length; k++) {
            nums[k + left] = mergedNums[k];
        }
    }
    
    public static void heapSort(int[] nums) {
        
        int len = nums.length;

        for (int i = nums.length / 2 - 1; i > -1; i--) {
            heapify(nums, len, i);
        }

        for (int i = nums.length - 1; i > 0 ; i--) {
            int tmp = nums[i];
            nums[i] = nums[0];
            nums[0] = tmp;
            heapify(nums, i, 0);
        }
    }

    public static void heapify(int[] nums, int len, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < len && nums[left] > nums[largest]) {
            largest = left;
        }

        if (right < len && nums[right] > nums[largest]) {
            largest = right;
        }

        if (largest != i) {
            int tmp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = tmp;
            heapify(nums, len, largest);
        }

    }
}
