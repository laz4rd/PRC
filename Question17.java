// Write a Java program with a class Student that uses a static
// variable to count the total number of students created. 
// Display the count after creating each object.

class Student
{
    static int count=0;

    String name;

    public Student(String name) {
        this.name=name;
        count++;
        System.out.println("Student created "+name);
        System.out.println("Number of Students "+count);
    }    
}
public class Question17
{
    public static void main(String[] args) {
        Student s1=new Student("Swiss");
        Student s2=new Student("Harshit");
        Student s3=new Student("Brijraj");
        Student s4=new Student("Neev");
    }
}