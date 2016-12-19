package geeksForGeeks;

public class LongestIncreasingSubsequences {
	// O(n^2) solution
	 /* lis() returns the length of the longest increasing
    subsequence in arr[] of size n */
	 static int lis(int arr[],int n)
	 {
	       int lis[] = new int[n];
	       int i,j,max = 0;
	
	       /* Initialize LIS values for all indexes */
	        for ( i = 0; i < n; i++ )
	           lis[i] = 1;
	
	        /* Compute optimized LIS values in bottom up manner */
	        for ( i = 1; i < n; i++ )
	           for ( j = 0; j < i; j++ )
	              if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
	                 lis[i] = lis[j] + 1;
	
	        /* Pick maximum of all LIS values */
	        for ( i = 0; i < n; i++ )
	           if ( max < lis[i] )
	              max = lis[i];
	
	         return max;
	 }
		
	// Nlog(N) solution
    // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1)
        {
            int m = l + (r - l)/2;
            if (A[m]>=key)
                r = m;
            else
                l = m;
        }
 
        return r;
    }
 
    static int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one
 
        int[] tailTable   = new int[size];
        int len; // always points empty slot
 
        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++)
        {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];
 
            else if (A[i] > tailTable[len-1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];
 
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
        }
 
        return len;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        int n = A.length;
        System.out.println("Length of Longest Increasing Subsequence is "+
                            LongestIncreasingSubsequenceLength(A, n));
    }
	

}
