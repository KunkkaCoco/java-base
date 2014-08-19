package com.jmx.bear;

import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import com.jmx.bear.mxbean.QueueStudent;

public class Main {

	public static void main(String[] args) throws Exception, NullPointerException {

		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		ObjectName name = new ObjectName("com.bear:type=HelloWorld");
		HelloWorld hw = new HelloWorld();
		mbs.registerMBean(hw, name);

		ObjectName queueName = new ObjectName("com.bear.mxbean:type=QueueStudent");
		Queue<String> queue = new ArrayBlockingQueue<String>(10);
		queue.add("first");
		queue.add("second");
		queue.add("third");

		QueueStudent qs = new QueueStudent(queue);
		mbs.registerMBean(qs, queueName);

		System.out.println("Waiting forever...");
		Thread.sleep(Long.MAX_VALUE);
	}

}
