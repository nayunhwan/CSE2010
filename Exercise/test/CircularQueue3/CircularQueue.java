public class CircularQueue{
	int size;
	int rear = 0, front = 0;
	int queue[];

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

	public int getCount(){
		return (size - front + rear) % size;
	}

	public void printQueue(){
		for(int i = front; i != rear; i = (i+1)%size){
			System.out.print(queue[i] + ", ");
		}
		System.out.println();
	}


}