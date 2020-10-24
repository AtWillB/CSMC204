import java.util.ArrayList;
import java.util.Comparator;

/*
 * BasicDoubleLinkedList object class
 * Description: Creates a unsorted double linked list
 * @Author Will Byrne
 */

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	private Comparator<T> comparator;
	private Node tail, head;
	private int size;

	
	private class Node {
		T item;
		Node next;
		Node previous;
		
	}

	
	/**
	 * sorted constructor
	 * @param comparator2
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator2) {
		tail = null;
		head = null;
		size = 0;
		this.comparator = comparator2; 
	}
	
	
	
	/**
	 * adds a data element to the sorted list
	 * @param data
	 * @return a refrence to the current list
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		Node node = new Node();
	     node.item = data;
	    if (head == null ) {
	    	head = node;
	        node.previous = head;
	        node.next = null;
	        head.next = node;
	        return this;
	    }

	    Node fast = head;
	    
	    while (fast.next != null &&  comparator.compare(node.item, fast.next.item) < 0) {
	        fast = fast.next;
	    }
	    if (fast.next == null) {
	        fast.next = node;
	        node.previous = fast;
	        node.next = null;
	    } else {
	        Node next = fast.next;
	        fast.next = node;
	        node.previous = fast;
	        node.next = next;
	        next.previous = node;
	    }
	    return this;    
	
	}
	
	/**
	 * this method only throws a exception
	 */
	@Override
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * This method only throws an exception
	 */
	@Override
	public BasicDoubleLinkedList<T> addToFront(T data) {
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * this method calls the super method from basic list to create an iterator
	 */
	@Override
	public java.util.ListIterator<T> iterator() {
		return this.iterator();
	}
	
	
	/**
	 * this method removes a item from the list
	 */
	@Override
	public BasicDoubleLinkedList<T> remove(T targetData, java.util.Comparator<T> comparator) {
		return this.remove(targetData, comparator);
	}
	
}
