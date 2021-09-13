import java.awt.Point;

public class BoxAndPointer {
    public static void main(String[] args) {
        Point p1 = new Point(2, 5);
        Point p2 = p1;
        Point p3 = new Point(p2);
        if (p1 != p3) {
            System.out.println("Wahoo!");
        } else {
            System.out.println("Penny!");
        }
        foo(p1, p2);
        System.out.println(p1 + " " + p2 + " " + p3);
        foo(p3, p1);
        System.out.println(p1 + " " + p2 + " " + p3);
        }
        private static void foo(Point f1, Point f2) {
        f1.translate(5, 5);
        f2 = new Point(19, 6);
        }
}
