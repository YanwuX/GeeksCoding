package FunTryOuts;

public class ReplaceStringWithoutReplaceMethod {

	public static void main(String[] args) {
		String originalString = "This car is my car";
		String replacedString = replaceMethod(originalString, "car", "bike");
		System.out.println(replacedString);
	}

	static String replaceMethod(String str, String from, String to) {
		String[] arr = str.split(from);
		StringBuilder output = new StringBuilder();

		int i = 0;
		for (; i < arr.length - 1; i++)
			output.append(arr[i]).append(to);

		output.append(arr[i]);
		if (str.substring(str.lastIndexOf(" ")).equalsIgnoreCase(" " + from))
			output.append(to);

		return output.toString();
	}

}
