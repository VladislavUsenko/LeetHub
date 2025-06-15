import java.util.Arrays;

public class TreeNode {
    
    boolean isEnd;
    TreeNode[] nodes;

    TreeNode() {
        nodes = new TreeNode[26];
    }

    TreeNode(TreeNode[] nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
       
        return Arrays.toString(nodes);
    }
}
