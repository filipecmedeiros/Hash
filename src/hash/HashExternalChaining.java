package hash;

public class HashExternalChaining {
	private NodeList [] hashTable;
	private int lenght;
	
	public HashExternalChaining(int lenght) {
		this.lenght = lenght;
		this.hashTable = new NodeList [lenght];
		
		for (int i=0; i<lenght; i++) {
			hashTable[i] = new NodeList();
		}
	}
	
	public int getLenght() {
		return this.lenght;
	}
	
	public int hash(int key) {
		return key%getLenght();
	}
	
	public void insert (int key) {
		int i = hash(key);
		
		hashTable[i].insert(key);
	}
	
	public void print() {
		System.out.println('{');
		for (int i=0; i<getLenght(); i++) {
			System.out.printf("    %d: ", i);
			hashTable[i].print();
		}
		System.out.println('}');
	}
	
	public Node search(int key) {
		int i = hash(key);
		return hashTable[i].search(key);
	}
	
	public void remove(int key) {
		int i = hash(key);
		hashTable[i].remove(key);
	}
}
