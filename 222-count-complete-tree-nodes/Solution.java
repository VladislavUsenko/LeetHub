class Solution {


    static int res = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        System.out.println("-------------");
        System.out.println(countNodes(root));
    }

    public static int countNodes(TreeNode root) {
        
        helper(root);
        return res;
    }

    public static void helper(TreeNode root) {

        if (root != null) {
            res++;
            helper(root.left);
            helper(root.right);
        } 
    }
}