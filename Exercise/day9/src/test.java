class Test{
	private class Node{
		int data;

		Node(int data){
			this.data = data;
		}
	}

	void run(){
		Node n1 = new Node(1);
		Node tmp = n1;
		System.out.println(n1.data);
		System.out.println(tmp.data);
		tmp.data = 3;
		System.out.println("change");
		System.out.println(n1.data);
		n1 = null;
		// System.out.println(n1.data);
		System.out.println(tmp.data);
	}
	public static void main(String[] args) {
		Test run = new Test();
		run.run();
	}
}