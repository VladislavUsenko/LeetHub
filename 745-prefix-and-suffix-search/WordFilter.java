class WordFilter {

    private final TrieNode root = new TrieNode();

    public WordFilter(String[] words) {
        for (int index = 0; index < words.length; index++) {
            String word = words[index];

            for (int i = 0; i <= word.length(); i++) {
                String key = word.substring(i) + "#" + word;

                TrieNode curr = root;
                for (char c : key.toCharArray()) {
                    curr = curr.putIfAbsent(c);
                    curr.maxIdx = index;
                }
            }
        }
    }

    public int f(String pref, String suff) {
        String searchKey = suff + "#" + pref;
        TrieNode curr = root;
        for (char c : searchKey.toCharArray()) {
            curr = curr.get(c);
            if (curr == null) return -1;
        }
        return curr.maxIdx;
    }

}
