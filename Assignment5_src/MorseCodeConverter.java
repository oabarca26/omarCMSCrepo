/**
 * @author Omar Abarca
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeConverter {

	private static MorseCodeTree morseTree = new MorseCodeTree();
	
	   /**
     * This method prints out all of the nodes in the tree
     * @return the full tree
     */
	 public static String printTree() {
		 morseTree = new MorseCodeTree();
		    String printed = "";
		    for(String let: morseTree.toArrayList()){
		    	printed+= let += " ";
		    }
		    return printed.substring(0,printed.length()-1);
	    }
	 
	   /**
	     * This method converts Morse code to English
	     * @param code Morse code to be converted to english 
	     * @return text converted into english
	     */
	 public static String convertToEnglish(String code) {
		 String coverter = "";
			String[] array = code.split(" ");
			for (int i = 0; i < array.length;i++){
				if (array[i].contentEquals("/")){
					coverter += " ";
				}
				else{
					coverter += morseTree.fetch(array[i]);
				}		
			}
			return coverter;
	 }
	 
	   /**
	     * This method converts Morse code to English from a file
	     * @param codeFile Morse code to be converted to english
	     * @return text converted into english
	     */
	 public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		 Scanner readInput = new Scanner(codeFile);
	        String text = "";
	        while (readInput.hasNextLine()) {
	            text += readInput.nextLine();
	        }
	        readInput.close();
	        return convertToEnglish(text);
		 }
}
