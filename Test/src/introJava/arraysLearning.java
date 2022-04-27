package introJava;

import java.util.Arrays;

public class arraysLearning {
	
	//public void display(int[] myArr) {
		
		//for (int i = 0; i < myArr.length; i++) {
			
			//System.out.print(myArr[i]);
		//}
	//}
	
	//public static int[] createArray(int n) {
		
		//int[] newArr = new int[n];
		
		//return newArr;
		
	//}
	
	
	
	public static void main(String[] args) {
		
		//display(createArray(10));
		
		int[] arr = {1, 54, 2, 7};
		for(int num : arr) {
			num+= 2;
		}
		System.out.println(Arrays.toString(arr));
	}
}