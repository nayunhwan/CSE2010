import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

//Sparse Matrix ADT
public class SparseMatrix {

	// nested class for each non-zero entry in Sparse Matrix
    class Entry {
        public int row, col, value;

        @Override
        public String toString() {
            return "Entry{" +
                "row=" + row +
                ", col=" + col +
                ", value=" + value +
                '}';
        }

        public Entry(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    private int rowCount;
    private int colCount;
    private int entryCount;
    private Entry[] data;
    private int nextSlot;

    private SparseMatrix(int rowCount, int colCount, int entryCount) {
        this.rowCount = rowCount;
        this.colCount = colCount;
        this.entryCount = entryCount;

        data = new Entry [entryCount];
        nextSlot = 0;
    }

    /*
	 * Construct a sparse matrix by reading data from a specified file
	 */
    public static SparseMatrix create(String filename) throws IOException {
        Path path = Paths.get(filename);
        if (!Files.exists(path))
            throw new IllegalArgumentException("No such file");

        SparseMatrix matrix = null;
        int row, col, count, value;
        try (Scanner scanner = new Scanner(path)) {
            row = scanner.nextInt();
            col = scanner.nextInt();
            count = scanner.nextInt();
            matrix = new SparseMatrix(row, col, count);

            for (int i = 0; i < count; i++) {
                row = scanner.nextInt();
                col = scanner.nextInt();
                value = scanner.nextInt();
                matrix.put(row, col, value);
            }
        };

        return matrix;
    }

    /*
	 * You can define additional private fields and/or methods here, if necessary.
	 */
    
    private void put(int row, int col, int value) {
    	data[nextSlot++] = new Entry(row, col, value);
	}

    /*
	 * Add this matrix with another matrix other.
	 * Assume that the dimensions of two matrices are always compatible.
	 */
	public SparseMatrix add(SparseMatrix other) {

		int newRowCount = this.rowCount;
		int newColCount = this.colCount;
		int newEntryCount = this.entryCount + other.entryCount;
		int newMatrix[][] = new int[newRowCount][newColCount];

		for(int i = 0; i < this.entryCount; i++){
			Entry currentEntry = data[i];
			newMatrix[currentEntry.row][currentEntry.col] += currentEntry.value;
		}

		for(int i = 0; i < other.entryCount; i++){
			Entry currentEntry = other.data[i];
			// 중복된 행열값을 갖는 Entry가 있을 경우 newEntryCount를 1만큼 감소
			if(newMatrix[currentEntry.row][currentEntry.col] != 0) newEntryCount--;
			newMatrix[currentEntry.row][currentEntry.col] += currentEntry.value;
			// 연산 후, Entry의 Value가 0 이 되었을 경우에는, 무의미한 값이므로 newEntryCount를 다시 한번 감소
			if(newMatrix[currentEntry.row][currentEntry.col] == 0) newEntryCount--;
		}

		SparseMatrix matrix = new SparseMatrix(newRowCount, newColCount, newEntryCount);

		for(int i = 0; i < this.rowCount; i++)
			for(int j = 0; j < this.colCount; j++)
				if(newMatrix[i][j] != 0) matrix.put(i, j, newMatrix[i][j]);	
	
		return matrix;
    }

	/*
	 * Transpose matrix
	 */
    public SparseMatrix transpose() {
    	//Transpose Matrix이기 때문에 row와 col의 크기 선언을 반대로 해준다.
    	int newRowCount = this.colCount;
    	int newColCount = this.rowCount;
    	int newMatrix[][] = new int[newRowCount][newColCount];

    	for(int i = 0; i < this.entryCount; i++){
    		Entry currentEntry = this.data[i];
    		newMatrix[currentEntry.col][currentEntry.row] = currentEntry.value;
    	}

    	//Transpose를 하더라도 entryCount에는 변함이 없으므로 this.entryCount로 선언한다.
    	SparseMatrix matrix = new SparseMatrix(newRowCount, newColCount, this.entryCount);

    	for(int i = 0; i < newRowCount; i++)
    		for(int j = 0; j < newColCount; j++)
    			if(newMatrix[i][j] != 0) matrix.put(i, j, newMatrix[i][j]);

    	return matrix;
    }

    public void print() {
    	System.out.println(this);
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(rowCount + ", " + colCount + ", " + entryCount + "\n");
        for (int i = 0; i < entryCount; i++) {
            builder.append(data[i].row + ", " + data[i].col + ", " + data[i].value + "\n");
        }
        return builder.toString();
    }

		/*
		 * DO NOT MODIFY CODE BELOW!!!!!
		 */
    public static void main(String... args) throws IOException {
        if (args[0].equals("p")) { // Print current matrix
            System.out.println("Printing a matrix: " + args[1]);
            SparseMatrix m = SparseMatrix.create(args[1]);
            m.print();
        } else if (args[0].equals("a")) { // Add two matrices
            System.out.println("Adding two matrices: " + args[1] + " and " + args[2] + "\n");
            SparseMatrix A = SparseMatrix.create(args[1]);
            System.out.println("Matrix A = \n" + A);
            SparseMatrix B = SparseMatrix.create(args[2]);
            System.out.println("Matrix B = \n" + B);

            System.out.println("Matrix A + B = \n" + A.add(B));
        } else if (args[0].equals("t")) {   // Transpose a matrix
            System.out.println("Transposing a matrix: " + args[1]);
            SparseMatrix matrix = SparseMatrix.create(args[1]);
            System.out.println(matrix);
            SparseMatrix transposedMatrix = matrix.transpose();
            System.out.println("Transposed Matrix = \n" + transposedMatrix);
        } else {
            System.err.println("Unknown operation ...");
        }
    }
}
