package source;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class Dlg extends JDialog {

	protected final JPanel contentPanel = new JPanel();
	protected JButton okButton = new JButton("OK");
	protected JButton cancelButton = new JButton("Cancel");
	protected JTextField textFieldMinistry;
	protected boolean ok;

	/**
	 * Launch the application.
	 */
	// public static void main(String[] args) {
	// try {
	// Dlg dialog = new Dlg();
	// dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	// dialog.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * Create the dialog.
	 */
	public Dlg() {
		setModal(true);
		setBounds(100, 100, 393, 171);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JLabel lblNewLabel = new JLabel("Ministry");
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldMinistry = new JTextField();
			contentPanel.add(textFieldMinistry);
			textFieldMinistry.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();

			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ok = true;
						setVisible(false);
					}
				});

				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{

				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ok = false;
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}

		}
	}

	public abstract Object createObject() throws Exception;
	public void setEditable (boolean b){
		okButton.setVisible(b);
		if(b)
			cancelButton.setText("Cancel");
		else
			cancelButton.setText("Exit");
		for(Component c: contentPanel.getComponents())
			c.setEnabled(b);
	}
}