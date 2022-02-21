//Omar Abarca
//CMSC 204
public class NoUpperAlphaException extends Exception {
	public NoUpperAlphaException() {
		super("The password must include an uppercase character.");
	}
}
