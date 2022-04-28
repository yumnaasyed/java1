package introJava;

// EnglishToArabicTranslator


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class EnglishToArabicTranslator {
	
	private HashMap<String, String> words = new HashMap<String, String>();
	
	public void translate() {
		
		try {
			BufferedReader in = new BufferedReader(new FileReader("EnglishToArabicDictionary.txt"));
			
			for (String line = in.readLine(); line != null; line = in.readLine()) {
				words.put(line, in.readLine());
			}
			in.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String toString(String w) {
		return words.get(w);
	}
	
	public static void main(String[] args) {
		
		EnglishToArabicTranslator runner = new EnglishToArabicTranslator();
		Scanner s = new Scanner(System.in);
		runner.translate();
		while (true) {
			System.out.println(runner.toString(s.next()));
		}
	}
}