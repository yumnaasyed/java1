package introJava;

public class ifStatements2 {
	
	private int age;
	private char gender;
	
	
	public void setAge(int age) {
		
		this.age = age;
		
	}
	
	public void setGender(char gender) {
		
		this.gender = gender;
		
	}
	
	public void vote() {
		
		if (age >= 18) {
			System.out.println("You can vote");
		}
		
		else {
			System.out.println("You cannot vote");
		}
		
	}
	
	public void tetanus() {
		
		if (age % 4 == 0) {
			System.out.println("you need a shot");
		}
		
		else {
			System.out.println("you do not need a shot");
		}
	}
	
	public void toddler() {
		
		if (age < 4 && gender == 'b') {
			System.out.println("toddler boy");
		}
		
		else if (age < 4 && gender == 'g') {
			System.out.println("toddler girl");
		}
		
		else {
			System.out.println("you are not a toddler");
		}
	}
	
	public void tickets() {
		
		if (age > 65 || age < 12) {
			System.out.println("you get free tickets");
		}
		
		else {
			System.out.println("you have to pay for tickets");
		}
	}
	
	public void teenager() {
		
		if (age > 12 && age < 18) {
			System.out.println("you are a teen");
		}
		else {
			System.out.println("you are not a teen");
		}
	}
	
		
	public static void main(String[] args) {
		
		
		ifStatements2 runner = new ifStatements2();
		
			runner.setAge(0);
		
			runner.setGender('g');
		
			runner.vote();
		
			runner.tetanus();
			
			runner.toddler();
			
			runner.tickets();
				
			runner.teenager();


	}
	
}