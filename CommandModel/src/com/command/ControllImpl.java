package com.command;

/**
 * 控制实现类
 * @author may
 *
 */
public class ControllImpl implements Controll {
	//遥控器所拥有的命令
	private Command offCommand, onComma;
	
	public ControllImpl(Command offCommand, Command OnComma) {
		this.offCommand = offCommand;
		this.onComma = OnComma;
		
	}
	
	public void offTV() {
		offCommand.offTV();
		
	}
	
	public void onTV() {
		onComma.onTV();
		
	}
	
	@Override
	public void execute() {
		//检查客户端是否发出了这个命令
		if(offCommand != null) {
			this.offTV();
			
		}

		if(onComma != null) {
			onComma.onTV();
		}
	}

}
