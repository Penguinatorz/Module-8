
public class ParallelSum extends Thread{

	private int[] array;

	private int low, high, partialVal;
	//setting values
	public ParallelSum(int[] array, int low, int high) {
		this.array = array;
		this.low = low;
		this.high = high;
	}

	//returning element value
	public int getPartialVal() {
		return partialVal;
	}
	
	//totaling element value
	public void run() {
		for (int i = low; i < high; i++) {
			partialVal += array[i];
		}
	}
	
}
