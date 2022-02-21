//Omar Abarca
import java.util.ArrayList;

public class NotationStack<T> implements StackInterface<T>{
	int count = 0;
	int finalsize;
	T[] basicStack;
	
	public NotationStack()
	{
		finalsize= 10;
		basicStack = (T[]) new Object[finalsize];
		count = 0;
	}
	
	public NotationStack(int size)
	{
		basicStack = (T[]) new Object[size];
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
	public T pop() throws StackUnderflowException {
		T element;
		if (!isEmpty()) {
			element = basicStack[count-1];
			basicStack[count-1] = null;
			count--;
			return element;
		} 
		else
			throw new StackUnderflowException();
	}

	@Override
	public T top() throws StackUnderflowException {
		if (!isEmpty()) 
		return basicStack[count - 1];
		else
			throw new StackUnderflowException();
	}

	@Override
	public boolean push(T e) throws StackOverflowException {
		if (!isFull())
		  {
	            basicStack[count++] = e;
	            return true;
		  }
		else
			 throw new StackOverflowException();
	}
	
	@Override
	public int size() {
		return count;
	}

	@Override
	public String toString() {
		String elements = "";
		for (T e : basicStack) {
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
				return elements + basicStack[i];

			elements += basicStack[i] + delimiter;

			}
		return elements;
	}

	@Override
	public void fill(ArrayList<T> list){
		basicStack = (T[]) new Object[list.size()];
		count = 0;
		for (int i = 0; i < list.size(); i++) {
			basicStack[i] = (T) list.get(i);
			count++;
		}
	}

}
