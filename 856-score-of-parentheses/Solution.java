
class Solution {

    public static void main(String[] args) {
        
        String s = "(()(())())";

        System.out.println("-----------------");
        System.out.println(scoreOfParentheses(s));
    }

    static int idx = 0;

    public static int scoreOfParentheses(String s) {

        int res = 0;

        while (idx < s.length() - 1) {
            if(s.charAt(idx) == '(') {
                if(s.charAt(idx + 1) == ')') {
                    idx += 2;
                    res += 1;
                } else {
                    idx++;
                    res += 2 * scoreOfParentheses(s);
                }
            } else break;
        }
        idx++;
        return res;
  
    }
}

/*
 * class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); 

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(0);
            } else {
                int v = stack.pop();
                int top = stack.pop();
                stack.push(top + Math.max(2 * v, 1));
            }
        }
        return stack.pop();
    }
}
 */