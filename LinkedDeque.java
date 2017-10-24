package inclass.oct;

public class LinkedDeque<T> implements DequeInterface<T> {

	private Node head;
	private Node tail;
	private int front;
	private int back;
	
	private class Node{
		private Node next;
		private T newData;
		
		public Node() {
			next = null;
			newData = null;
		}
		
		@SuppressWarnings("unchecked")
		public Node(Node nextAdr, T data) {
			this.next = nextAdr;
			data = (T) new Object();
			this.newData = data;
		}
	}
	
	public LinkedDeque() {
		head = null;
	}
	
	public LinkedDeque(Node node, int initialCapacity) {
		back = initialCapacity;
		front = 0;
	}
	
	@Override
	public void addToFront(T newEntry) {
		// TODO Auto-generated method stub
		Node newNode = new Node(head.next, newEntry);
		Node tempHead = head;
		T tempData = head.newData;
		head.newData = newEntry;
		head.next = tempHead.next;
		tempHead.next = null;
		tempData = null;
		if(isEmpty()) {
			tail = head;
		}
		back++;
		
	}

	@Override
	public void addToBack(T newEntry) {
		// TODO Auto-generated method stub
		Node tempTail = tail;
		Node newNode = new Node(tail.next, newEntry);
		T tempData = tail.newData;
		tail.newData = newEntry;
		tail.next = tempTail.next;
		tempTail.next = null;
		tempData = null;
		if(isEmpty()){
			head = tail;
		}
		back++;
		
	}

	@Override
	public T removeFront() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new EmptyQueueException();
		}
		Node tempHead = head;
		head = tempHead.next;
		tempHead.newData = null;
		tempHead = null;
		
		return head.newData;
	}

	@Override
	public T removeBack() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new EmptyQueueException();
		}
		Node tempTail = tail;
		tail = tempTail.next;
		tempTail.newData = null;
		tempTail = null;
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
		while(head.next == null) {
			Node tempNode = head;
			T tempData = head.newData;
			head = tempNode.next;
			head.newData = null;
			tempNode = null;
			head = head.next;
			
			
		}
		
		
	}
	
	

}
