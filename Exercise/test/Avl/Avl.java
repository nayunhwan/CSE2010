class Avl{
	Node root;

	private class Node{
		Node lchild;
		Node rchild;
		int height;
		int key;

		Node(int key){
			this.key = key;
			this.height = 0;
			this.lchild = null;
			this.rchild = null;
		}

		Node(int key, int height){
			this.key = key;
			this.height = height;
			this.lchild = null;
			this.rchild = null;
		}

	}

	void insert(int key){
		if(root == null) root = new Node(key);
		else{
			Node curNode = root;
			Node parNode = null;
			while(curNode != null){
				parNode = curNode;
				if(key < curNode.key) curNode = curNode.lchild;
				else curNode = curNode.rchild;
			}

			Node node = new Node(key);

			if(key < parNode.key) parNode.lchild = node;
			else parNode.rchild = node;

			

		}
	}


	Node rotateLeft(Node node){
		Node p = node.lchild;

		node.lchild = p.rchild;
		p.rchild = node;

		return p;
	}

	Node rotateRight(Node node){
		Node p = node.rchild;
		node.rchild = p.lchild;
		p.lchild = node;

		return p;
	}

	Node rotateLL(Node node){
		Node tmp;
		node.lchild = rotateLeft(node.lchild);
		tmp = rotateLeft(node);
		return tmp;
	}

	Node rotateRR(Node node){
		Node tmp;
		node.rchild = rotateRight(node.rchild);
		tmp = rotateRight(node);
		return tmp;
	}




}