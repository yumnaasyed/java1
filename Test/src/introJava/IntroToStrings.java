package introJava;

public class IntroToStrings {
	
	public static void printHalf(String word) {
		
		System.out.println(word.substring((word.length())/2));
	}
	
	public static void concatenate(String word1, String word2) {
		
		System.out.println(word1.substring(1) + word2.substring(1));
	}
	
	public static void adverbs(String word) {
		
		if (word.substring(word.length()-2, word.length()).equals("ly")) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
	
	public static void contains(String w1, String w2) {
		
		System.out.println(w1.contains(w2));
	}
	
	public static void backwards(String word) {
		
		for (int i = word.length()-1; i >= 0; i--) {
			System.out.print(word.charAt(i));
		}
	}
	
	
	
	public static void main(String[] args) {
			
		//printHalf("helloo");
		
		//concatenate("hello", "there");
		
		//adverbs("happily");
		
		//contains("world", "orld");
		
		//backwards("hello");
		
		
		
		

	}
}