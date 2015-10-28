/*
 * CSE2010 Homework #4: Location.java
 * 
 * DO NOT MODIFY THIS FILE!
 * 
 */
public class Location {
	public int x_coord;
	public int y_coord;
	
	public Location(int i, int j) {
		x_coord = i;
		y_coord = j;
	}
	
	public String toString() {
		return new String("[" + Integer.toString(x_coord) + "," + Integer.toString(y_coord) + "]");
	}
}