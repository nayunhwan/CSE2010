class LinkedList{

	private Node head;
	private int count; // 리스트의 노드갯수
	private class Node{

		int data;
		Node next;

		Node(int input){    //todo#1 
			this.data = input;
			this.next = null;
		}

	}

	public LinkedList(){
		this.head = new Node(0);
		this.count = 0;
	}

	public void insert(int position, int input){

		Node node = head;

		for(int i = 0; i <= count; i++){
			if(i == position){
				this.count++;
				Node newNode = new Node(input);
				newNode.next = node.next;
				node.next = newNode;
				break;
			}
			node = node.next;
		}
	}

	public void delete(int position){
		Node node = head;

		for(int i = 0; i <= count; i++){
			if(i == position){
				this.count--;
				node.next = node.next.next;
				break;
			}
			node = node.next;
		}
	}

	public void print_list(){
		// Node node = head.next;

		for(int i = 0; i < count; i++){
			get_data(i);
			System.out.print(", ");
			// node = node.next;			
		}
		System.out.println();

	}

	public void get_data(int position){
		Node node = head.next;
		for(int i = 0; i < count; i++){
			if(i == position){
				System.out.print(node.data);
				break;	
			} 
			node = node.next;
		}
	}
}