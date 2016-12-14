package com.visitor;

import java.util.Vector;

/**
 * 电子商店
 * @author may
 *
 */
public class ElectronicStore {
	
	private Vector<Electronics> electronics = new Vector<>();
	
	public void accept(Visitor visitor) {
		
		for (Electronics electronic : electronics) {
			electronic.accept(visitor);
		}
		
	}
	
	public void addElectronic(Electronics e) {
		electronics.add(e);
		
	}

}
