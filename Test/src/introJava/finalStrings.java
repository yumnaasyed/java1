package introJava;

public class finalStrings {
	
	public static void pigLatin(String str) {
		
		str = str.substring(1, str.length()) + str.charAt(0) + "ay";
		
		System.out.println(str);
	}
	
	
	public static void iterate(String str, char letter) {
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == letter) {
				System.out.print('$');;
			}
			else {
			System.out.print(str.charAt(i));
			}
		}	
	}
	
	
	public static void array(String[] arr) {
		
		String longest = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].length() > longest.length()) {
				longest = arr[i];
			}
		}
		System.out.println(longest);
	}
	
	
	public static void main(String[] args) {
		
		pigLatin("pig");
		
		iterate("hello", 'l');
		
		array(new String[] {"hello", "hello", "bye"});

	}
	
}