package com.callable.deadLock;

public class DeadLock1 {
	
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();

		new Thread(new Thread1(obj1, obj2)).start();;
		
		new Thread(new Thread2(obj1, obj2)).start();
		
		
		
		
	}
	
	
}

class Thread1 implements Runnable {
	
	Object obj1 = null;
	Object obj2 = null;
	
	Thread1(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
		
	}
	

	@Override
	public void run() {
		
		synchronized(obj1) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized(obj2) {
				
				System.out.println("Thread1...");
			}
			
			
		}
		
	}
	
	
	
}


class Thread2 implements Runnable {
	
	Object obj1 = null;
	Object obj2 = null;
	
	Thread2(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
		
	}
	

	@Override
	public void run() {
		
		synchronized(obj2) {
			
			try {
				Thread.sleep(1000);
				System.out.println("请注意我要死锁了");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			synchronized(obj1) {
				
				System.out.println("Tread2...");
			}
			
			
		}
		
	}
	
	
	
}
