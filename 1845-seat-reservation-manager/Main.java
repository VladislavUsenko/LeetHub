public class Main {
    public static void main(String[] args) {

        SeatManager manager = new SeatManager(5);

        manager.reserve(); //1
        manager.reserve(); //2
        manager.reserve(); //3

        manager.unreserve(2);
        manager.reserve(); //3 -> 2

        manager.reserve(); // 4
    }
}