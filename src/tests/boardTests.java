package tests;
import java.lang.IllegalArgumentException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import ticTacToe.Board;

class boardTests {
	Board mainBoard;
	
	
    
	@BeforeEach
	void setUp() throws Exception {
		mainBoard = new Board();
	}
	
	public void reset() {
		mainBoard = new Board();
	}

	@Test
	void testForEmptyBoard() {
		assertTrue(mainBoard.isEmpty());
	}
	
	@Test
	void testBoardLengthIs9() {
		assertEquals(mainBoard.size(), 9);
	}
	
	@Test
	void testInsertionAtSpecificSpot() {
		mainBoard.insert('X', 1);
		assertTrue(mainBoard.spotTaken(1));
	}
	
	@Test
	void testBoardNotEmpty() {
		mainBoard.insert('X', 3);
		assertEquals(mainBoard.isEmpty(), false);
	}
	
	@Test
	void testSpotIsFull() {
		mainBoard.insert('X', 0);
		assertTrue(mainBoard.spotTaken(0));
	}
	
	@Test
	void testSpotIsEmpty() {
		mainBoard.insert('O', 2);
		assertEquals(mainBoard.spotTaken(0), false);
	}
	
	@Test
	void testCheckIfSpecificSpotIsFull() {
		mainBoard.insert('O', 2);
		assertTrue(mainBoard.spotTaken(2));
	}
	
	@Test
	void testCountRow() {
		mainBoard.insert('X', 0);
		mainBoard.insert('X', 1);
		assertEquals(mainBoard.countChar(1, mainBoard.ROW, 'X'), 2);
	}
	
	@Test
	void testCountColumn() {
		mainBoard.insert('O', 0);
		mainBoard.insert('O', 3);
		assertEquals(mainBoard.countChar(1, mainBoard.COLUMN, 'O'), 2);
	}
	
	@Test
	void testRowFull() {
		mainBoard.insert('O', 3);
		mainBoard.insert('X', 4);
		mainBoard.insert('O', 5);
		
		assertTrue(mainBoard.isFull(mainBoard.ROW, 2));
	}
	
	@Test
	void testColumnFull() {
		mainBoard.insert('O', 0);
		mainBoard.insert('O', 3);
		mainBoard.insert('O', 6);
		
		assertTrue(mainBoard.isFull(mainBoard.COLUMN, 1));
		
	}
	
	@Test
	void testSpecificRowIsFull() {
		mainBoard.insert('O', 6);
		mainBoard.insert('X', 7);
		mainBoard.insert('X', 8);
		
		assertTrue(mainBoard.isFull(mainBoard.ROW, 3));
	}
	
	@Test
	void testSpecificColumnIsFull() {
		mainBoard.insert('X', 1);
		mainBoard.insert('O', 4);
		mainBoard.insert('X', 7);
		
		assertTrue(mainBoard.isFull(mainBoard.COLUMN, 2));
	}
	
	
	@Test
	void testBoardIsFull() {
		mainBoard.insert('X', 1);
		mainBoard.insert('O', 4);
		mainBoard.insert('O', 6);
		mainBoard.insert('X', 7);
		mainBoard.insert('X', 8);
		mainBoard.insert('O', 2);
		mainBoard.insert('X', 3);
		mainBoard.insert('O', 5);
		mainBoard.insert('X', 0);
		
		assertTrue(mainBoard.boardFull());
	}
	
	
	@Test()
	void testGetSectionReturnsException() {
		try {
			mainBoard.getSection("BAD ARGUMENT", 1);
			fail("IllegalArgumentException never thrown");
		}
		catch(IllegalArgumentException e) {
			String message = e.getMessage();
			assertEquals("Section BAD ARGUMENT does not exist", message);
		}
	}
	
	@Test()
	void testGetRowReturnsException() {
		try {
			mainBoard.getRow(0);
			fail("IndexOutOfBoundsException never thrown");
		}
		catch(IndexOutOfBoundsException e) {
			String message = e.getMessage();
			assertEquals("Index " + "0" + " not valid, 1-3 are acceptable row indexes", message);
		}
	}
	
	@Test()
	void testGetColumnReturnsException() {
		try {
			mainBoard.getColumn(0);
			fail("IndexOutOfBoundsException never thrown");
		}
		catch(IndexOutOfBoundsException e) {
			String message = e.getMessage();
			assertEquals("Index " + "0" + " not valid, 1-3 are acceptable column indexes", message);
		}
	}
	
	@Test()
	void testGetDiagonalReturnsException() {
		try {
			mainBoard.getDiagonal(4);
			fail("IndexOutOfBoundsException never thrown");
		}
		catch(IndexOutOfBoundsException e) {
			String message = e.getMessage();
			assertEquals("Index " + "4" + " not valid, 1-2 are acceptable diagonal indexes", message);
		}
	}

	
	
	

}
