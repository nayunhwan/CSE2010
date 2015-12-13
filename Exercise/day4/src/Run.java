class Run{
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();

		// gerate list 10 ~ 1 
		System.out.println("0번째 자리에 1~10까지 수 Insert");
		for(int i = 0; i < 10; i++){
			list1.insert(0, i+1);
		}
		list1.print_list();

		System.out.println("2번째 자리 지우기");
		list1.delete(2);
		list1.print_list();

		System.out.println("2번째 자리에 11 넣기");
		list1.insert(2,11);
		list1.print_list();

		System.out.println("10번째 자리에 8 넣기");
		list1.insert(10,8);
		list1.print_list();

		System.out.println("1번째 값");
		list1.get_data(1);
		System.out.println();

	}
}