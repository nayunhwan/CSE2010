class LinkedList{

	private Node head;
	public int count; // 리스트의 노드갯수

	private class Node{

		String key;
		String value;
		Node next;


		Node(String key, String value){    //todo#1 
			this.key = key;
			this.value = value;
			this.next = null;
		}

		Node(){
			this.key = null;
			this.value = null;
			this.next = null;
		}

	}

	public LinkedList(){
		this.head = new Node();
		this.count = 0;
	}

	public void insert(int position, String key, String value){

		Node node = head;

		for(int i = 0; i <= count; i++){
			if(i == position){
				this.count++;
				Node newNode = new Node(key, value);
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
				System.out.print(node.key+", "+node.value+"]");
				break;	
			} 
			node = node.next;
		}
	}

	public String getValue(String key){
		// System.out.println("?");
		Node node = head.next;
		while(node.key != key){

			node = node.next;
		}
		return node.value;
	}

	public boolean hasKey(String key){
		Node node = head.next;
		// System.out.println(count);
		while(node != null){
			// System.out.println(node.key);
			if(node.key == key) return true;
			node = node.next;
		}
		return false;
	}


	// public void recursive_insert(int size){
	// 	if(size == 1){
	// 		insert(count, (size-1)*5);
	// 		return;
	// 	}
	// 	recursive_insert(size-1);
	// 	insert(count, (size-1)*5);
	// }

	// public void recursive_delete(int size){
	// 	if(size == 1){
	// 		delete(count-1);
	// 		return;	
	// 	} 
	// 	recursive_delete(size-1);
	// 	delete(count-1);
	// }
}