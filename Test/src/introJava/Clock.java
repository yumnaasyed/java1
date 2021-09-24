package introJava;



public class Clock {
	
	private int time;
	
	// create your methods here
	
	public void setTime(int num) {
		time = num;
		
	}
	
	public void tick() {
		time += 1;
		
	}
	
	public void displayTime() {
		System.out.println(time%60);
		
	}
	
	public static void main(String[] args) {
		Clock tester = new Clock();
		
		// should display the time to be 56, 57, 58, 59, 0, 1, etc.
		tester.setTime(56);
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
		tester.tick();
		tester.displayTime();
	}
}