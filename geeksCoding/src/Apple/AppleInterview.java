package Apple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class AppleInterview<K, V> {

	private HashMap<K, Pair> hm = new HashMap<>();
	private ArrayList<K> list = new ArrayList<>();

	public AppleInterview() {

	}

	@SuppressWarnings("unchecked")
	public V get(K key) {
		return (V) hm.get(key).getO1();
	}

	public void put(K key, V value) {
		int index = 0;
		if (!hm.containsKey(key)) {
			list.add(key);
			index = list.size() - 1;
		} else {
			index = (int) hm.get(key).getO2();
		}
		hm.put(key, new Pair(value, index));
	}

	public void delete(K key) {
		listDelete(key);
		hm.remove(key);

	}

	public K getRandomKey() {
		Random rd = new Random();
		int random = rd.nextInt(list.size());
		return list.get(random);
	}

	private void listDelete(K key) {

		K lastKey = list.get(list.size() - 1);

		int index = (int) hm.get(key).getO2(); // here
		hm.put(lastKey, new Pair(hm.get(lastKey).getO1(), index));
		list.set(index, lastKey);
		hm.remove(key);
		list.remove(list.size() - 1);

	}

	public static void main(String[] args) {

		AppleInterview<Integer, Integer> a = new AppleInterview<Integer, Integer>();
		a.put(1, 1);
		a.put(2, 2);
		a.put(3, 3);
		a.put(4, 4);
		a.put(5, 5);

		System.out.println(a.getRandomKey());
		a.put(3, 100);
		System.out.println(a.get(3));
		a.delete(3);
	}

}