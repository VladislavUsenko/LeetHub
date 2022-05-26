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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
    ArrayList<List<Integer>> matrix = new ArrayList<>();

        int h = height(root);
        for (int i = 1; i <= h; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            printCurrentLevel(root, i, list);
            matrix.add(list);
        }
        return matrix;
    }

     public int height(TreeNode root) {
        if (root != null) {
            int lh = height(root.left);
            int rh = height(root.right);

            if (lh > rh) {
                return (lh + 1);
            } else return (rh + 1);
        } else return 0;
    }

     void printCurrentLevel(TreeNode root, int level, ArrayList<Integer> levelList) {
        if (root == null)
            return;
        if (level == 1) {
            levelList.add(root.val);


        } else if (level > 1) {
            printCurrentLevel(root.left, level - 1, levelList);
            printCurrentLevel(root.right, level - 1, levelList);
        }


    }
}