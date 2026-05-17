package player;

public class Move {
	private int row;
	private int column;
	private boolean wasSafe;
	
	public Move(int row, int column, boolean wasSafe) {
		this.row = row;
		this.column = column;
		this.wasSafe = wasSafe;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public boolean isWasSafe() {
		return wasSafe;
	}
}
