package com.thread.pool.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class newScheduledThreadPoolTest {

	public static void main(String[] args) {
		
		// 表示延迟3秒后执行
		ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);  
		  scheduledThreadPool.schedule(new Runnable() {  
		   public void run() {  
		    System.out.println("delay 3 seconds");  
		   }  
		  }, 3, TimeUnit.SECONDS);  
	}
}
