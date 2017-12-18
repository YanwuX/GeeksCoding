package GeeksForGeeks;

public class PrintKthElementInSpiralFormOfMatrix {
	/**
	 * runtime O(n) space O(1)
	 * @param arr
	 * @param k
	 */

//	public static void printKthElementInSpiralMatrix(int[][] arr, int k) {
//		int x = 0;
//		int y = 0;
//		if (k < arr[0].length) {
//			System.out.println(arr[0][k - 1]);
//			return;
//		}
//		
//		while (true) {
//				k = k - arr[0].length + x;
//				if (k < arr.length) {
//					System.out.println(arr[k + y][arr[0].length - x - 1]);
//					break;
//				} else {
//					k = k - arr.length + 1 + y;
//					if (k < arr[0].length) {
//						System.out.println(arr[arr.length - y - 1][arr[0].length - k - x - 1]);
//						break;
//					} else {
//						k = k - arr[0].length + 1 + x;
//						y += 1;
//						if (k < arr.length - y) {
//							System.out.println(arr[arr.length - k - 1][x]);
//							break;
//						}else {
//							x += 1;
//							k = k - arr.length + y + 1;
//							if(k < arr[0].length - x) {
//								System.out.println(arr[y][k]);
//								break;							
//							}
//						}
//					}
//				}
//			}
//		}

	
	public static int findKthElementRecursion(int[][] arr, int n, int m, int k) {
		if(n < 0 || m < 0) return -1;
		
		if(k < arr[0].length) return arr[0][k - 1];
		
		if(k < arr[0].length + arr.length -1) return arr[k - arr[0].length][arr[0].length - 1];
		
		if(k < 2 * arr[0].length + arr.length -2) return arr[arr.length][2 * arr[0].length + arr.length - k - 2];
		
		if(k < 2 * arr[0].length + 2 * arr.length - 4) return arr[2 * arr[0].length + 2 * arr.length - k - 3][0];
		
		return findKthElementRecursion(getInnerMatrix(arr), arr.length - 2, arr[0].length - 2, k - (2 * arr.length + 2 * arr[0].length -4));
	}
	public static int[][] getInnerMatrix(int[][] arr) {
		int[][] result = new int[arr.length - 2][arr[0].length - 2];
		for(int i = 1; i < arr.length - 1; i++) {
			for(int j = 1; j < arr[0].length - 1; j++){
				result[i - 1][j - 1] = arr[i][j];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int matrix[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int mat[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
//		printKthElementInSpiralMatrix(matrix, 15);
		System.out.println(findKthElementRecursion(matrix, 4, 4, 16));
	}

}
