package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.util.NoSuchElementException;

import linkedLists.LinkedList;
import linkedLists.AbstractSLList.SNode;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 
	
	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}
	
	
	public void addFirstNode(Node<E> nuevo) {
		((SNode<E>) nuevo).setNext(first);
		first = (SNode<E>) nuevo;
		length++;
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		SNode<E> next = ((SNode<E>)target).getNext();
		((SNode<E>) nuevo).setNext(next);
		((SNode<E>)target).setNext(((SNode<E>) nuevo));
		if(target == last)
			last = (SNode<E>) nuevo;
		length++;
		
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		if(target == first){
			addFirstNode(nuevo);
		}
		else{
			((SNode<E>) nuevo).setNext(((SNode<E>) target));
			Node<E> prev = findNodePrevTo(target);
			((SNode<E>)prev).setNext(((SNode<E>) nuevo));
			length++;
		}
		
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		return first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		if(target == last)
			throw new NoSuchElementException("Target is the last node");
		return ((SNode<E>)target).getNext();
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		if(target == first)
			throw new NoSuchElementException("Target is the first node");
		return findNodePrevTo(target);
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target) {
		if(target == first){
			first = ((SNode<E>)target).getNext();
			((SNode<E>)target).clean();
		}
		else if(target == last){
			last = ((SNode<E>)target).getNext();
			((SNode<E>)target).clean();
		}
		else{
			SNode<E> prev = (SNode<E>)findNodePrevTo(target);
			SNode<E> next = ((SNode<E>)target).getNext();
			prev.setNext(next);
		}
		length--;
	}
	
	public Node<E> createNewNode() {
		return new SNode<E>();
	}
	
	private Node<E> findNodePrevTo(Node<E> target) {
		// Pre: target is a node in the list
		if (target == first) 
			return null; 
		else { 
			SNode<E> prev = first; 
			while (prev != null && prev.getNext() != target) 
				prev = prev.getNext();  
			return prev; 
		}
	}

}
