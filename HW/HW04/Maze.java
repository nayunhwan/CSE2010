/*
 * CSE2010 Homework #4: Maze.java
 * 
 * Fill your code here!
 * 
 */

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Maze {
	private int numRows;
	private int numCols;
	private int[][] myMaze = null;
	private boolean[][] marked = null;
	private int startI = 0;
	private int startJ = 0;
	private int finalI;
	private int finalJ;
	
	/* Create Stack of Location with a capacity of 100 */
	private ArrayStack<Location> _stack = new ArrayStack<>(100);
	
	/*
	 * DO NOT MODIFY THIS CONSTRUCTOR CODE!
	 */	
	public Maze(String filename) {
		try {
			Scanner sc = new Scanner(new File(filename));
			
			numRows = sc.nextInt();
			numCols = sc.nextInt();
			
			finalI = numRows - 1;
			finalJ = numCols - 1;
			
			// Create Maze
			myMaze = new int[numRows][numCols];
			marked = new boolean[numRows][numCols];
			
			for (int i = 0; i < numRows; i++)
				for (int j = 0; j < numCols; j++) {
					myMaze[i][j] = sc.nextInt();
					marked[i][j] = false;
			}
			
			sc.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
	}

	/*
	 * DO NOT MODIFY THIS METHOD!
	 */		
	public boolean findPath() {
		
		return moveTo(0,0);
	}
	
	/*
   * Complete the following recursive method.
   */	
	private boolean moveTo(int row, int col) {
		_stack.push(new Location(row, col));
		marked[row][col] = true;

		// 마지막 탈출구에 도착했을 경우 true 리턴
		if(row == finalI && col == finalJ) return true;
		
		// 상 방향 탐색
		if(row-1 >= 0 && row-1 <= finalI && myMaze[row-1][col] == 0 && !marked[row-1][col] && !marked[finalI][finalJ]) moveTo(row-1, col);
		// 우 방향 탐색
		if(col+1 >= 0 && col+1 <= finalJ && myMaze[row][col+1] == 0 && !marked[row][col+1] && !marked[finalI][finalJ]) moveTo(row, col+1);
		// 하 방향 탐색
		if(row+1 >= 0 && row+1 <= finalI && myMaze[row+1][col] == 0 && !marked[row+1][col] && !marked[finalI][finalJ]) moveTo(row+1, col);
		// 좌 방향 탐색
		if(col-1 >= 0 && col-1 <= finalJ && myMaze[row][col-1] == 0 && !marked[row][col-1] && !marked[finalI][finalJ]) moveTo(row, col-1);

		if(!marked[finalI][finalJ]) _stack.pop();
		/* Your code */
		return marked[finalI][finalJ];
	}
	
	/*
	 * DO NOT MODIFY THIS METHOD!
	 */
	public void printMaze() {
		
		System.out.println("Maze[" + numRows + "][" + numCols + "]");
		System.out.println("Entry index = (" + startI + ", " + startJ + ")" );
		System.out.println("Exit index = (" + finalI + ", " + finalJ + ")"  + "\n");
		
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++)
				System.out.print(myMaze[i][j] + " ");
			System.out.print("\n");
		}
		System.out.println();
	}
	
	/*
	 * DO NOT MODIFY THIS METHOD!
	 */
	public void showPath() {
		
		while (!_stack.isEmpty()) {
			System.out.print(_stack.pop() + " <-- ");
		}
		
		System.out.println("Start");
	}
	
}