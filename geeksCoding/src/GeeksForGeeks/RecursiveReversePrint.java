package GeeksForGeeks;

/**
 * Created by Yanwu_Alienware on 2017/3/2.
 */
public class RecursiveReversePrint {

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public static void recursivePrint(Node node) {
		if (node == null)
			return;
		if (node.next != null)
			recursivePrint(node.next);
		System.out.print(node.data + " ");
	}

	public static void main(String args[]) {
		Node node = new Node(1);
		node.next = new Node(2);
		Node head = node;
		node = node.next;
		node.next = new Node(3);
		node = node.next;
		node.next = new Node(4);

		recursivePrint(head);
	}
}
