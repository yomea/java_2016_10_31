package com.observer;

public class Test {
	
	public static void main(String[] args) {
		//被观察者
		Watched watched = new Watched();
		
		Watcher watcher1 = new Watcher("xiao ming");
		Watcher watcher2 = new Watcher("xiao hong");
		//添加观察者
		watched.addWatcher(watcher1);
		watched.addWatcher(watcher2);
		//每隔1s触发
		/*new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hehe");
				
			}
		}).start();*/
		
	}

}
