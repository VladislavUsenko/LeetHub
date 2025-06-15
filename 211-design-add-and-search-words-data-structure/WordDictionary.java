
class WordDictionary {

    TreeNode nodes;

    public WordDictionary() {
        nodes = new TreeNode();
    }
    
    public void addWord(String word) {
        char[] letters = word.toCharArray();

        TreeNode currNode = nodes;
        for(int i = 0; i < letters.length; i++) {
            TreeNode nextNode = currNode.nodes[letters[i] - 'a'];
            if (nextNode == null) {
                nextNode = new TreeNode();
                currNode.nodes[letters[i] - 'a'] = nextNode;
            } 
            currNode = nextNode;
        }

        currNode.isEnd = true;
    }
    
    public boolean search(String word) {
        
        return dfs(nodes, 0, word);
    }

    private boolean dfs(TreeNode root, int lvl, String word) {

        if(root == null) return false;

        if (lvl == word.length()) {
            return root.isEnd;
        }

        char letter = word.charAt(lvl);

        if(letter == '.') {
            boolean result = false;
            for(int i = 0; i < 26; i++) {
                if (root.nodes[i] != null) {
                    result = (result || dfs(root.nodes[i], lvl + 1, word));
                }
            }

            return result;
        } else {

            return dfs(root.nodes[letter - 'a'], lvl + 1, word);
        }
    }
}