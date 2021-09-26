import java.awt.Point;
class Problem2 {

    public static void main(String[] args) {
        Point p1 = new Point(9,4);
        Point p2 = new Point(30, 50);
        p2=p1;
        String myString = "yahoo";

        foo(myString, p1);

        System.out.println(myString);
        System.out.println(p1.getX() + " " + p1.getY());
        System.out.println(p2.getX() + " " + p2.getY());

    }
    
    public static void foo(String s, Point p) {
        s = s.substring(2);
        p.translate(2, 2);
    }

}