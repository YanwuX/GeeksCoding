package funTryOuts;

import java.util.ArrayList;

public class FindAllSubListBackTrack {
	
	public static void subLists(ArrayList<String> list) {
		ArrayList<String> chosen = new ArrayList<String>();
		findSubLists(list, chosen);
	}
	
	private static void findSubLists(ArrayList<String> list, ArrayList<String> chosen) {
		if (list.isEmpty()) System.out.println(chosen);
		else {
			String first = list.get(0);
			list.remove(0);
			chosen.add(first);
			findSubLists(list, chosen);
			chosen.remove(chosen.size() - 1);
			findSubLists(list, chosen);
			list.add(0, first);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> test = new ArrayList<String>();
		test.add("a");
		test.add("b");
		test.add("c");
		test.add("d");
		
		subLists(test);
	}

}
