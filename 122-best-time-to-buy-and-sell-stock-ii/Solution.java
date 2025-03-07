
class Solution {

    public static void main(String[] args) {
        
        int[] prices = {7,1,5,3,6,4};

        System.out.println("--------");
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        
        int min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            
            if(prices[i] < min) {
                min = prices[i];
            } else if(prices[i] - min > profit) profit = prices[i] - min;
        }

        return profit;
    }
}