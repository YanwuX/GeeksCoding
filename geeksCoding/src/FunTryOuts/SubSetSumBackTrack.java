package FunTryOuts;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSetSumBackTrack {

	public void subSetSum(ArrayList<Integer> list, int sum) {
		if (list == null || list.size() == 0) {
			return;
		}

		findSubSetSum(list, new ArrayList<Integer>(), sum);

	}

	private void findSubSetSum(ArrayList<Integer> list, ArrayList<Integer> chosed, int sum) {

		if (list.size() == 0) {
			return;
		} else {
			int i = list.get(0);
			chosed.add(i);
			list.remove(0);
			chosed.stream().reduce(Integer::sum).ifPresent(s -> checkSumAndPrint(s, sum, chosed));
			findSubSetSum(list, chosed, sum);
			chosed.remove(chosed.size() - 1);
			findSubSetSum(list, chosed, sum);
			list.add(0, i);

		}
	}
	
	private void checkSumAndPrint(int s, int sum, ArrayList<Integer> list) {
		if (s == sum) {
			System.out.println(list);
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));

		SubSetSumBackTrack obj = new SubSetSumBackTrack();

		obj.subSetSum(list, 5);
	}

}
