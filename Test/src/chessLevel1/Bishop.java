package chessLevel1;

import java.awt.Image;
import java.util.ArrayList;

public class Bishop extends Piece {

	public Bishop(int turn, Image img) {
		super(turn, img);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<int[]> getMoves(Board board, int r, int c) {

		// list for all possible moves
		ArrayList<int[]> moves = new ArrayList<int[]>();
		
		// moves down and to the right
		// loops through diagonal line of moves that may be possible
		for (int i = 1; i < 8; i++) {
			// breaks if either coordinates are out of bounds
			if (c+i >= 8 || r+i >= 8) {
				break;
			}
			// checks if the spot to move is empty
			if (board.getBoard()[r+i][c+i].isEmpty() == true) {
				// creates move
				int[] move = {r+i, c+i};
				// adds move to list moves
				moves.add(move);
			}
			// checks if spot is occupied by enemy team
			if (board.getBoard()[r+i][c+i].getTeam() == (getTeam()+1)%2) {
				// creates move
				int[] move = {r+i, c+i};
				// adds move to list moves
				moves.add(move);
			}
			// checks and breaks if the spot is occupied by own team piece, not a valid move
			if (board.getBoard()[r+i][c+i].getTeam() != -1) {
				break;
			}
		}
		
		// moves up and to the left
		// loops through diagonal line of moves that may be possible
		for (int i = 1; i < 8; i++) {
			// breaks if either coordinates are out of bounds
			if (c-i < 0 || r-i < 0) {
				break;
			}
			// checks if the spot to move is empty
			if (board.getBoard()[r-i][c-i].isEmpty() == true) {
				// creates move
				int[] move = {r-i, c-i};
				// adds move to list moves
				moves.add(move);
			}
			// checks if spot is occupied by enemy team
			if (board.getBoard()[r-i][c-i].getTeam() == (getTeam()+1)%2) {
				// creates move
				int[] move = {r-i, c-i};
				// adds move to list moves
				moves.add(move);
			}
			// checks and breaks if the spot is occupied by own team piece, not a valid move
			if (board.getBoard()[r-i][c-i].getTeam() != -1) {
				break;
			}
		}
		
		// moves up and to the right
		// loops through diagonal line of moves that may be possible
		for (int i = 1; i < 8; i++) {
			// breaks if either coordinates are out of bounds
			if (r+i >= 8 || c-i < 0) {
				break;
			}
			// checks if the spot to move is empty
			if (board.getBoard()[r+i][c-i].isEmpty() == true) {
				// creates move
				int[] move = {r+i, c-i};
				// adds move to list moves
				moves.add(move);
			}
			// checks if spot is occupied by enemy team
			if (board.getBoard()[r+i][c-i].getTeam() == (getTeam()+1)%2) {
				// creates move
				int[] move = {r+i, c-i};
				// adds move to list moves
				moves.add(move);
			}
			// checks and breaks if the spot is occupied by own team piece, not a valid move
			if (board.getBoard()[r+i][c-i].getTeam() != -1) {
				break;
			}
		}
		
		// moves down and to the left
		// loops through diagonal line of moves that may be possible
		for (int i = 1; i < 8; i++) {
			// breaks if either coordinates are out of bounds
			if (r-i < 0 || c+i >=8) {
				break;
			}
			// checks if the spot to move is empty
			if (board.getBoard()[r-i][c+i].isEmpty() == true) {
				// creates move
				int[] move = {r-i, c+i};
				// adds move to list moves
				moves.add(move);
			}
			// checks if spot is occupied by enemy team
			if (board.getBoard()[r-i][c+i].getTeam() == (getTeam()+1)%2) {
				// creates move
				int[] move = {r-i, c+i};
				// adds move to list moves
				moves.add(move);
			}
			// checks and breaks if the spot is occupied by own team piece, not a valid move
			if (board.getBoard()[r-i][c+i].getTeam() != -1) {
				break;
			}
		}
		
		// returns the list of moves
		return moves;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean check(int kingr, int kingc, int r, int c, Board board) {
		
		// gets all possible moves
		ArrayList<int[]> moves = getMoves(board, r, c);
		
		// checks if any of possible moves are the location of king
		// loops through each index in moves
		for (int[] m : moves) {
			// if coordinates are the same return true (check)
			if (m[0] == kingr && m[1] == kingc) {
				return true;
			}
		}
		return false;
	}

}
