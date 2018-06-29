package LeetCode;

import Util.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static ArrayList<ArrayList<Integer>> leverlOrderTraversal (Node root) {

	    ArrayList result = new ArrayList<>();

	    if (root == null) {
	        return result;
        }

        Queue<Node> q = new LinkedList<Node>();
	    q.offer(root);

	    while(!q.isEmpty()) {
	        ArrayList<Integer> level = new ArrayList<>();
	        int size = q.size();
	        for (int i = 0; i< size; ++i) {
	            Node head = q.poll();
	            level.add(head.getValue());
	            if (head.left != null) {
	                q.add(head.left);
                }
                if (head.right != null) {
	                q.add(head.right);
                }
            }
            result.add(level);
        }
        return result;
    }

	public static void main(String[] args) {

	}

}
