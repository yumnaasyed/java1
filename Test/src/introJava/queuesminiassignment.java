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
	
	public static void zerosAndNines(int n) {
		System.out.println("When n is "+n);
		Queue<String> q=new LinkedList<>();//a queue
		//your code here
	}
	
	public static void main(String[] args) {
		// starbucks();
		generateBinaryNumber(8);
		// zerosAndNines(in.nextInt());
		//in.close();
	}

}