package Alibaba;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import Alibaba.CartesianProduct.recursiveCartesianProduct;


public class CartesianProductTest {

	@Test
	public void testRecursive() {
		Set<Integer> set1 = new HashSet<Integer>();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		Set<String> set2 = new HashSet<String>();
		set2.add("a");
		set2.add("b");
		set2.add("c");
		Set<Character> set3 = new HashSet<Character>();
		set3.add('x');
		set3.add('y');
		
		recursiveCartesianProduct rcp = new recursiveCartesianProduct();
		
		Set<Set<Object>> res = rcp.cartesianProduct(set1, set2, set3);
		
		HashMap<Object, Integer> hm = new HashMap<Object, Integer>();
		
		for(Set<?> set : res) {
			for(Object item : set) {
				hm.getOrDefault(item, 0);
			}
		}
		
		assertEquals(hm.get(1), hm.get(2));
		assertEquals(hm.get('x'), hm.get('y'));
		assertEquals(hm.get(1), hm.get('x'));
	}
	
//	@Test
//	public void testIterative() {
//		Set<Integer> set1 = new HashSet<Integer>();
//		set1.add(1);
//		set1.add(2);
//		set1.add(3);
//		Set<String> set2 = new HashSet<String>();
//		set2.add("a");
//		set2.add("b");
//		set2.add("c");
//		Set<Character> set3 = new HashSet<Character>();
//		set3.add('x');
//		set3.add('y');
//		
//		CartesianProduct cp = new CartesianProduct();
//		
//		Set<Set<Object>> res = cp.cartesianProduct(set1, set2, set3);
//		
//		HashMap<Object, Integer> hm = new HashMap<Object, Integer>();
//		
//		for(Set<?> set : res) {
//			for(Object item : set) {
//				hm.getOrDefault(item, 0);
//			}
//		}
//		
//		assertEquals(hm.get(1), hm.get(2));
//		assertEquals(hm.get('x'), hm.get('y'));
//		assertEquals(hm.get(1), hm.get('x'));
//	}

}
