/**
 * @author Omar Abarca
 */
import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{

	private TreeNode<String> root = null;
	String letter = "";
	
	public MorseCodeTree() {
		buildTree();
	}
	
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<>(newNode);
	}

	@Override
	public LinkedConverterTreeInterface<String> insert(String code, String result) {
		addNode(root, code, result);
		return this;
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		if(code.length() == 1) {
			if(code.equals(".")) {
				root.setLeftChild(new TreeNode<>(letter));
			}
			else if(code.equals("-")) {
				root.setRightChild(new TreeNode<>(letter));
			}
		}
		else if(code.length() > 1) {
			if(code.charAt(0) == '.') {
                addNode(root.getLeftChild(), code.substring(1), letter);
			}
			else if(code.charAt(0) == '-') {
                addNode(root.getRightChild(), code.substring(1), letter);
			}
		}
	}

	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
        if (code.length() == 1){
            if (code.equals(".")) {
            	letter = root.getLeftChild().getData();
            }
            else if (code.equals("-")) {
            	letter = root.getRightChild().getData();
            }
        }
        else if (code.length() > 1) {
            if (code.charAt(0) == '.') {
                fetchNode(root.getLeftChild(), code.substring(1));
            }
            else if (code.charAt(0) == '-') {
                fetchNode(root.getRightChild(), code.substring(1));
            }
        }
        return letter;
	}

	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Not supported yet");
	}

	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Not supported yet");
	}

	@Override
	public void buildTree() {
		 root = new TreeNode<String>("");
	        insert(".", "e");
	        insert("-", "t");
	        insert("..", "i");
	        insert(".-", "a");
	        insert("-.", "n");
	        insert("--", "m");
	        insert("...", "s");
	        insert("..-", "u");
	        insert(".-.", "r");
	        insert(".--", "w");
	        insert("-..", "d");
	        insert("-.-", "k");
	        insert("--.", "g");
	        insert("---", "o");
	        insert("....", "h");
	        insert("...-", "v");
	        insert("..-.", "f");
	        insert(".-..", "l");
	        insert(".--.", "p");
	        insert(".---", "j");
	        insert("-...", "b");
	        insert("-..-", "x");
	        insert("-.-.", "c");
	        insert("-.--", "y");
	        insert("--..", "z");
	        insert("--.-", "q");
	}

	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> treeArray = new ArrayList<>();
        LNRoutputTraversal(root, treeArray);
        return treeArray;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		   if (root != null)
		   {
			  LNRoutputTraversal(root.getLeftChild(), list);
		      list.add(root.getData());
		      LNRoutputTraversal(root.getRightChild(), list);
		   } 
	}


}
