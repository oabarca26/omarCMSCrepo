//Omar Abarca
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
	public Node head = null;
	public Node tail = null;
	int finalsize = 0;
	
	@Override
	public ListIterator<T> iterator()  throws UnsupportedOperationException,NoSuchElementException {
		return new iterator();
	}
	
	public int getSize() {
		return finalsize;
	}

	public BasicDoubleLinkedList<T> addToEnd(T data){
		Node newNode = new Node(data);

		if (finalsize == 0) 
		{
			head = newNode;
			tail = newNode;
		} 
		
		else 
		{
			tail.next = newNode;
			newNode.previous = tail;
			tail = newNode;
		}
		finalsize++;
		return this;	
	}

	public BasicDoubleLinkedList<T> addToFront(T data){
		Node newNode = new Node(data);
		
		if(finalsize == 0) 
		{
			head = newNode;
			tail = head;
		}
		else 
		{
			head.previous = newNode;
			newNode.next = head;
			head = newNode;
		}
		finalsize++;
		return this;
		
	}

	public T getFirst() {
		return head.data;
	}
	
	public T getLast(){
		return tail.data;
	}
	
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator ){
		Node target = head;
		while(target != null) {
			if (comparator.compare(target.data, targetData) == 0) {
				if(target == head) {
					target = target.next;
					head = target;
					target.previous = null;
				}
				else if (target == tail) {
					target = target.previous;
					tail = target;
					target.next = null;
				}
				else {
				target.previous.next = target.next;
				target.next.previous = target.previous;
				target.next = null;
				target.previous = null;
				target = null;
				}
			}
			else
				target = target.next;
		}
		finalsize--;
		return this;
	}
	
	public T retrieveFirstElement() {
		if(finalsize == 0)
			return null;
		
		T element = head.data;
		head = head.next;
		head.previous = null;
		finalsize--;
		
		return element;		
	}

	public T retrieveLastElement() {
		if(finalsize == 0)
			return null;
		
		T element = tail.data;
		tail = tail.previous;
		tail.next = null;
		finalsize--;
		
		return element;
	}
	
	public ArrayList<T> toArrayList() {
		ArrayList<T> array = new ArrayList<T>();
		
		Node target = head;
		while(target != null) {
			array.add(target.data);
			target = target.next;
		}
		return array;
	}
	
	protected class Node{
		T data = null;
		Node next = null;
		Node previous = null;
	
	protected Node(T data, Node nextNode, Node previous) {
		this.data = data;
		next = nextNode;
		this.previous = previous;
	}
	
	protected Node(T data) {
		this(data,null,null);
	}	
	}
	
	protected class iterator implements ListIterator<T>{
		Node pointer;
		
		protected iterator() {
			pointer = new Node (null,head,null);
		}
		
		@Override
		public boolean hasNext() {

			return pointer.next != null;
		}

		@Override
		public T next() {
		if (!hasNext()) 
		{
            throw new NoSuchElementException();
        } 
		else 
		{
            pointer = pointer.next;
            return pointer.data;
        }
        }
		
		@Override
		public boolean hasPrevious() {
			return pointer.data != null;
		}
		   
		@Override
		public T previous() { 
			if (hasPrevious()) {
				T data = pointer.data; 
				if(pointer==head) {
					pointer = new Node(null,pointer,null);
				}else
					pointer = pointer.previous;
				return data;
			 }
			 else 
				 throw new  NoSuchElementException ();
		}

		   @Override
	        public void set(T e)throws UnsupportedOperationException {
	            throw new UnsupportedOperationException(); 
	        }

	        @Override
	        public void add(T e)throws UnsupportedOperationException {
	            throw new UnsupportedOperationException(); 
	        }
			@Override
			public void remove() throws UnsupportedOperationException{
				throw new UnsupportedOperationException();
				
			}
	        @Override
	        public int nextIndex() throws UnsupportedOperationException {
	            throw new UnsupportedOperationException();
	        }

	        @Override
	        public int previousIndex() throws UnsupportedOperationException {
	            throw new UnsupportedOperationException();
	        }

	}//end inner Iterator
}