package introJava;

import java.io.*;
import java.util.LinkedList;
import java.util.*;

public class queuesminiassignment {
//static Scanner in=new Scanner(System.in);
	public static void starbucks() {
		
	}
	
	public static void generateBinaryNumber(int n) {
		System.out.println("When n is "+n);
		Queue<String> q=new LinkedList<>();
		q.add("1");
		while(n>0) {
			String curr = q.poll();
			System.out.println(curr);
			q.add(curr + "0");
			q.add(curr + "1");
			n--;
		}
	}
	
	static List<String> vec = new LinkedList<String>();
	
	public static void zerosAndNines() {
		
		//System.out.println("When n is "+n);
		Queue<String> q=new LinkedList<>();
		q.add("9");
		
		for (int i = 1000; i > 0; i-- ) {
			String string1 = q.peek();
            q.remove();
            
            vec.add(string1);
            
            String string2 = string1;
            
            q.add(string1 + "0");
            q.add(string2 + "9");
		}
		

	}
	
	public static String findSmallestMultiple(int n) {
		
		for (int i = 0; i < vec.size(); i++) {
			
			if (Integer.parseInt(vec.get(i)) % n == 0) {
				return vec.get(i);
			}
		}
		return "";
	}
	
	public static void main(String[] args) {
		// starbucks();
		//generateBinaryNumber(8);
		// zerosAndNines(7);
		zerosAndNines();
		System.out.println(findSmallestMultiple(7));
		//in.close();
	}

}