package com.chain;

import java.util.ArrayList;
import java.util.List;

//具体的管理类
public class MyHandler extends com.chain.Handler {
	
	List<Filter> filters = new ArrayList<>();
	private Action action = new MyAction();
	int index = -1;

	
	public void addFilter(Filter filter) {
		
		filters.add(filter);
	}
	
	public void removeFilter(Filter filter) {
		
		filters.remove(filter);
	}

	@Override
	public String doFilter(Handler handler) {
		index ++;
		String result = "";
		if(index < filters.size()) {
			
			result = filters.get(index).doFilter(this);
			
		} else {
			
			result = action.execute();
		}
		return result;
	}

}
