package hash;

public class Node {
	private int key;
	private Node next;
	
	
	public Node(int key) {
		this.key = key;
		this.next = null;
	}
	
	public String toString() {
		return Integer.toString(this.getKey());
	}

	public int getKey() {
		return this.key;
	}
	
	public void setkey(int key) {
		this.key = key;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
}
