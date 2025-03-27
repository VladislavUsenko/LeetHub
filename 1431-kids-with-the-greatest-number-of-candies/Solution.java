import java.util.*;

class Solution {

    public static void main(String[] args) {
        int[] candies = {2,3,5,1,3};
        int extraCandies = 3;

        System.out.println("-----------------------");
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        List<Boolean> result = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        for(int i: candies) {
            max = Math.max(max, i);
        }

        System.out.println(max);

        for(int i : candies) {
            result.add(i + extraCandies >= max);
        }

        return result;
    }
}