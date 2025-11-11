package Original;
// Write a Java program to display the

// Fibonacci series up to n terms using a while loop.

import java.util.*;

public class Question6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        int a = 0, b = 1, count = 0;

        System.out.print("Fibonacci Series: ");

        while (count < n) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
            count++;
        }
    }
}
