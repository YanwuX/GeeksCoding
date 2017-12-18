package FunTryOuts;

public class DecimalToBinary {
	
	public static void printBinary(int i) {
		StringBuilder sb = new StringBuilder();
		while(i > 1) {
			int lastDigit = i % 2;
			i = i / 2;
			sb.insert(0, lastDigit);
		}
		if (i < 2) sb.insert(0, i);
		System.out.println(sb.toString());
	}
	
	public static String printBinaryRecursive(int i, String s) {
		if (i < 2) {
			return s + i;
		}
		else {
			int lastDigit = i % 2;
			i = i / 2;
			s = printBinaryRecursive(i, s);
			return s + lastDigit;
		}
	}

	public static void main(String[] args) {
		printBinary(2);
		printBinary(8);
		printBinary(43);
		
		System.out.println(printBinaryRecursive(2, ""));
		System.out.println(printBinaryRecursive(8, ""));
		System.out.println(printBinaryRecursive(43, ""));
	}

}
