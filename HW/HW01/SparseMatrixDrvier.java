public class SparseMatrixDriver {

	public static void main(String[] args) {
		
		if (args[0].equals("print")) {	// Print the current matrix
			System.out.println("Printing a matrix: " + args[1]);
			new SparseMatrix(args[1]).printMe(); 
			System.out.println("\n\n--------------------------");
		} else if (args[0].equals("add")) {	// Add two matrices. A <-- A + B
			System.out.println("Adding two matrices: " + args[1] + " and " + args[2] + "\n");
			SparseMatrix A = new SparseMatrix(args[1]);	// create first matrix
			SparseMatrix B = new SparseMatrix(args[2]); // create second matrix
			A.addTo(B);
			A.printMe(); // print matrix A
			System.out.println("\n\n--------------------------");
		} else if (args[0].equals("transpose")) {
			System.out.println("Transposing a matrix: " + args[1]);
			SparseMatrix matrix = new SparseMatrix(args[1]);
			matrix.transpose();
			matrix.printMe();
			System.out.println("\n\n--------------------------");
		} else {
			System.err.println("Unknown operation");
		}
	}
}