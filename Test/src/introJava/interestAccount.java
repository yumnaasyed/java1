package introJava;

public class interestAccount extends bankAccount{
	
	private double interest;
	
	public interestAccount(String name, int money, double interest) {
		super(name, money);
		this.interest = interest;
	}
	
	public void addInterest() {
		
		deposit(interest * getMoney());

	}
	
	public String toString() {
		return super.toString() + " the interest rate is " + interest + " ";
	}
	
	
	public static void main(String[] args) {
		

	}
	
}