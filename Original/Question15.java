package Original;
// Create a base class Shape and derived classes Circle and Rectangle. Override

// the calculateArea() method in both

class Shape {
    @SuppressWarnings("unused")
    double calculateArea() {
        System.out.println("Empty");
        return 0;
    }
}

class Circle extends Shape {
    double r;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    double calculateArea() {
        return (Math.PI * r * r);
    }
}

class Rectangle extends Shape {
    double l;
    double w;

    public Rectangle(double l, double w) {
        this.l = l;
        this.w = w;
    }

    @Override
    double calculateArea() {
        return (l * w);
    }
}

public class Question15 {
    public static void main(String[] args) {
        Circle cir = new Circle(5);
        Rectangle rect = new Rectangle(2, 5);

        System.out.println("Area of Circle " + cir.calculateArea());
        System.out.println("Area of Circle " + rect.calculateArea());
    }
}