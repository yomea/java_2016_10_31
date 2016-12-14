package com.guava;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Table;
import com.google.common.collect.Table.Cell;

/**
 * 
 * 双键的Map-->table
 * @author may
 *
 */
public class Demo9 {
	
	public static void main(String[] args) {
		//创建table
		Table<String, String, Integer> table = HashBasedTable.create();
		
		table.put("小明", "Java", 100);
		
		table.put("小明", "javaScript", 100);
		
		table.put("小红", "oracle", 100);
		
		table.put("小红", "java", 100);
		
		Set<Cell<String, String, Integer>> set = table.cellSet();
		
		for (Cell<String, String, Integer> cell : set) {
			
			System.out.println(cell.getRowKey() +"-->" + cell.getColumnKey() + "-->" + cell.getValue());
		}
		
		System.out.println("*************************************************************");
		
		System.out.print("姓名" + "\t");
		
		System.out.print("课程" + "\t");
		
		System.out.print("成绩" + "\t");
		
		Set<String> columnKeySet = table.columnKeySet();
		
		Set<String> rowKeySet = table.rowKeySet();
		
		Collection<Integer> value = table.values();
		
		Iterator<String> iterator = rowKeySet.iterator();
		
		while(iterator.hasNext()) {
			
			
		}
		
		
	}

}
