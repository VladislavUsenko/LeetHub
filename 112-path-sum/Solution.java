import java.util.*;

class Solution {

    public static void main(String[] args) {
        
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        boolean result = false;
        ArrayList<Integer> list = new ArrayList<>();
        treeSums(root, 0, list);
        System.out.println(list);

        for (Integer i : list) {
            if (i == targetSum) {
                result = true;
                break;
            }
        }
        
        return result;
    }
    
    public void treeSums(TreeNode root, int sum,
                         ArrayList<Integer> pathSum) {

        if (root == null)
            return;

        sum += root.val;

        if (root.left == null &&
                root.right == null) {
            pathSum.add(sum);
            return;
        }

        treeSums(root.left, sum, pathSum);
        treeSums(root.right, sum, pathSum);
    }
}