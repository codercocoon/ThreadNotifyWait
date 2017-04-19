package com.codercocoon.ThreadExamples;

/**
 * This example shows how to use notify() and wait() methods of Thread class.
 * 
 * @author contact@codercocoon.com
 *
 */
public class SoccerField {
	private boolean available = true;

	/**
	 * If the soccer field is not available, then the thread will wait until
	 * being notified that the soccer field is available again.
	 */
	public synchronized void getSoccerField() {
		if (!available) {
			try {
				System.out.println(Thread.currentThread().getName() + " is waiting...");
				wait();
				System.out.println(Thread.currentThread().getName() + " is notified...");
			} catch (InterruptedException e) {
				// Do something to handle the InterruptedException
				e.printStackTrace();
			}
		}
	}

	/**
	 * When the soccer field is available, the other threads are notified to
	 * continue doing their jobs.
	 * 
	 */
	public synchronized void setAvailable(boolean a) {
		available = a;
		if (a) {
			notify();
			System.out.println("Dear threads get notified...!");
		}
	}

	public boolean isAvailable() {
		return available;
	}
}
