package com.thread.pool.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class newFixedThreadPoolTest {

	public static void main(String[] args) {

		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			fixedThreadPool.execute(new Runnable() {
				public void run() {
					System.out.println(Thread.currentThread().getName() + "-" + index);

				}
			});
		}
	}
}
