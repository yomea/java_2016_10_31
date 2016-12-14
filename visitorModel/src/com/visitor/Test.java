package com.visitor;

public class Test {
	
	public static void main(String[] args) {
		
		Visitor visitor = new VisitorPerson();
		
		ElectronicStore electronicStore = new ElectronicStore();
		
		Electronics compute = new Compute();
		
		Electronics mobile = new Mobile();
		
		electronicStore.addElectronic(compute);
		
		electronicStore.addElectronic(mobile);
		
		electronicStore.accept(visitor);
		
	}

}
