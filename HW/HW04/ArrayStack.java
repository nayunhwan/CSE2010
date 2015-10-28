/*
 * CSE2010 Homework #4: ArrayStack.java
 * 
 * Modify this file as needed!
 * 
 */
public class ArrayStack<T> implements Stack<T> {

	private int top;
	private int size;
	private T stack[];


	public ArrayStack(int size){
		this.top = -1;
		this.size = size;
		stack = (T[]) new Object[size];
	}

	public void push(T item){
		if(!isFull()) stack[++top] = item;	
		else throw new FullStackException();
	} 
	
	public T pop(){
		if(!isEmpty()) return stack[top--];
		else throw new EmptyStackException();
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isFull(){
		return top == size-1;
	}
	
	public T top(){
		if(!isEmpty()) return stack[top];
		else throw new EmptyStackException();
	}
	
}