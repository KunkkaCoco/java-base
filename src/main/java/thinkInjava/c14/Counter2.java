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

public class Counter2 extends Applet {
	TextField textfield = new TextField(10);
	private SeparateSubTask sp = null;
	private Button onOff = new Button("Toogle"), start = new Button("Start");

	@Override
	public void init() {
		add(textfield);
		start.addActionListener(new StartL());
		add(start);
		onOff.addActionListener(new OnOffL());
		add(onOff);
	}

	class StartL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (sp == null) {
				sp = new SeparateSubTask(Counter2.this);
			}
		}
	}

	class OnOffL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (sp != null) {
				sp.invertFlag();
			}
		}
	}

	public static void main(String[] args) {
		Counter2 applet = new Counter2();
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
