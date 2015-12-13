public class CircularQueue{
	int rear;
	int front;
	int queue[];
	int size;

	CircularQueue(int size){
		this.size = size+1;
		this.rear = 0;
		this.front = 0;
		this.queue = new int[size+1];
	}

	public void enqueue(int n){
		queue[rear] = n;
		rear = (rear+1) % size;
	}

	public int dequeue(){
		if(!isEmpty()){
			int result = queue[front];
			front = (front+1) % size;
			return result;	
		}
		return -1;
	}
	public boolean isFull(){
		return getCount() == size-1;
	}

	public boolean isEmpty(){
		return front == rear;
	}

	public int getCount(){
		return (size - front +rear) % size;
	}
	public void printQueue(){
		System.out.println("Count : " + getCount());
		for(int i = front; i != rear; i = (i+1)%size){
			System.out.print(queue[i] + ", ");
		}
		System.out.println();
		printArr();
	}

	public void printArr(){
		System.out.println("\tArray");
		System.out.print("\t");
		for(int i = 0; i < queue.length; i++){
			System.out.print(queue[i] + ", ");
		}
		System.out.println();
	}

}