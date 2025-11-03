// Create a Student class with roll number, name, and marks.
// Accept and display details of 3 students.

import java.util.*;

public class Question2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int rol     = sc.nextInt();
        int marks   = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();


        System.out.println("Student Name ============ "+name);
        System.out.println("Student Roll no. ======== "+rol);
        System.out.println("Student Marks =========== "+marks);    
    }
}