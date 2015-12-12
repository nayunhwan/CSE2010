public class BstRun{

	public static void main(String[] args) {
		Bst bst = new Bst();	
		int arr[] = {5, 3, 2, 1, 4, 8, 6, 7, 10, 9};
		for(int i = 0; i < arr.length; i++){
			// System.out.println("??");
			bst.insert(arr[i]);
		}

		System.out.println(bst.root);
		bst.postorder(bst.root);
		System.out.println();
		bst.delete(8);
		bst.delete(5);
		bst.delete(2);
		bst.inorder(bst.root);


	}
	

}