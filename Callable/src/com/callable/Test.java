package com.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Test {

	public static void main(String[] args) throws Exception {
		System.out.println(Test.method1());
		System.out.println(Test.method2());
	}

	public static Integer method1() throws InterruptedException, ExecutionException {
		CallableTest callableTest = new CallableTest(22);

		FutureTask<Integer> futureTask = new FutureTask<>(callableTest);
		futureTask.run();
		return futureTask.get();

	}
	
	public static Integer method2() throws InterruptedException, ExecutionException {
		
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		CallableTest callableTest = new CallableTest(22);
		
		Future<Integer> future = executorService.submit(callableTest);
		
		Integer result = future.get();
		
		executorService.shutdown();
		
		return result;
	}

}

class CallableTest implements Callable<Integer> {

	private int age;

	public CallableTest(int age) {
		this.age = age;

	}

	@Override
	public Integer call() throws Exception {

		return age;
	}

}
