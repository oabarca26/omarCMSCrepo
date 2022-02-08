//Omar Abarca
//CMSC 204
public class InvalidSequenceException extends Exception {
	public InvalidSequenceException() {
		super("The password should not contain more than 2 of the same character in sequence.");
	}
}
