import java.util.*;

class Solution {


    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(
            4,
            new TreeNode(
                2,
                new TreeNode(1),
                new TreeNode(3)
            ),
            new TreeNode(
                6,
                new TreeNode(5),
                new TreeNode(7)
            )
        );

        System.out.println("------------------");
        System.out.println(isValidBST(root));
    }

    static List<Integer> nums = new ArrayList<>();

    public static boolean isValidBST(TreeNode root) {

        scanBST(root);

        System.out.println(nums);
        for (int i = 0; i < nums.size() - 1; i++) {
            if(nums.get(i + 1) < nums.get(i)) return false;
        }

        return true;

    }

    public static void scanBST(TreeNode root) {

        if (root.right == null && root.left == null) {
            nums.add(root.val);
            return;
        }

        if (root.left != null) {
            scanBST(root.left);
        }

        nums.add(root.val);

        if (root.right != null) {
            scanBST(root.right);
        }
    }
}