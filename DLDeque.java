package inclass.oct;

/**
 * A class implementing an ADT QUEUE using a doubly linked node
 * @author Alexis Castro
 * Version 1.0
 */

public class DLDeque<T> implements DequeInterface<T>{
	
	private DLNode head; // pointer for the beginning of the line
	private DLNode tail; // pointer for the end of the line
	private int front;
	private int back;
	
	private class DLNode {
		
		private T newData;
		private DLNode next;
		private DLNode previous;
		
		public DLNode() {
			newData = null;
			next = null;
			previous = null;
		}
		
		@SuppressWarnings("unchecked")
		public DLNode(T data, DLNode nextAdr, DLNode previousAdr) {
			data = (T) new Object();
			this.newData = data;
			this.next = nextAdr;
			this.previous = previousAdr;
			 
		}
		
		

		
		
	}
	

	public DLDeque() {
		head = null;
		tail = null;
		
	}
	
	public DLDeque(DLNode node, int initialCapacity) {
		
		back = initialCapacity;
		front = 0;
		
	}

	@Override
	public void addToFront(T newEntry) {
		// TODO Auto-generated method stub

		DLNode tempHead = head;
		DLNode newNode = new DLNode(newEntry,head.next, head.previous);
		head = newNode;
		head.newData = newEntry;
		head.next = tempHead.next;
		head.previous = null;
		tempHead.newData = null;
		tempHead = null;
		if(isEmpty()) {
			tail = head;
		}
		back++;
		
		
		//create a new node
		//set it to the front of the line
		//fix all pointers 
		
		
	}

	@Override
	public void addToBack(T newEntry) {
		// TODO Auto-generated method stub
		DLNode tempTail = tail;
		DLNode newNode = new DLNode(newEntry, tail.next, tail.previous);
		tail = newNode;
		tail.newData = newEntry;
		tail.next = null;
		tail.previous = tempTail.previous;
		tempTail = null;
		if(isEmpty()) {
			head = tail;
		}
		back++;
		
		
		// create a new node
		//set it to the back of the line
		// fix all pointers
		
	}

	@Override
	public T removeFront() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
		T tempData = head.newData;
		DLNode tempHead = head;
		head = tempHead.next;
		head.newData = null;
		tempHead = null;
		head = head.next;
			if(head.next == head) {
			head.previous = null;
			}
			else {
				back--;
			}
		}
		
		
		//check if data is there, if not then throw an exception
		//hold data in a temporary value
		//delete data in DLNode(for security) set it to null
		//move head pointer to next
		//ONLY if there is a DLNode node the head is pointing to set its previous to null
		
		return head.newData;
	}

	@Override
	public T removeBack() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			T tempData = tail.newData;
			DLNode tempTail = tail;
			tail = tempTail.previous;
			tail.newData = null;
			tempTail = null;
			tail = tail.previous;
				if(tail.previous == tail) {
					tail.next = null;
				}
				else {
					back--;
				}
		}
		//check if data is there
		//hold data in a temporary value
		//delete data in DLNode(for security) set it to null
		//move tail pointer to previous
		//ONLY if there is a DLNode the tail is pointing to then move the next to null
		
		return tail.newData;
	}

	@Override
	public T getFront() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new EmptyQueueException();
		}
		else 
			return head.newData;
		
		
	}

	@Override
	public T getBack() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new EmptyQueueException();
			}
		else
		return tail.newData;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		boolean empty = false; 
		if(back == 0)
			empty = true;
		return empty;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		while(head.next != null) {
			DLNode tempNode = head;
			T tempData = head.newData;
			head = tempNode.next;
			head.newData = null;
			tempNode = null;
			head = head.next;
			}
		back = 0;
		
	}
	
	
	
	

}
