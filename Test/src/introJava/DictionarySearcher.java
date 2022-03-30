package introJava;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DictionarySearcher {
	
	private static boolean binary = false;	// controls which type of search to use
	
	// sequential search
	public static int seqSearch(String s, List<String> words) {
		
		// your code here
		
		for (int i = 0; i < words.size(); i++) {
			if (s.equals(words.get(i))) {
				return i + 1;
			}
		}
		return -1;
	}
	
	// binary search
	public static int binSearch(String s, List<String> words, int start, int end) {
		
		// your code here
		
		start = 0;
		end = words.size();
		int mid;
		
		while (start <= end) {
			mid = (start+end)/2;
			
			if (s.compareTo(words.get(mid)) == 0) {
				return mid + 1;
			}
			
			else if (s.compareTo(words.get(mid)) > 0) {
				start = mid;
			}

			if (s.compareTo(words.get(mid)) < 0) {
				end = mid;
			}
		}
		return -1;
		
	}

	// generates the list of words from words.txt, then runs the search
	public static void main(String[] args) throws IOException {
		// generates the word list from the dictionary file
		BufferedReader in = new BufferedReader(new FileReader("words.txt"));
		List<String> words = new ArrayList<String>();
		for (String line = in.readLine(); line != null; line = in.readLine()) {
			words.add(line.trim());
		}
		in.close();
		
		// get user input, then run our search on it. 
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a word");
		String search = s.nextLine().trim().toLowerCase();
		long startTime = System.currentTimeMillis();
		if (!binary)
			System.out.println(seqSearch(search, words));
		else
			System.out.println(binSearch(search, words, 0, words.size()-1));
		
		// print the runtime of the search
		System.out.println("runtime: " + (System.currentTimeMillis() - startTime));
		s.close();
	}
	
	// two extra methods that we will discuss later - for now, they'll go unused.
	public static void add(List<String> words, String s) {
		words.add(ind(words, s, 0, words.size()-1), s);
	}
	public static int ind(List<String> words, String s, int start, int end) {
		if (start > end)
			return start;
		int mid = (start + end)/2;
		if (words.get(mid).compareTo(s) < 0)
			return ind(words, s, mid + 1, end);
		return ind(words, s, start, mid-1);
	}
}
