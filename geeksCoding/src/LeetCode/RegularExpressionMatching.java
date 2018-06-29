package LeetCode;

enum Result {
    TRUE, FALSE
/**
 * Created by Yanwu_Alienware on 2018/6/29.
 */
}

public class RegularExpressionMatching {
    private Result[][] memo;
    public boolean isMatch(String str, String ptn) {
        memo = new Result[str.length() + 1][ptn.length() + 1];
        return dp(0, 0, str,  ptn);
    }

    private boolean dp(int i, int j, String str, String ptn) {
        boolean flag = false;

        if (str == null || ptn == null || ptn.charAt(0) == '*') {
            return false;
        }
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }

        if (j == ptn.length()) {
            flag = (i == str.length());
        } else {
            boolean matchingPart = (i < str.length() &&
                                    (str.charAt(i) == ptn.charAt(j) || str.charAt(i) == '.'));
            if (j < ptn.length() - 1 && ptn.charAt(j + 1) == '*') {
                flag = (matchingPart && dp(i + 1, j, str, ptn)) ||
                        dp(i, j + 2, str, ptn);
            } else if (i < str.length() && j < ptn.length()){
                dp(i + 1, j + 1, str, ptn);
            }
        }
        memo[i][j] = flag ? Result.TRUE : Result.FALSE;
        return flag;

    }



    public static void  main(String args[]) {
        RegularExpressionMatching test = new RegularExpressionMatching();
        System.out.println(test.isMatch("aa", "ab"));
        System.out.println(test.isMatch("aa", "a."));
        System.out.println(test.isMatch("aa", "a*"));
        System.out.println(test.isMatch("aa", ".b"));
        System.out.println(test.isMatch("aab", "c*a*b*"));
        System.out.println(test.isMatch("aa", "a*aaa*b"));
    }
}



