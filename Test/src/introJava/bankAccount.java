package introJava;

public class bankAccount {
	
	private String ownerName;
	private double accountMoney;
	
	public bankAccount(String name, double money) {
		ownerName = name;
		accountMoney = money;
		
	}
	
	public bankAccount(String name) {
		ownerName = name;
		accountMoney = 0;
		
	}
	
	public void deposit(double givenMoney) {
		accountMoney += givenMoney;
	}
	
	public void withdraw(double givenMoney) {
		accountMoney -= givenMoney;
	}
	
	
	public String toString() {
		return "This banks owner is " + ownerName + ". There is $" + accountMoney + " in the bank account.";
	}
	
	public double getMoney() {
		
		return accountMoney;
	}
	
	
	public static void main(String[] args) {
		
		bankAccount Shrewsbury = new bankAccount("Ron", 500);
		
		bankAccount Southborough = new bankAccount("Sarah", 1500);
		
		bankAccount Worcester = new bankAccount("Cam", 2000);
		
		Shrewsbury.withdraw(100);
		Southborough.deposit(700);
		
		System.out.println(Shrewsbury);
		

	}
	
}