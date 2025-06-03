import java.util.*;


class Solution {
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("-----------------");
        System.out.println(levelOrder(root));
    }
  
    public static List<List<Integer>> levelOrder(TreeNode root) {

        ArrayList<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> row = new ArrayList<>();

            for (int i = 0; i < size; i ++) {

              TreeNode node = queue.poll();
              row.add(node.val);
              if (node.left != null) queue.add(node.left);
              if (node.right != null) queue.add(node.right);

            }

            result.add(row);
        }

        return result;
    }
    
}