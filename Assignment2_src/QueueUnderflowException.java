public class QueueUnderflowException extends Exception {
	public QueueUnderflowException() {
		super("Enqueue method called on a full queue.");
	}
}
