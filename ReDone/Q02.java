import java.util.*;

class Student {
    private int roll;
    private String name;
    private int marks;

    public Student(int roll, String name, int marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public int getMarks() {
        return marks;
    }
}

public class Q02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student s1 = new Student(55, "Pol Baba", 0);

        System.out.println("\nName of Student " + s1.getName());
        System.out.println("\nRoll no of Student " + s1.getRoll());
        System.out.println("\nMarks of Student " + s1.getMarks());
        sc.close();
    }
}