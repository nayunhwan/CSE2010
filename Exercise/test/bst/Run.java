class Run{
	public static void main(String[] args) {
		Bst bst = new Bst();
		int arr[] = {5, 3, 2, 1, 4, 8, 6, 7, 10, 9};

		for(int i = 0; i < arr.length; i++){
			bst.insert(arr[i]);
		}

		bst.inOrder(bst.root);
		System.out.println();
		if(bst.search(8) != null) System.out.println("8 있음");
		else System.out.println("8없음");
		bst.delete(8);
		bst.delete(5);
		bst.delete(2);

		if(bst.search(8) != null) System.out.println("8 있음");
		else System.out.println("8없음");
		bst.inOrder(bst.root);
		System.out.println();
		bst.preOrder(bst.root);
		System.out.println();
	}
}