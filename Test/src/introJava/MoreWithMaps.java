package introJava;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MoreWithMaps {
	
	
	public void stock(HashMap<String, Integer> w, String name) {
		
		if (w.containsKey(name)) {
			System.out.println(w.get(name));
		}
		else if (name.equals("average")) {
			int sum = 0;
			for (int i : w.values()) {
				sum += i;
			}
			System.out.println(sum/w.size());
		}
		else {
			int maxInt = 0;
			for (int i : w.values()) {
				if (i > maxInt) {
					maxInt = i;
				}
			}
			System.out.println(maxInt);
		}
	}
	
	public void doubleZeroNine(HashMap<String, String> w, String name) {
		String n = name;
		String curr = w.get(name);
		System.out.println(name + " --> " + w.get(name));
		while (!name.equals(curr)) {
			System.out.print(curr + " --> " + w.get(curr));
		}
	}
	
	public static void main(String[] args) {
		
		MoreWithMaps runner = new MoreWithMaps();
		Scanner s = new Scanner(System.in);
		
		HashMap<String, Integer> comps = new HashMap<String, Integer>();

		comps.put("apple", 700);

		comps.put("ibm", 400);

		comps.put("tesla", 1000);
		
		//runner.stock(comps, "hfsf");

		 

		HashMap<String, String> people = new HashMap<String, String>();

		people.put("Ryan", "Yumna");

		people.put("Cooper", "Anika");

		people.put("Anika", "Ryan");

		people.put("Yumna", "Cooper");
		
		runner.doubleZeroNine(people, "Ryan");

	}
	
}