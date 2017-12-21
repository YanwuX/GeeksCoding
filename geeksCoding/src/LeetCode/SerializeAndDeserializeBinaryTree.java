package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

import Util.Node;

public class SerializeAndDeserializeBinaryTree {
	
	public static String serialize(Node root) {
		if (root == null) {
			return "";
		}
		StringBuilder result = new StringBuilder();
		Queue<Node> q = new LinkedList<Node>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			Node current = q.poll();
			if (current == null) {
				result.append("#");
				continue;
			}
			result.append(current.getValue());
			q.add(current.left);
			q.add(current.right);
			
		}
		return result.toString();
	}
	
	public static Node deserialize(String str) {
		if (str == null) {
			return new Node(0);
		}
		Queue<Node> q = new LinkedList<Node>();
		Node root = new Node(Character.getNumericValue(str.charAt(0)));
		
		q.add(root);
		
		for (int i = 1; i < str.length(); ++i) {
			Node current = q.poll();
			if (str.charAt(i) != '#') {
				Node left = new Node(Character.getNumericValue(str.charAt(i)));
				current.left = left;
				q.add(left);
			}
			if (str.charAt(i++) != '#') {
				Node right = new Node(Character.getNumericValue(str.charAt(i)));
				current.right = right;
				q.add(right);
			}
			
		}
		return root;
	}

	public static void main(String[] args) {
		Node root = new Node(0);
		root.left = new Node(1);
		root.right = new Node(2);
		root.right.left = new Node(3);
		root.right.right = new Node(4);
		root.right.right.left = new Node(5);
		String temp = serialize(root);
		System.out.println(temp);
		Node result = deserialize(temp);
		System.out.println(serialize(result));

	}

}
