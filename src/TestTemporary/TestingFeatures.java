package TestTemporary;

import java.util.Scanner;

import game.Board;
import game.CellState;

public class TestingFeatures {

	public static Scanner in = new Scanner(System.in);
	
	public static void showAdjacentMines(int size, int numMines, Board test) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				System.out.print(test.getTiles()[i][j].getAdjacentMines() + " ");
			}
			System.out.println();
		}
	}
	
	public static void showCurrentStateOfCells(int size, int numMines, Board test) {
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if (test.getTiles()[i][j].getCurrentState() == CellState.HIDDEN) System.out.print("H ");
				else System.out.print("R ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int size = in.nextInt();
		int numMines = in.nextInt();
		
		Board test1 = new Board(size, numMines);
		
		showAdjacentMines(size, numMines, test1);
		
		
		for(int i = 0; i < 2; i++) {
			
			int x = in.nextInt();
			int y = in.nextInt();
			
			test1.revealCell(x, y);
			showCurrentStateOfCells(size, numMines, test1);
			System.out.println(test1.getGameState());
		}
		
		
		
		

}
}
