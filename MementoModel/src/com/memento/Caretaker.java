package com.memento;
/**
 * 负责人，用来管理（储存）备忘录
 * @author may
 *
 */
public class Caretaker {
	
	private Memento memento;
	
	public Caretaker(Memento memento) {
		this.memento = memento;
		
	}

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
	

}
