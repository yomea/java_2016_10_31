package com.memento.blackBox;

import java.util.Vector;

/**
 * 负责人
 * @author may
 *
 */
public class Caretaker {
	
	private Vector<Memento> mementos = null;
	private Originator originator;
	
	public Caretaker(Originator originator) {
		this.originator = originator;
		this.mementos = new Vector<Memento>();
	}
	
	
	public void createMemento() {
		
		mementos.addElement(originator.createMemento());
		
	}
	
	public void restoreMemento(int index) {
		
		originator.restoreMemento(mementos.get(index));
	}
	

}
