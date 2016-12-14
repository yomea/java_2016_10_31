package com.queue;

/**
 * 传统的生产者和消费者
 * @author may
 *
 */
class User {
	
	private String username;
	
	private int age;
	
	private boolean flag = false;

	public synchronized void setUser(String username, int age) {
		
		if(flag) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.username = username;
		
		this.age = age;
		flag = true;
		notify();
	}

	
	public synchronized void print() {
		if(!flag) {
			
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("User [username=" + username + ", age=" + age + "]");
		flag = false;
		notify();
	}
	
	
	
	
}

/**
 * 生产者
 * @author may
 *
 */
class Produce implements Runnable {
	
	private User user = null;
	
	public Produce(User user) {
		this.user = user;
		
	}

	@Override
	public void run() {
		
		for(int i = 0; i < 10; i++) {
			if(i % 2 == 0) {
				
				user.setUser("小红", 21);
				
			} else {
				user.setUser("小明", 22);
			}
			
		}
	}
	
}

/**
 * 消费者
 * @author may
 *
 */
class Consumer implements Runnable {

	private User user = null;
	
	public Consumer(User user) {
		this.user = user;
		
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++) {
			user.print();
		}
		
	}
	
}

public class Produce_Consumer_trandition {
	
	public static void main(String[] args) {
		
		User user = new User();
		Produce produce = new Produce(user);
		
		Consumer consumer = new Consumer(user);
		
		new Thread(consumer).start();
		new Thread(produce).start();
		
	}
	

}
