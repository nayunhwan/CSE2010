import java.io.*;
import java.util.*;

// Sparse Matrix ADT 
public class SparseMatrix  {
	// nested class for each non-zero entry in Sparse Matrix

	ArrayList<Entry> entrys = new ArrayList<Entry>();

	int max_x, max_y;

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
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			int x = 0;
			while(true){
				String line = br.readLine();
				// System.out.println(line);

				if(line == null){
					max_x = x;
					break;
				}
				String[] lines = line.split(" ");
				max_y = lines.length;
				for(int y = 0; y < lines.length; y++){
					// System.out.println(lines[y]);
					if(!lines[y].equals("0")){
						entrys.add(new Entry(x, y, Math.round(Float.parseFloat(lines[y])*100d)/100d));
					}
					
				}
				x++;
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}

	/*
	 * Transpose this matrix
	 */
	public void transpose() {

		int temp  = max_x;
		max_x = max_y;
		max_y = temp;

		for(Entry i : entrys){
			temp = i.row;
			i.row = i.col;
			i.col = temp;
		}
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
		// for(Entry i : entrys){
		// 	i.printMe();	
		// }
		
		for(int i = 0; i < max_x; i++){
			for(int j = 0; j < max_y; j++){
				boolean flag = false;
				for(Entry e : entrys){
					if(e.row == i && e.col == j){
						flag = true;
						System.out.print(e.value+" ");
						break;
					}
				}

				if(!flag){
					System.out.print(0f+" ");
				}
			}
			System.out.println();
		}
	}
}
