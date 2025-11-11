public class Q13 {
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;

        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("The largest is: " + maximum(4, 10, 3));
        System.out.println("The largest is: " + maximum(4.1, 10.1, 3.1));
    }
}