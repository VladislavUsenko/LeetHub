import java.util.*;

class Trie {

    Map<Character, TreeNode> nodes;

    public Trie() {
        nodes = new HashMap<>();
    }
    
    public void insert(String word) {
        
        char[] letters = word.toCharArray();

        TreeNode currNode = nodes.containsKey(letters[0]) ?
                nodes.get(letters[0]) :
                new TreeNode(letters[0], new HashMap<>());

        nodes.put(letters[0], currNode);

        for(int i = 1; i < letters.length; i++) {

            if(currNode.nodes != null && currNode.nodes.containsKey(letters[i])) {
                currNode = currNode.nodes.get(letters[i]);
            } else {
                TreeNode newNode = new TreeNode(letters[i], new HashMap<>());
                currNode.nodes.put(letters[i], newNode);
                currNode = newNode;
            }
        }

        currNode.isLeaf = true;
    }
    
    public boolean search(String word) {

        char[] letters = word.toCharArray();

        TreeNode currNode = nodes.get(letters[0]);

        if(currNode == null) return false;

        for(int i = 1; i < letters.length; i++) {
            if(currNode.nodes != null && currNode.nodes.containsKey(letters[i])) {
                currNode = currNode.nodes.get(letters[i]);
            } else {
                return false;
            }
        }

        return currNode.isLeaf;
        
    }
    
    public boolean startsWith(String prefix) {

        char[] letters = prefix.toCharArray();

        TreeNode currNode = nodes.get(letters[0]);

        if(currNode == null) return false;

        for(int i = 1; i < letters.length; i++) {
            if(currNode.nodes != null && currNode.nodes.containsKey(letters[i])) {
                currNode = currNode.nodes.get(letters[i]);
            } else {
                return false;
            }
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */