package introJava;

class linkedlistassignment {

	Node head;
	Node tail;

	linkedlistassignment(Node headNode) {
		head = headNode;
		tail = headNode;
	}

	void prependNode(Node node) {
		node.next = head;
		head = node;
	}

	void appendNode(Node node) {
		tail.next = node;
		tail = node;
	}
	
	void insert(Node node, int index) {
		Node curr = head;
		for (int i = 0; i < index; i++) {
			if (curr == null) {
				throw new IndexOutOfBoundsException();
			}
			curr = curr.next;
		}
		
		var temp = curr.next;
		curr.next = node;
		node.next = temp;
		
	}
	
	void delete(int index) {
		Node curr = head;
		for (int i = 0; i < index-1; i++) {
			if (curr == null) {
				throw new IndexOutOfBoundsException();
			}
			curr = curr.next;

		}
		if (curr == null || curr.next == null) {
			throw new IndexOutOfBoundsException();
		}
		
		curr.next = curr.next.next;
	
	}

	void traverseAndPrint() {
		Node curr = head;
		while (curr != null) {
			System.out.println(curr.value);
			curr = curr.next;
		}
	}	

	public static void main(String[] args) {
		// create a linked list (3 -> 2 -> 1 -> 2)
		Node node = new Node(3);
		var ll = new linkedlistassignment(node);
		ll.appendNode(new Node(2));
		ll.appendNode(new Node(1));
		ll.appendNode(new Node(2));
		//ll.delete(3);
		ll.insert(new Node(3), 3);
		// traverse through and print
		ll.traverseAndPrint();
	}

}