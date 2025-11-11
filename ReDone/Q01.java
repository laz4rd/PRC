import java.util.*;

public class Q01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter A Base Salary");
        double base = sc.nextDouble();

        double hra = 0.2 * base;
        double da = 0.5 * base;
        double pf = 0.11 * base;
        double gs = base + hra + da - pf;

        System.out.println("Gross salary: " + gs);
        sc.close();
    }
}