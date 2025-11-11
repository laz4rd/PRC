package Original;
// Write a generic method maximum(T x, T y, T z) that returns the largest of three numbers.

// Test it with integers and doubles.

public class Question13 {

    // Generic method that works for any type that implements Comparable
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x; // assume x is initially the largest

        if (y.compareTo(max) > 0)
            max = y; // y is larger

        if (z.compareTo(max) > 0)
            max = z; // z is larger

        return max; // return the largest
    }

    public static void main(String[] args) {
        // Test with integers
        System.out.println("Maximum of 3, 7, 5 is: " + maximum(3, 7, 5));

        // Test with doubles
        System.out.println("Maximum of 6.6, 8.8, 7.7 is: " + maximum(6.6, 8.8, 7.7));
    }
}
