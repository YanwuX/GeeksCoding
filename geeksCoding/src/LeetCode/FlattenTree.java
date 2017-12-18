package LeetCode;

public class FlattenTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private TreeNode prev = null;

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		flatten(root.right);
		flatten(root.left);
		root.right = prev;
		root.left = null;
		prev = root;
	}

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(2);
		root.left = new TreeNode(4);
		
		TreeNode temp = root.left;
		temp.left = new TreeNode(5);
		
		
		FlattenTree f = new FlattenTree();
		f.flatten(root);

	}

}
