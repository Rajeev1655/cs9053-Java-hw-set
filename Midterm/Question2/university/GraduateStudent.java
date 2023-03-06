package university;

public class GraduateStudent extends Student{
    private boolean isPhD;

    public GraduateStudent() {
        super();
    }

    public GraduateStudent(int age, boolean isPhD, String department) {
        super(age, department);
        this.isPhD = isPhD;
    }

    public void setPhD(boolean phD) {
        isPhD = phD;
    }

    public boolean getPhD() {
        return isPhD;
    }

    public String toString() {
        return "GraduateStudent: " + super.toString() + " isPhD: " + isPhD;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GraduateStudent) {
            GraduateStudent other = (GraduateStudent) obj;
            if (super.equals(other)) {
                if (getPhD() == other.getPhD()) {
                    return true;
                }
            }
        }
        return false;
    }
}
