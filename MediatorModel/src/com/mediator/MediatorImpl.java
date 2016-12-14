package com.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorImpl implements Mediator {
	
	private List<Person> list = new ArrayList<>();
	
	public void jiaoshui() {
		
		for (Person person : list) {
			person.jiaoshui();
		}
		
	}

}
