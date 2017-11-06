package ticTacToe;

import java.util.Arrays;
import java.lang.IllegalArgumentException;
import java.util.List;

public class Board {
	private Character[] board;
	public final String ROW = "ROW";
	public final String COLUMN = "COLUMN";
	public final String DIAGONAL = "DIAGONAL"; 
	
	public Board() {
		board = new Character[] {'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'};	
	}
	public Character[] getBoard() {
		return board;
	}
	
	public int size() {
		return board.length;
	}
	
	public void insert(Character input, int index) {
		board[index] =  input;
	}
	
	public int countChar(int index, String section, char c) {
		Character[] l = getSection(section, 1);
		char letter = (c == 'X') ? 'X': 'O';
		int counter = 0;
		
		for(Character ch: l) {
			if(ch.charValue() == letter) {
				counter++;
			}
		}
		return counter;
	}
	
	public Character[] getSection(String section, int index) {
		if(section == "ROW") {
			return getRow(index);
		}
		else if(section == "COLUMN") {
			return getColumn(index);
		}
		else {
			throw new IllegalArgumentException("Section " + section + " does not exist");
		}	
	}
	
	public Character[] getRow(int row) {
		switch (row) {
			case 1:
				return new Character[] {board[0], board[1], board[2]};
			case 2:
				return new Character[] {board[3], board[4], board[5]};
			case 3:
				return new Character[] {board[6], board[7], board[8]};
			
			default:
				throw new IndexOutOfBoundsException("Index " + row + " not valid, 1-3 are acceptable row indexes");
		}
	}
	
	public Character[] getColumn(int column) {
		switch (column) {
			case 1:
				return new Character[] {board[0], board[3], board[6]};
			case 2:
				return new Character[] {board[1], board[4], board[7]};
			case 3:
				return new Character[] {board[2], board[5], board[8]};
			
			default:
				throw new IndexOutOfBoundsException("Index " + column + " not valid, 1-3 are acceptable column indexes");
		}
	}
	
	public Character[] getDiagonal(int diagonal) {
		switch (diagonal) {
			case 1:
				return new Character[] {board[0], board[4], board[8]};
			case 2:
				return new Character[] {board[2], board[4], board[6]};
			default:
				throw new IndexOutOfBoundsException("Index " + diagonal + " not valid, 1-2 are acceptable diagonal indexes");
		}
	}
	
	public boolean spotTaken(int index) {
		return board[index] != 'E';
	}
	public boolean isEmpty() {
		for(Character ch : board) {
			if(ch.charValue() != 'E') {
				return false;
			}
		}
		return true;
	
	}
	
	public boolean isFull(String section, int index) {
		List<Character> list = null;
		
		switch (section) {
			case "ROW": 
				list  = Arrays.asList(getRow(index));
				break;
			case "COLUMN":
				list = Arrays.asList(getColumn(index));
				break;
			case "DIAGONAL":
				list = Arrays.asList(getDiagonal(index));
				break;
			default:
				throw new IllegalArgumentException("Section " + section + " does not exist");
		}
		
		if(list != null) {
			return !list.contains('E');
		}
		
		return false;
	}
		
	
	public boolean boardFull() {
		if(Arrays.asList(board).contains('E')) {
			return false;
		}
		return true;
	
	}
}
