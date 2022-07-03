class Solution {
     public int minimumRefill(int[] plants, int capacityA, int capacityB) {
                  
        int steps = 0;
         
        int alice = 0;
        int bob = plants.length - 1;
         
        int canAlice = capacityA;
        int canBob = capacityB;
         
        while(alice < bob) {
            
            if(canAlice < plants[alice]) {
                steps++;
                canAlice = capacityA;
            }
            
            if(canBob < plants[bob]) {
                steps++;
                canBob = capacityB;
            }
            canAlice -= plants[alice++];
            canBob -= plants[bob--];
        }
         
        if(alice == bob &&
           canAlice < plants[alice] && 
           canBob < plants[bob]) steps++;
         
        return steps;
    }
}