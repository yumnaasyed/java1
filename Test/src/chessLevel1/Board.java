package chessLevel1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

public class Board {
	
	// keeps track of the position of each king. First row is the position of the white king, 
	// second row is the black king.
	private int[][] kingPositions = new int[2][2];
	

	// represents the entire board - make sure to initialize!.
	private Piece[][] board;
	
	public Board() {
		
		// loads the images into a map
		HashMap<String, Image> images = loadImages();
		
		// initializes all the pieces with images
		
		board = new Piece [8][8];
		
		// kings
		board[4][7] = new King(1, images.get("BlackKing"));
		board[4][0] = new King(0, images.get("WhiteKing"));
		kingPositions[0] = new int[]{4, 0};
		kingPositions[1] = new int[] {4, 7};
	
		// queens
		board[3][7] = new Queen(1, images.get("BlackQueen"));
		board[3][0] = new Queen(0, images.get("WhiteQueen"));

		// knights
		board[1][7] = new Knight(1, images.get("BlackKnight"));
		board[1][0] = new Knight(0, images.get("WhiteKnight"));
		board[6][7] = new Knight(1, images.get("BlackKnight"));
		board[6][0] = new Knight(0, images.get("WhiteKnight"));
		
		// rooks
		board[0][7] = new Rook(1, images.get("BlackRook"));
		board[0][0] = new Rook(0, images.get("WhiteRook"));
		board[7][7] = new Rook(1, images.get("BlackRook"));
		board[7][0] = new Rook(0, images.get("WhiteRook"));
		
		// bishop
		board[2][7] = new Bishop(1, images.get("BlackBishop"));
		board[2][0] = new Bishop(0, images.get("WhiteBishop"));
		board[5][7] = new Bishop(1, images.get("BlackBishop"));
		board[5][0] = new Bishop(0, images.get("WhiteBishop"));
		
		// pawn
		for (int i = 0; i < 8; i++) {
			board[i][6] = new Pawn(1, images.get("BlackPawn"));
		}
		
		for (int i = 0; i < 8; i++) {
			board[i][1] = new Pawn(0, images.get("WhitePawn"));
		}
		
		// empty
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j] == null) {
				board[i][j] = new Empty();
				}
			}
		}
	}
	
	// draws the board. There should be a grid of 8x8 squares, and each piece in their location. 
	// the last clicked piece (curr) should be drawn on a yellow background.
	public void draw(Graphics g, Piece curr) {
		
		int sw = Chess.SQUARE_WIDTH;	// the width of each square on the board
		
		// outlines each space
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (i%2 == j%2) {
					g.setColor(new Color(0, 100, 0));
					g.fillRect(((sw) * j) - board.length/2, (sw) * i, sw, sw);
				}
				else {
					g.setColor(new Color(255, 255, 255));
					g.fillRect(((sw) * j) - board.length/2, (sw) * i, sw, sw);
				}
				if (board[i][j] == curr) {
					g.setColor(Color.YELLOW);
					g.fillRect(((sw) * j) - board.length/2, (sw) * i, sw, sw);
				}
			}
		}
		
		// draws each piece (and empty) into spaces
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j].draw(g, j*sw, i*sw);
			}
		}
	}
	
	
	/******** DON'T TOUCH THE BELOW CODE ****************/
	
	// loads all necessary images into a map. Key = piece name, value = corresponding image
	public HashMap<String, Image> loadImages() {
		String[] pieces = {"King", "Queen", "Rook", "Bishop", "Knight", "Pawn"};
		
		HashMap<String, Image> images = new HashMap<String, Image>();
		
		for (String p : pieces) {
			for (String color : new String[] {"Black", "White"}) {
				Image img = Toolkit.getDefaultToolkit().getImage("Images/" + color + p + ".png");	
				images.put(color + p, img.getScaledInstance(Chess.IMG_WIDTH, Chess.IMG_WIDTH, Image.SCALE_SMOOTH));
			}
		}
		return images;
	}
	
	public Piece[][] getBoard() {
		return board;
	}
	
	
	// moves the piece currently at (r, c) to (newR, newC)
	// returns 0 for a normal move, 1 for a check move, 2 for a checkmate move
	public int move(int r, int c, int newR, int newC) {
		
		if (board[r][c].isKing()) {
			int team = board[r][c].getTeam();
			kingPositions[team] = new int[] {newR, newC};
		}
		
		if (board[newR][newC].isKing()) {
			board[newR][newC] = board[r][c];
			board[r][c] = new Empty();
			return 2;
		}
		
		board[newR][newC] = board[r][c];
		board[r][c] = new Empty();
		
		
		if (check()) return 1;
		return 0;
		
	}
	
	// determines if the non-current team is in check. 
	public boolean check() {
		for (int i = 0; i < 8; i ++)
			for (int j = 0; j < 8; j++) {
				if (board[i][j].getTeam()!= -1) {
					int opp = (board[i][j].getTeam()+1)%2;
					if (board[i][j].check(kingPositions[opp][0], kingPositions[opp][1], i, j, this)) {
						System.out.println("Player " + opp + " is in check");
						return true;
					}
				}
					
			}
		return false;
	}
}
