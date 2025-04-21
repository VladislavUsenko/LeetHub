import java.util.*;

class MinStack {

    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        if(!stack.isEmpty())
            return stack.peek();
        else return -1;
    }
    
    public int getMin() {

        if(stack.isEmpty()) return -1;
        
        int min = stack.peek();

        for (Integer num : stack) {
            min = Math.min(min, num);
        }

        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */