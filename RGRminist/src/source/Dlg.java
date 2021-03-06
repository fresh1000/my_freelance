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
import java.awt.Font;

public abstract class Dlg extends JDialog {

	protected final JPanel contentPanel = new JPanel();
	protected JButton okButton = new JButton("OK");
	protected JButton cancelButton = new JButton("Cancel");
	protected JTextField textFieldAnyName;
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
		setBounds(100, 100, 246, 193);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Name");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(64, 44, 35, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldAnyName = new JTextField();
			textFieldAnyName.setBounds(109, 43, 86, 20);
			contentPanel.add(textFieldAnyName);
			textFieldAnyName.setColumns(10);
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
