package com.thread;

public class Threadtest extends Thread {

	// public Threadtest() {
	// start();
	// }

	@Override
	public void run() {
		int con = 3;
		while (con > 0) {
			System.out.println("lllllllllllll");
			con--;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Threadtest t = new Threadtest();
		t.start();
	}
}
