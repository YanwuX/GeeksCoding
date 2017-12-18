package UberSayGoodBye;

import java.util.Date;

public class RateNode {
	
    private long time = 0;
    private RateNode next = null;

	public RateNode() {
    	time = new Date().getTime();
    }
    
    public RateNode (long time) {
        this.time = time;
    }

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
    
    public RateNode getNext() {
		return next;
	}

	public void setNext(RateNode next) {
		this.next = next;
	}
}
