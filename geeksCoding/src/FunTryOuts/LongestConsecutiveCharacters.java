package FunTryOuts;

import Util.Pair;

public class LongestConsecutiveCharacters {
	
	public static Pair findLongestConsecutiveCharacters(String str) {
		Pair result = new Pair("", 0);

		if (str.isEmpty()) return result;
		
		char[] chars = str.toCharArray();
		char temp = chars[0];
		int len = 1;
		int max = 1;
		
		for (int i = 1; i < chars.length; ++i) {
			if (chars[i] == temp) {
				len++;
			} else {
				len = 1;
				temp = chars[i];
			}
			if (len > max) {
				max = len;
				result.setO1(chars[i]);
				result.setO2(max);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(findLongestConsecutiveCharacters("aabcccdd").toString());
	}

}
