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
			int maxInt = Integer.MIN_VALUE;
			for (int i : w.values()) {
				if (i > maxInt) {
					maxInt = i;
				}
			}
			System.out.println(maxInt);
		}
	}
	
	public void doubleZeroNine(HashMap<String, String> w, String name) {
		String curr = w.get(name);
		System.out.print(name + " --> " + w.get(name) + " ");
		while (!name.equals(curr)) {
			System.out.print(curr + " --> " + w.get(curr) + " ");
			curr = w.get(curr);
		}
	}
	
	public void morse(HashMap<Character, String> code, String message) {
		
		String[] words = message.split("");
		
		System.out.println(message);
		
		for (int i = 0; i < words.length; i++) {
			System.out.print(code.get(words[i].charAt(0)) + " ");
		}
	}
	
	public static void main(String[] args) {
		
		MoreWithMaps runner = new MoreWithMaps();
		
		HashMap<String, Integer> comps = new HashMap<String, Integer>();

		comps.put("apple", 700);

		comps.put("ibm", 400);

		comps.put("tesla", 1000);
		
		runner.stock(comps, "ibm");

		 
		HashMap<String, String> people = new HashMap<String, String>();

		people.put("Ryan", "Yumna");

		people.put("Cooper", "Anika");

		people.put("Anika", "Ryan");

		people.put("Yumna", "Cooper");
		
		runner.doubleZeroNine(people, "Ryan");
		
		
		HashMap<Character, String> morseCode = new HashMap<Character, String>();
		
		morseCode.put('a', ".-");
		morseCode.put('b', "-...");
		morseCode.put('c', "-.-.");
		morseCode.put('d', "-..");
		morseCode.put('e', ".");
		morseCode.put('f', "..-.");
		morseCode.put('g', "--.");
		morseCode.put('h', "....");
		morseCode.put('i', "..");
		morseCode.put('j', ".---");
		morseCode.put('k', "-.-");
		morseCode.put('l', ".-..");
		morseCode.put('m', "--");
		morseCode.put('n', "-.");
		morseCode.put('o', "---");
		morseCode.put('p', ".--.");
		morseCode.put('q', "--.-");
		morseCode.put('r', ".-.");
		morseCode.put('s', "...");
		morseCode.put('t', "-");
		morseCode.put('u', "..-");
		morseCode.put('v', "...-");
		morseCode.put('w', ".--");
		morseCode.put('x', "-..-");
		morseCode.put('y', "-.--");
		morseCode.put('z', "--..");
		morseCode.put(' ', " / ");
		
		runner.morse(morseCode, "hello i am yumna");

	}
	
}