package view;

import java.awt.BorderLayout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Client;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgClient extends JDialog implements  IDlg {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldLName;
	private JTextField textFieldFName;
	private Client client;
	private JTextField textFieldEmail;
	private JTextField textFieldDiscount;

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
	public DlgClient() {
		setModal(true);
		setTitle("Client");
		setBounds(100, 100, 261, 368);
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
		textFieldEmail.setBounds(30, 216, 157, 31);
		contentPanel.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(30, 201, 46, 14);
		contentPanel.add(lblEmail);
		
		textFieldDiscount = new JTextField();
		textFieldDiscount.setBounds(30, 163, 157, 31);
		contentPanel.add(textFieldDiscount);
		textFieldDiscount.setColumns(10);
		
		JLabel lblDiscountCard = new JLabel("Discount Card");
		lblDiscountCard.setBounds(30, 148, 74, 14);
		contentPanel.add(lblDiscountCard);
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
	public JTextField getTextFieldDiscount() {
		return textFieldDiscount;
	}
	public JTextField getTextFieldEmail() {
		return textFieldEmail;
	}
	public Object getObject() {
		return client;
	}
	public void setLastname(String lastname) {
		textFieldLName.setText(lastname);
	}
	public void setFirstname(String firstname) {
		textFieldFName.setText(firstname);
	}
	public void setDiscountCard(String discountcard) {
		textFieldDiscount.setText(discountcard);
	}
	public void setEmail(String email) {
		textFieldEmail.setText(email);
	}
	protected void onCancel() {
		client = null;
		setVisible(false);
	}
	protected void onStore() {
		client = new Client();
		String lastname = textFieldLName.getText();
		String firstname = textFieldFName.getText();
		int discountcard = Integer.parseInt(textFieldDiscount.getText());
		String email = textFieldEmail.getText();
		client.setLastname(lastname);
		client.setFirstname(firstname);
		client.setDiscountCard(discountcard);
		client.setEmail(email);
		setVisible(false);
	}
}
