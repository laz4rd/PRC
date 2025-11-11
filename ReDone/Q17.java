class StudentB {
    static int count = 0;

    String name;

    public StudentB(String name) {
        this.name = name;
        count++;
        System.out.println("StudentB Created: " + name);
        System.out.println("Number of StudentBs: " + count);
    }
}

public class Q17 {
    public static void main(String[] args) {
        StudentB s1 = new StudentB("Brijraj");
        StudentB s2 = new StudentB("Neev");
        StudentB s3 = new StudentB("Arjun");
        StudentB s4 = new StudentB("Swiss");
    }
}