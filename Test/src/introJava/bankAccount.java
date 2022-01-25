package introJava;

public class bankAccount {
	
	private String ownerName;
	private int accountMoney;
	private double interestRate;
	
	public bankAccount(String name, int money, double rate) {
		ownerName = name;
		accountMoney = money;
		interestRate = rate;
		
	}
	
	public bankAccount(String name, double rate) {
		ownerName = name;
		interestRate = rate;
		accountMoney = 0;
		
	}
	
	public void deposit(int givenMoney) {
		accountMoney += givenMoney;
	}
	
	public void withdraw(int givenMoney) {
		accountMoney -= givenMoney;
	}
	
	public void addInterest() {
		
		accountMoney += accountMoney*interestRate;
		
	}
	
	public String toString() {
		return "This banks owner is " + ownerName + " and they have an interest rate of " + interestRate + ". There is $" + accountMoney + " in the bank account.";
	}
	
	
	public static void main(String[] args) {
		
		bankAccount Shrewsbury = new bankAccount("Ron", 500, 20);
		
		bankAccount Southborough = new bankAccount("Sarah", 1500, 12);
		
		bankAccount Worcester = new bankAccount("Cam", 2000, 15);
		
		Shrewsbury.withdraw(100);
		Southborough.deposit(700);
		Worcester.addInterest();
		
		System.out.println(Shrewsbury);
		

	}
	
}