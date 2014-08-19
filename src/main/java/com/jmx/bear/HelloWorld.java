package com.jmx.bear;

public class HelloWorld implements HelloWorldMBean {

	private final String name = "zhangshans";
	private final int DEFAULT_CACHE_SIZE = 200;
	private int cacheSize = DEFAULT_CACHE_SIZE;

	@Override
	public void sayHello() {
		System.out.println("hello World JMX ");
	}

	@Override
	public int add(int x, int y) {
		return x + y;
	}

	@Override
	public String gerName() {
		return this.name;
	}

	@Override
	public int getCacheSize() {
		return this.cacheSize;
	}

	@Override
	public void setCacheSize(int size) {
		this.cacheSize = size;
		System.out.println("Cache size now " + this.cacheSize);
	}

}
