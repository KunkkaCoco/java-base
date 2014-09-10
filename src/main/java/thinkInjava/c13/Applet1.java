package thinkInjava.c13;

import java.applet.Applet;
import java.awt.Graphics;

public class Applet1 extends Applet {

	@Override
	public void paint(Graphics g) {
		g.drawString("my applet", 10, 10);
	}
}
