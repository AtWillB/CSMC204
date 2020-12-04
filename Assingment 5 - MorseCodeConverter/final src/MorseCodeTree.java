import java.util.ArrayList;
/**
 * This is a MorseCodeTree which is specifically used for the conversion of morse code to english. 
 * It relies on a root (reference to root of the tree).
 * The root is set to null when the tree is empty. 
 * The class uses an external generic TreeNode class which consists of a reference to the data and a reference to the left and right child. 
 * The TreeNode is parameterized as a String, TreeNode 
 * This class uses a private member root (reference to a TreeNode) 
 * The constructor will call the buildTree method
 * @author willbyrne
 *
 */

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	private TreeNode<String> root;
	
	/**
	 * calls the buildTree method
	 */
	public MorseCodeTree() {
		root = new TreeNode<String>("");
		buildTree();
	}
	
	/**
	 * returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return root;
	}
	
	/**
	 * sets the root of the MorseCodeTree
	 * @param new Node - a copy if newNode will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String>newNode) {
		this.root = newNode;
	}

	/**
	 * Adds element to the correct position in the tree based on the code 
	 * This method will call the recursive method addNode
	 * @param code - the code for the new node to be added
	 * @param letter - the letter for the corresponding code
	 * @return the MorseCodeTree with the new node added
	 */
	@Override
	public MorseCodeTree insert(String code, String letter) {
		addNode(this.root, code, letter);
		return this;
	}

	/**
	 * This is a recursive method that adds element to the correct position in the tree based on the code
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @param letter - the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		TreeNode<String> current = root;
		
	
		if (code.length() == 1) {
			
			if (code.equals(".")) {
				current.setChildLeft(new TreeNode<String>());
				current = current.getChildLeft();
			}
			else if(code.equals("-")) {
				current.setChildRight(new TreeNode<String>());
				current = current.getChildRight();
			}
			current.setData(letter);
			return;
		}
		
		if (code.length() > 1) {
			if (code.charAt(0) == '.') {
				current = current.getChildLeft();
			}
			if(code.charAt(0) == '-') {
				current = current.getChildRight();
			}
			
			
			
			String newCode = code.substring(1);
			addNode(current, newCode, letter);
		}
	}

	/**
	 * Fetch the data in the tree based on the code 
	 * This method will call the recursive method fetchNode
	 * @param code - the code that describes the traversals to retrieve tbe string (letter)
	 * @return the string that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		return fetchNode(this.root, code);
	}

	/**
	 * his is the recursive method that fetches the data of the TreeNode that corresponds with the code 
	 * A '.' (dot) means traverse to the left. 
	 * A "-" (dash) means traverse to the right.
	 * @param root - the root of the tree for this particular recursive instance of addNode
	 * @param code - the code for this particular recursive instance of addNode
	 * @return the string corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		TreeNode<String> current = root;
		String newCode = null;
		
		if (code.length() == 1) {
			
			if (code.equals(".")) {
				current = current.getChildLeft();
			}
			else if(code.equals("-")) {
				current = current.getChildRight();
			}
			 return current.getData();	
		}
		
		if (code.length() > 1) {
			if (code.charAt(0) == '.') {
				current = current.getChildLeft();
			}
			if(code.charAt(0) == '-') {
				current = current.getChildRight();
			}
			
			newCode = new String(code.substring(1));
		}
		
			return fetchNode(current, newCode);
	}

	@Override
	public MorseCodeTree delete(String data) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MorseCodeTree update() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * This method builds the MorseCodeTree by inserting the nodes of the tree level by level based on the code
	 */
	@Override
	public void buildTree() {
		//root = "" - level 0
		insert(".", "e");
		insert("-", "t");// end of level 1
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m"); // end of level 2
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o"); // end of level 3 
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

	/**
	 * Returns an ArrayList of the items in the linked Tree in LNR (Inorder) Traversal order 
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in  the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		LNRoutputTraversal(this.root, list);
		return list;
	}

	/**
	 * The recursive method to put the contents of the tree in an ArrayList in LNR (Inorder)
	 * @param root - the root of the tree for this particular recursive instance
	 * @param list - the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root == null) {
					return;
		}
		LNRoutputTraversal(root.getChildLeft(), list);
		list.add(root.getData());
		LNRoutputTraversal(root.getChildRight(), list);
	}

}
