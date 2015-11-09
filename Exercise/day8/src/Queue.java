class Queue{

	private Node head;
	private Node tail;

	private class Node{

		private char data;
		private Node nextNode;
		private Node prevNode;

		Node(char data){
			this.data = data;
			nextNode = null;
			prevNode = null;
		}

		Node(){
			nextNode = null;
			prevNode = null;
		}
	}

	public Queue(){
		this.head = new Node();
		this.tail = new Node();
		head.nextNode = tail;
		tail.prevNode = head;

	}

	public void Enqueue(char data){
		Node newNode = new Node(data);

		newNode.nextNode = tail;
		newNode.prevNode = tail.prevNode;
		tail.prevNode.nextNode = newNode;
		tail.prevNode = newNode;
	}

	public char Dequeue(){
		if(!empty()){
			Node getNode = head.nextNode;

			head.nextNode = getNode.nextNode;
			getNode.nextNode.prevNode = head;

			return getNode.data;
		}
		return ' ';
	}

	public void printQueue(){

		for(Node curNode = head; curNode != null; curNode = curNode.nextNode) System.out.print(curNode.data);
		System.out.println();

	}

	public boolean empty(){
		return head.nextNode == tail;
	}
}