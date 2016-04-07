package com.thread.pool.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class newCachedThreadPoolTest {


	public static void main(String[] args) {
		
		/**
		 * 创建一个可缓存线程池，
		 * 如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
		 * 线程池为无限大，当执行第二个任务时如果第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
		 */
		ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			final int index = i;
			try {
				Thread.sleep(1 * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cachedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						Thread.sleep(2 * 1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+"-"+index);
				}
			});
		}
	}
}
