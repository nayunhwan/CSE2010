public class Run{
	public static void main(String[] args) {
		int size = 10;
		CircularQueue queue = new CircularQueue(size);

		for(int i = 0; i < 10; i++){
			int randInt = (int)(Math.random()*100+1);
			System.out.println("Enqueue : " + randInt);
			queue.enqueue(randInt);
		}

		queue.printQueue();
		
		for(int i = 0; i < 5; i++){
			System.out.println("Dequeue : " + queue.dequeue());
		}
		queue.printQueue();

		for(int i = 0; i < 3; i++){
			int randInt = (int)(Math.random()*100+1);
			System.out.println("Enqueue : " + randInt);
			queue.enqueue(randInt);
		}
		queue.printQueue();
	}
}