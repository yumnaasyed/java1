package introJava;

import java.util.ArrayList;

public class PriorityQueue<T> {
	
	private class Bundle {
		
		T element;
		int priority;
		
		public Bundle(T e, int p) {
			element = e;
			priority = p;
		}
		
		public String toString() {
			return element + " : " + priority;
		}
	}
	
	ArrayList<Bundle> queue = new ArrayList<Bundle>();
	
	// pop, size, put, to string
	
	public void put(T info, int p) {
		
		if (queue.contains(new Bundle(info, p))) {
			
			for (int i = 0; i < queue.size(); i++) {
				
				if (queue.get(i).element.equals(info)) {
					queue.remove(i);
					break;
				}
			}
		}
		
		for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i).priority < p) {
				queue.add(new Bundle(info, p));
				return;
			}
		}
		queue.add(new Bundle(info, p));
		
	}
	
	public T pop() {
		return queue.remove(0).element;
	}
	
	public int size() {
		return queue.size();
	}
	
	public String toString() {
		
		return queue.toString();
	}
	
	public static void main(String[] args) {
		
		PriorityQueue<String> newQueue = new PriorityQueue<String>();
		
		newQueue.put("sarah", 30);
		newQueue.put("yumna", 20);
		newQueue.put("judy", 15);
		newQueue.put("sarah", 0);
		newQueue.put("mare", 50);
		newQueue.put("ryan", 6);
		newQueue.put("cooper", 50);
		
		newQueue.pop();
		
		newQueue.size();
		
		System.out.println(newQueue);

	}
}