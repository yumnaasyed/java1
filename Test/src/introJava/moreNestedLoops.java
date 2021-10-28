package introJava;

public class moreNestedLoops {
	
	public void loopingBox(int x) {
		
		for (int j = 0; j < x; j++) {
			for (int i = j+1; i <= x+j; i++) {
				if (i <= x) {
					System.out.print(i);
				}
				else {
					System.out.print(i-5);
				}
			}
			System.out.println();
		}
	}
	
	public void triangleX(int n) {
		
		for (int height = 1; height <= n; height++) {
			for (int width = 1; width <= height; width++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}
	
	public void diamond(int x) {
		for (int height = 0; height < x; height++) {
			for (int width = 0; width < x; width++) {
				if (width < x - height - 1) {
				System.out.print(" ");
				}
				else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		for (int height = x+1; height < 2*x; height++) {
			for (int width = 0; width < x; width++) {
				if (width < height - x) {
				System.out.print(" ");
				}
				else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		moreNestedLoops runner = new moreNestedLoops();
		
		runner.loopingBox(5);
		runner.triangleX(5);
		runner.diamond(25);
	

	}
	
}