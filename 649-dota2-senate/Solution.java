import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public static void main(String[] args) {
        
        String senate = "DDRRR";

        System.out.println("=============");
        System.out.println(predictPartyVictory(senate));
    }

    public static String predictPartyVictory(String senate) {

        Queue<Integer> radiantIdxs = new LinkedList<Integer>();
        Queue<Integer> direIndxs = new LinkedList<Integer>();
        int n = senate.length();

        for(int i = 0; i < n; i++){
            if(senate.charAt(i) == 'R') {
                radiantIdxs.add(i);
            } else direIndxs.add(i);
        }

        while(!radiantIdxs.isEmpty() && !direIndxs.isEmpty()){

            int radiantIdx = radiantIdxs.poll();
            int direIndx = direIndxs.poll();

            if(radiantIdx < direIndx) {
                radiantIdxs.add(radiantIdx + n);
            } else direIndxs.add(direIndx + n);
        }
        return direIndxs.isEmpty() ? "Radiant" : "Dire";
    }
}