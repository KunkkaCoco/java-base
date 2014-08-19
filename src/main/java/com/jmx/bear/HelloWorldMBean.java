package com.jmx.bear;

public interface HelloWorldMBean {

	public void sayHello();

	public int add(int x, int y);

	public String gerName();

	public int getCacheSize();

	public void setCacheSize(int size);

}
