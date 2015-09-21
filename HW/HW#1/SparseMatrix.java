import java.io.*;
import java.util.*;

// Sparse Matrix ADT 
public class SparseMatrix  {
	// nested class for each non-zero entry in Sparse Matrix

	// ArrayList<Entry> entrys = new ArrayList<Entry>();
	ArrayList<Entry> entrys = new ArrayList<Entry>();
	int max_x, max_y, count;

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
	
	public void entry_swap(int index_i, int index_j){
		Entry tmp = entrys.get(index_i);
		entrys.set(index_i, entrys.get(index_j));
		entrys.set(index_j, tmp);
	}

	public void entry_sort(){
		// row 정렬
		for(int i = 0; i < entrys.size() - 1; i++){
			for(int j = 0; j < entrys.size() - 1 - i; j++){
				if(entrys.get(j).row > entrys.get(j+1).row){
					// Entry tmp = entrys.get(j);
					// entrys.set(j, entrys.get(j+1));
					// entrys.set(j+1, tmp);
					entry_swap(j,j+1);
				}
			}
		}


		int front = 0;
		int back = 0;

		// col 정렬

		for(int i = 0; i < entrys.size() - 1; i++){
			if(entrys.get(i).row != entrys.get(i+1).row){
				back = i+1;
				entry_sort_part(front, back);
				front = back;
			}
		}
	}

	public void entry_sort_part(int front, int back){
		for(int i = front; i < back - 1; i++){
			for(int j = front; j < back - i - 1; j++){
				if(entrys.get(j).col > entrys.get(j+1).col){
					// Entry tmp = entrys.get(j);
					// entrys.set(j, entrys.get(j+1));
					// entrys.set(j+1, tmp);
					entry_swap(j,j+1);
				}
			}
		}
	}
	
	
	/*
	 * Construct a sparse matrix by reading data from a specified file
	 */
	public SparseMatrix(String filename) {
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			// int x = 0;

			String first_line = br.readLine();
			String first_element[] = first_line.split(" ");

			max_x = Integer.parseInt(first_element[0]);
			max_y = Integer.parseInt(first_element[1]);
			count = Integer.parseInt(first_element[2]);

			// entrys = new Entry[count];

			for(int i = 0; i < count; i++){
				String line = br.readLine();
				String lines[] = line.split(" ");
				int row = Integer.parseInt(lines[0]);
				int col = Integer.parseInt(lines[1]);
				double value = Math.round(Float.parseFloat(lines[2])*100d)/100d;
				entrys.add(new Entry(row, col, value));

			}
			// while(true){
			// 	String line = br.readLine();
			// 	// System.out.println(line);

			// 	if(line == null){
			// 		// max_x = x;
			// 		break;
			// 	}
			// 	String[] lines = line.split(" ");

			// 	entrys.add(new Entry(Integer.parseInt(lines[0]), Integer.parseInt(lines[1]), Math.round(Float.parseFloat(lines[2])*100d)/100d));
			// 	// max_y = lines.length;
			// 	// for(int y = 0; y < lines.length; y++){
			// 	// 	// System.out.println(lines[y]);
			// 	// 	if(!lines[y].equals("0")){
			// 	// 		entrys.add(new Entry(x, y, Math.round(Float.parseFloat(lines[y])*100d)/100d));
			// 	// 	}
					
			// 	// }
			// 	// x++;
			// }
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

		// // row 정렬
		// for(int i = 0; i < count - 1; i++){
		// 	for(int j = 0; j < count - 1 - i; j++){
		// 		if(entrys.get(j).row > entrys.get(j+1).row){
		// 			Entry tmp = entrys.get(j);
		// 			entrys.set(j, entrys.get(j+1));
		// 			entrys.set(j+1, tmp);
		// 		}
		// 	}
		// }


		// int front = 0;
		// int back = 0;

		// // col 정렬

		// for(int i = 0; i < count - 1; i++){
		// 	if(entrys.get(i).row != entrys.get(i+1).row){
		// 		back = i+1;
		// 		entry_sort_part(front, back);
		// 		front = back;
		// 	}
		// }
		entry_sort();
		print_arr();
	}
	
	

	public void print_arr(){
		for(Entry e : entrys){
			System.out.println(e.row+" "+e.col+" "+e.value);
		}
	}
	/*
	 * Add this matrix with another matrix m.
	 * Assume that the dimensions of two matrices are always compatible.
	 */
	public void addTo(SparseMatrix m) {
		// int min_count = (m.count > count)? count : m.count;
		// int max_count = (m.count > count)? m.count : count;

		// for(int i = 0; i < count; i++){
		// 	for(int j = 0; j < m.count; j++){
		// 		if(entrys.get(i).row == m.entrys.get(j).row && entrys.get(i).col == m.entrys.get(j).col){
		// 			entrys.get(i).value += m.entrys.get(j).value;
		// 		}
		// 	}
		// }

		for(int i = 0; i < m.count; i++){
			boolean flag = false;
			for(int j = 0; j < count; j++){
				if(entrys.get(j).row == m.entrys.get(i).row && entrys.get(j).col == m.entrys.get(i).col){
					entrys.get(j).value += m.entrys.get(i).value;
					flag = true;
					break;
				}
			}

			if(!flag){
				entrys.add(m.entrys.get(i));
			}
		}

		entry_sort();
		print_arr();
	}
	
	/*
	 * Print contents of this matrix
	 */
	public void printMe() {
		// for(Entry i : entrys){
		// 	i.printMe();	
		// }
		
		// for(int i = 0; i < max_x; i++){
		// 	for(int j = 0; j < max_y; j++){
		// 		boolean flag = false;
		// 		for(Entry e : entrys){
		// 			if(e.row == i && e.col == j){
		// 				flag = true;
		// 				System.out.print(e.value+" ");
		// 				break;
		// 			}
		// 		}

		// 		if(!flag){
		// 			System.out.print(0f+" ");
		// 		}
		// 	}
		// 	System.out.println();
		// }
		int index = 0;
		for(int i = 0; i < max_x; i++){
			for(int j = 0; j < max_y; j++){
				if(entrys.get(index).row == i && entrys.get(index).col == j){
					System.out.print(entrys.get(index).value+" ");
					if(index < count-1) index++;
				}
				else{
					System.out.print(0f+" ");
				}
			}
			System.out.println();
		}
	}
}
