package introJava;

import java.awt.Color;
import java.util.Arrays;

public class Wrestler {
	
	
	private String name;
	private double weight;
	private String color;
	private int numWins;
	
	
	public Wrestler(String name, double weight, String color, int wins) {
		
		this.name = name;
		this.weight = weight;
		this.color = color;
		numWins = wins;
	}
	
	public String intimidating() {
		
		return "You are going to lose";
	}
	
	public String toString() {
		
		return "I am " + name + " and " + weight + " pounds. I have " + numWins;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public String name() {
		return name;
	}
	
	public boolean fight(Wrestler other) {
		
		if (weight > other.getWeight()) {
			numWins++;
			return true;
		}
		else if (weight == other.getWeight()) {
			if (name.compareToIgnoreCase(other.name) < 0) {
				numWins++;
				return true;
			}
		}
		other.numWins++;
		return false;
	}
	
	public double lifting(int min) {
		
		for (int i = 0; i < min; i++) {
			weight += 0.1;
		}
		return weight;
	}
	
	public boolean tagTeam(Wrestler[] allies, Wrestler[] opps) {
		
		double allyWeight = this.weight, oppsWeight = 0;
		
		for (Wrestler w : allies) {
			w.color = this.color;
			allyWeight += w.weight;
		}
		
		for (int i = 0; i < opps.length; i++) {	
			opps[i].color = opps[0].color;
			oppsWeight += opps[i].weight;
		}
		
		if (allyWeight >= oppsWeight) {
			
			numWins++;
			
			for (Wrestler w : allies) {
				w.numWins++;
			}
			return true;
		}
		else {
			for (Wrestler w : allies) {
				w.numWins++;
			}
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		
		Wrestler S = new Wrestler("s", 34, "blue",  5);
		Wrestler G = new Wrestler("g", 43, "green", 5);
		Wrestler B = new Wrestler("b", 2454, "pink", 5);
		Wrestler F = new Wrestler("f", 423, "white", 5);
		Wrestler C = new Wrestler("c", 132,  "red", 15);
		Wrestler K = new Wrestler("k", 243, "blue", 5);
		
		Wrestler[] allies = {S, G, B};
		Wrestler[] opps = {F, K};
		
		System.out.println(S.fight(G));

	}
	
}