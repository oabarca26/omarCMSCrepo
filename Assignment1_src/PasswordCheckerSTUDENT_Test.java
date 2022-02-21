
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * 
 * @Author Omar Abarca
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwords;
	@Before
	public void setUp() throws Exception {
		String[] password = { "omarabarca", "Washington26", "CMSC", "COMMANDERS"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(password));
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;

	}

	@Test
	public void testIsValidPasswordTooShort() {
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("panda"));
		}
		catch(LengthException e)
		{
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
			System.out.println("line 43");
		}
	}

	@Test
	public void testIsValidPasswordNoUpperAlpha() {
		try {
			PasswordCheckerUtility.isValidPassword("omarramo");
		} 
		catch (NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaException", true);
		} 
		catch (Exception e) {
			assertTrue("Threw a different exception instead of NoUpperAlphaException", false);
			System.out.println("line 64");
		}
	}
	
	@Test
	public void testIsValidPasswordNoLowerAlpha() {
		try {
			PasswordCheckerUtility.isValidPassword("MICHAEL");
		} 
		catch (NoLowerAlphaException e) {
			assertTrue("Successfully threw a NoLowerAlphaException", true);
		} 
		catch (Exception e) {
			assertTrue("Threw a different exception instead of NoLowerAlphaException", false);
			System.out.println("line 83");
		}
	}

	@Test
	public void testIsWeakPassword() {
		try {
			assertEquals(true, PasswordCheckerUtility.isValidPassword("Washington@21"));
		} catch (Exception e) {
			assertTrue("Wrong exception thrown", false);
		}
	}

	@Test
	public void testIsValidPasswordInvalidSequence() {
		try {
			PasswordCheckerUtility.isValidPassword("Commanders@26");
		} 
		catch (InvalidSequenceException e) {
			assertTrue("Successfully threw a InvalidSequenceException", true);
		} 
		catch (Exception e) {
			assertTrue("Threw a different exception instead of InvalidSequenceException", false);
			System.out.println("line 117");
		}
	}

	@Test
	public void testIsValidPasswordNoDigit() {
		try {
			PasswordCheckerUtility.isValidPassword("Maryland");
		} 
		catch (NoDigitException e) {
			assertTrue("Successfully threw a NoDigitException", true);
		} 
		catch (Exception e) {
			assertTrue("Threw a different exception instead of NoDigitException", false);
			System.out.println("line 135");
		}
	}

	/**
	 * Test correct passwords This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful() {
		try {
			PasswordCheckerUtility.isValidPassword("Spoderman@812");
			assertTrue("No exceptions thrown", true);		
		} catch (Exception e) {
			assertTrue("Should not have thrown any exceptions", false);
		}
	}

	@Test
	public void testInvalidPasswords() {
		ArrayList<String> myResult;
		myResult = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertEquals(myResult.size(), 4);
		assertEquals(myResult.get(0), "0 The password must include an uppercase character.");
		assertEquals(myResult.get(1), "1 The password must include a special character.");
		assertEquals(myResult.get(2), "2 The password must be at least 6 characters long.");
		assertEquals(myResult.get(3), "3 The password must include an lowercase character.");
	}

}