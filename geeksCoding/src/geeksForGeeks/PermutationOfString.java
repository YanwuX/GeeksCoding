package geeksForGeeks;

public class PermutationOfString {
	public static void printPerm(String str) {
	    getPerm("", str);
	    
	}
	 
	public static void getPerm(String pref, String str) {
	    int l = str.length();
	    if(l == 0) System.out.print(pref + " ");
	    
	    else{
	        for(int i = 0; i < l; i++) {
	            getPerm(pref + str.charAt(i), 
	                    str.substring(0,i) + str.substring(i + 1, l));
	        }
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPerm("abc");
	}

}
