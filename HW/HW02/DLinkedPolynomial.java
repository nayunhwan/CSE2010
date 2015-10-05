/*
 * (C) 2015 CSE2010 HW #2
 * 
 */

/*
 * class DLinkedPolynomial
 */


class Node{

	protected Node prev;
	protected Term element;
	protected Node next;

	public Node(Node prev, Term element, Node next){
		this.prev = prev;
		this.element = element;
		this.next = next;
	}

	public Node getPrev(){
		return prev;
	}

	public Term getElement(){
		return element;
	}

	public Node getNext(){
		return next;
	}

	public void setPrev(Node element){
		this.prev = element;
	}

	public void setNext(Node element){
		this.next = element;
	}

	public void setElement(Term element){
		this.element = element;
	}

}


public class DLinkedPolynomial implements Polynomial {
	
	public Node head;
	public Node tail;


	public DLinkedPolynomial(){
		tail = new Node(null, null, null);
		head = new Node(null, null, tail);
		tail.setPrev(head);
	}


	public DLinkedPolynomial(Polynomial p){
		// tail = new Node(null, null, null);
		// head = new Node(null, null, tail);
		// tail.setPrev(head);

		// int p_degree = p.getDegree();

		// for(int i = p_degree; i >= 0; i--){

		// 	double p_coeff = getCoefficient(i);
		// 	if(p_coeff != 0){
		// 		System.out.println("???");
		// 		attach(new Term(p_coeff, i));
		// 	}
		// }

		// p.printMe();

		tail = p.getTail();
		head = p.getHead();
	}

	public boolean isEmpty(){
		if(getHead().getNext() == getTail()) return true;
		return false;
	}
	public Node getHead(){
		return head;
	}

	public Node getTail(){
		return tail;
	}

	public Node getFirst(){
		return getHead().getNext();
	}

	public Node getLast(){
		return getTail().getPrev();
	}

	public void removeNode(int expo){
		Node node = getFirst();
		while(node != getTail()){
			if(node.getElement().expo == expo){
				node.getPrev().setNext(node.getNext());
				node.getNext().setPrev(node.getPrev());
				return;
			}
			node = node.getNext();
		}
	}

	public void addAfter(Node prev, Node node){
		node.setNext(prev.getNext());
		node.setPrev(prev);
		prev.getNext().setPrev(node);
		prev.setNext(node);
	}

	public void addBefore(Node node, Node next){
		node.setNext(next);
		node.setPrev(next.getPrev());
		next.getPrev().setNext(node);
		next.setPrev(node);
	}

	public int getDegree() { 
		return getFirst().getElement().expo;
	}
	
	public double getCoefficient(int exponent) {
		Node node = getFirst();
		while(node != getTail()){
			Term curTerm = node.getElement();
			if(curTerm.expo == exponent) return curTerm.coeff;
			node = node.getNext();
		}
		return 0;
		// Complete here ...
	}
	
	public Polynomial padd(Polynomial p) {
		
		DLinkedPolynomial dlink_p = new DLinkedPolynomial(p);

		Node node = getFirst();
		Node p_node = dlink_p.getFirst();

		while(node != getTail()){
			if(p_node == dlink_p.getTail()) System.out.println("망");
			while(p_node != dlink_p.getTail()){
				if(node.getElement().expo != p_node.getElement().expo){
					attach(p_node.getElement());
					dlink_p.removeNode(p_node.getElement().expo);
				}
				else{
					node.getElement().coeff += dlink_p.getCoefficient(p_node.getElement().expo);
				}
			}

			node = node.getNext();
		}
		return this;
		// Complete here ...
	}
	
	public Polynomial pmult(Polynomial p) {	
		return this;
		// Complete here ...
	}
	
	public void attach(Term term) {
		// Node lastNode = getLast();
		// Node tailNode = getTail();
		// lastNode.setNext(new Node(lastNode, term, tailNode));
		// tailNode.setPrev(lastNode.getNext());
		Node node = getFirst();

		if(isEmpty()){
			addAfter(getHead(), new Node(null, term, null));
			return;
		}

		while(node != getTail()){
			Term curTerm = node.getElement();
			// Term nextTerm = node.getNext().getElement();

			if(term.expo > curTerm.expo){
				addBefore(new Node(null, term, null), node);
				return;	
			} 
			else if(node == getLast()){
				addAfter(node, new Node(null, term, null));
				return;
			}
			else if(term.expo == curTerm.expo){
				throw new DuplicateException();
			}
			// if(node.getNext() == getHead() && term.expo > prevTerm.expo){
			// 	addAfter(getHead(), new Node(null, term, null));		
			// }
			// else if(prevTerm.expo > curTerm.expo && )
			node = node.getNext();
		}
		// addAfter(getLast(), new Node(null, term, null));
		// Complete here ...
	}
	
	public double evaluate(double val) {
		Node node = getFirst();
		double result = 0;
		while(node != getTail()){
			Term curTerm = node.getElement();
			result += curTerm.coeff * Math.pow(val, curTerm.expo);
			node = node.getNext();
		}
		return result;
		// Complete here ...
	}
	
	public void printMe() {
		Node node = getFirst();

		while(node != getTail()){
			Term curTerm = node.getElement();
			System.out.print("("+curTerm.coeff+", "+curTerm.expo+") ");
			node = node.getNext();
		}
		System.out.println();

		// Complete here ...
	}		
}