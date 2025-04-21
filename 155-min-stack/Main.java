public class Main {
    
    public static void main(String[] args) {
        
        int val = 3;

        MinStack obj = new MinStack();
        obj.push(val);
        obj.pop();
        int param_3 = obj.top();
        System.out.println(param_3);
        int param_4 = obj.getMin();
        System.out.println(param_4);


    }
}
