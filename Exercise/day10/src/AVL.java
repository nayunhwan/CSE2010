class AVL{
	private class Node{
		Node lchild;
		Node rchild;
		int key;

		Node(int key){
			lchild = null;
			rchild = null;
			this.key = key;
		}
	}

	public void insert(int key){

	}

	public void delete(int key){

	}

	public boolean search(int key){

	}

	public void rotateLL(Node selected){
		Node tmpNode = selected.lchild;
		selected.lchild = tmpNode.rchild;
		tmpNode.rchild = selected;
	}

	public void rotateLR(){

	}

	public void rotateRR(){

	}

	public void rotateRL(){

	}

	public void print_preorder();
	public void print_inorder();
	public void print_postorder();

}