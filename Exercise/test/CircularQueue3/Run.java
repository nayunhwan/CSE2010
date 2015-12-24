public class Run{
	static int size = 10;
	static CircularQueue queue = new CircularQueue(size);

	public static void insert(int count){
		for(int i = 0; i < count; i++){
			int rndInt = (int)(Math.random()*100+1);
			System.out.println("Enqueue : " + rndInt);
			queue.enqueue(rndInt);
		}
	}

	public static void deinsert(int count){
		for(int i = 0; i < count; i++){
			System.out.println("Dequeue : " + queue.dequeue());
		}
	}

	public static void main(String[] args) {

		insert(10);
		queue.printQueue();

		deinsert(4);

		queue.printQueue();
		insert(3);
		queue.printQueue();

	}
}