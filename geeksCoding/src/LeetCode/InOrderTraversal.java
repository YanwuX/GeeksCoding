package LeetCode;

public class InOrderTraversal {
	
	public static class Node {

		int val;
		Node right;
		Node left;
		
		public Node (int i) {
			val = i;
		}
		
	} 
	
	public static Node InOrderTraversalRecursive (Node root, Node result) {
		
		Node current;
		current = root;
		
		if (root == null) return null;
		
		InOrderTraversalRecursive(current.left, result.right);
		result = current;
		InOrderTraversalRecursive(current.right, result.right);
		return result;
	}

	public static void main(String[] args) {

		Node root = new Node(5);
		root.left = new Node(4);
		root.right = new Node(6);
		Node temp = root.left;
		temp.left = new Node(3);
		temp.right = new Node(2);
		temp.left.right = new Node(1);
		temp = root.right;
		temp.left = new Node(7);
		
		
		Node r = InOrderTraversalRecursive(root, new Node(0));
		System.out.println(r);
	}

}
