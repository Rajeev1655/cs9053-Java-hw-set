package university;

public abstract class Student extends Person{
    private String department = "";

    public Student() {
        super();
    }

    public Student(int age, String department) {
        super(age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String Department) {
        this.department = Department;
    }

    public String toString() {
        return "Student: " + super.toString() + " department: " + department;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student s = (Student) obj;
            if (super.equals(s)) {
                if (getDepartment().equals(s.getDepartment())) {
                    return true;
                }
            }
        }
        return false;
    }
}
