package LeetCode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {
	
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    
    public LRU(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 1.0f, true){
        	@Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
        	    return size() > CAPACITY;
            }
        };
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void add(int key, int value) {
        map.put(key, value);
    }

	public static void main(String[] args) {

		LRU lru = new LRU(5);
		lru.add(1, 1);
		lru.add(2, 2);
		lru.add(3, 3);
		lru.add(4, 4);
		lru.add(5, 5);
		lru.add(6, 6);
		lru.add(5, 3);
		lru.add(5, 5);
		lru.get(5);
		lru.get(3);
		lru.get(10);
	}

}
