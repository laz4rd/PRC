// Create a class Rectangle with data members length and width. Use a constructor to initialize them and a method to calculate the area.

import java.util.*;

class Rectangle //Rectangle Class
{
    double length;
    double width;

    Rectangle(double length, double width) {

        this.length=length;
        this.width=width;
    }
    
    double Area()
    {
        double area=this.length*this.width;
        return area;
    }
}
public class Question5
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        double Length=sc.nextDouble();
        double Width=sc.nextDouble();

        Rectangle rect=new Rectangle(Length, Width);
        System.out.println("The Area of the Rectangle is "+rect.Area()+" sq.units");
    }
}