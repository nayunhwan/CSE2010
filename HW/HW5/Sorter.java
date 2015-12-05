/*
 * CSE2010 Homework #5: Sorter.java
 * 
 * Complete this file!
 * 
 */

public class Sorter {
	
	public static void selectionSort(int[] entry) {
		// Your code goes here!

		for(int i = 0; i < entry.length-1; i++){
			int minIndex = i;
			for(int j = i + 1; j < entry.length; j++) {
				if(entry[j] < entry[minIndex]) minIndex = j;
			}
			int tmp = entry[i];
			entry[i] = entry[minIndex];
			entry[minIndex] = tmp;
		}
		
	}
	
	public static void insertionSort(int[] entry) {
		// Your code goes here!

		for(int i = 0; i < entry.length-1; i++){
			for(int j = i+1; j > 0; j--){
				if(entry[j] < entry[j-1]){
					int tmp = entry[j];
					entry[j] = entry[j-1];
					entry[j-1] = tmp;
				}
				else break;
			}
		}
		
	}
	
	public static void heapSort(int[] entry) {
		// Your code goes here!

		int heap[] = new int[entry.length+1];
		for(int i = 0; i < entry.length; i++){
			int tmpIndex = i+1;
			heap[tmpIndex] = entry[i];

			while(tmpIndex != 1){
				int parentIndex = tmpIndex/2;
				if(heap[parentIndex] > heap[tmpIndex]){
					int tmp = heap[parentIndex];
					heap[parentIndex] = heap[tmpIndex];
					heap[tmpIndex] = tmp;
					tmpIndex = parentIndex;
				}
				else break;
			}
		}


		// System.out.println("heap sample");
		// for(int i = 0; i < entry.length+1; i++){
		// 	System.out.print(heap[i]+", ");
		// }
		// System.out.println();


		for(int i = 0; i < entry.length; i++){
			entry[i] = heap[1];

			heap[1] = heap[entry.length-i];
			heap[entry.length-i] = 0;

			int tmpIndex = 1;
			// System.out.println();
			while(true){
				// System.out.println("?");
				
				// for(int j = 1; j < entry.length+1; j++){
				// 	System.out.print(heap[j]+", ");
				// }
				// System.out.println();

				int lchildIndex = tmpIndex*2;
				int rchildIndex = tmpIndex*2+1;
				int heapLength = heap.length-i-1;

				// 범위 초과
				if(lchildIndex >= heapLength && rchildIndex >= heapLength) break;

				if(lchildIndex < heapLength && rchildIndex < heapLength){

					if(heap[tmpIndex] < heap[lchildIndex] && heap[tmpIndex] < heap[rchildIndex]) break;

					if(heap[lchildIndex] < heap[rchildIndex]){
						int tmp = heap[lchildIndex];
						heap[lchildIndex] = heap[tmpIndex];
						heap[tmpIndex] = tmp;
						tmpIndex = lchildIndex;
					}
					else{
						int tmp = heap[rchildIndex];
						heap[rchildIndex] = heap[tmpIndex];
						heap[tmpIndex] = tmp;
						tmpIndex = rchildIndex;
					}

				}
				else{
					
					if(heap[tmpIndex] > heap[lchildIndex]){
						int tmp = heap[lchildIndex];
						heap[lchildIndex] = heap[tmpIndex];
						heap[tmpIndex] = tmp;
						tmpIndex = lchildIndex;
					}
					else break;

				}
				

			}

		}



	}



}