package PartI;
import java.util.ArrayList;


public class MyStack<E> {

	private ArrayList<E> ar;

	public MyStack() {
		ar = new ArrayList<>();
	}

	boolean empty() {
		return ar.isEmpty();
	}

	E peek() {
		return ar.get(ar.size() - 1);
	}

	E pop() {
		return ar.remove(ar.size() - 1);
	}

	E push(E item) {
		ar.add(item);
		return item;
	}

	int search(Object o) {
		return ar.indexOf(o);
	}
}
