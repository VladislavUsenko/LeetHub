class Solution {

    public static void main(String[] args) {
        
        int num = 38;
        System.out.println("--------------");
        System.out.println(addDigits(num));
    }

    public static int addDigits(int num) {
        
        while (num > 9) {

            int tmp = 0;

            while (num > 0) {
                tmp += num % 10;
                num = num / 10; 
            }

            num = tmp;
        }
        

        return num;
    }
}