import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println("--------------");
        System.out.println(nthUglyNumber(10));
    }


    public static int nthUglyNumber(int n) {
        
        TreeSet<Integer> set = new TreeSet<>();

        set.add(1);
        for (int i = 1; i < n; i++) {
            int l = set.pollFirst();
            set.add(l * 2);
            set.add(l * 3);
            set.add(l * 5);
        }
        return set.first();
    }
}