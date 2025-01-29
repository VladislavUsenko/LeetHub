
class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(
            3, new TreeNode(4,
            new TreeNode(1),
            new TreeNode(2)),
            new TreeNode(5)
        );

        TreeNode subRoot = new TreeNode(4,
        new TreeNode(1),
        new TreeNode(2));

        System.out.println("-------------");
        System.out.println("result: " + isSubtree(root, subRoot));
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if (root == null) return false;
        if (compareTrees(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean compareTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null) return false;


        return (
            root1.val == root2.val &&
            compareTrees(root1.left, root2.left) &&
            compareTrees(root1.right, root2.right)
            );
    }
}