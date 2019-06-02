package main;

import hash.DoubleHashOpenChaining;
import hash.HashExternalChaining;
import hash.HashInternalChaining;
import hash.HashLinearOpenChaining;

public class Main {
	public static void main(String[] args) {
		//hashLinearOpenChaining();
		//hashExternalChaining();
		//hashInternalChaining();
		doubleHashOpenChaining();
	}
	
	public static void hashLinearOpenChaining() {
		HashLinearOpenChaining h;
		
		h = new HashLinearOpenChaining(10);
		
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
		System.out.println(h.search(25));
		System.out.println(h.search(99));
		
		h.print();
	}
	
	public static void doubleHashOpenChaining() {
		DoubleHashOpenChaining hash = new DoubleHashOpenChaining(10);
		
		hash.print();
		hash.insert(1);
		hash.insert(10);
		hash.insert(100);
		hash.insert(22);
		hash.insert(15);
		hash.insert(35);
		hash.insert(18);
		hash.print();
		System.out.println(hash.search(35));
	}
	
	public static void hashExternalChaining() {
		HashExternalChaining hash = new HashExternalChaining(10);
		
		hash.print();
		hash.insert(10);
		hash.insert(1);
		hash.insert(100);
		hash.insert(95);
		hash.insert(24);
		hash.insert(36);
		hash.insert(49);
		hash.insert(48);
		hash.insert(38);
		hash.insert(26);
		hash.insert(15);
		hash.insert(23);
		hash.insert(12);
		hash.insert(02);
		hash.insert(100);
		hash.insert(157);
		hash.print();
		System.out.println(hash.search(36).getKey());
		System.out.println(hash.search(100).getKey());
		hash.remove(100);
		hash.remove(1);
		hash.remove(12);
		hash.print();
		
	}
	
	public static void hashInternalChaining() {
		HashInternalChaining hash = new HashInternalChaining(20, 10);
		
		
		hash.print();
		hash.insert(10);
		hash.insert(1);
		hash.print();
		hash.insert(100);
		hash.insert(95);
		hash.print();
		hash.insert(24);
		hash.insert(36);
		hash.print();
		hash.insert(49);
		hash.insert(48);
		hash.print();
		hash.insert(38);
		hash.print();
		
		System.out.println(hash.search(38));
		
		
	}
	
}
