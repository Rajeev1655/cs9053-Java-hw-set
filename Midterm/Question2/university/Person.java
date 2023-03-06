package university;

import java.util.ArrayList;

public class Person {
	private final int ID;
	private int age;
	private static int nextID = 0;

	public Person() {
		ID = nextID;
		nextID++;
	}

	public Person(int age) {
		this();
		this.age = age;
	}

	public int getID() {
		return ID;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public static void printPersons(ArrayList<Person> persons) {
		for (Person p : persons) {
			System.out.println(p.toString());
		}
	}

	public String toString() {
		return "ID: " + ID + " Age: " + age;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person other = (Person) obj;
			return age == other.age;
		}
		return false;
	}
}
