public class StackUnderflowException extends Exception {
	public StackUnderflowException() {
		super("Push method called on a full stack.");
	}
}
