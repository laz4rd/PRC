import java.util.*;

class Rectangle {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int Area() {
        int area = length * width;
        return area;
    }
}

public class Q05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int l = sc.nextInt();
        int w = sc.nextInt();

        Rectangle rect = new Rectangle(l, w);
        System.out.println("Area of Rectangle: " + rect.Area());

        sc.close();
    }
}