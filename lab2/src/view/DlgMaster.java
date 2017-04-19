package view;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Master;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgMaster extends JDialog implements  IDlg {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldLName;
	private JTextField textFieldFName;
	private Master master;
	private JTextField textFieldEmail;
	private JTextField textFieldActivity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgMaster dialog = new DlgMaster();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgMaster() {
		setModal(true);
		setTitle("Master");
		setBounds(100, 100, 261, 358);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textFieldLName = new JTextField();
		textFieldLName.setBounds(30, 50, 157, 31);
		contentPanel.add(textFieldLName);
		textFieldLName.setColumns(10);
		
		textFieldFName = new JTextField();
		textFieldFName.setBounds(30, 106, 157, 31);
		contentPanel.add(textFieldFName);
		textFieldFName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(30, 34, 74, 14);
		contentPanel.add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(30, 92, 74, 14);
		contentPanel.add(lblFirstName);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(30, 225, 157, 31);
		contentPanel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(30, 210, 46, 14);
		contentPanel.add(lblEmail);
		
		textFieldActivity = new JTextField();
		textFieldActivity.setBounds(30, 168, 157, 31);
		contentPanel.add(textFieldActivity);
		textFieldActivity.setColumns(10);
		
		JLabel lblActivity = new JLabel("Activity");
		lblActivity.setBounds(30, 148, 46, 14);
		contentPanel.add(lblActivity);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Store");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onStore();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						onCancel();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public JTextField getTextFieldLName() {
		return textFieldLName;
	}
	public JTextField getTextFieldFName() {
		return textFieldFName;
	}
	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}
	public JTextField getTextFieldActivity() {
		return textFieldActivity;
	}
	public Object getObject() {
		return master;
	}
	public void setLastname(String lastname) {
		textFieldLName.setText(lastname);
	}
	public void setFirstname(String firstname) {
		textFieldFName.setText(firstname);
	}
	public void setEmail(String email) {
		textFieldEmail.setText(email);
	}
	public void setActivity(String activity) {
		textFieldActivity.setText(activity);
	}
	protected void onCancel() {
		master = null;
		setVisible(false);
	}
	protected void onStore() {
		master = new Master();
		String lastname = textFieldLName.getText();
		String firstname = textFieldFName.getText();
		String activity = textFieldActivity.getText();
		String email = textFieldEmail.getText();
		master.setLastname(lastname);
		master.setFirstname(firstname);
		master.setActivity(activity);
		master.setEmail(email);
		setVisible(false);
	}
}
