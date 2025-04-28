import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        
        String s = "ab#c", t = "ad#c";

        System.out.println("=================");
        System.out.println(backspaceCompare(s, t));

    }

    public static boolean backspaceCompare(String s, String t) {
        
        //create 2 stack
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        
        int size = Math.max(s.length(), t.length());

        // loop with longest string
        for(int i = 0; i < size; i++) {

            if(s.length() > i) {
                if(s.charAt(i) == '#') {
                    if (!stackS.isEmpty()) stackS.pop();
                } 
                else stackS.push(s.charAt(i));
            }

            if(t.length() > i) {
                if(t.charAt(i) == '#') {
                    if(!stackT.isEmpty()) stackT.pop();
                }
                else stackT.push(t.charAt(i));
            }
            
        }

        // copmpare strings length
        if (stackS.size() != stackT.size()) return false;

        // compare results
        while (!stackS.isEmpty()) {
            if(stackS.pop() != stackT.pop()) return false;
        }

        return true;
    }
}