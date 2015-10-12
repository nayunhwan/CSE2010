public class Run{
	public static void main(String[] args){
		DCLinkedList list1 = new DCLinkedList();

		//TODO #3
		//Math.Random을 사용하여 50개의 값을 리스트에 삽입 list1.print_list_forward(1);
		for(int i = 0; i < 20; i++){
			int rndInt = (int)(Math.random()*10)+1;
			list1.insert(0, rndInt);
		}

		list1.print_list_forward(1);
		list1.print_list_backward(1); 
		list1.delete(2);
		list1.delete(2); 
		list1.print_list_forward(15); 
		list1.print_list_backward(15); 
		list1.get_data(2);
	} 
}