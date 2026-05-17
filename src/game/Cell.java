package game;

public class Cell {
	
	private boolean isMine;
	private CellState currentState;
	private int adjacentMines;
	
	public Cell() {
		this.isMine = false;
		this.currentState = CellState.HIDDEN;
		this.adjacentMines = 0;
	}
	
	
	public boolean getIsMine() {
		return isMine;
	}
	public void setIsMine(boolean isMine) {
		this.isMine = isMine;
	}
	
	public CellState getCurrentState() {
		return currentState;
	}
	public void setCurrentState(CellState currentState) {
		this.currentState = currentState;
	}
	
	public int getAdjacentMines() {
		return adjacentMines;
	}
	public void setAdjacentMines(int adjacentMines) {
		this.adjacentMines = adjacentMines;
	}
	
	
	
}
