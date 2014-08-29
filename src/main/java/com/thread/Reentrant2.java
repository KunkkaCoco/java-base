package com.thread;


public class Reentrant2 {
	MyLock lock = new MyLock();

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
		Reentrant2 rt2 = new Reentrant2();
		try {
			rt2.inner();
			System.out.println("-------------");
			rt2.outer();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}