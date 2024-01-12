class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));

        HashMap<String, String> map = new HashMap<>();

        for (String w : wordlist) {
            String lower = w.toLowerCase();
            String devLower = lower.replaceAll("[aeiou]", "#");

            map.putIfAbsent(lower, w);
            map.putIfAbsent(devLower, w);
        }

        for (int i = 0; i < queries.length; ++i) {

            if (words.contains(queries[i])) continue;

            String lower = queries[i].toLowerCase();
            String devLower = lower.replaceAll("[aeiou]", "#");

            queries[i] = map.containsKey(lower) ? map.get(lower) :
                    map.getOrDefault(devLower, "");
        }

        return queries;
    }
}