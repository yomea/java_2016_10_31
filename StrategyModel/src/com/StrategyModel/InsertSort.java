package com.StrategyModel;

public class InsertSort extends SortStrategy {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] sort(T[] arr) {
		
		for(int i = 1; i < arr.length; i++) {
			T index = arr[i];
			int j = i;
			while(j > 0 && ((Comparable<T>)arr[j - 1]).compareTo(index) > 0) {
				
				arr[j] = arr[j - 1];
				
				j--;
			}
			
			arr[j] = index;
			
		}
		
		return arr;
	}

}
