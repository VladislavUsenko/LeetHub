public class Point {

    int x;
    int y;
    double distance;

    Point(int x, int y) {
        this.x = x;
        this.y = y;

        distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
}
