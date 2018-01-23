package FunTryOuts;

import Util.ListNode;

public class ReverseLinkedList {
	
	public static ListNode reverseLinkedList(ListNode head) {
		
		if (head == null) {
			return new ListNode(0);
		}
		
		ListNode ret = null;
		while(head != null) {
			ListNode temp = head.getNext();
			head.setNext(ret);
			ret = head;
			head = temp;
				
		}
		return ret;
		
	}
	
	public static ListNode reverseLinkedListBetween(ListNode head, int start, int end) {
		if (head == null || start > end) {
			return new ListNode(0);
		}
		
		ListNode retNode = new ListNode(0);
		retNode.setNext(head);
		
		head = retNode;
		
		ListNode startNode;
		ListNode preStart;
		int counter = 0;
		while(head != null && counter < start) {
			head = head.getNext();
			counter ++;
		}
		
		preStart = head;
		startNode = head.getNext();
		ListNode endNode = startNode, postEnd = startNode.getNext();
		counter = start;
		while(startNode != null && counter < end) {
			ListNode temp = postEnd.getNext();
			postEnd.setNext(endNode);
			endNode = postEnd;
			postEnd = temp;
			counter ++;
		}
		startNode.setNext(postEnd);
		preStart.setNext(endNode);
		
		return retNode.getNext();
		
	}
	
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		
		a.setNext(b);
		b.setNext(c);
		c.setNext(d);
		d.setNext(e);
		System.out.println(a.toString());
		System.out.println(reverseLinkedList(a).toString());
		System.out.println(reverseLinkedListBetween(a, 1, 2));
	}

}
