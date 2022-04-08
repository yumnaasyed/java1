package introJava;

public class LinkedList<Q> {
	
	private int size = 0;
	
	private class Node {
		
		Q info;
		Node next;
		
		public Node(Q i, Node n) {
			info = i;
			next = n;
		}
	}
	
	private Node head = null;	
	
	public void add(Q info) {
		
		size++;
		
		Node newNode = new Node(info, null);
		
		if (head == null) {
			head = newNode;
		}
		else {
			Node curr = head;
			while(curr.next!= null) {
				curr = curr.next;
			}
			curr.next = newNode;
		}
	}
	
	public void addIndex(Q info, int ind) {
		
		try {
			size++;
			Node newNode = new Node(info, null);
		
			if (ind == 0) {
				newNode.next = head;
				head = newNode;
			}
			else {
				Node curr = head;
				
				for (int i = 0; i < ind-1; i++) {
					curr = curr.next;
				}
				newNode.next = curr.next.next;
				curr.next = newNode;
			}
		}
		catch(NullPointerException e) {
			throw new IndexOutOfBoundsException();
		}
	}

	public Q get(int x) {
		
		try { 
			Node curr = head;
		
			for (int i = 0; i < x; i++) {
				curr = curr.next;
			}
			return curr.info;
		}
		catch(NullPointerException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public Q remove(int x) {
		
		try {
			Q storedInfo;
		
			if (x == 0) {
				storedInfo = head.info;
				head = head.next;
				size--;
			}
			else {
				Node curr = head;
			
				for (int i = 0; i < x-1; i++) {
					curr = curr.next;
				}
				storedInfo = curr.next.info;
				curr.next = curr.next.next;
				size--;
			}
			return storedInfo;
		}
		catch(NullPointerException e) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public String toString() {
		
		String output = "";
		Node curr = head;
		
		while (curr != null) {
			
			output += curr.info.toString();
		}
		return output;
	}
	
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		
		LinkedList<String> l = new LinkedList<String>();
		l.add("hello");
		l.add("my");
		l.add("name");
		l.add("is");
		l.add("yumna");
		
		l.addIndex("judy", 3);
		System.out.println(l.remove(2));
		System.out.println(l.toString());
	}
	
}