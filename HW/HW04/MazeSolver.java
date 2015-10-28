/*
 * CSE2010 Homework #4: MazeSolver.java
 * 
 * DO NOT MODIFY THIS FILE!
 * 
 */

public class MazeSolver {

	public static void main(String[] args) {

	  if (args.length != 1) {
	  	System.err.println("Usage ==> $ java MazeSolver filename");
	  	System.exit(1);
	 	}
	 	
		Maze maze = new Maze(args[0]);
		
		maze.printMaze();
		
		boolean isSuccess = maze.findPath();
		
		if (isSuccess) maze.showPath();
		else
			System.out.println("No path found");
		
	}
}

