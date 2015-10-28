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

		// 0부터 count까지 돌면서, i == position이 되면, 현재 노드(head를 -1로 본다) 앞에 새로운 노드를 붙이고, 새로운 노드의 next를
		// 기존의 node의 next로 바꾼다.

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

		// 0부터 count까지 돌면서, i == position이 되면, 현재 노드(head를 -1로 본다)의 next 값을 next.next 노드값으로 바꾼다.

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

		// 0부터 count까지 돌면서 get_data를 이용해 값을 출력한다.

		for(int i = 0; i < count; i++){
			get_data(i);
			System.out.print(", ");		
		}
		System.out.println();

	}

	public void get_data(int position){
		
		// 0부터 count까지 돌면서 i == position이 될 때 해당 노드의 data값을 출력한다.

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