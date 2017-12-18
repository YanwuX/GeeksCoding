package FunTryOuts;

import java.util.LinkedHashSet;

public class AirBnBSayGoodBye {
	
	
    static String[] paginate(int num, String[] results) {
        if (results == null) return new String[0];
        if (results.length <= num) return results;
        
        int count = 0;
                
        String[] r = new String[results.length];
        
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
        
        for (int i = 0; i < results.length; ++i) {
        	
        	if (results[i].split(",").length != 4) continue;
        	
        	int key = Integer.valueOf(results[i].split(",")[0]);
        	if	(!set.contains(key)) {
        		set.add(key);
        		r[i] = results[i];
        	} else {
        		for (int j = i; j < results.length; ++j) {
        			if (results[j].split(",").length != 4) continue;
        			
        			key = Integer.valueOf(results[j].split(",")[0]);
        			if (!set.contains(key)) {
        				set.add(key);
                		r[i] = results[j];
                		results[j] = "";
                		break;
        			}
        		}
        	}
        	
        	count ++;
        	
        	if (count % num == 0) {
        		set = new LinkedHashSet<Integer>();
        	}
        }
        

        return r;
    }

	public static void main(String[] args) {
		String[] results = {
	               "1,28,300.6,San Francisco",  
	               "4,5,209.1,San Francisco",  
	               "20,7,203.4,Oakland",  
	               "6,8,202.9,San Francisco",  
	               "6,10,199.8,San Francisco",  
	               "1,16,190.5,San Francisco",  
	               "6,29,185.3,San Francisco",  
	               "7,20,180.0,Oakland",  
	               "6,21,162.2,San Francisco",  
	               "2,18,161.7,San Jose",  
	               "2,30,149.8,San Jose",  
	               "3,76,146.7,San Francisco",  
	               "2,14,141.8,San Jose",  
	};
	String[] r = paginate(5, results);
	for (String s : r) System.out.println(s);
	}

}
