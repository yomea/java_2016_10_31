package com.StrategyModel;

public class Test {
	
	public static void main(String[] args) {
		
		Integer[] arr = {23,45,1346,7,2,77,2367,5,75,23};
		//java.swing中的布局管理器使用的就是策略模式
		//Sorter sorter = new Sorter(new SelectSort());
		//Sorter sorter = new Sorter(new BubbleSort());
		//Sorter sorter = new Sorter(new InsertSort());
		Sorter sorter = new Sorter(new QuickSort());
		
		arr = sorter.sort(arr);
		
		sorter.print(arr);
		
		
		
	}
	

}
