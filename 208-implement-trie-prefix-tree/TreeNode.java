import java.util.*;

public class TreeNode {
    
    Character c;
    boolean isLeaf;
    Map<Character, TreeNode> nodes;

    TreeNode(char c) {
        this.c = c;
        isLeaf = false;
    }

    TreeNode(char c, Map<Character, TreeNode> nodes) {
        this.c = c;
        this.nodes = nodes;
        isLeaf = false;
    }

    @Override
    public String toString() {
        return this.c + " -> " + this.nodes;
    }
}
