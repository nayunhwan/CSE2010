class BinaryTree{

	public Node root;

	private class Node{
		Node lchild;
		Node rchild;
		int key;

		Node(int key){
			this.lchild = null;
			this.rchild = null;
			this.key = key;
		}
	}

	public BinaryTree(){
		this.root = null;
	}

	public void insert(int key){
		// root가 비어있을 경우에는 root에 Node를 새로 생성한다.
		if(root == null) root = new Node(key);
		else{
			// root부터 탐색을 시작한다.
			Node curNode = root;

			while(curNode != null){
				// inputKey가 curNode의 key보다 작을 경우
				if(curNode.key > key){
					// curNode의 왼쪽 자식이 비어있다면 새로 생성
					if(curNode.lchild == null){
						curNode.lchild = new Node(key);
						return;	
					} 
					// 왼쪽 자식이 존재한다면 왼쪽노드로 이동한다.
					else{
						curNode = curNode.lchild;
						continue;
					}
				}
				// inputKey가 curNode의 key보다 클 경우
				else{
					// curNode의 오른쪽 자식이 비어있다면 새로 생성
					if(curNode.rchild == null){
						curNode.rchild = new Node(key);
						return;
					}
					// 오른쪽 자식이 존재한다면 오른쪽노드로 이동
					else{
						curNode = curNode.rchild;
						continue;
					}
				}
			}
		}
	}

	public void delete(int key){
		Node selectNode = search(key);
		Node parent = null;
		Node curNode = null;

		// selectNode에 자식노드가 없을 때 즉 리프노드일 경우
		if(selectNode.lchild == null && selectNode.rchild == null){
			// selectNode가 parentNode의 왼쪽 자식인지, 오른쪽 자식인지 비교 후, 삭제
			// if(selectNode.parent.lchild == selectNode) selectNode.parent.lchild = null;
			// else if(selectNode.parent.rchild == selectNode) selectNode.parent.rchild = null;
			// return;
			selectNode = null;
			return;
		}
		

		// selectNode가 노드를 모두 가지고 있을 경우
		if(selectNode.lchild != null && selectNode.rchild != null){
			curNode = selectNode.lchild;
			while(curNode.rchild != null){
				curNode = curNode.rchild;
			}

			curNode.parent.rchild = curNode.lchild;
		}

		// selectNode가 왼쪽노드는 가지고 있고, 오른쪽노드는 없는 경우
		else if(selectNode.lchild != null && selectNode.rchild == null){
			curNode = selectNode.lchild;
			while(curNode.lchild != null){
				curNode = curNode.lchild;
			}
			curNode.parent.lchild = curNode.rchild;
			
		}

		// selectNode가 오른쪽노드는 가지고 있고, 왼쪽노드는 없는 경우
		else if(selectNode.lchild == null && selectNode.rchild != null){
			curNode = selectNode.rchild;
			while(curNode.rchild != null){
				curNode = curNode.rchild;
			}
			curNode.parent.rchild = curNode.lchild;
			
		}

		// 만약에 seledtNode가 root일 경우
		if(selectNode == root){
			root = curNode;	
		}
		else if(selectNode != root){
			if(selectNode.parent.lchild == selectNode) selectNode.parent.lchild = curNode;
			else if(selectNode.parent.rchild == selectNode) selectNode.parent.rchild = curNode;	
		}
		

		curNode.lchild = selectNode.lchild;
		curNode.rchild = selectNode.rchild;

		if(selectNode.lchild != null) selectNode.lchild.parent = curNode;
		if(selectNode.rchild != null) selectNode.rchild.parent = curNode;


	}

	public Node search(int key){
		Node curNode = root;
		while(true){
			if(curNode == null) return curNode;

			// inputKey가 curNode의 key보다 작을 경우에는, 왼쪽노드로 이동
			if(curNode.key > key){
				curNode = curNode.lchild;
				continue;
			}
			// inputKey와 curNode의 key값이 같을 경우 return curNode;
			else if(curNode.key == key) return curNode;
			// inputKey가 curNode의 key값보다 클 경우에는, 오른쪽노드로 이동
			else{
				curNode = curNode.rchild;
				continue;
			}
		}
	}

	public void print_preorder(Node node){
		System.out.print(node.key + " ");
		if(node.lchild != null) print_preorder(node.lchild);
		if(node.rchild != null) print_preorder(node.rchild);
	}

	public void print_inorder(Node node){
		if(node.lchild != null) print_inorder(node.lchild);
		System.out.print(node.key + " ");
		if(node.rchild != null) print_inorder(node.rchild);
	}

	public void print_postorder(Node node){
		if(node.lchild != null) print_postorder(node.lchild);
		if(node.rchild != null) print_postorder(node.rchild);
		System.out.print(node.key + " ");
	}

}