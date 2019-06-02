package hash;

public class HashInternalChaining {
	private Node [] hashTable;
	private int lenght;
	private int base;
	
	public HashInternalChaining(int lenght, int base) {
		this.base = base;
		this.lenght = lenght;
		this.hashTable = new Node [lenght];
		for (int i=0; i<lenght; i++) {
			hashTable[i] = null;
		}
	}
	
	public int getLenght() {
		return this.lenght;
	}
	
	public int getBase() {
		return this.base;
	}
	
	public int hash(int key) {
		return key%getBase();
	}
	
	public int rehash(int key) {
		return ((key+1)%(getLenght()-getBase()))+getBase();
	}
	
	public void print() {
		System.out.println('{');
		for (int i=0; i<getLenght(); i++) {
			if (i == getBase()) {
				System.out.println("Synonyms");
			}
			
			System.out.printf("    %d: ", i);
			if (hashTable[i] != null)
				System.out.print(hashTable[i]);
			else
				System.out.print("null");
			System.out.print(" pointer to:");
			if (hashTable[i] != null) {
				if (hashTable[i].getNext() != null)
					System.out.println(hashTable[i].getNext());
				else
					System.out.println("null");
			}
			else {
				System.out.println("null");
			}
		}
		System.out.println('}');
	}
	
	public void insert(int key) {
		Node node = new Node(key);
		int i = hash(key);
		
		if (hashTable[i] == null) {
			hashTable[i] = node;
		}
		else {
			Node aux = hashTable[i];
			
			while (aux.getNext()!= null) {
				aux = aux.getNext();
			}
			
			while (hashTable[i] != null) {
				i = rehash(i);
			}

			hashTable[i] = node;
			aux.setNext(node);
			
		}
		
	}
	
	public Node search(int key) {
		int i = hash(key);
		Node node = hashTable[i];
		
		while (node.getKey()!=key && node != null) {
			node = node.getNext();
		}
		
		return node;
	}

}
