package geeksForGeeks;

import java.util.Arrays;

public class LongestIncreasingSubsequences {
	
	static int max_ref; // stores the LIS

	/*
	 * To make use of recursive calls, this function must return two things: 1)
	 * Length of LIS ending with element arr[n-1]. We use max_ending_here for
	 * this purpose 2) Overall maximum as the LIS may end with an element before
	 * arr[n-1] max_ref is used this purpose. The value of LIS of full array of
	 * size n is stored in max_ref which is our final result
	 */
	static int _lis(int arr[], int n) {
		// base case
		if (n == 1)
			return 1;

		// 'max_ending_here' is length of LIS ending with arr[n-1]
		int res, max_ending_here = 1;

		/*
		 * Recursively get all LIS ending with arr[0], arr[1] ... arr[n-2]. If
		 * arr[i-1] is smaller than arr[n-1], and max ending with arr[n-1] needs
		 * to be updated, then update it
		 */
		for (int i = 1; i < n; i++) {
			res = _lis(arr, i);
			if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
				max_ending_here = res + 1;
		}

		// Compare max_ending_here with the overall max. And
		// update the overall max if needed
		if (max_ref < max_ending_here)
			max_ref = max_ending_here;

		// Return length of LIS ending with arr[n-1]
		return max_ending_here;
	}

	// The wrapper function for _lis()
	static int lis(int arr[], int n) {
		// The max variable holds the result
		max_ref = 1;

		// The function _lis() stores its result in max
		_lis(arr, n);

		// returns max
		return max_ref;
	}
	
	
	// O(n^2) solution
	 /* lis() returns the length of the longest increasing
    subsequence in arr[] of size n */
	 static int lisDynamic(int arr[],int n)
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
    
    static int LongestIncreasingSubsequenceLengthWithBinary(int[] array) {
    	
    	int[] dp = new int[array.length];
    	int len = 0;
    	
    	for (int num : array) {
    		int i = Arrays.binarySearch(dp, 0, len, num);
    		if (i < 0) {
    			i = - (i + 1);
    		}
    		dp[i] = num;
    		if (i == len) {
    			len++;
    		}
    	}
    	
    	return len;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
		
//        System.out.println(Arrays.binarySearch(A, 6));

        int n = A.length;
//        System.out.println("Length of Longest Increasing Subsequence is "+
//                            LongestIncreasingSubsequenceLength(A, n));
        System.out.println("Length of Longest Increasing Subsequence (Dynamic) is "+
        		lisDynamic(A, n));
        System.out.println("Length of Longest Increasing Subsequence (Dynamic with Binary search) is "+
        		LongestIncreasingSubsequenceLengthWithBinary(A));
    }
	

}
