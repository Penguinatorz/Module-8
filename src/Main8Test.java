/*
 * Jancarlo Sevilla
 * 11/1/2020
 * Module - 8 - Concurrency
 */
import java.util.Random;

public class Main8Test {

	public static void main(String[] args){
		Random rand = new Random();
		int[] array = new int[200000000];
		
		//loops
		for (int i = 0; i < array.length; i++) {

			array[i] = rand.nextInt(10) + 1;
		}
		long startTime = System.currentTimeMillis();
		
		//pThread of two threads
		System.out.println("Parallel Thread " + parallelArraySum(array) + " elements");
		System.out.println("Parallel: " + (System.currentTimeMillis() - startTime + "ms"));
		
		
		//sThread
		startTime = System.currentTimeMillis();
		singleSum(array);
		System.out.println("Single: " + (System.currentTimeMillis() - startTime + "ms"));

	}
	
	//method 2 parallelArrayThread
	public static int parallelArraySum(int[] array)
	{
		ParallelSum pS1 = new ParallelSum(array, 0, (array.length/2));
		ParallelSum pS2 = new ParallelSum(array, (array.length/2), array.length);
		pS1.start();
		pS2.start();
		try {
			pS1.join();
			pS2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pS1.getPartialVal() + pS2.getPartialVal();
		
	}
	
	//method singleSum
	public static void singleSum(int[] array)
	{
		SingleSum singleSum1 = new SingleSum();
		singleSum1.setArray(array);
		singleSum1.start();
		try {
			singleSum1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}





