package com.StrategyModel;

public class SelectSort extends SortStrategy {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] sort(T[] arr) {
		
		for(int i = 0; i < arr.length - 1; i++) {
			int n = i;
			for(int j = i; j < arr.length; j++) {
				if(((Comparable<T>)arr[n]).compareTo(arr[j]) > 0) {
					
					n = j;
					
				}
				
			}
			
			if(n != i) {
				
				T temp = arr[i];
				arr[i] = arr[n];
				arr[n] = temp;
				
			}
			
		}
		
		return arr;
	}

}
