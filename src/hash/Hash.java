package hash;

public class Hash {
	private int [] hashTable;
	private int lenght;
	
	public Hash(int lenght) {
		this.lenght = lenght;
		this.hashTable = new int [lenght];
		
		for (int i=0; i<this.lenght; i++) {
			hashTable[i] = -1;
		}
	}
	
	public int[] getHashTable() {
		return this.hashTable;
	}
	
	public void setHashTable(int [] hashTable) {
		this.hashTable = hashTable;
	}
	
	public int getLenght() {
		return this.lenght;
	}
	
	public void setLenght(int lenght) {
		this.lenght = lenght;
	}
	
	public int hash(int key) {
		return key % getLenght();
	}
	
	public int rehash(int key) {
		return (key+1) % getLenght();
	}
	
	public void print () {
		System.out.print('[');
		for (int i=0; i < getLenght(); i++) {
			System.out.print(hashTable[i] + " ");
		}
		System.out.println("]");
	}
	
	public int search (int key) {
		int i = hash(key);
		int j = i;
		
		if (hashTable[i] == key){}
		else {
			do {
				j = rehash(j);
				if (hashTable[j] == key) {
					i = j;
					break;
				}
				else if (hashTable[j] == -1) {
					i = -1;
					break;
				}
				else {
					i = -1;
				}
			}while(j != hash(key));
		}
		
		return i;
	}
	
	public void insert (int key) {
		int i = hash(key);
		int j = i;
		
		if (hashTable[i] == -1) {
			hashTable[i] = key;
		}
		else {
			do {
				j = rehash(j);
				if (hashTable[j] == -1) {
					hashTable[j] = key;
					break;
				}
			}while(j != i);
		}
	}
	
	public void remove (int key) {
		int i = search(key);
		
		if (i != -1) {
			hashTable[i] = -1;
			
		}
	}
	
}
