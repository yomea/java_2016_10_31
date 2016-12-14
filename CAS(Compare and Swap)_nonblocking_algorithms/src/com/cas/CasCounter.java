package com.cas;

/**
 * 模拟cas操作
 * @author may
 *
 */
public class CasCounter {
	private SimulatedCAS simulatedCAS = null;

	int getValue() {
		return simulatedCAS.getValue();
	}

	int increment() {
		int oldValue = simulatedCAS.getValue();
		//判断拿出来的值是否和当初的拿出来相等，相等表示没有被其他线程修改，所以可以进行修改，否侧重新取得值，在改变一次。
		while (simulatedCAS.compareAndSwap(oldValue, oldValue + 1) != oldValue)
			oldValue = simulatedCAS.getValue();
		return oldValue;
	}

	CasCounter(SimulatedCAS cas) {
		this.simulatedCAS = cas;
	}

	public static void main(String[] args) throws InterruptedException {
		CasCounter counter = new CasCounter(new SimulatedCAS());
		Thread[] ts = new Thread[10000];
		for (int i = 0; i < 10000; i++) {
			ts[i] = new CounterThread(counter);

		}
		for (Thread t : ts) {
			t.start();
		}

		for (Thread t : ts) {
			t.join();
		}

		System.out.println("counter: " + counter.getValue());
	}
}

class CounterThread extends Thread {
	CasCounter counter = null;

	CounterThread(CasCounter counter) {

		this.counter = counter;
	}

	@Override
	public void run() {
		counter.increment();
	}
}

class SimulatedCAS {

	private volatile int value = 0;

	synchronized int getValue() {
		return value;

	}

	synchronized int compareAndSwap(int expectedValue, int newValue) {
		if (value == expectedValue)
			value = newValue;
		return expectedValue;
	}
}
