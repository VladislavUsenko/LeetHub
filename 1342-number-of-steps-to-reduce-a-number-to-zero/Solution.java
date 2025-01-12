
class Solution {


    public static void main(String[] args) {
        
        System.out.println(numberOfSteps(7));
    }

    public static int numberOfSteps(int num) {
        
        int result = 0;

        if (num == 0) return 0;

        System.out.println("==============");
        while (num !=0) {
            result++;
            System.out.println(num);
            if (num % 2 == 0) {
                num /= 2;
            } else num--;
        }
        return result;
    }
}