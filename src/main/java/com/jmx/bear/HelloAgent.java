package com.jmx.bear;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class HelloAgent {

	private MBeanServer mbs = null;

	/*
	 * public HelloAgent()
	 * {
	 * mbs = MBeanServerFactory.createMBeanServer("HelloAgent");
	 * 
	 * 
	 * RmiConnectorServer connector = new RmiConnectorServer();
	 * 
	 * 
	 * }
	 */

	public static void main(String[] args) throws Exception, NullPointerException {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName("com.bear:type=HelloWorld");
		HelloWorld mbean = new HelloWorld();
		System.out.println("Waiting forever...");
		Thread.sleep(Long.MAX_VALUE);

	}

}
