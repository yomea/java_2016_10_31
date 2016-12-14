package com.command;

//打开命令
public class OnCommand extends AbstractCommand{
	
	private TV tv;
	
	public OnCommand(TV tv) {
		this.tv = tv;
	}
	

	@Override
	public void onTV() {
		tv.onTV();

	}

}
