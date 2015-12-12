class Bst{
	Node root;

	private class Node{
		Node lchild;
		Node rchild;
		int key;

		Node(){
			lchild = null;
			rchild = null;
		}

		Node(int key){
			lchild = null;
			rchild = null;
			this.key = key;
		}

		void setkey(int key){
			this.key = key;
		}

		int getkey(){
			return this.key;
		}

	}



	public void insert(int key){
		if(root == null) root = new Node(key);
		else{
			Node curNode = root;
			Node parNode = null;
			while(curNode != null){
				parNode = curNode;
				if(key < curNode.getkey()) curNode = curNode.lchild;
				else curNode = curNode.rchild;
			}

			if(key < parNode.getkey()) parNode.lchild = new Node(key);
			else parNode.rchild = new Node(key);
			// curNode = new Node(key);	
		}
		
	}

	public void delete(int key){
		Node curNode = root;
		Node parNode = null;

		while(curNode != null){
			if(key == curNode.getkey()) break;
			parNode = curNode;
			
			if(key < curNode.getkey()) curNode = curNode.lchild;
			else curNode = curNode.rchild;
		}

		if(curNode.lchild == null && curNode.rchild == null){
			if(parNode.lchild == curNode) parNode.lchild = null;
			else if(parNode.rchild == curNode) parNode.rchild = null;
		}
		else if(curNode.lchild != null && curNode.rchild == null){
			Node tmpNode = curNode;
			Node tmpParNode = null;
			while(tmpNode.lchild != null){
				tmpParNode = tmpNode;
				tmpNode = tmpNode.lchild;
			}

			if(tmpParNode != null) tmpParNode.lchild = null;

			if(parNode.lchild == curNode) parNode.lchild = tmpNode;
			else parNode.rchild = tmpNode;

			tmpNode.lchild = curNode.lchild;
			tmpNode.rchild = curNode.rchild;
		}
		else if(curNode.lchild == null && curNode.rchild != null){
			Node tmpNode = curNode;
			Node tmpParNode = null;
			while(tmpNode.rchild != null){
				tmpParNode = tmpNode;
				tmpNode = tmpNode.rchild;
			}

			tmpParNode.lchild = null;

			if(parNode.lchild == curNode) parNode.lchild = tmpNode;
			else parNode.rchild = tmpNode;

			tmpNode.lchild = curNode.lchild;
			tmpNode.rchild = curNode.rchild;
		}
		else if(curNode.lchild != null && curNode.rchild != null){
			Node tmpNode = curNode.lchild;
			Node tmpParNode = null;
			while(tmpNode.rchild != null){
				tmpParNode = tmpNode;
				tmpNode = tmpNode.rchild;
			}

			tmpParNode.rchild = null;

			if(parNode.lchild == curNode) parNode.lchild = tmpNode;
			else parNode.rchild = tmpNode;

			tmpNode.lchild = curNode.lchild;
			tmpNode.rchild = curNode.rchild;			
		}
	}

	Node search(int key){
		Node curNode = root;
		while(curNode != null){
			if(key == curNode.getkey()) return curNode;
			else if(key < curNode.getkey()) curNode = curNode.lchild;
			else curNode = curNode.rchild;
		}
		return null;
	}

	void preorder(Node node){
		System.out.print(node.getkey() + " ");
		if(node.lchild != null) preorder(node.lchild);
		if(node.rchild != null) preorder(node.rchild);
	}

	void inorder(Node node){
		if(node.lchild != null) inorder(node.lchild);
		System.out.print(node.getkey()+ " ");
		if(node.rchild != null) inorder(node.rchild);
	}

	void postorder(Node node){
		if(node.lchild != null) postorder(node.lchild);
		if(node.rchild != null) postorder(node.rchild);
		System.out.print(node.getkey() + " ");
	}
}