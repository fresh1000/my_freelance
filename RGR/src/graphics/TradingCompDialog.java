package graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class TradingCompDialog extends MainDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public static void main(String[] args) {
		try {
			TradingCompDialog dialog = new TradingCompDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public TradingCompDialog() {
		setTitle("Trading Company");
		setBounds(100, 100, 355, 212);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setForeground(Color.ORANGE);
		contentPanel.setBackground(Color.ORANGE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblShortName = new JLabel("Name");
			lblShortName.setHorizontalAlignment(SwingConstants.LEFT);
			lblShortName.setFont(new Font("Sylfaen", Font.BOLD, 14));
			lblShortName.setBounds(10, 21, 86, 14);
			contentPanel.add(lblShortName);
		}
		{
			JLabel lblFullName = new JLabel("Address main office");
			lblFullName.setHorizontalAlignment(SwingConstants.LEFT);
			lblFullName.setFont(new Font("Sylfaen", Font.BOLD, 14));
			lblFullName.setBounds(10, 59, 138, 14);
			contentPanel.add(lblFullName);
		}
		{
			JLabel lblCountry = new JLabel("Activity");
			lblCountry.setHorizontalAlignment(SwingConstants.LEFT);
			lblCountry.setFont(new Font("Sylfaen", Font.BOLD, 14));
			lblCountry.setBounds(10, 96, 86, 14);
			contentPanel.add(lblCountry);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Sylfaen", Font.BOLD, 14));
			textField.setBounds(146, 18, 184, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Sylfaen", Font.BOLD, 14));
			textField_1.setBounds(146, 56, 184, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Sylfaen", Font.BOLD, 14));
			textField_2.setBounds(146, 93, 184, 20);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setForeground(Color.ORANGE);
			buttonPane.setBackground(Color.ORANGE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setBackground(Color.BLACK);
				okButton.setForeground(Color.ORANGE);
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
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
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setBackground(Color.BLACK);
				cancelButton.setForeground(Color.ORANGE);
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
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
	
	public TradingCompDialog(Object data) {
		this();
		TradingCompInfo ci = (TradingCompInfo)data;
		textField.setText(ci.name);
		textField_1.setText(ci.trdcmpAdr);
		textField_2.setText(ci.trdcmpActivity);
	}
	
	@Override
	public Object createObject() throws Exception {
		if(!ok) {
			return null;
		}
		String name = textField.getText();
		String adr = textField_1.getText();
		String activity = textField_2.getText();
		return new TradingCompInfo(name, adr, activity);
	}

}

