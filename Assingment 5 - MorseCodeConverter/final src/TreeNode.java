 /**
 * The external Tree Node for Linked Trees
 * @author willbyrne
 *
 */
public class TreeNode<T> {
	//Required fields for treeNode class
	private T data;
	private TreeNode<T> childLeft;
	private TreeNode<T> childRight;
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode - the data to be stored in the TreeNode
	 */
	public TreeNode(T dataNode){
		this.data = dataNode;
		this.childLeft = null;
		this.childRight = null;
	}
	
	/**
	 * used for making deep copies
	 * @param node - node to make copy of
	 */
	public TreeNode(TreeNode<T> node) {
		this.data = node.data;
		this.childLeft = node.childLeft;
		this.childRight = node.childRight;
	}
	
	public TreeNode() {
		data = null;
		childLeft = null;
		childRight = null;
	}
	
	/**
	 * Return the data within this TreeNode
	 * @return the data within the TreeNode
	 */
	public T getData() {
		return data;
	}
	
	public void setData(T dataNode) {
		this.data = dataNode;
	}
	
	public void setChildLeft(TreeNode<T> childLeft) {
		this.childLeft = childLeft;
	}
	
	public void setChildRight(TreeNode<T> childRight) {
		this.childRight = childRight;
	}
	
	public TreeNode<T> getChildLeft() {
		return childLeft;
	}
	
	public TreeNode<T> getChildRight() {
		return childRight;
	}
	

}
