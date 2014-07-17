package thinkInjava.c14;

import java.io.IOException;

/**
 * 守护线程在没有用户线程可服务时自动离开
 * 
 * @author 五斗米
 * @blog http://blog.csdn.net/mq612
 */
public class TestMain4 extends Thread {

	public TestMain4() {
	}

	/**
	 * 线程的run方法，它将和其他线程同时运行
	 */
	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		TestMain4 test = new TestMain4();
		test.setDaemon(false);
		test.start();
		TestMain4 test1 = new TestMain4();
		test1.setDaemon(false);
		test1.start();
		System.out.println("isDaemon = " + test.isDaemon());
		try {
			System.in.read(); // 接受输入，使程序在此停顿，一旦接收到用户输入，main线程结束，守护线程自动结束
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}