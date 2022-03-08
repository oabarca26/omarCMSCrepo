//Omar Abarca
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortedDoubleLinkedList_STUDENT_Test {
	StringComparator comparator;
	SortedDoubleLinkedList<String> sortedVeggieLinked;
	

	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		sortedVeggieLinked = new SortedDoubleLinkedList<String>(comparator);
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		sortedVeggieLinked = null;
	}

	@Test
	public void testAddToEndSTUDENT() {
		try {
			sortedVeggieLinked.addToEnd("Artichoke");
		}
		catch (UnsupportedOperationException e)
		{
			assertEquals(e.getMessage(), "Invalid operation for sorted list");
		}
	}

	@Test
	public void testAddToFrontSTUDENT() {
		try {
			sortedVeggieLinked.addToFront("Broccoli");
		}
		catch (UnsupportedOperationException e)
		{
			assertEquals(e.getMessage(), "Invalid operation for sorted list");
		}
	}

	@Test
	public void testAdd_STUDENT() {
		sortedVeggieLinked.add("Carrot"); 
		sortedVeggieLinked.add("Daikon"); 
		sortedVeggieLinked.add("Endive"); 
		assertEquals(new String("Carrot"), sortedVeggieLinked.getFirst());
		assertEquals(new String("Endive"), sortedVeggieLinked.getLast());
	}
	
	@Test
	public void testRemoveMiddle_STUDENT() {
		sortedVeggieLinked.add("Ginger");
		sortedVeggieLinked.add("Horseradish"); 
		assertEquals(new String("Ginger"), sortedVeggieLinked.getFirst());
		assertEquals(new String("Horseradish"), sortedVeggieLinked.getLast());
		sortedVeggieLinked.add("Fennel"); 
		assertEquals(3,sortedVeggieLinked.getSize());
		sortedVeggieLinked.remove("Ginger", comparator);
		assertEquals(new String("Fennel"), sortedVeggieLinked.getFirst());
		assertEquals(new String("Horseradish"), sortedVeggieLinked.getLast());
		assertEquals(2,sortedVeggieLinked.getSize());
        }

	
	private class StringComparator implements Comparator<String>
	{
		@Override
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
		
	}
}