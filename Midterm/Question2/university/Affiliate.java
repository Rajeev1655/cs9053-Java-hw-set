package university;

public class Affiliate extends Person {

    public Affiliate() {
        super();
    }

    public Affiliate(int age) {
        super(age);
    }

    public String toString() {
        return "Affiliate: " + super.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Affiliate) {
            Affiliate other = (Affiliate) obj;
            return super.equals(other);
        }
        return false;
    }
}
