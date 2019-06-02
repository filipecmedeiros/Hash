package main;

import hash.Hash;

public class Main {
	public static void main(String[] args) {
		Hash h;
		
		h = new Hash(10);
		
		h.print();
		h.insert(1);
		h.insert(3);
		h.insert(5);
		h.insert(8);
		h.insert(15);
		h.insert(25);
		h.insert(70);
		h.insert(82);
		h.insert(94);
		h.insert(95);
		h.print();
		
		System.out.println(h.search(15));
		System.out.println(h.search(99));
		
		h.remove(1);
		h.remove(95);
		h.print();
	}
}
