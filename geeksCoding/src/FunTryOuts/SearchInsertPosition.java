package FunTryOuts;

public class SearchInsertPosition {

	public static int doSearchInsertPosition(int[] arr, int target) {
		
		if (arr.length == 0 || arr == null) {
			return -1;
		}
		
		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		

		while (start + 1 < end) {
			mid = (start + end) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (target < arr[mid] ) {
				end = mid;
			} else {
				start = mid;
			}
		}
		
		if (arr[start] >= target) {
			return start;
		} else if (arr[end] >= target) {
			return end;
		} else {
			return end + 1;
		}
		
	}

	public static void main(String[] args) {
		System.out.println(doSearchInsertPosition(new int[] {2, 3, 5, 7, 8, 23, 34}, 8));
		System.out.println(doSearchInsertPosition(new int[] {2, 4, 6, 11}, 3));

	}
}
