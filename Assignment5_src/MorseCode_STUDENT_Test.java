/**
 * @author Omar Abarca
 */
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCode_STUDENT_Test {
	File inputFile;
	MorseCodeTree morseTree = new MorseCodeTree();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFetch() {
		assertEquals(morseTree.fetch(".-"),"a");
		assertEquals(morseTree.fetch("-..."), "b");
		assertEquals(morseTree.fetch("-.-."),"c");	
		assertEquals(morseTree.fetch("-..-"),"x");
		assertEquals(morseTree.fetch("-.--"), "y");
		assertEquals(morseTree.fetch("--.."),"z");	
	}
	
	@Test
	public void testConvertToEnglishString() {
		String converter1 = MorseCodeConverter.convertToEnglish(".... . .-.. .--. / -- . ");
		assertEquals("help me",converter1);
		String converter2 = MorseCodeConverter.convertToEnglish(".. / .- -- / ... - ..- -.-. -.- ");
		assertEquals("i am stuck",converter2);
		String converter3 = MorseCodeConverter.convertToEnglish(".. -. / - .... . / -.-. --- -- .--. ..- - . .-. ");
		assertEquals("in the computer",converter3);
	}

	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {
		String test1="how do i love thee let me count the ways";		
		getFile("howDoILoveThee.txt");
		String converter1 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test1,converter1);
		
		String test2="love looks not with the eyes but with the mind";		
		getFile("LoveLooksNot.txt");
		String converter2 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test2,converter2);

	}
	
	public void getFile(String in) throws FileNotFoundException {		
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if(status == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inputFile = chooser.getSelectedFile();
				// readFile();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
