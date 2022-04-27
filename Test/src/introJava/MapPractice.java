package introJava;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class MapPractice {
	
	public static void main(String[] args) {
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("UserInputs.text"));
			
			for (String line = in.readLine(); line != null;
					line = in.readLine()) {
				System.out.println(line);
			
			in.close();
		
		}
		

		HashMap<String, Integer> ages = new HashMap<String, Integer>();
		
		ages.put("Condy", 5);
		ages.put("Mare", 17);
		ages.put("Joe", 14);
		
		//ages.remove("Joe");
		
		for (String name : ages.keySet()) {
			System.out.println(ages.get(name));
		}
	}
}