package com.thread;

import sun.misc.Lock;

public class Reentrant1 {
	Lock lock = new Lock();

	public void outer() throws InterruptedException {
		System.out.println("outer");
		lock.lock();
		inner();
		lock.unlock();
	}

	public synchronized void inner() throws InterruptedException {
		lock.lock();
		// do something
		System.out.println("inner");
		lock.unlock();
	}

	public static void main(String[] args) {
		Reentrant1 rt2 = new Reentrant1();
		try {
			rt2.inner();
			System.out.println("-------------");
			rt2.outer();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}