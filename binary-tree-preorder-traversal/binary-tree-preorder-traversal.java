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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();       
        
        fillList(root, result);


        return result;
    }
    
    public void fillList(TreeNode root, List<Integer> list) {
        
        if(root != null) {
            
            list.add(root.val);
            fillList(root.left, list);
            fillList(root.right, list);
        }
    }
}