import java.awt.Graphics;

import javax.swing.JApplet;


public class Applet extends JApplet {

	public void paint(Graphics g) {
		super.paint(g);
		g.drawString("Hello World", 25, 25);
	}

}
