public class SingleSum extends Thread{
	private static int[] array;
	
	public static int sum(int[] arr){
		return sum(arr, 0, arr.length);
		}
	//total elements
	public static int sum(int[] arr, int low, int high){

		int total = 0;

		for (int i = low; i < high; i++) {

			total += arr[i];
			}
		return total;
		}
	
	
	//setters and getters
	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		SingleSum.array = array;
	}

	public void run() {
		//System.out.println("array Test " + array.length);
		System.out.println("Thread - 1  " + SingleSum.sum(array) + " elements");
		
	}
	
		
	
	
	
}
