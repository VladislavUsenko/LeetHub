import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {

        Integer[] root = {5,8,9,2,1,3,7,4,6};
        TreeNode node = new TreeNode(root);

        System.out.println("----------------");
        System.out.println(kthLargestLevelSum(node, 2));
    }

    public static long kthLargestLevelSum(TreeNode root, int k) {

        List<Long> sums = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){

            int size = queue.size();
            long curr=0L;

            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                curr += (long) node.val;

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            sums.add(curr);
        }

        if(sums.size() < k){
            return -1;
        }
        
        Collections.sort(sums,Collections.reverseOrder());

        return sums.get(k - 1);
    }
}