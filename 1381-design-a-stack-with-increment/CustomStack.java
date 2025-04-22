import java.util.Arrays;

class CustomStack {

    int[] stack;
    int index = -1;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
    }
    
    public void push(int x) {
        if(index < stack.length - 1) {
            stack[++index] = x;
        }
    }
    
    public int pop() {
        if(index == -1) return -1;
        return stack[index--];
    }
    
    public void increment(int k, int val) {
        int size = Math.min(index, k - 1);
        for(int i = 0; i <= size; i++) {
            stack[i] += val; 
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(stack) + ", i = " + index;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */