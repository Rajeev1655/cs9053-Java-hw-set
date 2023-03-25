package PartI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;

public class Packet {
	Byte[] payload;
	int priority;
	
	public Packet(Byte[] payload, int priority) {
		// figure out how this works
		this.payload = payload;
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public String toString() {
		StringBuilder payload = new StringBuilder();
		for (Byte aByte : this.payload) {
			if (aByte != null) {
				payload.append(aByte);
			}
		}
		if (payload.length() == 0) {
			payload.append("all null");
		}
		return "Packet with priority " + priority + " and payload " + payload;
	}

	public static void main(String[] args) {
		PriorityQueue<Packet> pq = new PriorityQueue<>((o1, o2) -> o2.getPriority() - o1.getPriority());
				
		for (int i=0;i<10;i++) {
			Byte[] payload = new Byte[256];
			int priority = (int)(Math.random()*5) + 1;
			Packet p = new Packet(payload, priority);
			pq.add(p);
		}
		
		while (!pq.isEmpty()) {
			System.out.println("got packet " + pq.remove().toString());
		}
	}

}
