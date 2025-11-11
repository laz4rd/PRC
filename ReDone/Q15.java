public class Q15 {
    public static void main(String[] args) {
        Circle cir = new Circle(5);
        Rectangle rect = new Rectangle(5, 10);

        System.out.println("Area of Circle: " + cir.calcArea());
        System.out.println("Area of Rect: " + rect.calcArea());
    }
}

class Shape {
    public int calcArea() {
        return 0;
    }
}

class Circle extends Shape {
    int r;

    public Circle(int r) {
        this.r = r;
    }

    @Override
    public int calcArea() {
        return r * 3 * r;
    }
}

class Rectangle extends Shape {
    int l;
    int w;

    public Rectangle(int l, int w) {
        this.l = l;
        this.w = w;
    }

    @Override
    public int calcArea() {
        return (l * w);
    }
}