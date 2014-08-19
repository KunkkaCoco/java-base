package com.jmx.bear;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class HelloWorldNotice extends NotificationBroadcasterSupport implements HelloWorldMBean {

	private final String name = "zhangshans";
	private final int DEFAULT_CACHE_SIZE = 200;
	private int cacheSize = DEFAULT_CACHE_SIZE;
	private long sequenceNumber = 0;

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
		int oldValue = size;
		this.cacheSize = size;

		Notification n = new AttributeChangeNotification(this, sequenceNumber, System.currentTimeMillis(),
				"the ChacheSize is changed", "CacheSize", "int", oldValue, this.cacheSize);
		sendNotification(n);
		System.out.println("Cache size now " + this.cacheSize);
	}

	// 获取通知信息
	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		// TODO Auto-generated method stub
		String[] types = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };

		String name = AttributeChangeNotification.class.getName();
		String description = "an attribute of the Mbean has changed ";

		MBeanNotificationInfo mni = new MBeanNotificationInfo(types, name, description);

		return new MBeanNotificationInfo[] { mni };
	}

}
