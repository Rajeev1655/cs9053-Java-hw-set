package university;

public class Faculty extends Employee {
    private String department = "";

    public Faculty() {
        super();
    }

    public Faculty (int age, String dep, double salary) {
        super(age, salary);
        this.department = dep;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String Department) {
        this.department = Department;
    }

    public String toString() {
        return "Faculty: " + super.toString() + " department: " + department;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Faculty) {
            Faculty f = (Faculty) obj;
            if (super.equals(f)) {
                if (getDepartment().equals(f.getDepartment())) {
                    return true;
                }
            }
        }
        return false;
    }
}
