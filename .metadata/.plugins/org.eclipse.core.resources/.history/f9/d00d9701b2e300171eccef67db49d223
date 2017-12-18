package UberSayGoodBye;

public class RateList {
	
	private int counter;
	
	RateNode firstNode;
    RateNode lastNode;
    
    public RateList() {
    	this.counter = 0;
    	this.firstNode = null;
    	this.lastNode = null;
    }
    
    public RateList(RateNode node) {
    	this.counter = 1;
    	this.firstNode = node;
    	this.lastNode = node;
    }
    
    public int size() {
    	return counter;
    }
    
    public void add(RateNode node) {
    	counter++;
    	if (firstNode == null) {
    		firstNode= node;
        	lastNode = firstNode;
    	}
    	lastNode.setNext(node);
		lastNode = lastNode.getNext();
    }
    
    public RateNode getFirst() {
    	if(firstNode != null) return firstNode;
    	return new RateNode();
    }
    
    public RateNode getLast() {
    	if(lastNode != null) return lastNode;
    	return new RateNode();
    }
}
