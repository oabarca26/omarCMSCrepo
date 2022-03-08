//Omar Abarca
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BasicDoubleLinkedList_STUDENT_Test {
	BasicDoubleLinkedList<String> basicFruitLinked;

	@Before
	public void setUp() throws Exception {
		basicFruitLinked = new BasicDoubleLinkedList<String>();
		basicFruitLinked.addToEnd("Apple");
		basicFruitLinked.addToEnd("Banana");
		basicFruitLinked.addToEnd("Coconut");
	}

	@Test
	public void getSize() {
		assertEquals(3,basicFruitLinked.getSize());
	}
	
	@Test
	public void addToEnd(){
		assertEquals(new String("Coconut"), basicFruitLinked.getLast());
		basicFruitLinked.addToEnd("Date");
		assertEquals(new String("Date"), basicFruitLinked.getLast());
	}

	@Test
	public void addToFront(){
		assertEquals(new String("Apple"), basicFruitLinked.getFirst());
		basicFruitLinked.addToFront("Elderberry");
		assertEquals(new String("Elderberry"), basicFruitLinked.getFirst());
	}

	@Test
	public void getFirst(){
		assertEquals(new String("Apple"), basicFruitLinked.getFirst());
		basicFruitLinked.addToFront("Fig");
		assertEquals(new String("Fig"), basicFruitLinked.getFirst());
	}

	@Test
	public void getLast(){
		assertEquals(new String("Coconut"), basicFruitLinked.getLast());
		basicFruitLinked.addToEnd("Grape");
		assertEquals(new String("Grape"), basicFruitLinked.getLast());
	}
	

	@Test
	public void retrieveFirstElement(){
		assertEquals(new String("Apple"), basicFruitLinked.getFirst());		
		basicFruitLinked.addToFront("Honeydew");
		assertEquals(new String("Honeydew"), basicFruitLinked.retrieveFirstElement());
	}
	
	@Test
	public void retrieveLastElement(){
		assertEquals(new String("Coconut"), basicFruitLinked.getLast());
		basicFruitLinked.addToEnd("Imbe");
		assertEquals(new String("Imbe"), basicFruitLinked.retrieveLastElement());
	}
	
}