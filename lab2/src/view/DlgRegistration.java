package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controller.*;
import model.*;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgRegistration extends JDialog implements IDlg{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldMaster;
	private JTextField textFieldClient;
	private JTextField textFieldDate;
	private Registration registration;
	private Master master;
	private Client client;
	private IController controller;
	private JTextField textFieldService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRegistration dialog = new DlgRegistration();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRegistration() {
		setTitle("Registration");
		setModal(true);
		setBounds(100, 100, 363, 289);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textFieldMaster = new JTextField();
		textFieldMaster.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectMaster();
			}
		});
		textFieldMaster.setEditable(false);
		textFieldMaster.setBounds(33, 37, 124, 39);
		contentPanel.add(textFieldMaster);
		textFieldMaster.setColumns(10);
		
		textFieldClient = new JTextField();
		textFieldClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectClient();
			}
		});
		textFieldClient.setEditable(false);
		textFieldClient.setBounds(188, 37, 124, 39);
		contentPanel.add(textFieldClient);
		textFieldClient.setColumns(10);
		
		textFieldDate = new JTextField();
		textFieldDate.setBounds(33, 105, 124, 39);
		contentPanel.add(textFieldDate);
		textFieldDate.setColumns(10);
		
		JLabel lblMaster = new JLabel("Master");
		lblMaster.setBounds(36, 23, 92, 14);
		contentPanel.add(lblMaster);
		
		JLabel lblClient = new JLabel("Client");
		lblClient.setBounds(191, 23, 46, 14);
		contentPanel.add(lblClient);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(33, 89, 46, 14);
		contentPanel.add(lblDate);
		
		textFieldService = new JTextField();
		textFieldService.setBounds(188, 106, 124, 36);
		contentPanel.add(textFieldService);
		textFieldService.setColumns(10);
		
		JLabel lblService = new JLabel("Service");
		lblService.setBounds(188, 89, 55, 14);
		contentPanel.add(lblService);
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
	public JTextField getTextFieldDate() {
		return textFieldDate;
	}
	public void setController(IController controller) {
		this.controller = controller;
	}
	protected void selectMaster() {
		if (textFieldMaster.isEnabled()) {
			TableModel model = controller.getModel("Master");
			DlgSelect dlg = new DlgSelect(model,"Master");
			dlg.setVisible(true);
			master = (Master) dlg.getObject();
			textFieldMaster.setText(master.toString());
		}
	}
	protected void selectClient() {
		if (textFieldClient.isEnabled()) {
			TableModel model = controller.getModel("Client");
			DlgSelect dlg = new DlgSelect(model, "Client");
			dlg.setVisible(true);
			client = (Client) dlg.getObject();
			textFieldClient.setText(client.toString());
		}
	}
	public void setRegistration(String oldDate) {
		textFieldDate.setText(oldDate);
}

public void setMasterName(String oldMaster) {
		textFieldMaster.setText(oldMaster);
		textFieldMaster.setEnabled(false);
}

public void setClientName(String oldClient) {
		textFieldClient.setText(oldClient);
		textFieldClient.setEnabled(false);
}
public void setService(String oldService) {
	textFieldService.setText(oldService);
}

protected void onCancel() {
	registration = null;
	setVisible(false);
}
protected void onStore() {
	try {
		registration = new Registration();
		Date date = Date.valueOf(textFieldDate.getText());
		String service = textFieldService.getText();
		registration.setMaster(master);
		registration.setClient(client);
		registration.setDate(date);
		registration.setService(service);
	} catch (NumberFormatException e) {
		JOptionPane.showMessageDialog(null, e, this.getTitle(), JOptionPane.ERROR_MESSAGE);
		return;
	}
	setVisible(false);
}

@Override
public Object getObject() {
	// TODO Auto-generated method stub
	return registration;
}
	public JTextField getTextFieldService() {
		return textFieldService;
	}
	}
