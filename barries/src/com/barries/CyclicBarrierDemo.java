package com.barries;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 一个周期性处理任务的例子，在这个例子中有一对的任务（100个），希望每10个为一组进行处理，当前仅当上一组任务处理完成后才能进行下一组，另外在每一组任务中，当任务剩下50%，30%以及所有任务执行完成时向观察者发出通知。
 * 珊栏test
 * @author may
 *
 */
public class CyclicBarrierDemo {

	final CyclicBarrier barrier;

	final int MAX_TASK;

	public CyclicBarrierDemo(int cnt) {
		barrier = new CyclicBarrier(cnt + 1);
		MAX_TASK = cnt;
	}

	public void doWork(final Runnable work) {
		new Thread() {
			
			@Override
			public void run() {
				work.run();
				try {
					int index = barrier.await();//阻塞方法，当所有的线程到达屏障时就会一起启动
					doWithIndex(index);
				} catch (InterruptedException e) {
					return;
				} catch (BrokenBarrierException e) {
					return;
				}
			}
		}.start();
	}

	private void doWithIndex(int index) {
		if (index == MAX_TASK / 3) {
			System.out.println("Left 30%.");
		} else if (index == MAX_TASK / 2) {
			System.out.println("Left 50%");
		} else if (index == 0) {
			System.out.println("run over");
		}
	}

	public void waitForNext() {
		try {
			doWithIndex(barrier.await());
		} catch (InterruptedException e) {
			return;
		} catch (BrokenBarrierException e) {
			return;
		}
	}

	public static void main(String[] args) {
		final int count = 10;
		CyclicBarrierDemo demo = new CyclicBarrierDemo(count);
		for (int i = 0; i < 100; i++) {
			demo.doWork(new Runnable() {

				public void run() {
					// do something
					try {
						Thread.sleep(1000L);
					} catch (Exception e) {
						return;
					}
				}
			});
			if ((i + 1) % count == 0) {
				demo.waitForNext();
			}
		}
	}

}