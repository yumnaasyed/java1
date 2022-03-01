package introJava;

import java.util.ArrayList;
import java.util.Collections;

public class gettingToKnowLists {
	
	
	public static ArrayList<Character> everySecond(ArrayList<Character> list) {
		
		for (int i = 0; i < list.size(); i++) {
			list.remove(i);
		}
		return list;
	}
	
	public static ArrayList<String> reverse(ArrayList<String> list) {
		
		ArrayList<String> newList = new ArrayList<String>();
		
		for (int i = 0; i < list.size(); i++) {
			
			newList.add(0, list.get(i));
		}
		return newList;
	}
	
	public static ArrayList<Double> doubleList(ArrayList<Double> list) {
		
		ArrayList<Double> newList = new ArrayList<Double>();
		
		for (int i = 0; i < list.size(); i++) {
			newList.add(list.get(i)*2);
		}
		return newList;
	}
	
	public static ArrayList<Character> letters(int n) {
		
		ArrayList<Character> list = new ArrayList<Character>();
		
		for (int i = 97; i < 97+n; i++) {
			if (i % 2 == 0) {
				list.add((char)(i));
			}
			else {
				list.add(0, (char)(i));
			}
		}
		return list;
		
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<Character> list = new ArrayList<Character>();
		
		list.add('d');
		list.add('k');
		list.add('e');
		list.add('p');
		list.add('w');
		list.add('s');
		list.add('f');
		
		//System.out.println(everySecond(list));
		
		
		ArrayList<String> list2 = new ArrayList<String>();
		
		list2.add("lists");
		list2.add("are");
		list2.add("great");
		
		//System.out.println(reverse(list2));
		
		
		ArrayList<Double> list3 = new ArrayList<Double>();
		
		list3.add(4.2);
		list3.add(3.5);
		list3.add(5.0);
		
		//System.out.println(doubleList(list3));
		
		System.out.println(letters(7));
		

	}
	
}