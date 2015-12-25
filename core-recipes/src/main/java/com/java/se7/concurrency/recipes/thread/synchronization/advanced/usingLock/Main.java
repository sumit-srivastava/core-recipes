package com.java.se7.concurrency.recipes.thread.synchronization.advanced.usingLock;

/**
 * Main class of the example
 *
 */
public class Main {
	
	/**
	 * Main method of the example
	 * @param args
	 */
	public static void main (String args[]){
		// Creates the print queue
		PrintQueue printQueue=new PrintQueue();
		
		// Creates ten jobs and the Threads to run them
		Thread thread[]=new Thread[10];
		for (int i=0; i<10; i++){
			thread[i]=new Thread(new Job(printQueue),"Thread "+i);
		}
		
		// Launch a thread ever 0.1 seconds
		for (int i=0; i<10; i++){
			thread[i].start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
