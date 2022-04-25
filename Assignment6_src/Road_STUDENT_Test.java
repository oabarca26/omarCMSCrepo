/**
 * @author Omar Abarca
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test {

	Town town1;
	Town town2;
	Town town3;
	Town town4;

	Road road;
	Road road1;
	Road road2;
	Road road3;
	Road road4;
	
	@Before
	public void setUp() throws Exception {
		town1 = new Town("New York City");
		town2 = new Town("Los Angeles");
		town3 = new Town("Chicago");
		town4 = new Town("Houston");
		
		road = new Road(town1, town2, 6, "Phoenix");
		road1 = new Road(town1, town2, "1st St");
		road2 = new Road(town2, town3, "2nd St");
		road3 = new Road(town3, town4, "3rd St");
		road4 = new Road(town4, town3, "3rd St");
	}

	@After
	public void tearDown() throws Exception {
		town1 = null;
		town2 = null;
		town3 = null;
		town4 = null;
		
		road1 = null;
		road2 = null;
		road3 = null;
	}
	
	@Test
	public void testToString() {
		assertEquals("Road [source=" + road.getSource() + ", destination=" + 
	road.getDestination() + ", name=" + road.getName() + ", weight=" + road.getWeight()+ "]", road.toString());
	}
	
	@Test
	public void testGetName() {
		assertEquals("Phoenix", road.getName());
	}
	
	@Test
	public void testGetWeight() {
		assertEquals(road.getWeight(), 6);
	}
	
	@Test
	public void testGetSource() {
		assertEquals(road.getSource(), new Town("New York City"));
	}
	
	@Test
	public void testGetDestination() {
		assertEquals(road.getDestination(), new Town("Los Angeles"));
	}

	@Test
	public void testCompareTo() {
		assertEquals(1, road1.compareTo(road2));
		assertEquals(1, road2.compareTo(road3));
		assertEquals(0, road3.compareTo(road4));
	}

	@Test
	public void testContains() {
		assertTrue(road1.contains(town1));
		assertTrue(road2.contains(town2));
		assertFalse(road3.contains(town2));
	}

	@Test
	public void testEquals() {
		assertFalse(road1.equals(road2));
		assertFalse(road2.equals(road3));
		assertTrue(road3.equals(road4));
	}

}
