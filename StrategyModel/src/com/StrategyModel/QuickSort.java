package com.StrategyModel;

public class QuickSort extends SortStrategy {

	@Override
	public <T> T[] sort(T[] arr) {
		
		this.quick(arr, 0, arr.length - 1);
		
		return arr;
	}
	
	@SuppressWarnings("unchecked")
	public <T> void quick(T[] arr, int low, int high) {
		int i, j;
		T index;
		
		if(low >= high) {
			
			return ;
		}
		
		i = low;
		j = high;
		index = arr[low];
		
		while(i < j) {
			
			while(i < j && ((Comparable<T>)arr[j]).compareTo(index) >= 0) {
				j --;
			}
			if(i < j) {
				arr[i++] = arr[j];
				
			}
			while(i < j && ((Comparable<T>)arr[i]).compareTo(index) <= 0) {
				
				i ++;
			}
			if(i < j) {
				arr[j--] = arr[i];
				
			}
			
		}
		
		arr[i] = index;
		this.quick(arr, low, i - 1);
		this.quick(arr, i + 1, high);
		
	}

}
