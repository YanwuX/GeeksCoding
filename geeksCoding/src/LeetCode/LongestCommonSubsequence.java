package LeetCode;

public class LongestCommonSubsequence {

	/* Returns length of LCS for X[0..m-1], Y[0..n-1] */
	public int lcs(char[] X, char[] Y, int m, int n) {
		int L[][] = new int[m + 1][n + 1];

		/*
		 * Following steps build L[m+1][n+1] in bottom up fashion. Note that
		 * L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
		 */
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X[i - 1] == Y[j - 1])
					L[i][j] = L[i - 1][j - 1] + 1;
				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[m][n];
	}
	
	public int lcs(String s1, String s2) {
		int temp[][] = new int[s1.length() + 1][s2.length() + 1]; 
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		for (int i = 1; i <= s1.length(); ++i) {
			for (int j = 1; j <= s2.length(); ++j) {
				temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - 1]);

				if (c1[i - 1] == c2[j - 1]) temp[i][j] = temp[i - 1][j - 1] + 1;
			}
		}
		return temp[s1.length()][s2.length()];
	}

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		int m = X.length;
		int n = Y.length;

		System.out.println("Length of LCS is" + " " + lcs.lcs(X, Y, m, n));
		
		System.out.println("Length of LCS is" + " " + lcs.lcs(s1, s2));
		
	}

}