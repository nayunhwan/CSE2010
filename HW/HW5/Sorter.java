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
		
		class Node{
			Node lchild;
			Node rchild;
			int key;

			Node(int key){
				this.key = key;
				this.lchild = null;
				this.rchild = null;
			}
		}
	}
}