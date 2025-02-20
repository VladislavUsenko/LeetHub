import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        
        String s = "ABCD";
        
        System.out.println("===============");
        System.out.println(convert(s, 3));
    }

    public static String convert(String s, int numRows) {

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        int idx = 0, d = 1;
        List<List<Character>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }

        for (char c : s.toCharArray()) {
            rows.get(idx).add(c);
            if (idx == 0) {
                d = 1;
            } else if (idx == numRows - 1) {
                d = -1;
            }
            idx += d;
        }

        StringBuilder result = new StringBuilder();
        for (List<Character> row : rows) {
            for(Character c : row) result.append(c);
        }

        return result.toString();
    }
}