import java.util.*;

class Solution {

    public static void main(String[] args) {
        int n = 368712509;

        System.out.println("=================");
        System.out.println(reorderedPowerOf2(n));
    }

    public static boolean reorderedPowerOf2(int n) {
        
        Map<Integer, Set<Integer>> pow2SMap = new HashMap<>();

        for (int i = 1; i < 32; i++) {
            int pow2 = (int) Math.pow(2, i);
            int numberOfDigits = (int) (Math.log10(pow2) + 1);
            pow2SMap.computeIfAbsent(numberOfDigits, k -> new HashSet<>()).add(pow2);
        }

        int size = (int) (Math.log10(n) + 1);
        
        Map<Integer, Integer> digits = new HashMap<>();

        int tmp = n;
        while (tmp != 0) {
            int digit = tmp % 10;
            digits.put(digit, digits.getOrDefault(digit, 0) + 1);
            tmp /= 10;
        }

        var setPows = pow2SMap.get(size);

        for(int num : setPows) {

            var tmpDigits = new HashMap<>(digits);

            while (num != 0) {
                int number = num % 10;
                if (tmpDigits.containsKey(number)) {
                    if (tmpDigits.get(number) == 1) {
                        tmpDigits.remove(number);
                        
                    } else tmpDigits.put(number, tmpDigits.get(number) - 1);
                } else break;

                num /= 10;
            }

            if (tmpDigits.isEmpty()) {
                return true;
            }
        }

        return false;
    }
}