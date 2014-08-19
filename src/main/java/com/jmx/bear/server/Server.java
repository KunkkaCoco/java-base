package com.jmx.bear.server;

import java.io.IOException;

import javax.management.Attribute;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanConstructorInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanNotificationInfo;
import javax.management.MBeanOperationInfo;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

public class Server {

	public void startRun() throws Exception, NullPointerException {
		String mbeanClassName = "com.bear.server.SimpleStandard";

		MBeanServer mbs = MBeanServerFactory.createMBeanServer();
		String doMain = mbs.getDefaultDomain();
		System.out.println("doMain: " + doMain);

		String mbeanObjNameStr = "com.bear.server:type=SimpleStandard";
		System.out.println(new SimpleStandard().getClass().getName());
		ObjectName mbeanObjectName = ObjectName.getInstance(mbeanObjNameStr);
		mbs.createMBean(mbeanClassName, mbeanObjectName);

		System.out.println("======>>>");

	}

	public static void main3(String[] args) throws Exception, Exception {

		new Server().startRun();

	}

	public static void main(String[] args) {

		String mbeanClassName = "com.bear.server.SimpleStandard";

		try {

			// 初始化 MbeanServer
			echo("\n>>> Create the MBean server");
			MBeanServer mbs = MBeanServerFactory.createMBeanServer();
			waitForEnterPressed();

			// 获取server domain
			echo("\n>>> Get the MBean server's default domain");
			String domain = mbs.getDefaultDomain();
			echo("\tDefault Domain = " + domain);
			waitForEnterPressed();

			// 注册Mbean
			String mbeanObjectNameStr = domain + ":type=" + mbeanClassName + ",name=1";
			ObjectName mbeanObjectName = createSimpleMBean(mbs, mbeanClassName, mbeanObjectNameStr);
			waitForEnterPressed();

			// 打印Mbean暴露信息
			System.out.println("=========================================================================");
			printMBeanInfo(mbs, mbeanObjectName, mbeanClassName);
			waitForEnterPressed();

			// Manage the SimpleStandard MBean
			// 简单管理Mbean
			System.out.println("=========================================================================");
			manageSimpleMBean(mbs, mbeanObjectName, mbeanClassName);
			waitForEnterPressed();

			// 注册动态Mbean
			// Create and register the SimpleDynamic MBean
			//
			/*
			 * mbeanClassName = "com.bear.server.SimpleDynamic";
			 * mbeanObjectNameStr =
			 * domain + ":type=" + mbeanClassName + ",name=1";
			 * mbeanObjectName =
			 * createSimpleMBean(mbs, mbeanClassName, mbeanObjectNameStr);
			 * waitForEnterPressed();
			 * 
			 * // Get and display the management information exposed by the
			 * // SimpleDynamic MBean
			 * //
			 * printMBeanInfo(mbs, mbeanObjectName, mbeanClassName);
			 * waitForEnterPressed();
			 * 
			 * // Manage the SimpleDynamic MBean
			 * //
			 * manageSimpleMBean(mbs, mbeanObjectName, mbeanClassName);
			 * waitForEnterPressed();
			 */

			// Create an RMI connector server
			//
			// 创建远程调用 connector 服务端
			echo("\nCreate an RMI connector server");
			String rmiStr = "service:jmx:rmi:///jndi/rmi://localhost:9999/server";
			JMXServiceURL url = new JMXServiceURL(rmiStr);
			JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(url, null, mbs);

			// Start the RMI connector server
			//
			echo("\nStart the RMI connector server");
			cs.start();
			echo("\nThe RMI connector server successfully started");
			echo(rmiStr);
			echo("and is ready to handle incoming connections");
			echo("\nStart the client on a different window and");
			echo("press <Enter> once the client has finished");
			waitForEnterPressed();

			/*
			 * // Stop the RMI connector server
			 * //
			 * echo("\nStop the RMI connector server");
			 * cs.stop();
			 * System.out.println("\nBye! Bye!");
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static ObjectName createSimpleMBean(MBeanServer mbs, String mbeanClassName, String mbeanObjectNameStr) {
		echo("\n>>> Create the " + mbeanClassName + " MBean within the MBeanServer");
		echo("\tObjectName = " + mbeanObjectNameStr);
		try {
			ObjectName mbeanObjectName = ObjectName.getInstance(mbeanObjectNameStr);
			mbs.createMBean(mbeanClassName, mbeanObjectName);
			return mbeanObjectName;
		} catch (Exception e) {
			echo("\t!!! Could not create the " + mbeanClassName + " MBean !!!");
			e.printStackTrace();
			echo("\nEXITING...\n");
			System.exit(1);
		}
		return null;
	}

	private static void printMBeanInfo(MBeanServer mbs, ObjectName mbeanObjectName, String mbeanClassName) {
		echo("\n>>> Retrieve the management information for the " + mbeanClassName);
		echo("    MBean using the getMBeanInfo() method of the MBeanServer");
		MBeanInfo info = null;
		try {
			info = mbs.getMBeanInfo(mbeanObjectName);
		} catch (Exception e) {
			echo("\t!!! Could not get MBeanInfo object for " + mbeanClassName + " !!!");
			e.printStackTrace();
			return;
		}
		echo("\nCLASSNAME: \t" + info.getClassName());
		echo("\nDESCRIPTION: \t" + info.getDescription());
		echo("\nATTRIBUTES");
		MBeanAttributeInfo[] attrInfo = info.getAttributes();
		if (attrInfo.length > 0) {
			for (MBeanAttributeInfo element : attrInfo) {
				echo(" ** NAME: \t" + element.getName());
				echo("    DESCR: \t" + element.getDescription());
				echo("    TYPE: \t" + element.getType() + "\tREAD: " + element.isReadable() + "\tWRITE: "
						+ element.isWritable());
			}
		} else {
			echo(" ** No attributes **");
		}
		echo("\nCONSTRUCTORS");
		MBeanConstructorInfo[] constrInfo = info.getConstructors();
		for (MBeanConstructorInfo element : constrInfo) {
			echo(" ** NAME: \t" + element.getName());
			echo("    DESCR: \t" + element.getDescription());
			echo("    PARAM: \t" + element.getSignature().length + " parameter(s)");
		}
		echo("\nOPERATIONS");
		MBeanOperationInfo[] opInfo = info.getOperations();
		if (opInfo.length > 0) {
			for (MBeanOperationInfo element : opInfo) {
				echo(" ** NAME: \t" + element.getName());
				echo("    DESCR: \t" + element.getDescription());
				echo("    PARAM: \t" + element.getSignature().length + " parameter(s)");
			}
		} else {
			echo(" ** No operations ** ");
		}
		echo("\nNOTIFICATIONS");
		MBeanNotificationInfo[] notifInfo = info.getNotifications();
		if (notifInfo.length > 0) {
			for (MBeanNotificationInfo element : notifInfo) {
				echo(" ** NAME: \t" + element.getName());
				echo("    DESCR: \t" + element.getDescription());
				String notifTypes[] = element.getNotifTypes();
				for (String notifType : notifTypes) {
					echo("    TYPE: \t" + notifType);
				}
			}
		} else {
			echo(" ** No notifications **");
		}
	}

	private static void manageSimpleMBean(MBeanServer mbs, ObjectName mbeanObjectName, String mbeanClassName) {

		echo("\n>>> Manage the " + mbeanClassName + " MBean using its attributes ");
		echo("    and operations exposed for management");

		try {
			// Get attribute values
			printSimpleAttributes(mbs, mbeanObjectName);

			// Change State attribute
			echo("\n    Setting State attribute to value \"new state\"...");
			Attribute stateAttribute = new Attribute("State", "new state");
			mbs.setAttribute(mbeanObjectName, stateAttribute);

			// Get attribute values
			printSimpleAttributes(mbs, mbeanObjectName);

			// Invoking reset operation
			echo("\n    Invoking reset operation...");
			mbs.invoke(mbeanObjectName, "reset", null, null);

			// Get attribute values
			printSimpleAttributes(mbs, mbeanObjectName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void printSimpleAttributes(MBeanServer mbs, ObjectName mbeanObjectName) {
		try {
			echo("\n    Getting attribute values:");
			String State = (String) mbs.getAttribute(mbeanObjectName, "State");
			Integer NbChanges = (Integer) mbs.getAttribute(mbeanObjectName, "NbChanges");
			echo("\tState     = \"" + State + "\"");
			echo("\tNbChanges = " + NbChanges);
		} catch (Exception e) {
			echo("\t!!! Could not read attributes !!!");
			e.printStackTrace();
		}
	}

	private static void echo(String msg) {
		System.out.println(msg);
	}

	private static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void waitForEnterPressed() {
		try {
			echo("\nPress <Enter> to continue...");
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
