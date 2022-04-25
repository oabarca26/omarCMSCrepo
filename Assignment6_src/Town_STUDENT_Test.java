/**
 * @author Omar Abarca
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test {

	Town town1;
	Town town2;
	Town town3;
	Town town4;
	
	@Before
	public void setUp() throws Exception {
		town1 = new Town("New York City");
		town2 = new Town("Los Angeles");
		town3 = new Town(town2);
		town4 = new Town("Chicago");
	}

	@After
	public void tearDown() throws Exception {
		town1 = null;
		town2 = null;
		town3 = null;
		town4 = null;
	}
	
	@Test
	public void testGetName() {
		assertEquals("New York City", town1.getName());
		assertEquals("Los Angeles", town2.getName());
		assertEquals("Los Angeles", town3.getName());
		assertEquals("Chicago", town4.getName());
	}
	
	@Test
	public void testToString() {
		assertEquals("Town [name=" + town1.getName() + "]", town1.toString());
		assertEquals("Town [name=" + town2.getName() + "]", town2.toString());
		assertEquals("Town [name=" + town3.getName() + "]", town3.toString());
		assertEquals("Town [name=" + town4.getName() + "]", town4.toString());
	}

	@Test
	public void testCompareTo() {
		assertEquals(1, town1.compareTo(town2));
		assertEquals(0, town2.compareTo(town3));
		assertEquals(1, town3.compareTo(town4));
	}

	@Test
	public void testEquals() {
		assertFalse(town1.equals(town2));
		assertTrue(town2.equals(town3));
		assertFalse(town3.equals(town4));
	}
}
