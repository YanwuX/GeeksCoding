package Util;

public class ListNode {
	
	private int value;    
    private ListNode head;
    private ListNode next;


    public ListNode(int v) {
        this.value = v;
        head = this;
    }

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

    public int getValue() {
        return value;
    }
    
	public void setValue(int value) {
		this.value = value;
	}

	@Override
    public String toString() {
    	StringBuilder sb = new StringBuilder();
    	while(head != null) {
    		sb.append(head.value);
    		head = head.next;
    	}
    	return sb.toString();
    }
}
