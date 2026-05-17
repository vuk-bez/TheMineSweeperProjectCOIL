package game;

import java.util.Random;

import game.CoordinateQueue.Coordinates;

public class Board {
	
	private int size;
	private int numMines;
	
	private Cell[][] tiles;
	
	public int getSize() {
		return size;
	}
	
	public int getNumMines() {
		return numMines;
	}
	
	public Cell[][] getTiles() {
		return tiles;
	}
	
	public Board(int size, int numMines) {
		
		//restrictions checker
		if (size <= 0 || numMines < 0 || numMines > size*size) {
			throw new IllegalArgumentException("Requirements not met!");
		}
		
		this.size = size;
		this.numMines = numMines;
		tiles = new Cell[size][size];
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tiles[i][j] = new Cell();
			}
		}
		
		placingMines();
		calculateAdjacentMines();
		
	}
	
	// placing mines on random tiles
	private void placingMines () {
		
		Random random = new Random();
		int i = 1;
		
		while(i <= numMines) {
		
			int x = random.nextInt(size);
			int y = random.nextInt(size);
			
			if(!tiles[y][x].getIsMine()) {
				tiles[y][x].setIsMine(true);
				i++;
			}
		}
	}
	
	// computing the number of adjacentMines
	private void calculateAdjacentMines() {
		int[] dx = {1, 1, 1, 0 , 0, -1, -1, -1};
		int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
		
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				
				int mineAmount = 0;
				for(int k = 0; k < 8; k++) {
					int newI = i + dy[k];
					int newJ = j + dx[k];
					
					if (newI >= 0 && newJ >= 0 && newI < size && newJ < size && tiles[newI][newJ].getIsMine()) {
						mineAmount++;
					}
				}
				tiles[i][j].setAdjacentMines(mineAmount);
			}
			
		}
	}
	
	public void revealCell(int x, int y) {
		
		//revealCell will always be called on a hidden cell
		tiles[y][x].setCurrentState(CellState.REVEALED);
		if(tiles[y][x].getAdjacentMines() != 0 || tiles[y][x].getIsMine()) return;
		
		CoordinateQueue que = new CoordinateQueue();
		que.add(x, y);
		
		int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
		int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
		
		
		while(!que.isEmpty()) {
			
			int currX = que.peek().getX();
			int currY = que.peek().getY();
			for(int k = 0; k < 8; k++) {
				int newX = currX + dx[k];
				int newY = currY + dy[k];
				
				if(newX < 0 || newY < 0 || newX >= this.size || newY >= this.size) continue;
				if(tiles[newY][newX].getCurrentState() == CellState.REVEALED) continue;
				if(tiles[newY][newX].getIsMine()) continue;
				if(tiles[newY][newX].getAdjacentMines() == 0) {
					tiles[newY][newX].setCurrentState(CellState.REVEALED);
					que.add(newX, newY);
				}
				else tiles[newY][newX].setCurrentState(CellState.REVEALED);
		    }
			que.remove();
					
		}
		
	
	}
	
	
	//we should keep amount of revealed cells so that getGameState is O(1)
	public GameOutcome getGameState() {
		
		boolean indicator = true;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if(tiles[i][j].getIsMine() && tiles[i][j].getCurrentState() == CellState.REVEALED) {
					return GameOutcome.DEFEAT;
				}
				if(!tiles[i][j].getIsMine() && tiles[i][j].getCurrentState() == CellState.HIDDEN) {
					indicator = false;
				}
			}
		}
		
		if (indicator) {
			return GameOutcome.VICTORY;
		} else {
			return GameOutcome.IN_PROGRESS;
		}
	}
}
