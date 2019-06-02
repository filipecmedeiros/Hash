package hash;

public class NodeList {
	private Node list;
	
	public NodeList() {
		this.setList(null);
	}

	public Node getList() {
		return list;
	}

	public void setList(Node list) {
		this.list = list;
	}
	
	public void print() {
		Node aux = list;
		
		if (aux != null) {
			while(aux != null) {
				System.out.print(aux.getKey());
				System.out.print(' ');
				aux = aux.getNext();
			}
			System.out.println(" ");
		}
		else {
			System.out.println("null");
		}
	}
	
	public void insert (int key) {
		Node node = new Node(key);
		Node aux = null;
		
		if (getList() == null) {
			setList(node);
		}
		else {
			aux = getList();
			if (node.getKey() < aux.getKey()) {
				node.setNext(aux);
				setList(node);
			}
			else {
				while(node.getKey()<aux.getKey()) {
					aux = aux.getNext();
				}
				if (aux.getNext() == null) {
					aux.setNext(node);
				}
				else {
					node.setNext(aux.getNext());
					aux.setNext(node);
				}
			}
		}
	}
	
	public Node search(int key) {
		Node aux = list;
		
		while(aux != null && key != aux.getKey()) {
			if (aux.getKey() == key) {
				break;
			}
			else {
				aux = aux.getNext();
			}
		}
		
		return aux;
	}
	
	public void remove(int key) {
		Node aux = list;
		boolean found = false;
		
		if (aux!=null) {
			if (aux.getKey() == key) {
				list = aux.getNext();
				found = true;
			}
			else {
				while(aux.getNext() != null && !found) {
					if (aux.getNext().getKey() == key) {
						found = true;
					}
					else {
						aux = aux.getNext();
					}
				}
				if (found) {
					aux.setNext(aux.getNext().getNext());
				}
			}
		}
	}

}
