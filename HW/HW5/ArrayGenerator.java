/*
 * CSE210 Homework #5: ArrayGenerator.java
 * 
 * DO NOT MODIFY THIS FILE!
 * 
 */
import java.util.Date;
import java.util.Random;

public class ArrayGenerator  {
	
	static int[] generate(int count, int upperbound) {
	
		Random r = new Random(new Date().getTime());
		
		int[] temp = new int[count];
		
		for (int i = 0; i < count; i++) {
			temp[i] = r.nextInt(upperbound);
		}
		
		return temp;
	}
}