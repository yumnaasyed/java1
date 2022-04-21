package introJava;

import java.util.ArrayList;

public class Editor {
	
	private ArrayList<String> history = new ArrayList<String>();
	private int ind = 0;
	
	public Editor(String s) {
		history.add(s);;
	}
	
	public void change(String newS) {
		history.add(newS);
		ind++;
	}
	
	public void delete() {
		String curr = history.get(ind);
		history.add(curr.substring(0, curr.length()-1));
		ind++;
	}
	
	public void undo() {
		ind -= 1;
	}
	public void redo() {
		ind += 1;
	}
	
	public String toString() {
		return(history.get(ind));
	}
	
	public static void main(String[] args) {
		Editor e = new Editor ("hello");
		System.out.println(e);
		e.delete();
		System.out.println(e);
		e.undo();
		System.out.println(e);
		e.redo();
		System.out.println(e);
		
	}
	
}