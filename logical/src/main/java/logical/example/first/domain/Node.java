package logical.example.first.domain;

public class Node {

	private Node leftChild = null;
	private Node rightChild = null;
	private boolean isGoalNode = false;
	private String name;
    
    public Node(String name, Node left, Node right, boolean isGoalNode) {
        this.name = name;
        leftChild = left;
        rightChild = right;
        this.isGoalNode = isGoalNode;
    }

	public Node getLeftChild() {
		return leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public boolean isGoalNode() {
		return isGoalNode;
	}

	public String getName() {
		return name;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public void setGoalNode(boolean isGoalNode) {
		this.isGoalNode = isGoalNode;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    

}
