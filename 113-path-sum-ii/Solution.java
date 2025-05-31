import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public static void main(String[] args) {
    //root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);


        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));

    }

    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        findPathSum(root, targetSum, 0);
        
        return result;
    }

    public static void findPathSum(TreeNode root, int target, int sum) {

        if (root == null) return;

        sum += root.val;
        path.add(root.val);

        if (root.left == null && root.right == null) {
            if(sum == target) result.add(List.copyOf(path));
        }

        findPathSum(root.left, target, sum);
        findPathSum(root.right, target, sum);

        path.removeLast();

    }
}
