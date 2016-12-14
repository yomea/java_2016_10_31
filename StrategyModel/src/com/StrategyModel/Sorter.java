package com.StrategyModel;

public class Sorter {
	
	private SortStrategy sorterStrategy;
	
	public Sorter(SortStrategy sorterStrategy) {
		this.sorterStrategy = sorterStrategy;
		
	}
	
	public <T> T[] sort(T[] arr) {
		if(arr == null) {
			
			return null;
		}
		
		return sorterStrategy.sort(arr);
	}
	
	public <T> void print(T[] arr) {
		if(arr == null) {
					
			System.out.println("null");
			return;
		}
		
		for (T t : arr) {
			System.out.println(t);
		}
		
		
	}

}
