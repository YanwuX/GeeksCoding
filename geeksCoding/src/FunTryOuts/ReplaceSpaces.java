package FunTryOuts;

public class ReplaceSpaces {

	public static void main(String[] args) {

		String str = "a b c";
		System.out.println(replaceWhiteSpaces(str));
	}
	
	public static String replaceWhiteSpaces(String str) {
		return str.replaceAll(" ", "%20");
	}

}
