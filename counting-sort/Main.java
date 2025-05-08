import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] nums = {25, 12, 9, 30, 1, 28, 3, 24, 6, 20,
                17, 11, 5, 18, 2, 29, 4, 15, 8, 7,
                23, 19, 13, 27, 10, 21, 14, 22, 26, 16};

        nums = bucketSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static int[] countingSort(int[] nums){

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length + 1; i++) {
            map.put(i, 0);
        }

        for (int num : nums) {
            map.put(num, map.get(num) + 1);
        }

        for (int i = 1; i < map.size(); i++) {
            map.put(i, map.get(i) + map.get(i - 1));
        }

        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            res[map.get(nums[i]) - 1] = nums[i];
            map.put(nums[i], map.get(nums[i]) - 1);
        }

        return res;
    }

    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // output array
        int[] count = new int[10]; // for digits 0-9

        // Count occurrences
        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so it contains actual position of this digit in output[]
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build output[] array
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy sorted numbers to arr[]
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static int[] radixSort(int[] nums) {
        int max = getMax(nums);

        for (int i = 1; max / i > 0; i *= 10) {
            countingSort(nums, i);
        }

        return nums;
    }

    public static int[] bucketSort(int[] arr) {
        if (arr.length == 0) return arr;

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        int bucketCount = (int) Math.sqrt(arr.length); // heuristic
        int range = (max - min + 1);

        // Create buckets
        @SuppressWarnings("unchecked")
        List<Integer>[] buckets = new List[bucketCount];
        for (int i = 0; i < bucketCount; i++)
            buckets[i] = new ArrayList<>();

        // Distribute elements into buckets
        for (int num : arr) {
            int bucketIndex = (int) ((long)(num - min) * bucketCount / range);
            if (bucketIndex >= bucketCount) bucketIndex = bucketCount - 1; // fix edge case
            buckets[bucketIndex].add(num);
        }

        // Sort individual buckets and merge
        int index = 0;
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (int num : bucket) {
                arr[index++] = num;
            }
        }

        return arr;
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int value : arr)
            if (value > max)
                max = value;
        return max;
    }
}
