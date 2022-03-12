package chessLevel1;

import java.awt.Image;
import java.util.ArrayList;

public class Knight extends Piece {

	public Knight(int turn, Image img) {
		super(turn, img);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		
		// list for all possible moves
		ArrayList<int[]> moves = new ArrayList<int[]>();
		
		// stores all the potentially possible moves for knights in any place on board
		int[][] possibleMoves = {{r+1, c-2}, {r+1, c+2}, {r+2, c-1}, {r+2, c+1}, {r-1, c-2}, {r-1, c+2}, {r-2, c-1}, {r-2, c+1}};
		
		// loops through each possible location
		for (int[] m : possibleMoves) {
			// checks if location is within boundaries and if location is not own team piece
			if (m[0] < 8 && m[0] >= 0 && m[1] < 8 && m[1] >= 0 && board.getBoard()[m[0]][m[1]].getTeam() != board.getBoard()[r][c].getTeam()) {
				// adds move to list moves
				moves.add(m);
			}
		}
		// returns list of possible moves
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
			// returns true (check) if possible move is king's location
			if (m[0] == kingr && m[1] == kingc) {
				return true;
			}
		}
		return false;
	}
}
