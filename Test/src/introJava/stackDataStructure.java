package introJava;
import java.util.*;

public abstract class stackDataStructure<T> implements Iterable<T> {
	
	private static class Node<T> {
		private T info;
		private Node<T> next;
		
		public Node(T info) {
			this.info = info;
		}
	}
	
	private Node<T> top;
	private int size = 0;
		
	public void push(T info) {
		Node<T> newNode = new Node<T>(info);
		newNode.next = top;
		top = newNode;
		size++;
	}
	
	public T pop() {
		T newNode = top.info;
		top = top.next;
		size--;
		return newNode;
	}
	
	public T peek() {
		return top.info;
	}
	
	public int size() {
		return size;
	}
	
	public T get(int index) {
		Node<T> current = top;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current.info;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public String toString() {
		StringBuilder string = new StringBuilder();
		Node<T> curr = top;
		while (curr != null) {
			string.append(curr.info).append(" , ");
			curr = curr.next;
		}
		return string.toString();
	}

	public static void main (String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(4);
		stack.push(2);
		stack.push(6);
		stack.push(8);
		stack.push(9);
		stack.push(5);
		
		System.out.println(stack.toString());
		
		stack.pop();
		
		System.out.println(stack.toString());
		
		System.out.println(stack.peek());
		
		System.out.println(stack.size());
		
		System.out.println(stack.get(3));
		
		System.out.println(stack.isEmpty());
		
	}
}