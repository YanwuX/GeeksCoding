package funTryOuts;

import java.util.ArrayList;

public class getArrayListUniqueElements {
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
		// TODO Auto-generated method stub
//		ArrayList<Integer> al = new ArrayList<Integer>(){
//			@Override
//			public int size(){
//				return 10;
//			}
//		};
//		
//		System.out.println(al.size());
		
		ArrayList<String> l = new ArrayList<String>(){
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
