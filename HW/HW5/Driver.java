/*
 * CSE2010 Homework #5: Driver.java
 * 
 * DO NOT MODIFY THIS FILE!
 * 
 */

public class Driver {
	/*
	 * argw[0] : sorting method {h, i, s}
	 * args[1] : number of array 
	 * args[2] : max value in array 
	 */
	public static void main(String[] args) {
		
		int[] data = ArrayGenerator.generate(Integer.valueOf(args[1]).intValue(), Integer.valueOf(args[2]).intValue());
		
		
		for (int i =0 ; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
		
		
		long start = System.nanoTime();
		if (args[0].equals("h"))		// Heap sort 
			Sorter.heapSort(data);
		else if (args[0].equals("s"))	// Selection sort
			Sorter.selectionSort(data);
		else if (args[0].equals("i"))	// Insertion sort
			Sorter.insertionSort(data);
		else
			System.out.println("Unknown sorting method.....");
		long end = System.nanoTime();
		
		// Calculate running time
		System.out.println(end - start);
		
		
		for (int i =0 ; i < data.length; i++) {
			System.out.print(data[i] + " ");
		}
		System.out.println();
		
	}
}