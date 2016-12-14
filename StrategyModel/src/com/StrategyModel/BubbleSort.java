package com.StrategyModel;

public class BubbleSort extends SortStrategy {

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] sort(T[] arr) {
		
		for(int i = arr.length; i > 1; i-- ) {
			boolean state = false;
			for(int j = 0; j < i - 1; j++) {
				if(((Comparable<T>)arr[j]).compareTo(arr[j + 1]) > 0) {
					
					T temp = arr[j];
					
					arr[j] = arr[j + 1];
					
					arr[j + 1] = temp;
					
					state = true;
				}
				
			}
			
			if(!state) {
				break;
			}
			
		}
		
		return arr;
	}

}
