// Sparse Matrix ADT 
class SparseMatrix  {
	// nested class for each non-zero entry in Sparse Matrix
	class Entry {
		int row;
		int col;
		double value;
		
		Entry(int r, int c, double v) {
			row = r; col = c; value = v;
		}
		
		void printMe() {
			System.out.println(row + " " + col + " " + value);
		}
	}
		
	/*
	 * You can define additional private fields and/or methods here, if necessary.
	 */

	/*
	 * Construct a sparse matrix by reading data from a specified file
	 */
	public SparseMatrix(String filename) {
		
	}

	/*
	 * Transpose this matrix
	 */
	public void transpose() {
		
	}
	
	/*
	 * Add this matrix with another matrix m.
	 * Assume that the dimensions of two matrices are always compatible.
	 */
	public void addTo(SparseMatrix m) {
	
	}
	
	/*
	 * Print contents of this matrix
	 */
	public void printMe() {

	}
}
public class HW01{
	public static void main(String[] args) {
		
	}
}