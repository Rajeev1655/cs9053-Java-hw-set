package university;

public abstract class Employee extends Person{
    private double salary;

    public Employee() {
        super();
    }

    public Employee(int age, double salary) {
        super(age);
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return "Employee: " + super.toString() + " salary: " + salary;
    }
}
