import java.util.*;

class Solution {

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        System.out.println("--------------------");
        System.out.println(inorderTraversal(root));
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        
         List<Integer> result = new ArrayList<>();

        fillResult(root, result);

        return result;
    }
    
    public static void fillResult(TreeNode root, List<Integer> result){
        
        if(root != null) {
            fillResult(root.left, result);
            result.add(root.val);
            fillResult(root.right, result);
        }
    }
}