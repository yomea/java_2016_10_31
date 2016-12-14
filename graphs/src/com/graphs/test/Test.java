package com.graphs.test;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class Test {
	
	public static void main(String[] args) {
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		dataset.setValue("hello", 142);
		dataset.setValue("youth", 45);
		dataset.setValue("yes", 3);
		dataset.setValue("no", 213);
		
		JFreeChart chart = ChartFactory.createPieChart("test", dataset, true, true, false);
		
		ChartFrame frame = new ChartFrame("title", chart, true);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
	}

}
