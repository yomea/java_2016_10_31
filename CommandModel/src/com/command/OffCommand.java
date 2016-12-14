package com.command;

//关闭命令
public class OffCommand extends AbstractCommand {
	
	private TV tv;
	
	public OffCommand( TV tv) {
		this.tv = tv;
		
	}

	@Override
	public void offTV() {
		tv.offTV();

	}


}
