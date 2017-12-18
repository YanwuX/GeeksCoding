package GeeksForGeeks;

public class KthSmallestElement {
	
	public int findKthSmallestElement(int[] arr, int k){
		if(arr == null || k > arr.length) return 0;
		
		return findKthSmallestElement(arr, k, 0, arr.length - 1);
	}
	
	public int findKthSmallestElement(int[] arr, int k, int l, int r) {
		System.out.println(arrValue(arr));
		int pos = partition(arr, 0, r);
		
		System.out.println(pos);
		System.out.println(arrValue(arr));
		System.out.println();
		
		if(pos - l == k - 1) return arr[pos];
		if(pos - l > k - 1) return findKthSmallestElement(arr, k, l, pos - 1);
		else return findKthSmallestElement(arr, k - pos + l - 1, pos + 1, r);
		
	}
	
	public int partition(int[] arr, int l, int r){
		int temp = arr[r], i = l;
		for(int j = l; j < r; ++j){
			if(arr[j] <= temp) {
				System.out.println("arr[i] " + arr[i] + " " + "arr[j] " + arr[j]);
				swap(arr, i, j);
				i++;
			}
		}
		swap(arr, i, r);
		return i;
	}
	
	public void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public String arrValue(int[] arr){
		String result = "";
		for(int i = 0; i < arr.length; ++i){
			result += arr[i] + " ";
		}
		return result;
	}

	public static void main(String[] args) {
		int arr[] = {12, 1, 3, 2, 5, 7, 4, 19, 26};
		KthSmallestElement find = new KthSmallestElement();
		System.out.println(find.findKthSmallestElement(arr, 3));
	}

}
