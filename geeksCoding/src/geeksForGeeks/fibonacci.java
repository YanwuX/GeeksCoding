package geeksForGeeks;

import java.util.ArrayList;

public class fibonacci {

	// 0 1 1 2 3 5 8 13 21...
	// 0 1 2 3 4 5 6 7 8
	
	public int fibRecursive(int num) {
		if (num < 2)
			return num;
		else
			return fibRecursive(num - 1) + fibRecursive(num - 2);
	}

	public int fibIterative(int num) {
		int current = 1;
		int previous = 1;
		int result = 0;
		for (int i = 0; i < num - 2; ++i) {
			result = previous + current;
			previous = current;
			current = result;
		}
		return result;
	}

	public int fibDynamicTopDown(int num) {
		ArrayList<Integer> lookUp = new ArrayList<Integer>();
		lookUp.add(0);
		lookUp.add(1);
		lookUp.add(1);
		return fibDynamicTopDown(lookUp, num);
	}

	public int fibDynamicTopDown(ArrayList<Integer> lookUp, int num) {

		if (num < 2)
			return lookUp.get(num);
		else
			lookUp.add(num, fibDynamicTopDown(lookUp, num - 1) + fibDynamicTopDown(lookUp, num - 2));
		
		return lookUp.get(num);
	}
	
	public int fibDynamicBotUp(int num) {
		int[] lookUp = new int[num + 1];
		lookUp[0] = 0;
		lookUp[1] = 1;
		for (int i = 2; i <= num; ++i) {
			lookUp[i] = lookUp[i -1] + lookUp[i - 2];
		}
		return lookUp[num];
	}

	public static void main(String[] args) {
		fibonacci fib = new fibonacci();
		System.out.println("recursive: " + fib.fibRecursive(25));
		System.out.println("iterative: " + fib.fibIterative(25));
		System.out.println("Dynamic Top Down: " + fib.fibDynamicTopDown(25));
		System.out.println("Dynamic Bot Up: " + fib.fibDynamicBotUp(25));
	}
	
}
