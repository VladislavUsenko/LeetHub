class Solution {

    public static void main(String[] args){

        int[] flowered = {0,0,1,0,0};

        System.out.println("------------");
        System.out.println(canPlaceFlowers(flowered, 1));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int len = flowerbed.length;

        if(n == 0) return true;

        if(len < 3) {
            for (int i : flowerbed) {
                if(i != 0) return false;
            }
            flowerbed[0] = 1;
            n--;
        }

        if(len >= 2) {
            if(flowerbed[0] == 0 && flowerbed[1] == 0){
                flowerbed[0] = 1;
                n--;
            }

            if(flowerbed[len - 1] == 0 &&
               flowerbed[len - 2] == 0) {
                flowerbed[len - 1] = 1;
                n--;
            }
        }



        for(int i = 1; i < len - 1 && n > 0; i++) {
            if(flowerbed[i - 1] == 0 &&
               flowerbed[i] == 0 &&
               flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n--;
                i++;
            }
        }

        return n <= 0;
    }
}