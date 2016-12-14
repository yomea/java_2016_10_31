package com.memento;

/**
 * 发起人，发起某个信息（这里用的是状态表示）,并创建备忘录，存到负责人那里。
 * @author may
 *
 */
public class Originator {
	
	private String state;
	
	public Memento createMemento() {
		
		return new Memento(state);
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
		System.out.println("发起人状态已设置为:" + state);
	}

	public void restoreMemento(Memento memento) {
		this.state = memento.getState();
		System.out.println("已恢复状态为:" + state);
		
	}
	
	

}
