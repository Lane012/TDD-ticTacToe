package ticTacToe;

public class Player {
	private final Character LETTER;
	public Player(Character letter) {
		this.LETTER = letter;
	}
	
	public Character getLetter() {
		return LETTER;
	}
}