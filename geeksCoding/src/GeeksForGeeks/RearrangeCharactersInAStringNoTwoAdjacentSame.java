package GeeksForGeeks;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class RearrangeCharactersInAStringNoTwoAdjacentSame {

	public static String rearrangeCharacters(String s) {
		char[] c = s.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		
		for (char i : c) {
			if(!hm.containsKey(i)) hm.put(i, 1);
			else {
				hm.put(i, hm.get(i) + 1);
			}
		}
		
		@SuppressWarnings("unchecked")
		PriorityQueue<Entry<Character, Integer>> pq = new PriorityQueue<Entry<Character, Integer>>(s.length(), new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				@SuppressWarnings("unchecked")
				Entry<Character, Integer> e1 = (Entry<Character, Integer>) o1, e2 = (Entry<Character, Integer>) o2;
				if(e1.getValue() > e2.getValue()) return -1;
				if(e1.getValue() == e2.getValue()) return 0;
				return 1;
			}
		});
		
		for (Entry<Character, Integer> e : hm.entrySet()) {
			pq.add(e);
		}
		
		StringBuilder sb = new StringBuilder();
		
		while (!pq.isEmpty()) {
			Entry<Character, Integer> e1 = pq.poll();
			sb.append(e1.getKey());
			Entry<Character, Integer> e2 = pq.poll();
			if (e1.getValue() > 0) {
				e1.setValue(e1.getValue() - 1);
				pq.add(e1);
			}
			if (e2 != null) {
				sb.append(e2.getKey());

				if (e2.getValue() > 0) {
					e2.setValue(e2.getValue() - 1);
					pq.add(e2);
				}
			}
		}
		
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(rearrangeCharacters("aaabb"));

	}

}
