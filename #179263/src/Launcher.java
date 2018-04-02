import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Launcher extends JFrame{
	private JTextArea textArea = new JTextArea();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu launchMenu = new JMenu("Launch");
	private JMenuItem launchBoxMenuItem = new JMenuItem("Launch Box");
	private JMenuItem launchDialogBoxMenuItem = new JMenuItem("Launch DialogBox");
	private JMenuItem launchConversionMenuItem = new JMenuItem("Launch Conversion");
	private JMenuItem exitMenu = new JMenuItem("Exit");
	
	
	public Launcher() {
		getContentPane().setLayout(null);
		this.setBounds(100, 100, 392, 284);
		
		textArea.setBounds(0, 0, 376, 224);
		getContentPane().add(textArea);		
		setJMenuBar(menuBar);		
		menuBar.add(launchMenu);
		menuBar.add(exitMenu);
		
		launchBoxMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("Box launched\n");
				TestBox.main(new String[]{});
			}
		});
		
		launchConversionMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("Conversion launched\n");
				Conversion.main(new String[]{});
			}
		});
		
		launchDialogBoxMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append("DialogBox launched\n");
				DialogBox.main(new String[]{});
			}
		});
		
		exitMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		launchMenu.add(launchBoxMenuItem);
		launchMenu.add(launchDialogBoxMenuItem);
		launchMenu.add(launchConversionMenuItem);
	}

	

	public static void main(String[] args) {
		Launcher app = new Launcher();
		app.setVisible(true);
	}
}
