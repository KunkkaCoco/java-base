package thinkInjava.c14;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Counter2i extends Applet {
	private class SeparateSubTask extends Thread {
		int count = 0;
		boolean runFlag = true;

		SeparateSubTask() {
			start();
		}

		@Override
		public void run() {
			while (true) {
				try {
					sleep(100);
				} catch (InterruptedException e) {
				}
				if (runFlag) {
					t.setText(Integer.toString(count++));
				}
			}
		}
	}

	TextField t = new TextField(10);
	private SeparateSubTask sp = null;
	private Button onOff = new Button("Toogle"), start = new Button("Start");

	@Override
	public void init() {
		add(t);
		start.addActionListener(new StartL());
		add(start);
		onOff.addActionListener(new OnOffL());
		add(onOff);
	}

	class StartL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (sp == null) {
				sp = new SeparateSubTask();
			}
		}
	}

	class OnOffL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (sp != null) {
				sp.runFlag = !sp.runFlag;
			}
		}
	}

	public static void main(String[] args) {
		Counter2i applet = new Counter2i();
		Frame aFrame = new Frame("Counter2");
		aFrame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);

			}
		});
		aFrame.add(applet, BorderLayout.CENTER);
		aFrame.setSize(300, 200);
		applet.init();
		applet.start();
		aFrame.setVisible(true);
	}
}
