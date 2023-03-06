package university;

import java.util.ArrayList;

public class main {

    /** test function for question 1: Inheritance **/
    public static void main(String[] args) {
        Affiliate a = new Affiliate();
        Affiliate b = new Affiliate(20);
        Affiliate b1 = new Affiliate(20);
        Faculty f = new Faculty();
        Faculty g = new Faculty(43, "Math", 5000);
        Faculty g1 = new Faculty(43, "Math", 5000);
        GraduateStudent gs = new GraduateStudent();
        GraduateStudent gs2 = new GraduateStudent(25, true, "CS");
        Staff s = new Staff();
        Staff s2 = new Staff(30, 3000);
        Undergraduate ug = new Undergraduate();
        Undergraduate ug2 = new Undergraduate(21, "CE", true);

        // test toString
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(a);
        people.add(b);
        people.add(b1);
        people.add(f);
        people.add(g);
        people.add(g1);
        people.add(gs);
        people.add(gs2);
        people.add(s);
        people.add(s2);
        people.add(ug);
        people.add(ug2);

        Person.printPersons(people);

        // test equals
        System.out.println("b.equals(b1): " + b.equals(b1)); // true
        System.out.println("g.equals(g1): " + g.equals(g1)); // true
        System.out.println("a.equals(b): " + a.equals(b)); // false
        System.out.println("f.equals(g): " + f.equals(g)); // false
        System.out.println("gs.equals(gs2): " + gs.equals(gs2)); // false
        System.out.println("s.equals(s2): " + s.equals(s2)); // false
        System.out.println("ug.equals(ug2): " + ug.equals(ug2)); // false
        System.out.println("a.equals(f): " + a.equals(f)); // false
        System.out.println("gs.equals(s): " + gs.equals(s)); // false
        System.out.println("ug.equals(gs): " + ug.equals(gs)); // false
    }
}
