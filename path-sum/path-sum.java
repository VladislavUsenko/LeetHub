/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
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