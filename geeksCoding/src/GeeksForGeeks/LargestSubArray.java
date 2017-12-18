package GeeksForGeeks;

public class LargestSubArray {

	public static int maxSubArray(int[] A) {

		if (A == null || A.length == 0) {
			return 0;
		}

		int max = Integer.MIN_VALUE, sum = 0;

		for (int i = 0; i < A.length; ++i) {
			sum += A[i];
			max = Math.max(max, sum);
			sum = Math.max(sum, 0);
		}
		return max;
	}

	public static int maxSubArrayII(int[] A) {
		int maxSoFar = A[0], maxEndingHere = A[0];
		for (int i = 1; i < A.length; ++i) {
			maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		return maxSoFar;
	}

	public static int maxSubArrayIII(int[] A) {
		int max = Integer.MIN_VALUE, sum = 0;
		for (int i = 0; i < A.length; i++) {
			if (sum < 0)
				sum = A[i];
			else
				sum += A[i];
			if (sum > max)
				max = sum;
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 3, -5, 0, 6, -8, 12, 3, -9, 2, 5, 8, -3 };
		// System.out.println(maxSubArray(arr));

		System.out.println(maxSubArrayII(new int[] { 6, -4, 20, 30 }));
		System.out.println(maxSubArrayII(new int[] { -9, -7, -5, -2 }));
		System.out.println(maxSubArrayII(arr));

		System.out.println(maxSubArrayIII(new int[] { -9, -7, -5, -2 }));

	}

}
