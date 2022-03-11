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
		
		ArrayList<int[]> moves = new ArrayList<int[]>();
		
		int[][] possibleMoves = {{r+1, c-2}, {r+1, c+2}, {r+2, c-1}, {r+2, c+1}, {r-1, c-2}, {r-1, c+2}, {r-2, c-1}, {r-2, c+1}};
		
		for (int[] m : possibleMoves) {
			if (m[0] < 8 && m[0] >= 0 && m[1] < 8 && m[1] >= 0 && board.getBoard()[m[0]][m[1]].getTeam() != board.getBoard()[r][c].getTeam()) {
				moves.add(m);
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
		
		// gets all possible moves
		ArrayList<int[]> moves = getMoves(board, r, c);
		
		// checks if any of possible moves are the location of king
		for (int[] m : moves) {
			if (m[0] == kingr && m[1] == kingc) {
				// returns true (check) if possible move is king's location
				return true;
			}
		}
		return false;
	}

}
