import java.util.TreeSet;

class Solution {

    public static void main(String[] args) {
        System.out.println("---------------------");
        System.out.println(nthUglyNumber(5, 2, 11, 13));
    }

    
    public static int nthUglyNumber(int n, int a, int b, int c) {
        
        TreeSet<Integer> set = new TreeSet<>();

        set.add(1);
        for (int i = 1; i < n; i++) {
            int l = set.pollFirst();
            set.add(l * a);
            set.add(l * b);
            set.add(l * c);
        }

        set.pollFirst();

        return set.first();
    }
}