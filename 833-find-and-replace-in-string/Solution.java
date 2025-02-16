import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        
        System.out.println("--------------");

        int[] indices = {3,5,1};
        String[] sources = {"kg", "ggq", "mo"};
        String[] targets = {"s","so","bfr"};

        System.out.println(
            findReplaceString("vmokgggqzp", indices, sources, targets)
        );
    }

    public static String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

        List<int[]> indexList = new LinkedList<>();

        for (int i = 0; i < indices.length; i++) {
            indexList.add(new int[]{indices[i], i});
        }

        Collections.sort(indexList, (a, b) -> a[0] - b[0]);

        StringBuilder sb = new StringBuilder();

        int last = 0;
        for (int[] index : indexList) {
            int strIndex = index[0];
            int sourceIndex = index[1];
            if (s.substring(strIndex).indexOf(sources[sourceIndex]) == 0) {
                sb.append(s.substring(last, strIndex));
                sb.append(targets[sourceIndex]);
                last = strIndex + sources[sourceIndex].length();
            }
        }


        if (last != s.length()) {
            sb.append(s.substring(last));
        }

        return sb.toString();
    }
}