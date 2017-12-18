package leetCode;

public class ValidatePalindrome {

    public boolean isPalindrome(String s) {
        String str = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        for (int i = 0, j = str.length() - 1; i < j; ++i, --j) {
            if (str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }
    
	public static void main(String[] args) {
		ValidatePalindrome vaidator = new ValidatePalindrome();
		System.out.println(vaidator.isPalindrome("aA."));

	}

}
