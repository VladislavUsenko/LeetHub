import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        String str = "10200";
        int k = 1;
        System.out.println(removeKdigits(str, k));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        while (k-- > 0) {
            stack.pop();
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}
