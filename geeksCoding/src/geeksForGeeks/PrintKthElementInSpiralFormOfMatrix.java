package geeksForGeeks;

public class PrintKthElementInSpiralFormOfMatrix {

	public static void printKthElementInSpiralMatrix(int[][] arr, int k) {
		int x = 0;
		int y = 0;
		k += 1;
		while (true) {
			if (k < arr[0].length) {
				System.out.println(arr[y][k]);
				break;
			} else {
				k = k - arr[0].length;
				if (k < arr.length) {
					System.out.println(arr[k][arr[0].length - x - 1]);
					break;
				} else {
					k = k - arr.length;
					if (k < arr[0].length) {
						System.out.println(arr[arr.length - y - 1][arr[0].length - k - x - 1]);
						break;
					} else {
						k = k - arr[0].length;
						if (k < arr.length) {
							System.out.println(arr[arr.length - k - 1][x]);
							break;
						}
						x += 1;
						y += 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
		printKthElementInSpiralMatrix(mat, 17);
	}

}
