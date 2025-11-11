import java.util.*;

public class Q04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] a = new int[5];

        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        int MAX = a[0];
        int MIN = a[0];

        for (int i = 0; i < a.length; i++) {
            if (a[i] > MAX) {
                MAX = a[i];
            }
            if (a[i] < MIN) {
                MIN = a[i];
            }
        }

        System.out.println("The largest Number in the array is: " + MAX);
        System.out.println("The smallest Number in the array is: " + MIN);

        sc.close();
    }
}
