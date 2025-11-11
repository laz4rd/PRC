import java.util.Scanner;
import mypack.Calculator;

public class Q07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calc = new Calculator();

        int a = sc.nextInt();
        int b = sc.nextInt();

        int c = calc.add(a, b);
        int d = calc.sub(a, b);

        System.out.println("Sum: " + c);
        System.out.println("Difference: " + d);

        sc.close();
    }
}