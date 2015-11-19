class Run{
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int arr[] = {5, 3, 2, 1, 4, 8, 6, 7, 10, 9};
		for(int item : arr){
			tree.insert(item);
		}


		System.out.println(tree.search(7) == null? "7없음" : "7있음" );

		System.out.println("Preorder");
		tree.print_preorder(tree.root);
		System.out.println("\nInorder");
		tree.print_inorder(tree.root);
		System.out.println("\nPostorder");
		tree.print_postorder(tree.root);
		System.out.println();
		tree.delete(8);
		tree.delete(5);
		tree.delete(2);

		System.out.println(tree.search(8) == null? "8없음" : "8있음" );

		System.out.println("Preorder");
		tree.print_preorder(tree.root);
		System.out.println();

		
	}
}