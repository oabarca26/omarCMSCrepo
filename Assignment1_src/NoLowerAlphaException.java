//Omar Abarca
//CMSC 204
public class NoLowerAlphaException extends Exception {
	public NoLowerAlphaException() {
		super("The password must include an lowercase character.");
	}
}
