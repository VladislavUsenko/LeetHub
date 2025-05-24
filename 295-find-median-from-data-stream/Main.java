
public class Main {

    public static void main(String[] args) {
        

        MedianFinder finder = new MedianFinder();

        finder.addNum(6);
        System.out.println(finder.findMedian());
        finder.addNum(10);

        System.out.println(finder.findMedian());

        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(6);
        System.out.println(finder.findMedian());
        finder.addNum(5);

        System.out.println(finder.findMedian());

        finder.addNum(0);
        System.out.println(finder.findMedian());
        finder.addNum(6);
        System.out.println(finder.findMedian());
        finder.addNum(3);

        System.out.println(finder.findMedian());
    }
}