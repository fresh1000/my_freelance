package graphics;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public abstract class MainDialog extends JDialog {

	protected final JPanel contentPanel = new JPanel();
	protected JTextField textField;
	protected JButton okButton;
	protected JButton cancelButton;
	protected boolean ok;
	
	public abstract Object createObject() throws Exception;
	
	public void setEditable(boolean b) {
		okButton.setVisible(b);
		if(b) {
			cancelButton.setText("Cancel");
		} else {
			cancelButton.setText("Exit");
		}
		for(Component c : contentPanel.getComponents()) {
			c.setEnabled(b);
		}
	}
	
//	public static void main(String[] args) {
//		try {
//			MainDialog dialog = new MainDialog();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public MainDialog() {
		getContentPane().setBackground(Color.ORANGE);
		setModal(true);
		setBounds(100, 100, 222, 151);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.ORANGE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Sylfaen", Font.BOLD, 14));
		lblName.setBounds(20, 35, 47, 14);
		contentPanel.add(lblName);
		
		textField = new JTextField();
		textField.setFont(new Font("Sylfaen", Font.BOLD, 14));
		textField.setBounds(64, 32, 119, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setBackground(Color.BLACK);
				okButton.setForeground(Color.ORANGE);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ok = true;
						setVisible(false);
					}
				});
				okButton.setFont(new Font("Sylfaen", Font.BOLD, 14));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setBackground(Color.BLACK);
				cancelButton.setForeground(Color.ORANGE);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ok = false;
						setVisible(false);
					}
				});
				cancelButton.setFont(new Font("Sylfaen", Font.BOLD, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public JButton getOkButton() {
		return okButton;
	}
	public JButton getCancelButton() {
		return cancelButton;
	}
}

