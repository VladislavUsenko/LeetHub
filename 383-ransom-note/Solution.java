import java.util.HashMap;

class Solution {

    public static void main(String[] args) {
        
        System.out.println("-------------");
        System.out.println(canConstruct("a", "b"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        
        HashMap<Character, Integer> map = new HashMap<>();


        for (char i : ransomNote.toCharArray()) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(char c : magazine.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);

                if (map.get(c) == 0) map.remove(c);
            }
        }


        return map.isEmpty();

    }
}