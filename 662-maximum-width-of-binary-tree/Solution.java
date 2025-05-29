import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        
        TreeNode node = new TreeNode(
            1, 
        new TreeNode(
            3,
            new TreeNode(5),
            null
        ), 
        new TreeNode(2));

        System.out.println("----------------");
        System.out.println(widthOfBinaryTree(node));
    }

    static List<Long> rights = new ArrayList<>();
    static List<Long> lefts = new ArrayList<>();

    public static int widthOfBinaryTree(TreeNode root) {
        ScanBinaryTree(root, 0, 0);
        int max = getMaxRange();
        return max;
    }

    public static void ScanBinaryTree(TreeNode root, long idx, int level) {

        if(rights.size() <= level) {
            rights.add(idx);
        } else if (rights.get(level) < idx) {
            rights.set(level, idx);
        }

        if (lefts.size() <= level) {
            lefts.add(idx);
        } else if (lefts.get(level) > idx) {
            lefts.set(level, idx);
        }

        if(root.left != null) {
            ScanBinaryTree(root.left, idx * 2, level + 1);
        }

        if(root.right != null) {
            ScanBinaryTree(root.right, idx * 2 + 1, level + 1);
        }

    }

    public static int getMaxRange() {
        int res = -1;

        for(int i = 0; i < lefts.size(); i++) {
            System.out.println("Left: " + lefts.get(i) + ", Right: " + rights.get(i));
            int curr = (int) (rights.get(i) - lefts.get(i) + 1);
            res = Math.max(res, curr);
        }

        return res;
    }
}