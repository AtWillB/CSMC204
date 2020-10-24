/*
 * BasicDoubleLinkedList object class
 * Description: Creates a unsorted double linked list
 * @Author Will Byrne
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
	
	Node head, tail;
	int size;
	
	class Node{
		T item;
		Node next;
		Node previous;
		
		public Node(T item, Node next, Node previous) {
			this.item = item;
			this.next = next;
			this.previous = previous;
		}

	}
	
	public BasicDoubleLinkedList() {
		size = 0;
	}
	
	
	/**
	 * This method just returns the value of the instance 
	 * variable you use to keep track of size.
	 * @returns size of the linked list
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Adds an element to the end of the list. 
	 * @param data - the data for the Node within the linked list
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		Node newNode = new Node(data, null, tail);
		
		if(tail != null) {
			tail.next = newNode;
		}
		tail = newNode;
		if(head == null) {
			head = newNode;
		}
		size++;
		
		return this;
	}
	
	/**
	 * Adds element to the front of the list.
	 * @param data - the data for the node within the linked list
	 * @return reference to the current object. 
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) {
		Node newNode = new Node(data, head, null);
		
		if (head!= null) {
			head.previous = newNode;
		}
		head = newNode;
		if (tail == null) {
			tail = newNode;
		}
		size++;
		return this;
	}
	
	/**
	 * Returns but does not remove the first element from the list.
	 * If there are no elements the method returns null
	 * @return the data element or null
	 */
	public T getFirst() {
		return head.item;
	}
	
	/**
	 * returns but does not remove the last element form the list. 
	 * If there are no elements the method returns null
	 * @return the data element or null
	 */
	public T getLast() {
		return tail.item;
	}
	
	/**
	 * This method must be implemented using an inner class that implements ListIterator 
	 * and defines the methods of hasNext(), next(), hasPrevious() and previous()
	 */
	public  ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
		return new BasicDoubleLinkedListIterator();
	}
		
	private class BasicDoubleLinkedListIterator implements ListIterator<T> {
		private Node current;
		private Node lastViewed;
		private int index = 0;
		private int listSize;
		private Node listTail;
		
		
		BasicDoubleLinkedListIterator() {
			current = head;
			lastViewed = null;
			index = 0;
			listSize = size;
			listTail = tail;
		}


		//Do this one
		@Override
		public boolean hasNext() {
			return index < size;
		}


		//Do this one
		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			lastViewed = current;
			T item = current.item;
			current = current.next;
			index++;
			return item;
		}

		// do this one
		@Override
		public boolean hasPrevious() {
			return index > 0;
		}

		//Do this one 
		@Override
		public T previous() {
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			if (index == size) {
				current = tail;
			}
			T item = current.item;
			current = current.previous;
			lastViewed = current;
			index--;
			return item;
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();}

		@Override
		public void set(T e) {
			throw new UnsupportedOperationException();}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();}

	}
		
	
	
	/**
	 * Removes the first instance of the targetData from the list
	 * @param targetData - the data element to be removed
	 * @param comparator - the comparator to determine equality of data elements
	 * @return data element or null
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator) {
		Node current = head;
		Node target = null;
		 
		
		//find the target node. If it doesn't exist, return null
		for(int i = 0; i < this.size; i++) {
			if(current != null) {
				if (comparator.compare(targetData, current.item) == 0) {
					target = current;
					break;
				}
				else {
					current = current.next;
				}
			}
			else {
				return null;
			}
		}
		
		//if list has only one node, remove it
		if(this.getSize() == 1) {
			head = null;
			tail = null;
		}
		//if target node is the head, remove it
		else if (target == head) {
			head = head.next;
			head.previous = null;
		}
		//if target is the tail, remove it
		else if(target == tail) {
			tail = tail.previous;
			tail.next = null;
		}
		//if the target is inbetween head and tail, find and remove it. 
		else {
			current = null;
			current = head;
			while (current != target) {
				current = current.next;
			}
			current.previous.next = current.next;
			if (current.next != null) {
				current.next.previous = current.previous;
			}
			current = null;
		}
		size = size - 1;
		return this;
	}
	
	/**
	 * Removes and returns the first element from the list. 
	 * If there are no elements the method returns null.
	 * @return data element or null
	 */
	public T retrieveFirstElement() {
		T headData = null;
		
		if (this.getSize() >= 1) {
			headData = head.item;
			head = head.next;
			head.previous = null;	
		}
		else if (this.getSize() < 1) {
			return null;
		}
		size = size - 1;
		return headData;
	}
	/**
	 * Removes and returns the last element from the list. 
	 * If there are no elements the method returns null.
	 * @return data element or null
	 */
	public T retrieveLastElement() {
		T tailData = null;
		if (this.getSize() >=1) {
			tailData = tail.item;
			tail = tail.previous;
			tail.next = null;
		}
		else if (this.getSize() < 1) {
			return null;
		}
		
		size = size - 1;
		return tailData;
	}
	
	/**
	 * Returns an arraylist of the items in the list 
	 * from head of list to tail
	 * @return  an arraylist of items in the list
	 */
	public ArrayList<T> toArrayList() {
		Node current = head;
		ArrayList<T> arrayList = new ArrayList<>(size + 1);
		T tempVar;
		
		for(int i = 0; i < this.size ; i++) {
			if(current != null) {
				tempVar = current.item;
				arrayList.add(tempVar);
				current = current.next;
			}
			else {
				break;
			}

		}
		
		return arrayList;
	}
	
	
}
