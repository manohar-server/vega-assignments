package logical.example.main;

import logical.example.first.domain.Node;

public class FirstLogicalExample {

	private static Node makeBinaryTree() {
		Node root, a, b, c, d, e, f;
		c = new Node("C", null, null, false);
		d = new Node("D", null, null, false);
		e = new Node("E", null, null, true);
		f = new Node("F", null, null, false);
		a = new Node("A", c, d, false);
		b = new Node("B", e, f, false);
		root = new Node("Root", a, b, false);
		return root;
	}

	private static boolean solvable(Node node) {
		
		if (node == null){
			return false;
		}
		
		if (node.isGoalNode()){
			return true;
		}
		
		if (solvable(node.getLeftChild())){
			return true;
		}
		
		if (solvable(node.getRightChild())){
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		Node rootNode = makeBinaryTree();
		System.out.println(solvable(rootNode));
	}

}
