package thinkInjava.c14;

import java.awt.Container;
import java.awt.TextField;
//: Blocking.java
// Demonstrates the various ways a thread
// can be blocked.

class Blockable extends Thread {
	private Peeker peeker;
	protected TextField state = new TextField(40);
	protected int i;

	protected Blockable(Container c) {
		c.add(state);
		peeker = new Peeker(this, c);
	}

	public synchronized int read() {
		return i;
	}

	protected synchronized void update() {
		state.setText(getClass().getName() + " state:i=" + i);
	}

	public void stopPeeker() {
		peeker.terminate();
	}
}

class Peeker extends Thread {
	private Blockable b;
	private int session;
	private TextField status = new TextField(40);
	private boolean stop = false;

	public Peeker(Blockable b, Container c) {
		c.add(status);
		this.b = b;
		start();
	}

	public void terminate() {
		stop = true;
	}

	@Override
	public void run() {
		while (!stop) {
			status.setText(b.getClass().getName() + " Peeker " + (++session) + "; value = " + b.read());
			try {
				sleep(100);

			} catch (InterruptedException e) {
			}
		}

	}
}// /:Continued
// /:Continuing
// /////////// Blocking via sleep() ///////////

class Sleeper1 extends Blockable {
	public Sleeper1(Container c) {
		super(c);
	}

	@Override
	public synchronized void run() {
		while (true) {
			i++;
			update();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

}

class Sleeper2 extends Blockable {
	public Sleeper2(Container c) {
		super(c);
	}

	@Override
	public void run() {
		while (true) {
			change();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public synchronized void change() {
		i++;
		update();
	}

}

// /:Continuing
// ///////// Blocking via suspend() ///////////
class SuspendResume extends Blockable {
	public SuspendResume(Container c) {
		super(c);
		new Resumer(this);
	}

}

class SuspendResume1 extends SuspendResume {
	public SuspendResume1(Container c) {
		super(c);
	}

	@Override
	public synchronized void run() {
		while (true) {
			i++;
			update();
			suspend();
		}
	}
}

class SuspendResume2 extends SuspendResume {
	public SuspendResume2(Container c) {
		super(c);
	}

	@Override
	public void run() {
		while (true) {
			change();
			suspend();
		}
	}

	public synchronized void change() {
		i++;
		update();
	}
}
class Resumer extends Thread{
	private SuspendResume sr;
	public Resumer(SuspendResume sr){
		this.sr = sr;
		start();
	}
	public void run(){
		while(true){
			try{
				sleep(1000)
			}catch(InterruptedException e){}
			sr.resume();
		}

	}
}///:Continued


public class Blocking {

}
