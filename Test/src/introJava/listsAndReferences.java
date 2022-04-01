package introJava;

import java.util.ArrayList;

public class listsAndReferences {
	
	// return
	public static String oneString(ArrayList<Character> l) {
		
		 String word = "";
		 
		 for (int i = 0; i < l.size(); i++) {
			 word += l.get(i);
		 }
		 return word;
	}
	
	// dont return
	public static void average(ArrayList<Double> n) {
		
		for (int i = 0; i < n.size(); i++) {
			double avg = 0;
			for (int j = 0; j < n.size(); j++) {
				avg += n.get(j);
			}
			n.set(i, avg/n.size());
		}
	}
	
	// return
	public static ArrayList<Integer> addElement(ArrayList<Integer> e) {
		
		ArrayList<Integer> newArr = new ArrayList<Integer>();
		
		for (int i = 0; i < e.size(); i++) {
			for (int j = 0; j < i + 1; j++) {
				newArr.add(e.get(j));
			}
		}
		return newArr;
	}

	public static void main(String[] args) {
		
		ArrayList<Character> l = new ArrayList<Character>();
		
		l.add('h');
		l.add('e');
		l.add('l');
		l.add('l');
		l.add('o');
		
		System.out.println(oneString(l));
		
		
		ArrayList<Double> n = new ArrayList<Double>();
		
		n.add(3.0);
		n.add(6.0);
		n.add(1.0);
		n.add(8.0);
		n.add(19.0);
		
		 average(n);
		 System.out.println(n);
		
		
		ArrayList<Integer> e = new ArrayList<Integer>();
		
		e.add(3);
		e.add(1);
		e.add(4);
		e.add(2);
		
		System.out.println(addElement(e));

	}
}