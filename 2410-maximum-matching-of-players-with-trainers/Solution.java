import java.util.*;

class Solution {

    public static void main(String[] args) {
        
        int[] players = {4,7,9};
        int[] trainers = {8,2,5,8};

        System.out.println("======================");
        int matches = matchPlayersAndTrainers(players, trainers);
        System.out.println(matches);
    }

    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int matches = 0;
        int i = 0, j = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                matches++;
                i++;
            }
            j++;
        }

        return matches;
    }
}