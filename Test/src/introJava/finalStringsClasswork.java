package introJava;

import java.util.ArrayList;
//classwork 4/8
public class finalStringsClasswork {
	
	public static ArrayList<Integer> relativeMax(double[] ds) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		for (int i = 1; i < ds.length-1; i++) {
			if (ds[i-1] < ds[i] && ds[i+1] < ds[i]) {
				a.add(i);
			}
		}
		return a;
	}
	
	public static void main(String[] args) {
		System.out.println(relativeMax(new double[] {5.5, 6.3, 4.4, 9.2, 7.7}));

		
	
	}
}