class Solution {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(20 ,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        int sum = sumOfLeftLeaves(root);
        System.out.println(sum);

    }

    public static int result = 0;
    public static int sumOfLeftLeaves(TreeNode root) {
        if(root.left == null && root.right == null) return result;

        counterLeaves(root);

        return result;
    }

    public static void counterLeaves(TreeNode root) {

        if(root.left != null) {
            TreeNode left = root.left;
            if (left.left == null && left.right == null) {
                result += left.val;
            } else {
                counterLeaves(root.left);
            }
        }

        if (root.right != null) {
            counterLeaves(root.right);
        }
    }
}