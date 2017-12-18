package FunTryOuts;

public class FindAllSubArrayBackTrack {

	public static void findAllSubArray(int[] array) {
		findSubArray(array, new int[] {});

	}

	private static void findSubArray(int[] array, int[] prefix) {
		if (array.length == 0) {
			System.out.println(toString(prefix));
			return;
		}
		int first = array[0];
		array = arrayRemove(array, 0);
		prefix = arrayAdd(prefix, first);
		findSubArray(array, prefix);
		prefix = arrayRemove(prefix, 0);
		findSubArray(array, prefix);
		array = arrayInsert(array, first, 0);

	}

	private static int[] arrayAdd(int[] array, int element) {
		int[] newArray = new int[array.length + 1];
		for (int i = 0; i < array.length; ++i){
			newArray[i] = array[i];
		}
		newArray[array.length] = element;
		return newArray;
	}
	
	private static int[] arrayInsert(int[] array, int element, int index) {
		int[] newArray = new int[array.length + 1];
		for (int i = 0; i < array.length; ++i) {
			if (i == index) newArray[i] = element;
			if (i > index) newArray[i + 1] = array[i];
			else newArray[i] = array[i];
		}
		return newArray;
	}

	private static int[] arrayRemove(int[] array, int index) {
		if (array.length - 1 < 0) return new int[] {};
		int[] newArray = new int[array.length - 1];
		for (int i = 0, j = 0; i < array.length; ++i) {
			if (i == index) continue;
			newArray[j] = array[i];
			j++;
		}
		return newArray;
	}

	private static String toString(int[] array) {
		String temp = "";
		for (int i : array) {
			temp = temp + i + ",";
		}
		return temp;
	}

	public static void main(String[] args) {
		findAllSubArray(new int[] {1, 2, 3});
	}

}
