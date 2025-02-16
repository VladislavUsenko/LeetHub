import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Main {

    public static void main(String[] args) {
        int[] nums = {1,2,4,8};

        List<Integer> result = largestDivisibleSubset(nums);
        System.out.println(result);
    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {

    int[] leng = new int[nums.length];
    int[] prev = new int[nums.length];

    int max = 0;
    int index = -1;
    
    Arrays.sort(nums);
    
    for (int i = 0; i < nums.length; i++){
        leng[i] = 1;
        prev[i] = -1;
        for (int j = i - 1; j >= 0; j--){
            if (nums[i] % nums[j] == 0 && leng[j] + 1 > leng[i]){
                leng[i] = leng[j] + 1;
                prev[i] = j;
            }
        }
        if (leng[i] > max){
            max = leng[i];
            index = i;
        }
    }

    List<Integer> res = new ArrayList<Integer>();

    while (index != -1){
        res.add(nums[index]);
        index = prev[index];
    }
    return res; 
    }
}