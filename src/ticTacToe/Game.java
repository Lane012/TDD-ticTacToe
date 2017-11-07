package ticTacToe;

public class Game {
	private Board board;
	private Player PlayerOne;
	private Player PlayerTwo;
	
	public Game() {
		board = new Board();	
	}
	
	public void insertLetter(Character letter, int index) {
		board.insert(letter, index);
	}
	
	public boolean spotTaken(int index) {
		return board.spotTaken(index);
	}
}
