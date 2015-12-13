public class CircularQueue{
	int size;
	int queue[];
	int front = 0, rear = 0;

	public CircularQueue(int size){
		this.size = size+1;
		this.queue = new int[this.size];
	}

	public void enqueue(int n){
		queue[rear] = n;
		rear = (rear + 1) % size;
	}

	public int dequeue(){
		int result = queue[front];
		front = (front + 1) % size;
		return result;
	}

	public boolean isEmpty(){
		return rear == front;
	}

	public int getCount(){
		return (size - front + rear) % size;
	}

	public void printQueue(){
		System.out.println("Print Queue");
		for(int i = front; i != rear; i = (i+1)%size){
			System.out.print(queue[i] + ", ");
		}
		System.out.println();
	}
}