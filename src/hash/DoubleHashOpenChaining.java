package hash;

public class DoubleHashOpenChaining {
	private int [] hashTable;
	private int lenght;
	
	public DoubleHashOpenChaining(int lenght) {
		this.lenght = lenght;
		this.hashTable = new int [lenght];
		
		for (int i=0; i<lenght; i++) {
			hashTable[i] = -1;
		}
	}
	
	public int getLenght(){
		return this.lenght;
	}
	
	public int hash(int key) {
		return key%getLenght();
	}
	
	public int hash2(int key) {
		return 1+(key%(getLenght()-1));
	}
	
	public int rehash(int key, int i) {
		return (i + hash2(key))%getLenght();
	}
	
	public void print () {
		System.out.print('[');
		for (int i=0; i < getLenght(); i++) {
			System.out.print(hashTable[i] + " ");
		}
		System.out.println("]");
	}
	
	public void insert(int key) {
		int i = hash(key);
		
		if (hashTable[i] == -1) {
			hashTable[i] = key;
		}
		else {
			i = hash2(key);
			
			if (hashTable[i] == -1) {
				hashTable[i] = key;
			}
			else {
				
				while(hashTable[i] != -1) {
					i = rehash(key, i);
				}
				hashTable[i] = key;
			}
		}
	}
	
	public int search (int key) {
		int i = hash(key);
		
		if (hashTable[i] != key) {
			i = hash2(key);
			
			while(hashTable[i] != key || hashTable[i] == -1) {
				i = rehash(key, i);
			}
		}
		
		return i;
	}
	
	
}
