package UberSayGoodBye;

import java.util.Date;

public class RateFunction {
	
	static RateList hist = new RateList();
	static long[] histArray = new long[100];
	static int index = 0;


	public static void ratingFunction() throws OverRateException {
		hist.add(new RateNode());
		if (hist.lastNode.getTime() - hist.firstNode.getTime() > 100) {
			throw new OverRateException("Over Rated");
		}
	}
	
	public static void ratingFunctionWithArray() throws OverRateException {
		if (index > 99) throw new OverRateException("Over Rated");
		
		histArray[index] = new Date().getTime();
		if (histArray[index] - histArray[0] > 1000) throw new OverRateException("Over Rated");
		index++;
	}
	
	
	public static void main(String[] args) throws OverRateException {
		while(true) {
			try {
//				ratingFunction();
				ratingFunctionWithArray();
			} catch (OverRateException e) {
				System.out.println(e.getExceptionMessage());
				break;
			}
		}
//		
//		while(true){
//			ratingFunction();
//		}
	}

}
