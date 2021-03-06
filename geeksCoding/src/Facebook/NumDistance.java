package Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumDistance {

	  public int totalDistance(int[] arr) {
		  int sum = 0;
		  if(arr == null) return 0;
		    List<List<Integer>> list = findSubSet(arr);
		    for (int i = 0; i < list.size(); i ++) {
		      if (list.get(i).size() != 2 ) break;
		      sum = sum + distance(list.get(i).get(0), list.get(i).get(1));
		    }
		    return sum;
	  }

		  private List<List<Integer>> findSubSet(int [] nums) {
		    
		    // this needs improvements
		    List<List<Integer>> list = new ArrayList<List<Integer>>();
		    for (int i = 0; i < nums.length; i++) {
		      int temp = nums[i];
		      for (int j = i + 1; j < nums.length; j++) {
		        list.add(Arrays.asList(temp, nums[j]));
		      }
		    }
		    return list;
		  }

		  private int distance(int m, int n) {
		    int count = 0;
		    for (int i = 0; i < 32; i++) {
		      if ( ((m >> i) & 1) != ((n >> i) & 1) ) {
		        count ++;
		      }
		    }
		    return count;
		  }
	
	
	public static void main(String[] args) {
		NumDistance nd = new NumDistance();
		System.out.println(nd.totalDistance(new int[] {1, 2, 3}));

	}

}
