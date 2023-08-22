
public class Main {
    
    public static void main(String[] args) {
        
        int n = Integer.parseInt(args[0]);
        getBits(n);
    }

    public static void getBits(int n) {

        int[] bitArray = new int[32];
        int i = 0;
        while(n > 0) {
            bitArray[bitArray.length - 1 - i] = n % 2;
            ++i;
            n = n / 2;
        }

        for(int j : bitArray) {
            System.out.print(j);
        }

        int result = 0;
        System.out.println();
        System.out.println("i = " + i);
        for(int k = 32 - i; k < bitArray.length; k++) {
            result = result + (multipleTwo(i - 1) * bitArray[bitArray.length - i]);
            --i;
            System.out.println(result + " - " + i);
        }

        System.out.println("\n" + result);
    }

    public static int multipleTwo(int x) {

        int result = 1;
        for(int i = 0; i < x; i++) {
            result = result * 2;
        }
        return result;
    }

    static void reverse(int a[], int n)
    {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }

    }
}
