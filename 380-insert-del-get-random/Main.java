public class Main {
    
    public static void main(String[] args) {

        int val = 1;
        int val_2 = 2;
        
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(val);
        boolean param_2 = obj.remove(val_2);
        boolean param_3 = obj.insert(val_2);
        int param_4 = obj.getRandom();

        boolean param_5 = obj.remove(val);
        boolean param_6 = obj.insert(val_2);

        int param_7 = obj.getRandom();

        System.out.println("---------------");

        System.out.println(
            param_1 + ", " +
            param_2 + ", " +
            param_3 + ", " +
            param_4 + ", " +
            param_5 + ", " +
            param_6 + ", " +
            param_7
        );
    }
}
