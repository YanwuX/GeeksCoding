package funTryOuts;

public class IsBST {
	
	public class Node {
		private int value = 0;
		Node left;
		Node right;
	}
	
	public static boolean isBST(Node node) {
		if (node.left.value > node.value || node.right.value < node.value) return false;
		return isBST()
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
