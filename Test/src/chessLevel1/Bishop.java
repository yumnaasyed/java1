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

		ArrayList<int[]> moves = new ArrayList<int[]>();
		
		// moves down and to the right
		for (int i = 1; i < 8; i++) {
			// breaks if either coordinats are out of bounds
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
			// checks if its on enemy team
			if (board.getBoard()[r+i][c+i].getTeam() == (getTeam()+1)%2) {
				int[] move = {r+i, c+i};
				moves.add(move);
			}
			// checks if its on same team
			if (board.getBoard()[r+i][c+i].getTeam() != -1) {
				break;
			}
		}
		
		// moves up and to the left
		for (int i = 1; i < 8; i++) {
			if (c-i < 0 || r-i < 0) {
				break;
			}
			if (board.getBoard()[r-i][c-i].isEmpty() == true) {
				int[] move = {r-i, c-i};
				moves.add(move);
			}
			if (board.getBoard()[r-i][c-i].getTeam() == (getTeam()+1)%2) {
				int[] move = {r-i, c-i};
				moves.add(move);
			}
			if (board.getBoard()[r-i][c-i].getTeam() != -1) {
				break;
			}
		}
		
		// moves up and to the right
		for (int i = 1; i < 8; i++) {
			if (r+i >= 8 || c-i < 0) {
				break;
			}
			if (board.getBoard()[r+i][c-i].isEmpty() == true) {
				int[] move = {r+i, c-i};
				moves.add(move);
			}
			if (board.getBoard()[r+i][c-i].getTeam() == (getTeam()+1)%2) {
				int[] move = {r+i, c-i};
				moves.add(move);
			}
			if (board.getBoard()[r+i][c-i].getTeam() != -1) {
				break;
			}
		}
		
		// moves down and to the left
		for (int i = 1; i < 8; i++) {
			if (r-i < 0 || c+i >=8) {
				break;
			}
			if (board.getBoard()[r-i][c+i].isEmpty() == true) {
				int[] move = {r-i, c+i};
				moves.add(move);
			}
			if (board.getBoard()[r-i][c+i].getTeam() == (getTeam()+1)%2) {
				int[] move = {r-i, c+i};
				moves.add(move);
			}
			if (board.getBoard()[r-i][c+i].getTeam() != -1) {
				break;
			}
		}
		return moves;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean check(int kingr, int kingc, int r, int c, Board board) {
		
		ArrayList<int[]> moves = getMoves(board, r, c);
		
		for (int[] m : moves) {
			if (m[0] == kingr && m[1] == kingc) {
				return true;
			}
		}
		return false;
	}

}
