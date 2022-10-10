// Yumna Syed
// Wordle Game
// October 2022

package introJava;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Wordle {
	
	// initiates variable for mystery word
	private static String w = "";
	
	// list of all viable words
	private static List<String> words;

	// 2d array variable for the gameboard
	private static String[][] grid = new String[6][2];
	
	// list of possible letters in every word
	private static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	// variable for input from user
	static Scanner input = new Scanner(System.in);
	
	// method to create word list and set random word
	public List<String> getWords() throws IOException {
		
		// reads the file of list of words
		BufferedReader in = new BufferedReader(new FileReader("fiveLetterWords.txt"));
		//initiates list of words
		ArrayList<String> words = new ArrayList<String>();
		// turns each line in file into separate string
		String line = in.readLine(); 
		// adds each string to list
		while (line != null) { 
			words.add(line); 
			line = in.readLine(); 
		}
		// closes function
		in.close();
		
		// sets random word as the secret word
		w = words.get(new Random().nextInt(words.size()));
		
		// returns list of all possible words
		return words;
	}
	
	// method to check if guess is valid
	public boolean valid(String guess) {
		
		// checks if guess is five letters and is in list of all words
		return(guess.length() == 5 && words.contains(guess));
	}
	
	// method to return feedback on guess to user
	public String evaluate(String guess) {
		
		// variable for hint for user
		String hint = "";
		
		// loops through length of word
		for (int i = 0; i < guess.length(); i++) {
			// turns each letter in guess into its own character
			char c = guess.charAt(i);
			
			// if secret words letter is in same place as guesses' letter
			if (w.charAt(i) == c) {
				// alert user in hint
				hint += "*";
			}
			// if letter is not in same place
			else {
				// variable to see if letter is present at all in word
				boolean isThere = false;
				// loops through length of word
				for (int j = 0; j < guess.length(); j++) {
					// if any of the letters in word are in guess
					if (w.charAt(j) == c) {
						// make variable true -- letter is there
						isThere = true;
						// stop loop
						break;
					}
				}
				// alert user in hint if letter is present
				if (isThere) {
					hint += "@";
				}
				// if letter is not present at all in secret word
				else {
					// alert user in hint that letter is not there
					hint += "x";
					// loops through the list of alphabet
					for (int t = 0; t < alphabet.length; t++) {
						// finds letter in list
						if (c == alphabet[t]) {
							// cross out letter so user knows not to use it again
							alphabet[t] = '#';
						}
					}
				}
			}
		}
		// returns the hint to user
		return hint;
	}
	
	// checks if game is won
	public boolean gameWon(String h) {
		
		// returns if hint is all correct letters
		return(h.equals("*****"));
	}
	
	// main method
	public static void main(String[] args) throws IOException {
		
		Wordle game = new Wordle();
		
		// sets game to not won
		boolean won = false;
		
		// fills array words with list of words from file
		words = game.getWords();
		
		// prints index of what each character in hint represents
		System.out.println("* = letter in correct position, @ = letter is present, x = letter not found");
		
		// loops through number of guesses possible
		for (int i = 0; i < 6; i++) {
			
			// asks user for input
			System.out.println("enter a word: ");
			
			// takes input (guess)
			String guess = input.nextLine();
			// makes all letters lowercase
			guess = guess.toLowerCase();
			
			// runs valid method to check if input is valid guess
			boolean valid = game.valid(guess);
			
			// if guess is not valid
			while (!valid) {
				// ask user for new word
				System.out.println("Invalid word. enter another word:");
				// takes new input
				guess = input.nextLine();
				// turns new input lowercase
				guess = guess.toLowerCase();
				
				// checks if new input is valid guess
				valid = game.valid(guess);
			}
			
			// runs method to evaluate the letters in guess and return hint to user
			String hint = game.evaluate(guess);
			
			// if guess is correct
			if (game.gameWon(hint)) {
				// alerts user they won game along with stats
				System.out.println("You won! The secret word was " + w + ". You took " + (i+1) + " tries!");
				// sets won to true
				won = true;
				// breaks for loop
				break;
			}
			
			// sets top grid space to guess and bottom to hint for each guess (6 guesses)
			grid[i][0] = guess;
			grid[i][1] = hint;
			
			// for each loop going through grid
			for (String[] temp : grid) {
				
				// if grid index is empty
				if (temp[0] == null) {
					// print out empty spaces for formatting
					System.out.println("[       ]");
					System.out.println("[       ]");
				}
				// if grid index is not empty
				else {	
					// print out the current guess and hint
					System.out.println("[ "+temp[0]+" ]");
					System.out.println("[ "+temp[1]+" ]");
				}
			}
			// print out new alphabet with irrelevant letters crossed out
			System.out.println (Arrays.toString(alphabet));
		}
		// if game is lost
		if (!won) {
			// alert user of secret word
			System.out.print("You lost. The secret word was " + w);
		}
	}
}