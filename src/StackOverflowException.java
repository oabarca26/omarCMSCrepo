public class StackOverflowException extends Exception {
	public StackOverflowException() {
		super("Top or pop method called on an empty stack.");
	}
}
