package Original;

// File: MainProgram.java
import Original.com.laz4rd.mypackages.Calculator;

public class Question7 {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        int sum = calc.add(10, 5);
        int difference = calc.subtract(10, 5);

        System.out.println("Sum = " + sum);
        System.out.println("Difference = " + difference);
    }
}
