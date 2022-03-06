package introJava;
import java.util.Arrays;
import java.util.ArrayList;

public class moreLists {
	
	
	public static ArrayList<Double> randomNum(int n, int x) {
		ArrayList<Double> l = new  ArrayList<Double>();
		
		for (int i = 0; i < n; i++) {
			l.add(i, Math.floor(Math.random()*(x - (-x) + 1) + (-x)));
		}
		return l;
	}
	
	
	public static void posNeg(ArrayList<Integer> l) {
		
		ArrayList<Integer> pos = new ArrayList<Integer>();
		ArrayList<Integer> neg = new ArrayList<Integer>();
		
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i) < 0) {
				neg.add(l.get(i));
			}
			else {
				pos.add(l.get(i));
			}
		}
		System.out.println(pos);
		System.out.println(neg);
	}
	
	public static ArrayList<Double> reverse(ArrayList<Double> l) {
		
		for (int i = 0; i < l.size(); i++) {
			l.add(i, l.remove(l.size()-1));
		}
		return l;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(randomNum(5, 5));
		
		ArrayList<Integer> myList = new ArrayList<Integer>();
		
		myList.add(-9);
		myList.add(3);
		myList.add(42);
		myList.add(-17);
		myList.add(-19);
		
		
		posNeg(myList);
		
		
		ArrayList<Double> myList1 = new ArrayList<Double>();
		
		myList1.add(4.0);
		myList1.add(5.0);
		myList1.add(6.0);
		myList1.add(7.0);
		myList1.add(8.0);
		
		System.out.println(reverse(myList1));
		
		

	}
	
}