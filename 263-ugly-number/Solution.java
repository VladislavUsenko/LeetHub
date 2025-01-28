
class Solution {

    public static void main(String[] args) {
        System.out.println("--------------");
        System.out.println(isUgly(300));
    }

    public static int maxDivide(int a, int b) {
        while (a % b == 0)
            a = a / b;
        return a;
    }
 
    public static boolean isUgly(int no) {
        no = maxDivide(no, 2);
        no = maxDivide(no, 3);
        no = maxDivide(no, 5);
 
        return (no == 1);
    }
}