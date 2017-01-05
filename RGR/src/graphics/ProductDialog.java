package graphics;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ProductDialog extends MainDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public static void main(String[] args) {
		try {
			ProductDialog dialog = new ProductDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ProductDialog() {
		setTitle("Product");
		setBounds(100, 100, 369, 267);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.ORANGE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblShortName = new JLabel("Name");
			lblShortName.setFont(new Font("Sylfaen", Font.BOLD, 14));
			lblShortName.setHorizontalAlignment(SwingConstants.LEFT);
			lblShortName.setBounds(10, 22, 57, 14);
			contentPanel.add(lblShortName);
		}
		{
			JLabel lblFullName = new JLabel("Price");
			lblFullName.setFont(new Font("Sylfaen", Font.BOLD, 14));
			lblFullName.setHorizontalAlignment(SwingConstants.LEFT);
			lblFullName.setBounds(10, 58, 57, 14);
			contentPanel.add(lblFullName);
		}
		{
			JLabel lblCountry = new JLabel("Country");
			lblCountry.setFont(new Font("Sylfaen", Font.BOLD, 14));
			lblCountry.setHorizontalAlignment(SwingConstants.LEFT);
			lblCountry.setBounds(10, 98, 57, 14);
			contentPanel.add(lblCountry);
		}
		{
			JLabel lblAge = new JLabel("Value");
			lblAge.setFont(new Font("Sylfaen", Font.BOLD, 14));
			lblAge.setHorizontalAlignment(SwingConstants.LEFT);
			lblAge.setBounds(10, 142, 57, 14);
			contentPanel.add(lblAge);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Sylfaen", Font.BOLD, 14));
			textField.setBounds(77, 16, 266, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Sylfaen", Font.BOLD, 14));
			textField_1.setBounds(77, 52, 266, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Sylfaen", Font.BOLD, 14));
			textField_2.setBounds(77, 92, 266, 20);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField_3 = new JTextField();
			textField_3.setFont(new Font("Sylfaen", Font.BOLD, 14));
			textField_3.setBounds(77, 136, 266, 20);
			contentPanel.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
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

	public ProductDialog(Object data) {
		this();
		ProductInfo pi = (ProductInfo)data;
		textField.setText(pi.name);
		textField_1.setText(String.valueOf(pi.prdctPrice));
		textField_2.setText(pi.prdctCountry);
		textField_3.setText(String.valueOf(pi.prdctValue));
	}

	@Override
	public Object createObject() throws Exception {
		if(!ok) {
			return null;
		}
		String name = textField.getText();
		double price =  Double.parseDouble(textField_1.getText());
		String country = textField_2.getText();
		int value = Integer.parseInt(textField_3.getText());
		return new ProductInfo(name, price, country, value);
	}

	public JTextField getTextField_3() {
		return textField_3;
	}
}
