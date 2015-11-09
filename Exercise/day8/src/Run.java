class Run{
	
	public static void bracketCheck(String s){
		Queue queue = new Queue();
		Stack stack = new Stack();

		for(int i = 0; i < s.length(); i++){
			queue.Enqueue(s.charAt(i));
		}

		// while(!queue.empty()){
		// 	char getChar = queue.Dequeue();

		// 	if(getChar == '(') stack.push(getChar);
		// 	else if(getChar == ')'){
		// 		if(stack.empty()){
		// 			System.out.println("\nError!");
		// 			return;
		// 		}
		// 		stack.pop();	
		// 	} 

		// 	System.out.print(getChar);
		// }

		// if(!stack.empty()) System.out.println("\nError!");
		// else System.out.println();

		queue.printQueue();
	}


	public static void main(String[] args) {

		String a1 = "((142+(2+(3-24)))+23)+(1414+(14-11))";
		String a2 = "(142+2(32)4+14((1))4+(1(4-11)";
		String a3 = "(142+2324)+1414)+14";
		String a4 = "(((((())))()()))((((((()))()))(((())((((()))))))))";

		bracketCheck(a1);
		bracketCheck(a2);
		bracketCheck(a3);	
		bracketCheck(a4);	

		
	}
}