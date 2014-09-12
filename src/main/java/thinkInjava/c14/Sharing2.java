package thinkInjava.c14;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class TwoCounter2 extends Thread {
	private boolean started = false;
	private TextField t1 = new TextField(5), t2 = new TextField(5);
	private Label l = new Label("count1 == count2");
	private int count1 = 0, count2 = 0;

	public TwoCounter2(Container c) {
		Panel p = new Panel();
		p.add(t1);
		p.add(t2);
		p.add(l);
		c.add(p);
	}

	@Override
	public void start() {
		if (!started) {
			started = true;
			super.start();
		}
	}

	@Override
	public void run() {
		while (true) {
			synchronized (this) {
				t1.setText(Integer.toString(count1++));
				t2.setText(Integer.toString(count2++));
			}
			try {
				sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}

	public synchronized void synchTest() {
		Sharing2.incrementAccess();
		if (count1 != count2) {
			l.setText("Unsynched");
			System.out.println("count1=" + count1 + ",count2=" + count1);
		}
	}
}

class Watcher2 extends Thread {
	private Sharing2 p;

	public Watcher2(Sharing2 p) {
		this.p = p;
		start();
	}

	@Override
	public void run() {
		while (true) {
			for (TwoCounter2 element : p.s) {
				element.synchTest();
			}
			try {
				sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}

public class Sharing2 extends Applet {
	TwoCounter2[] s;
	private static int accessCount = 0;
	private static TextField aCount = new TextField("0", 10);

	public static void incrementAccess() {
		accessCount++;
		aCount.setText(Integer.toString(accessCount));
	}

	private Button start = new Button("Start"), observer = new Button("Observe");
	private boolean isApplet = true;
	private int numCounters = 0;
	private int numObservers = 0;

	@Override
	public void init() {
		if (isApplet) {
			numCounters = Integer.parseInt(getParameter("size"));
			numObservers = Integer.parseInt(getParameter("observers"));
		}
		s = new TwoCounter2[numCounters];
		for (int i = 0; i < s.length; i++) {
			s[i] = new TwoCounter2(this);
		}
		Panel p = new Panel();
		start.addActionListener(new StartL());
		p.add(start);
		observer.addActionListener(new ObserverL());
		p.add(observer);
		p.add(new Label("Access Count"));
		p.add(aCount);
		add(p);
	}

	class StartL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (TwoCounter2 element : s) {
				element.start();
			}
		}
	}

	class ObserverL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < numObservers; i++) {
				new Watcher2(Sharing2.this);
			}
		}
	}

	public static void main(String[] args) {
		Sharing2 applet = new Sharing2();
		applet.isApplet = false;
		applet.numCounters = 20;
		applet.numObservers = 20;
		Frame aFrame = new Frame("Sharing2");
		aFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		aFrame.add(applet, BorderLayout.CENTER);
		aFrame.setSize(350, applet.numCounters * 100);
		applet.init();
		applet.start();
		aFrame.setVisible(true);

	}

}