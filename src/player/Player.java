package player;

import java.util.Random;

import game.*;

public class Player {
	Board board;
	MyLinkedList history;
	int numMoves = 0;
	int clicks = 0;
	
	public Player(int size, int numMines) {
		this.board = new Board(size, numMines);
		this.history = new MyLinkedList();
	}
	
	public MyLinkedList getMoveHistory() {
		return history;
	}
	
	public GameOutcome playTurn() {
		Random random = new Random();
		int x = random.nextInt(board.getSize());
		int y = random.nextInt(board.getSize());
		
		while(board.getTiles()[y][x].getCurrentState() != CellState.HIDDEN) {
			x = random.nextInt(board.getSize());
			y = random.nextInt(board.getSize());
		}
		
		board.revealCell(x, y);
		
		history.add(new NodeMove(new Move(x, y, !board.getTiles()[y][x].getIsMine())));
		
		return board.getGameState();
	}
}

