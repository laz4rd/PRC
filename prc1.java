import java.util.*;

public class prc1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input basic salary
        System.out.print("Enter the basic salary: ");
        double basicSalary = sc.nextDouble();

        // Calculations
        double hra = 0.20 * basicSalary;
        double da = 0.50 * basicSalary;
        double pf = 0.11 * basicSalary;

        double grossSalary = basicSalary + hra + da - pf;

        // Display results
        System.out.println("\n----- Salary Breakdown -----");
        System.out.println("Basic Salary : " + basicSalary);
        System.out.println("HRA (20%)    : " + hra);
        System.out.println("DA (50%)     : " + da);
        System.out.println("PF (11%)     : " + pf);
        System.out.println("-----------------------------");
        System.out.println("Gross Salary : " + grossSalary);

        sc.close();
    }
}
