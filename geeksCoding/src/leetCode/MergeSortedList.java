package leetCode;

/**
 * Created by Yanwu_Alienware on 2017/8/11.
 */
public class MergeSortedList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode r = new ListNode(0);

		if (l1 == null || l2 == null)
			return r;
		ListNode head = r;
		while (l1 != null || l2 != null) {
			if (l1 == null) {
				head.next = l2.next;
				l2 = l2.next;
				head = head.next;

				continue;
			}			
			if (l2 == null) {
				head.next = l1.next;
				l1 = l1.next;
				head = head.next;

				continue;
			}
			if (l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
				head = head.next;

				continue;
			}
			if (l1.val >= l2.val) {
				head.next = l2;
				l2 = l2.next;
				head = head.next;

				continue;
			}
		}
		return r.next;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(5);
		ListNode l4 = new ListNode(7);
		ListNode l5 = new ListNode(10);

		l1.next = l3;
		l2.next = l4;
		l4.next = l5;
		MergeSortedList sort = new MergeSortedList();
		ListNode r = sort.mergeTwoLists(l1, l2);
		while (r != null ) {
			System.out.println(r.val);
			r = r.next;
		}
	}
}
