class Hashtable{
	
	LinkedList table[];

	Hashtable(){
		this.table = new LinkedList[6];
		for(int i = 0; i < table.length; i++){
			this.table[i] = new LinkedList();
		}
	}
	public int hashFunction(String key){
		return key.length() % table.length;
	}

	public String getValue(String key){

		if(hasValue(key)) return table[hashFunction(key)].getValue(key);
		else return null;
	}

	public void setValue(String key, String value){
		int hash = hashFunction(key);
		table[hash].insert(table[hash].count, key, value);
	}

	public boolean hasValue(String key){
		return table[hashFunction(key)].hasKey(key);
	}

	public void showAll(){
		for(int i = 0; i < table.length; i++){
			if(table[i].count == 0){
				System.out.print("["+i+", NULL]");
			}
			for(int j = 0; j < table[i].count; j++){
				System.out.print("["+i+", ");
				table[i].get_data(j);
			}
		}
		System.out.println();
	}
}