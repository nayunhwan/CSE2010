public class Run{
	public static void main(String[] args){
		Hashtable table = new Hashtable();
		table.setValue("Jonh","111-1111");
		table.setValue("No","123-4567"); 
		table.setValue("Sam","222-2222");
		table.setValue("Jee","456-7890"); 
		table.setValue("Sandra","333-3333");
		table.setValue("Jaewon","000-0000"); 
		table.setValue("Lisa" ,"444-4444");
		table.setValue("Chris" ,"555-5555");
		// getValue  Lisa, Chris, Kim
		// System.out.println("?");
		System.out.println(table.getValue("Lisa"));
		System.out.println(table.getValue("Chris"));
		System.out.println(table.getValue("Kim"));
		table.showAll();
	}

}