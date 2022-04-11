/**
 * @author Omar Abarca
 */
public class TreeNode<T> {
	private T data;
	private TreeNode<T> leftChild;  
	private TreeNode<T> rightChild;
	
	/**
     * This constructor creates a default tree
     */
	public TreeNode(T dataNode) {
		 data = dataNode;
		 setLeftChild(null);
		 setRightChild(null);
	}
	
	/**
     * This constructor creates a deep copy of the default tree
     */
	public TreeNode(TreeNode<T> node) {
		data = node.data;
		setLeftChild(node.getLeftChild());
		setRightChild(node.getRightChild());
	}
	
	public T getData() {
		return data;
	}

	public TreeNode<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
}
