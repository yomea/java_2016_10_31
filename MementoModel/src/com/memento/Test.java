package com.memento;

public class Test {
	
	public static void main(String[] args) {
		
		Originator originator = new Originator();
		//发起一个状态（记录一件事）
		originator.setState("on");
		
		Memento memento = originator.createMemento();
		//发起另一个状态（忘记了某件事）
		originator.setState("off");
		
		Caretaker caretaker = new Caretaker(memento);
		//找备忘录，恢复某个状态（重新回忆起某件事）
		originator.restoreMemento(caretaker.getMemento());
		
	}

}
