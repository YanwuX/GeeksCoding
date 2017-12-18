package funTryOuts;

public class FindAllSubStringBackTrack {
	
	public static void printAllSubString(String s) {
		getSubStrings(s, "");
	}
	
	private static void getSubStrings(String str, String chosen) {
//		System.out.println("\'" + s + "\' , " + "\'" + prefix + "\'");
		if (str.isEmpty()) System.out.println(chosen);
		else {
			String first = str.substring(0, 1);
			str = str.substring(1);
			getSubStrings(str, chosen + first);
			
			getSubStrings(str, chosen);
			str = first + str; 
			
		}
	}

	public static void main(String[] args) {
		printAllSubString("abc");
		
	}

}
