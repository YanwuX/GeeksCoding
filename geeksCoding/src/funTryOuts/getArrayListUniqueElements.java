package funTryOuts;

import java.util.ArrayList;

public class GetArrayListUniqueElements {
	// get unique elements from array list and return itself as a updated array list
	public static ArrayList<String> getUniques(ArrayList<String> l){
		for(int i = 0; i < l.size(); i++) {
			while(l.lastIndexOf(l.get(i)) != i) l.remove(l.lastIndexOf(l.get(i)));
		}
		return l;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<String> l = new ArrayList<String>(){
			// this is intended to see how for loop works.
			// the second argument of for loop will be executed every time.
			@Override
			public int size(){
				System.out.println(super.size());
				return super.size();
			}
			// to override the to string method
			@Override 
			public String toString(){
				String result = "";
				for(int i = 0; i < size(); i++){
					result += get(i) + " ";
				}
				return result;
			}
		};
		l.add("a");l.add("b");l.add("c");l.add("a");l.add("a");
		System.out.println(getUniques(l).toString());
		
	}

}
