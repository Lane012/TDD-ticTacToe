package tests;
import ticTacToe.*;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class gameTests {
	Game game;
	Player playerOne;
	Player playerTwo;
	
	@BeforeEach
	void setUp() throws Exception {
		game = new Game();
		playerOne = new Player('X');
		playerTwo = new Player('O');
	}

	
	@Test
	void testAssignPlayerSymbol() {
		Player p = new Player('O');
		assertEquals(p.getLetter(), new Character('O'));
	}
	
	@Test
	void testGameCheckIfSpotIsFull() {
		game.insertLetter('O', 0);
		
		assertTrue(game.spotTaken(0));
	}
	
	@Test
	void testInsertPlayersInput() {
		int index = 1;
		game.insertLetter(playerOne.getLetter(), index);
		
		assertTrue(game.spotTaken(1));
	}

}
