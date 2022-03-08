//Omar Abarca
import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

    protected Comparator<T> comparator = null;

    public SortedDoubleLinkedList(Comparator<T> comparator) {
       this.comparator = comparator;
    }

    public SortedDoubleLinkedList<T> add(T data) {
        if (finalsize == 0) 
        {
            Node newNode = new Node(data);
            head = tail = newNode;
        } 
        else if (comparator.compare(head.data, data) > 0) 
        {
            Node newNode = new Node(data);
        	head.previous = newNode;
            newNode.next = head;
            head = newNode;
        } 
        else if (comparator.compare(tail.data, data) < 0) 
        {
            Node newNode = new Node(data);
        	tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } 
        else 
        {
            Node newNode = new Node(data);
            Node search = head;
            while (search != null) {
                if (comparator.compare(search.data, data) <= 0) {
                    Node before = search;
                    Node after = search.next;
                    after.previous = before.next = newNode;
                    newNode.next = after;
                    newNode.previous = before;   
                }
                search = search.next;
            }
        }
        
        finalsize++;
        return this;
    }
      
    @Override
    public BasicDoubleLinkedList<T> addToEnd(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }

    @Override
    public BasicDoubleLinkedList<T> addToFront(T data) {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }
   
    @Override
    public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
        return super.iterator();
    }

    @Override
    public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
        super.remove(data, comparator);
        return this;
    }
    
}