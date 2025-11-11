package Original;
// Create a base class Employee and a derived class 

// Manager that adds department and bonus.
// Display all details using inheritance.

class Employee {
    int EmpID;
    String name;
    double salary;

    public Employee(int EmpID, String name, double salary) {
        this.EmpID = EmpID;
        this.name = name;
        this.salary = salary;
    }

    public void display() {
        System.out.println("EmpID " + EmpID);
        System.out.println("name " + name);
        System.out.println("Salary " + salary);
    }

}

class Manager extends Employee {
    String department;
    double bonus;

    public Manager(int EmpID, String name, double salary, String department, double bonus) {
        super(EmpID, name, salary);
        this.department = department;
        this.bonus = bonus;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("department " + department);
        System.out.println("bonus " + bonus);
    }
}

public class Question12 {
    public static void main(String[] args) {
        Manager m1 = new Manager(02, "Brijraj", 298472, "DC", 1231231);

        m1.display();
    }
}