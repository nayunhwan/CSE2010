import java.util.*;



public class Quick{

	public static int[] quicksort(int arr[], int start, int end){
		if(start >= end) return arr;
		
		int mid = (start+end)/2;
		int pivot = arr[start];

		System.out.print("\t pivot : " + pivot + " -> ");
		printArr(arr);

		int left = start+1;
		int right = end;

		while(true){
			while(left <= end && arr[left] <= pivot) left++;
			while(right >= start+1 && arr[right] > pivot) right--;

			if(left > right) break;

			int tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
		}

		int tmp = arr[start];
		arr[start] = arr[right];
		arr[right] = tmp;

		arr = quicksort(arr, start, right-1);
		arr = quicksort(arr, right+1, end);

		return arr;
	}	

	public static void printArr(int arr[]){
		for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + ", ");
		System.out.println();
	}
	public static void main(String[] args) {
		int size = 10;
		int arr[] = new int[size];

		for(int i = 0; i < arr.length; i++) arr[i] = (int)(Math.random()*100+1);

		System.out.println("Initial Array");
		printArr(arr);
		System.out.println("Sorted Array");
		arr = quicksort(arr, 0, arr.length-1);
		printArr(arr);



	}
}