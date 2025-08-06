class Solution {

    public static void main(String[] args) {
        int[] fruits = {4,2,5};
        int[] baskets = {3,5,4};

        System.out.println("====================");
        System.out.println(numOfUnplacedFruits(fruits, baskets));
    }
    
    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        
        int result = fruits.length;

        for (int i = 0; i < fruits.length; i++) {
            for (int j = 0; j < baskets.length; j++) {
                if (fruits[i] <= baskets[j]) {
                    baskets[j] = 0;
                    result--;
                    break;
                }
            }
        }


        return result;
    }
}