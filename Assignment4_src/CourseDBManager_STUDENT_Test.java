/**
	 * @author Omar Abarca
	 */
import static org.junit.Assert.*;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface CDS = new CourseDBManager();


	@Before
	public void setUp() throws Exception {
		CDS = new CourseDBManager();
	}


	@After
	public void tearDown() throws Exception {
		CDS = null;
	}

	@Test
	public void testGet() {
		CDS.add("GYM100",01234,3,"GYM0","Broadway Joe");
		try {
		CDS.get(01234);
		}
		catch (Exception e) {
			fail("Should not have thrown an exception");
		}
		
	}

	@Test
	public void testAddToDB() {
		try {
			CDS.add("GYM101",12345,3,"GYM1","Johnny Football");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	

	@Test
	public void testShowAll() {
		CDS.add("GYM103",12345,3,"GYM3","Johnny Football");
		CDS.add("GYM101",23456,3,"GYM1","Magic Johnson");
		CDS.add("GYM104",34567,4,"GYM4","Penny Hardaway");
		CDS.add("GYM102",45678,4,"GYM2","Tiger Woods");
		ArrayList<String> list = CDS.showAll();

		assertEquals(list.get(0),"\nCourse:GYM101 CRN:23456 Credits:3 Instructor:Magic Johnson Room:GYM1");
		assertEquals(list.get(3),"\nCourse:GYM104 CRN:34567 Credits:4 Instructor:Penny Hardaway Room:GYM4");
			}

	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("GYM101 23456 3 GYM1 Magic Johnson");
			inFile.println("GYM102 45678 4 GYM2 Tiger Woods");
			inFile.println("GYM103 12345 3 GYM3 Johnny Football");
			inFile.print("GYM104 34567 4 GYM4 Penny Hardaway");
			
			inFile.close();
			CDS.readFile(inputFile);
			System.out.println(CDS.showAll());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
