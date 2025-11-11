class Employee {
    String name;
    double salary;
    int EmpID;

    public Employee(String name, double salary, int EmpID) {
        this.name = name;
        this.salary = salary;
        this.EmpID = EmpID;
    }

    public void Display() {
        System.out.println("Employee ID: " + EmpID);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    String Dept;
    double bonus;

    public Manager(String name, double salary, int EmpID, String Dept, double bonus) {
        super(name, salary, EmpID);
        this.Dept = Dept;
        this.bonus = bonus;
    }

    @Override
    public void Display() {
        super.Display();
        System.out.println("Department: " + Dept);
        System.out.println("Bonus: " + bonus);
    }
}

public class Q12 {
    public static void main(String[] args) {
        Manager m1 = new Manager("Pol", 0, 0, "TP", 0);
        Employee e1 = new Employee("Baba", 0, 0);

        m1.Display();
        e1.Display();
    }
}