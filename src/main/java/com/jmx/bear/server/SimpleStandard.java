package com.jmx.bear.server;

/**
 *
 * The "SimpleStandard" standard MBean shows how to expose attributes
 * and operations for management by implementing its corresponding
 * "SimpleStandardMBean" management interface.
 *
 * This MBean has two attributes and one operation exposed
 * for management by a JMX agent:
 *      - the read/write "State" attribute,
 *      - the read only "NbChanges" attribute,
 *      - the "reset()" operation.
 *
 * This object also has one property and one method not exposed
 * for management by a JMX agent:
 *      - the "NbResets" property,
 *      - the "getNbResets()" method.
 */

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.NotificationBroadcasterSupport;

// 标准Mbean 继承通知
public class SimpleStandard extends NotificationBroadcasterSupport implements SimpleStandardMBean {

	// 已暴露给 JMX
	private String state = "initial state";
	private int nbChanges = 0;
	// 未暴露给 JMX 属性
	private int nbResets = 0;

	@Override
	public String getState() {
		System.out.println("           >>调用 getState() 返回state: " + state);
		return state;
	}

	@Override
	public void setState(String s) {
		System.out.println("           >>调用 setState() 设置state: " + state);
		state = s;
		nbChanges++;
	}

	@Override
	public int getNbChanges() {
		System.out.println("           >>调用 getNbChanges() 返回nbChanges: " + nbChanges);
		return nbChanges;
	}

	// 初始化各种状态
	@Override
	public void reset() {
		AttributeChangeNotification acn = new AttributeChangeNotification(this, 0, 0, "NbChanges reset", "NbChanges",
				"Integer", new Integer(nbChanges), new Integer(0));
		state = "initial state";
		nbChanges = 0;
		nbResets++;
		sendNotification(acn);
	}

	// 保留属性
	public int getNbResets() {
		return nbResets;
	}

	public void setNbResets(int nbResets) {
		this.nbResets = nbResets;
	}

	// 通知继承 覆写
	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		return new MBeanNotificationInfo[] { new MBeanNotificationInfo(
				new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE },
				AttributeChangeNotification.class.getName(),
				"This notification is emitted when the reset() method is called.") };
	}

}
