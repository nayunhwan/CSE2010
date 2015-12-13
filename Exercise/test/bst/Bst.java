class Bst{
<<<<<<< HEAD
<<<<<<< HEAD

=======
>>>>>>> origin/master
=======
>>>>>>> origin/master
	Node root;

	private class Node{
		Node lchild;
		Node rchild;
		int key;

<<<<<<< HEAD
<<<<<<< HEAD
		Node(int key){
			this.key = key;
			lchild = null;
			rchild = null;
		}
	}


	void insert(int key){
=======
=======
>>>>>>> origin/master
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
<<<<<<< HEAD
>>>>>>> origin/master
=======
>>>>>>> origin/master
		if(root == null) root = new Node(key);
		else{
			Node curNode = root;
			Node parNode = null;
			while(curNode != null){
				parNode = curNode;
<<<<<<< HEAD
<<<<<<< HEAD
				if(key < curNode.key) curNode = curNode.lchild;
				else curNode = curNode.rchild;
			}

			if(key < parNode.key) parNode.lchild = new Node(key);
			else parNode.rchild = new Node(key);
		}
	}

	void delete(int key){
=======
=======
>>>>>>> origin/master
				if(key < curNode.getkey()) curNode = curNode.lchild;
				else curNode = curNode.rchild;
			}

			if(key < parNode.getkey()) parNode.lchild = new Node(key);
			else parNode.rchild = new Node(key);
			// curNode = new Node(key);	
		}
		
	}

	public void delete(int key){
<<<<<<< HEAD
>>>>>>> origin/master
=======
>>>>>>> origin/master
		Node curNode = root;
		Node parNode = null;

		while(curNode != null){
<<<<<<< HEAD
<<<<<<< HEAD
			if(key == curNode.key) break;
			parNode = curNode;

			if(key < curNode.key) curNode = curNode.lchild;
			else curNode = curNode.rchild;
		}

		Node tmpNode = curNode;
		Node tmpParNode = null;

		if(curNode.lchild == null && curNode.rchild == null){
			if(curNode == root) root = null;
			else{
				if(parNode.lchild == curNode) parNode.lchild = null;
				else if(parNode.rchild == curNode) parNode.rchild = null;	
			}
			
		}
		else if(curNode.lchild != null && curNode.rchild == null){
=======
=======
>>>>>>> origin/master
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
<<<<<<< HEAD
>>>>>>> origin/master
=======
>>>>>>> origin/master
			while(tmpNode.lchild != null){
				tmpParNode = tmpNode;
				tmpNode = tmpNode.lchild;
			}
<<<<<<< HEAD
<<<<<<< HEAD
			tmpParNode.lchild = tmpNode.rchild;
		}
		else if(curNode.lchild == null && curNode.rchild != null){
=======
=======
>>>>>>> origin/master

			if(tmpParNode != null) tmpParNode.lchild = null;

			if(parNode.lchild == curNode) parNode.lchild = tmpNode;
			else parNode.rchild = tmpNode;

			tmpNode.lchild = curNode.lchild;
			tmpNode.rchild = curNode.rchild;
		}
		else if(curNode.lchild == null && curNode.rchild != null){
			Node tmpNode = curNode;
			Node tmpParNode = null;
<<<<<<< HEAD
>>>>>>> origin/master
=======
>>>>>>> origin/master
			while(tmpNode.rchild != null){
				tmpParNode = tmpNode;
				tmpNode = tmpNode.rchild;
			}
<<<<<<< HEAD
<<<<<<< HEAD
			tmpParNode.rchild = tmpNode.lchild;
		}
		else if(curNode.lchild != null && curNode.rchild != null){
			tmpNode = curNode.lchild;

=======
=======
>>>>>>> origin/master

			tmpParNode.lchild = null;

			if(parNode.lchild == curNode) parNode.lchild = tmpNode;
			else parNode.rchild = tmpNode;

			tmpNode.lchild = curNode.lchild;
			tmpNode.rchild = curNode.rchild;
		}
		else if(curNode.lchild != null && curNode.rchild != null){
			Node tmpNode = curNode.lchild;
			Node tmpParNode = null;
<<<<<<< HEAD
>>>>>>> origin/master
=======
>>>>>>> origin/master
			while(tmpNode.rchild != null){
				tmpParNode = tmpNode;
				tmpNode = tmpNode.rchild;
			}

<<<<<<< HEAD
<<<<<<< HEAD
			tmpParNode.rchild = tmpNode.lchild;
		}

		if(curNode == root) root = tmpNode;
		else{
			if(parNode.lchild == curNode) parNode.lchild = tmpNode;
			else if(parNode.rchild == curNode) parNode.rchild = tmpNode;
		}

		tmpNode.lchild = curNode.lchild;
		tmpNode.rchild = curNode.rchild;

		// if(tmpParNode.lchild == tmpNode) tmpParNode.lchild = null;
		// else if(tmpParNode.rchild == tmpNode) tmpParNode.rchild = null;

=======
=======
>>>>>>> origin/master
			tmpParNode.rchild = null;

			if(parNode.lchild == curNode) parNode.lchild = tmpNode;
			else parNode.rchild = tmpNode;

			tmpNode.lchild = curNode.lchild;
			tmpNode.rchild = curNode.rchild;			
		}
<<<<<<< HEAD
>>>>>>> origin/master
=======
>>>>>>> origin/master
	}

	Node search(int key){
		Node curNode = root;
<<<<<<< HEAD
<<<<<<< HEAD

		while(curNode != null){
			if(key == curNode.key) return curNode;

			if(key < curNode.key) curNode = curNode.lchild;
			else curNode = curNode.rchild;
		}

		return null;
	}

	void preOrder(Node node){
		System.out.print(node.key + " ");
		if(node.lchild != null) preOrder(node.lchild);
		if(node.rchild != null) preOrder(node.rchild);
	}

	void inOrder(Node node){
		if(node.lchild != null) inOrder(node.lchild);
		System.out.print(node.key + " ");
		if(node.rchild != null) inOrder(node.rchild);
	}

	void postOrder(Node node){
		if(node.lchild != null) postOrder(node.lchild);
		if(node.rchild != null) postOrder(node.rchild);
		System.out.print(node.key + " ");

	}


=======
=======
>>>>>>> origin/master
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
<<<<<<< HEAD
>>>>>>> origin/master
=======
>>>>>>> origin/master
}