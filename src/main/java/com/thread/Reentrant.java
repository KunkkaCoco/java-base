package com.thread;

public class Reentrant {
	public synchronized void outer() {
		System.out.println("outer");
		inner();
	}

	public synchronized void inner() {
		// do something
		System.out.println("inner");
	}

	public static void main(String[] args) {
		Reentrant rt = new Reentrant();
		rt.outer();

	}
}