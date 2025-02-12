class Solution {

    public static void main(String[] args) {
        
        int[] ratings = {1,6,10,8,7,3,2};

        System.out.println("-------------");
        System.out.println(candy(ratings));
    }

    public static int candy(int[] ratings) {
        

        int result = ratings.length;

        for (int i = 0; i < ratings.length - 1;) {

            if (ratings[i] == ratings[i + 1]) {
                i++;
                continue;
            }
            
            int candyPeak = 0;
            while(i < ratings.length - 1 && ratings[i] < ratings[i + 1]) {
                candyPeak = candyPeak + 1;
                result += candyPeak;
                i++;
            }

            if (i == ratings.length) {
                return result;
            }

            int candyButtom = 0;
            while(i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                candyButtom = candyButtom + 1;
                result += candyButtom;
               i++;
            }

            result -= Math.min(candyPeak, candyButtom);

        }

        return result;
    }
}