package introJava;

public class moreStrings {
	
	public static void firstTwo(String word) {
		
		System.out.println(word.substring(0, 2).equals(word.substring(word.length()-2)));
	}
	
	
	public static void contain(String w1, String w2) {
		
		for (int i = 0; i < w2.length(); i++) {
			
			System.out.println(w1.contains(w2.charAt(i)+ ""));
		}
	}
	
	
	public static void wordCount(String words) {
		
		String[] w = words.split(" ");
		
		System.out.print(w);
		
		
	}
	
	
	public static void noE (String words) {
		
		for (int i = 0; i < words.length(); i++) {
			if (words.charAt(i) != 'e') {
				System.out.print(words.charAt(i));
			}
		}
	}
	
	
	public static void palindrome(String word) {
		
		String rev = "";
		for (int i = word.length()-1; i >= 0; i--) {
			rev += word.charAt(i);
		}
		System.out.println(word.equals(rev));
	}
	
	
	public static void arrayElement(String words) {
		
		System.out.print(words.split(""));
	}
	

	
	public static void main(String[] args) {
		
		//firstTwo("edited");
		
		//contain("hello world", "leg");
		
		//wordCount("i love me");
		
		//noE("lets eat there");
		
		//palindrome("ava");
		
		arrayElement("AP CS is for nerds");
	}
}