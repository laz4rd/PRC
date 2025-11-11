import java.util.Scanner;

public class Q06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter limit of sequence");
        int n = sc.nextInt();

        int a = 0, b = 1, count = 0;

        while (count < n) {
            System.out.print(a + ", ");
            int next = a + b;
            a = b;
            b = next;
            count++;
        }
        sc.close();
    }
}
