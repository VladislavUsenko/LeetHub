class Solution {

    public static void main(String[] args) {
        System.out.println("---------------------");
        System.out.println(nthUglyNumber(5, 2, 11, 13));
    }

    public static int target = 2;

    public static int nthUglyNumber(int n, int a, int b, int c) {

        int i = 1;

        int[] arr = new int[n + 1];
        int index = 0;
        while (n > 0) {
            i++;
            if (isUgly(i, a, b, c) == 1) {
                arr[index++] = i;
                n--;
            }
        }
        
        return i;
    }

    public static int maxDivide(int a, int b) {
        while (a % b == 0)
            a = a / b;
        return a;
    }

    public static int isUgly(int no, int a, int b, int c) {
        no = maxDivide(no, a);
        no = maxDivide(no, b);
        no = maxDivide(no, c);
 
        return (no == 1) ? 1 : 0;
    }
}