class Solution {

    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(new Integer[]{0,1,2,3,4,3,4});
        String s = smallestFromLeaf(root);

        System.out.println("=====================");
        System.out.println(s);
    }

    private  static String best = "~";       
    private  static final StringBuilder path = new StringBuilder();

    public static String smallestFromLeaf(TreeNode root) {
        dfs(root);
        return best;
    }

    private static void dfs(TreeNode node) {
        if (node == null) return;

        path.append((char) ('a' + node.val));

        if (node.left == null && node.right == null) { 
            
            String candidate = path.reverse().toString();
            path.reverse();                               
            if (candidate.compareTo(best) < 0) best = candidate;
        }

        dfs(node.left);
        dfs(node.right);

        path.setLength(path.length() - 1);
    }
}