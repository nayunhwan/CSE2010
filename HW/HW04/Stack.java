/*
 * CSE2010 Homework #4: Stack.java
 * 
 * DO NOT MODIFY THIS FILE!
 * 
 */
public interface Stack<T> {
	
	public void push(T item) throws FullStackException;
	
	public T pop() throws EmptyStackException;
	
	public boolean isEmpty();
	
	public boolean isFull();
	
	public T top();
	
}