package introJava;
import java.util.ArrayList;

public class learningArrayList {
	
	///ArrayList<Integer> myList = new ArrayList<Integer>();
	
	//Integer x = new Integer(7);
	
	
	public static int search(ArrayList<Integer> l, int target) {
		
		int start = 0;
		int end = l.size() - 1;
		
		while (start <= end) {
			int mid = (start+end)/2;
			
			if (l.get(mid) == target) {
				return (mid);
			}
			if (l.get(mid) < target) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		return (-1);
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> myList = new ArrayList<Integer>();
		
		myList.add(5);
		myList.add(4);
		myList.add(6);
		myList.add(7);
		myList.add(8);
		myList.add(9);
		
		System.out.print(search(myList, 17));
		
		//myList.add(0, 7);
		
		//myList.remove(1);
		
		//myList.set(1, 9);
		
		//myList.get(2);
		
		//System.out.println(myList);

	}
	
}