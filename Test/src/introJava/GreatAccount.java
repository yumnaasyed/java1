package introJava;

public class GreatAccount extends bankAccount {
	
	private int totalWithdraws;
	private int month;
	private int withdraw;
	
	public GreatAccount(String name, double money) {
		super(name, money);
		
	}
	
	public void withdraw(double givenMoney) {
		
		if (withdraw <= 3) {
			withdraw++;
			super.withdraw(givenMoney);
		}
	}
	
	public void nextMonth() {
		
		totalWithdraws += withdraw;
		month++;
		withdraw = 0;
		
		if (month == 12 && totalWithdraws == 0) {
			deposit(getMoney());
			month = 0;
		}
		else if (month == 12) {
			month = 0;
			totalWithdraws = 0;
		}
	}
	
	public String toString() {
		return super.toString() + " The month is " + month + " with " + withdraw + " total withdraws.";
	}
	
	
	
	
	public static void main(String[] args) {
		
		bankAccount b1 = new bankAccount("B1");
		b1.deposit(500);
		b1.withdraw(200);
		System.out.println(b1.toString());
		interestAccount b2 = new interestAccount("B2", 500, 0.01);
		b2.addInterest();
		System.out.println(b2.toString());
		CreditCard b3 = new CreditCard("B3", 500, 0.01);
		b3.addInterest();
		b3.withdraw(405);
		GreatAccount b4 = new GreatAccount("B4", 500);
		b4.withdraw(0);
		b4.withdraw(0);
		b4.withdraw(0);
		b4.withdraw(0);
		System.out.println(b4.toString());
		GreatAccount b5 = new GreatAccount("B5", 500);
		for(int i = 0; i < 12; i++) {
			b5.nextMonth();
		}
		System.out.println(b5.toString());
		b5.withdraw(0);
		for(int i = 0; i < 12; i++) {
			b5.nextMonth();
		}
		System.out.println(b5.toString());

	}
	
}