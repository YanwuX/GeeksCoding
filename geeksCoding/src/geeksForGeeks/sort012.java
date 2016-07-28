package geeksForGeeks;

public class sort012 {
	
    public static int[] sort(int[] arr) {
        int index = 0;
        int length = arr.length - 1;
        int temp = 0;
    while(temp < length) {
        if(arr[temp] == 0){
        	int tempVal = arr[index];
        	arr[index] = arr[temp];
        	arr[temp] = tempVal;
        	index++;
        	temp++;
        }
        if(arr[temp] == 1) temp++;
        if(arr[temp] == 2) {
        	int tempVal = arr[temp];
        	arr[temp] = arr[length];
        	arr[length] = tempVal;
        	length--;
        }
    }
        return arr;
    }

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = new int[] {1, 0, 1,2};

	     sort(arr);
	        
	     for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + " " );
	}

}
