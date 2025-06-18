import java.util.*;

class MapSum {

    Map<Character, SumChar> sums;
     Map<String, Integer> keys;

    public MapSum() {
        sums = new HashMap<>();
        keys = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        int delta = val - keys.getOrDefault(key, 0);
        keys.put(key, val);

        char[] letters = key.toCharArray();
        SumChar currChar = sums.computeIfAbsent(letters[0], _ -> new SumChar());
        currChar.sum += delta;

        for (int i = 1; i < letters.length; i++) {
            char c = letters[i];
            currChar = currChar.nodes.computeIfAbsent(c, _ -> new SumChar());
            currChar.sum += delta;
        }
    }
    
    public int sum(String prefix) {
        char[] letters = prefix.toCharArray();

        SumChar currChar = sums.get(letters[0]);
        if (currChar == null) return 0;

        for(int i = 1; i < letters.length; i++) {
            if(currChar.nodes.containsKey(letters[i])) {
                currChar = currChar.nodes.get(letters[i]);
            } else return 0;
            
        }

        return currChar.sum;
    }
}
