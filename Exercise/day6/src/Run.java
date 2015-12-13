class Run{
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList();

		list1.recursive_insert(20);
		list1.print_list();
		list1.recursive_delete(15);
		list1.print_list();

	}
}