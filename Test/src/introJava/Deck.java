package introJava;


public class Deck {
	
	private Card[] deck = new Card[52];
	
	
	public Deck() {
		
		String[] suits = {"clubs", "spades", "diamonds", "hearts"};
		int count = 0;
		
		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < 13; j++) {
				deck[count] = new Card(suits[i], j+1);
				count++;
			}
		}
	}
	
	public String toString() {
		
		String info = "";
		
		for (Card c : deck) {
			info += c.toString();
		}
		return info;
	}
	
	public Card getRandom() {
		
		return deck[(int)(Math.random()*52)];
	}
	
	public Card[] getFirstN(int n) {
		
		Card[] firstN = new Card[n];
		
		for (int i = 0; i < n; i++) {
			firstN[i] = deck[i];
		}
		return firstN;
	}
	
	public void shuffle() {
		
		for (int i = 0; i < deck.length; i++) {
			int num = (int)(Math.random()*52);
			Card temp = deck[num];
			deck[num] = deck[i];
			deck[i] = temp;
		}
	}
	
	public void sort() {
		
		for (int i = 0; i < deck.length; i++) {
			
			int min = Integer.MAX_VALUE;
			int minInd = i;
			
			for (int j = i; j < deck.length; j++) {
				if (deck[j].getNum() < min) {
					min = deck[j].getNum();
					minInd = j;
				}
			}
			Card temp = deck[i];
			deck[i] = deck[minInd];
			deck[minInd] = temp;
		}
	}
	
}