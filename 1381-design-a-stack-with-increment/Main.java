public class Main {
    
    public static void main(String[] args) {

        System.out.println("=================");
        
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        System.out.println(stack);

        stack.pop();
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println(stack);

        stack.increment(5, 100);
        stack.increment(2, 100);

        System.out.println(stack);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        System.out.println(stack);

    }
}
