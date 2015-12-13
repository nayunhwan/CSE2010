class Stack{
	private Node top;
	private class Node{

		private char data;
		private Node nextNode;

		Node (char data){
			this.data = data;
			this.nextNode = null;
		}

	}

	public Stack(){
		this.top = null;
	}

	public void push(char data){
		Node newNode = new Node(data);
		newNode.nextNode = top;
		top = newNode;
	}

	public char pop(){
		if(!empty()){
			Node returnNode = top;
			top = top.nextNode;
			return returnNode.data;	
		}
		else return ' ';
		
	}

	public boolean empty(){
		return top == null;
	}

	public void printStack(){
		if(empty()) System.out.println("비어있음");
		else{
			Node curNode = top;
			while(curNode != null){
				System.out.print(curNode.data+" ");	
				curNode = curNode.nextNode;
			} 
			System.out.println();
		}
	}
}