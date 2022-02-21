//Omar Abarca
import java.util.ArrayList;

public class NotationQueue<T> implements QueueInterface<T>{
	int count = 0;
	int finalsize;
	T[] basicQueue;
	
	public NotationQueue()
	{
		finalsize= 10;
		basicQueue = (T[]) new Object[finalsize];
		count = 0;
	}
	
	public NotationQueue(int size)
	{
		basicQueue = (T[]) new Object[size];
		this.finalsize = size;
		count = 0;
	}
	
	@Override
	public boolean isEmpty() {
		if(count == 0)
			return true;
		return false;
	}

	@Override
	public boolean isFull() {
		if(count == finalsize)
			return true;
		return false;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		 if (!isEmpty()) {
	            T result = basicQueue[0];
	            for(int i = 1; i < count; i++) {
	            	basicQueue[i-1] = basicQueue[i];
	            }
	            count--;
	            return result;
	        }
		 else
			 throw new QueueUnderflowException();
	}
	
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		if (!isFull()) 
		{
            basicQueue[count++] = e;
            return true;
		}
		else
			throw new QueueOverflowException();
	}
	
	@Override
	public int size() {
		return count;
	}

	@Override
	public String toString() {
		String elements = "";
		for (T e : basicQueue) {
			if (e == null)
				return elements;
			elements += e;
		}
		return elements;
	}
	
	@Override
	public String toString(String delimiter) {
		String elements = "";
		
		for (int i = 0; i < size(); i++) {
			if (i == size() - 1)
				return elements + basicQueue[i];

			elements += basicQueue[i] + delimiter;

			}
		return elements;
	}


	@Override
	public void fill(ArrayList<T> list) {
		basicQueue = (T[]) new Object[list.size()];
		count = 0;
		for (int i = 0; i < list.size(); i++) {
			basicQueue[i] = (T) list.get(i);
			count++;
		}
	}
}
