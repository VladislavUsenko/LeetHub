import java.util.*;
import java.util.Map.Entry;

public class Solution {
    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(
            1, new TreeNode(1), null

        );

        System.out.println("----------------");
        System.out.println(Arrays.toString(findFrequentTreeSum(root)));
        
    }

    public static int[] findFrequentTreeSum(TreeNode root) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        helper(root, map);

        int maxCount = Integer.MIN_VALUE;
        List<Integer> mostFreqSums = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            int sum = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount)
            {
                mostFreqSums.clear();
                mostFreqSums.add(sum);
                maxCount = count;
            }
            else if (count == maxCount)
            {
                mostFreqSums.add(sum);
            }
        }

        return mostFreqSums.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int helper(TreeNode root, HashMap<Integer, Integer> map) {

        if(root == null) return 0;

        int sum = root.val + 
            helper(root.left, map) + helper(root.right, map);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        return sum;
    }
}
