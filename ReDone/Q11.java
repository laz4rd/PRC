public class Q11 {
    public int div(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {

        Q11 q11 = new Q11();
        try {
            int a = 10;
            int b = 0;
            System.out.println("Answer: " + q11.div(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error, Cannot divide by 0 " + e.getMessage());
        }
    }
}
