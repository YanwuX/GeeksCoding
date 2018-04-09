package FunTryOuts;

public class Print1Or0 {

	public static void print(String s) {
		recursivePrint(s.toCharArray(), 0);
	}
	
	private static void recursivePrint(char[] c, int i) {
		if (i == c.length) {
			printCharArr(c);
			return;
		}
		if (c[i] == '?') {
			c[i] = '0';
			recursivePrint(c, i + 1);
			c[i] = '1';
			recursivePrint(c, i + 1);
			c[i] = '?';
		} else {
			recursivePrint(c, i + 1);
		}

	}
	
	private static void printCharArr(char[] cArr) {
		for (char c : cArr) {
			System.out.print(c);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String s = "1?0?";
		print(s);
	}

}
