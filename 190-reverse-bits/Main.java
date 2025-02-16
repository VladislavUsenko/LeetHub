
public class Main {
    
    public static void main(String[] args) {
        
        int n = 964176192;
        getBits(n);
    }

    public static void getBits(int n) {

        int result = 0;
            for (int i = 0; i < 32; i++) {
                int bit = n & 1;  
                System.out.print(bit);        
                result = (result << 1) | bit; 
                n = n >>> 1;             
            }
        
        System.out.println("\n" + result);
    }
}
