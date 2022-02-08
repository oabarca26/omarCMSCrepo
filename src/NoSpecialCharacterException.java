//Omar Abarca
//CMSC 204
public class NoSpecialCharacterException extends Exception {
	public NoSpecialCharacterException() {
		super("The password must include a special character.");
	}
}
