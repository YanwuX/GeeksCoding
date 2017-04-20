package geeksForGeeks;

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

	public static void main(String[] args) {
		int[] arr = new int[] {4, 3, -5, 0, 6, -8, 12, 3, -9, 2, 5, 8, -3};
		System.out.println(maxSubArray(arr));
	}

}
