package university;

public class Staff extends Employee{

    public Staff() {
        super();
    }

    public Staff(int age, double salary) {
        super(age, salary);
    }

    public String toString() {
        return "Staff: " + super.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Staff) {
            Staff other = (Staff) obj;
            return super.equals(other);
        }
        return false;
    }
}
