package com.chain;

//管理类
public abstract class Handler {

	public abstract String doFilter(Handler handler);

	public abstract void addFilter(Filter filter);

	public abstract void removeFilter(Filter filter);

}
