class Avl{

	Node root;
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

	Avl(){
		this.root = null;
	}

	public void insert(int key){
		Node curNode = root;
		while(curNode != null){
			if(key < curNode.key) curNode = curNode.lchild;
			else curNode = curNode.rchild;
		}
		curNode = new Node(key);
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