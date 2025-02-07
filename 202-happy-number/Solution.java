import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        
        System.out.println("-------------");
        System.out.println(isHappy(101));
    }

    public static boolean isHappy(int n) {

        Set<Integer> visit = new HashSet<>();
        
        while (!visit.contains(n)) {
            visit.add(n);
            
            int tmp = 0;

             while (n != 0) {
                tmp += (n % 10) * (n % 10);
                n = n / 10;
            }

            n = tmp;

            if (n == 1) {
                return true;
            }
        }
        
        return false;     
    }
}