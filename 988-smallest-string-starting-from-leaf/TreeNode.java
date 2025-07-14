import java.util.ArrayDeque;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
            throw new IllegalArgumentException("Array must start with a non‑null root value.");
        }

        // Create the root and a queue for BFS construction.
        this.val = arr[0];
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(this);

        int i = 1; // index in the input array
        while (!q.isEmpty() && i < arr.length) {
            TreeNode curr = q.poll();

            // left child
            if (i < arr.length && arr[i] != null) {
                curr.left = new TreeNode(arr[i]);
                q.add(curr.left);
            }
            i++;

            // right child
            if (i < arr.length && arr[i] != null) {
                curr.right = new TreeNode(arr[i]);
                q.add(curr.right);
            }
            i++;
        }
    }
}