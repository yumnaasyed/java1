package introJava;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class HashMapDictionary{
	
	public static void main (String[]args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);

		BufferedReader br = new BufferedReader(new FileReader("wordDictionary.txt"));
		
		HashMap<String, String> words = new HashMap<String, String>();
		
		for (String line = br.readLine(); line != null; line = br.readLine()) {
			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) == '|') {
                    words.put(line.substring(0, i), line.substring(i));
                    break;
				}
			}
		}
		br.close();
		
		
		String input = scanner.nextLine();
		
		if (words.get(input) != null) {
			System.out.println(words.get(input));
		}
		else {
			System.out.println("try typing the word again");
			input = scanner.nextLine();
		}
		scanner.close();
		
		
	}

}