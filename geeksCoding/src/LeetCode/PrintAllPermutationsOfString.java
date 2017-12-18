package LeetCode;

public class PrintAllPermutationsOfString {
	
	public static void printPermutes(String s) {
		doPermutes(s, "");
	}
	
	private static void doPermutes(String s, String prefix) {
		if (s.equals("")) System.out.println(prefix);
		else {
			for(char c : s.toCharArray()) {
				s = s.substring(1);
				doPermutes(s, prefix + c);
				s = s + c;
			}
		}
	}

	public static void rollDice(int howManyDice) {
		doRollDice(howManyDice, "");
	}
	
	private static void doRollDice(int howManyDice, String prefix) {
		if (howManyDice == 0) System.out.println(prefix);
		else {
			for (int i = 1; i < 7; ++i) {
				howManyDice--;
				doRollDice(howManyDice, prefix + " " + i);
				howManyDice++;
			}
		}
	}
	
	/**
	 * permutation function
	 * 
	 * @param str
	 *            string to calculate permutation for
	 * @param l
	 *            starting index
	 * @param r
	 *            end index
	 */
	private void permute(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * 
	 * @param a
	 *            string value
	 * @param i
	 *            position 1
	 * @param j
	 *            position 2
	 * @return swapped string
	 */
	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	public static void main(String[] args) {
		String str = "ABC";
//		int n = str.length();
//		PrintAllPermutationsOfString permutation = new PrintAllPermutationsOfString();
//		permutation.permute(str, 0, n - 1);
//		
		printPermutes(str);
		
//		rollDice(3);
	}

}
