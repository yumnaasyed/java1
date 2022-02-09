package introJava;

public class CreditCard extends interestAccount{
	
	
	public CreditCard(String name, int money, double interest) {
		super(name, money, interest);
	}
	
	public void addInterest() {
		super.addInterest();
		withdraw(10);
	}
	
	public void withdraw(double givenMoney) {
		
		if (getMoney() - givenMoney > 100) {
			super.withdraw(givenMoney);
		}
	}
	
	public String toString() {
		return super.toString();
	}
	
	
	
	public static void main(String[] args) {

	}
	
}