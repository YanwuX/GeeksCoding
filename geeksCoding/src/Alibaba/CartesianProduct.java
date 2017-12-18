package Alibaba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/***
 * This class is used for interview at Alibaba. The act of this class is to
 * produce the Cartesian Product of given input
 * 
 * @author Yanwu
 * @param <T>
 *            generic type
 *
 */
public class CartesianProduct<T> {
	/***
	 * A inner class way to get Cartesian Product.
	 * @author Yanwu
	 *
	 */
	public final static class recursiveCartesianProduct {
		public static Set<Set<Object>> cartesianProduct(Set<?>... sets) {
			return cartesianProduct(Arrays.asList(sets));
		}

		public static Set<Set<Object>> cartesianProduct(List<Set<?>> sets) {
			if (sets.size() < 2) {
				// we can either throw exception
				// Or, we can return the original input

				throw new IllegalArgumentException("not enough arguments");
			}

			return CartesianSet.create(0, sets);
		}
		
		// using inner class to create the Cartesian Product
		// the recursive way is easy to read, but may cause 
		// stack overflow error
		// O(n^2) complexity and O(n^2) space
		private final static class CartesianSet<T> {

			static Set<Set<Object>> create(int index, List<Set<?>> sets) {
				Set<Set<Object>> ret = new HashSet<Set<Object>>();
				if (index == sets.size()) {
					ret.add(new HashSet<Object>());
				} else {
					for (Object obj : sets.get(index)) {
						for (Set<Object> set : create(index + 1, sets)) {
							set.add(obj);
							ret.add(set);
						}
					}
				}
				return ret;
			}

		}
	}
	
	
	/***
	 * normal iterative way to get CartesianProduct 
	 * this way avoids the stack overflow error.
	 * and its O(n^2) complexity
	 * with O(n) space
	 * @param sets
	 * @return
	 */
	public <T> List<Set<T>> cartesianProduct(Set<T>... sets) {
		return cartesianProduct(Arrays.asList(sets));
	}
	/***
	 * normal iterative way to get CartesianProduct
	 * @param list
	 * @return
	 */
	public <T> List<Set<T>> cartesianProduct(List<Set<T>> sets) {
		if (sets.size() < 2) {
			// we can either throw exception
			// Or, we can return the original input

			throw new IllegalArgumentException("not enough arguments");
		}
		
		List<Iterator<T>> iterators = new ArrayList<Iterator<T>>(sets.size());
		List<T> items = new ArrayList<T>(sets.size());
		List<Set<T>> ret = new ArrayList<Set<T>>();
		for (int i = 0; i < sets.size(); i++) {
			iterators.add(sets.get(i).iterator());
			items.add(iterators.get(i).next());
		}
		for (int j = 1; j >= 0;) {
			HashSet<T> hs = new HashSet<T>();
			hs.addAll(items);
			ret.add(hs);
			for (j = iterators.size() - 1; j >= 0 && !iterators.get(j).hasNext(); j--) {
				iterators.set(j, sets.get(j).iterator());
				items.set(j, iterators.get(j).next());
			}
			items.set(Math.abs(j), iterators.get(Math.abs(j)).next());
		}
		return ret;
	}

	/***
	 * print the result
	 * @param sets
	 */
	public static void print(Set<?>... sets) {
		for (Set<?> set : sets) {
			for (Object item : set) {
				System.out.println(item);
			}
		}
	}

	public static void main(String[] args) {
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
		
		print(recursiveCartesianProduct.cartesianProduct(set1, set2, set3));
	}

}
