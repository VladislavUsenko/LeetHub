import java.util.*;;

class Solution {

    public static void main(String[] args) {
        
        int[] nums = {71,18,52,29,55,73,24,42,66,8,80,2};

        System.out.println("-----------------");
        System.out.println(Arrays.toString(mostCompetitive(nums, 3))); // 2,6,4
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums.length; i++) {

            int deep = stack.size() + (nums.length - i);

            while (deep > k && stack.size() > 0) {
                if(stack.peek() > nums[i]) {
                    stack.pop();
                    deep++;
                } else break;
            }

            if(stack.size() < k) {
                stack.push(nums[i]);
            }
            
        }

        System.out.println(stack);

        int[] array = new int[k];
        
        for (int i = k - 1; i >= 0; i--) {
            array[i] = stack.pop();
        }
        return array;
    }
}