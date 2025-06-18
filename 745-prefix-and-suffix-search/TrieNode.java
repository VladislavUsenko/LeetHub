public class TrieNode {
        TrieNode[] children = new TrieNode[27]; // 'a'-'z' + '#'
        int maxIdx = -1;

        TrieNode get(char c) {
            int i = (c == '#') ? 26 : c - 'a';
            return children[i];
        }

        TrieNode putIfAbsent(char c) {
            int i = (c == '#') ? 26 : c - 'a';
            if (children[i] == null) {
                children[i] = new TrieNode();
            }
            return children[i];
        }
    }
