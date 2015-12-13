class Run{
	public static void main(String[] args) {
		Stack st1 = new Stack();
		st1.pop();
		st1.printStack();
		// 2의 배수로 5개 push
		for(int i = 0; i < 5; i++){
			st1.push(String.valueOf((i+1)*2));
		}
		
		st1.printStack();

		// 3개 pop,  push(‘1’)
		for(int i = 0; i < 3; i++){
			System.out.println(st1.pop());
		}
		
		st1.push("1");
		
		st1.printStack();

	}
}