package introJava;

public class Card {
	
	
	private String suit;
	
	private int num;
	
	
	public Card(String suit, int num) {
		
		this.suit = suit;
		this.num = num;
	}
	
	public String toString() {
		return "this is a " + suit + ", with number " + num + "  . ";
	}
	
	public String getSuit() {
		
		return suit;
	}
	
	public int getNum() {
		
		return num;
	}
	
	
	
}