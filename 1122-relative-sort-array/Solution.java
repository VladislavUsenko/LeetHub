import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public static void main(String[] args) {
        int[] arr1 = {2,14,3,1,8,3,2,4,6,19,9,2,7};
        int[] arr2 = {2,1,4,3,9,6};

        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i: arr2) {
            map.put(i, map.getOrDefault(i, 0));
        }

        for (int i: arr1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
        }

        for (int i = 1; i < arr2.length; i++) {
            map.put(arr2[i], map.get(arr2[i]) + map.get(arr2[i - 1]));
        }

        int[] res = new int[arr1.length];
        int notAppIdx = arr1.length - 1;
        for (int i = arr1.length - 1; i >= 0; i--) {
            if(map.containsKey(arr1[i])){
                res[map.get(arr1[i]) - 1] = arr1[i];
                map.put(arr1[i], map.get(arr1[i]) - 1);
            } else {
                res[notAppIdx] = arr1[i];
                notAppIdx--;
            }

        }

        for (int i = 0; i < res.length - notAppIdx - 1; i++) {
            for (int j = notAppIdx + 1; j < res.length - i - 1; j++) {
                if(res[j] > res[j + 1]) {
                    int tmp = res[j];
                    res[j] = res[j + 1];
                    res[j + 1] = tmp;
                }
            }
        }

        return res;
    }
}