package university;

public class Undergraduate extends Student{
    private boolean isMatriculated;

    public Undergraduate() {
        super();
    }

    public Undergraduate(int age, String Dept, boolean isMatriculated) {
        super(age, Dept);
        this.isMatriculated = isMatriculated;
    }

    public boolean getMatriculated() {
        return isMatriculated;
    }

    public void setMatriculated(boolean isMatriculated) {
        this.isMatriculated = isMatriculated;
    }

    public String toString() {
        return "Undergraduate: " + super.toString() + " isMatriculated: " + isMatriculated;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Undergraduate) {
            Undergraduate other = (Undergraduate) obj;
            return super.equals(other) && isMatriculated == other.isMatriculated;
        }
        return false;
    }
}
