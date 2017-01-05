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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class GroupProductDialog extends MainDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		try {
			GroupProductDialog dialog = new GroupProductDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public GroupProductDialog() {
		setBackground(Color.ORANGE);
		setForeground(Color.ORANGE);
		setTitle("Group of Product");
		setBounds(100, 100, 372, 183);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.ORANGE);
		contentPanel.setForeground(Color.ORANGE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblShortName = new JLabel("Name");
			lblShortName.setHorizontalAlignment(SwingConstants.LEFT);
			lblShortName.setFont(new Font("Sylfaen", Font.BOLD, 14));
			lblShortName.setBounds(10, 30, 48, 14);
			contentPanel.add(lblShortName);
		}
		{
			JLabel lblFullName = new JLabel("Type");
			lblFullName.setHorizontalAlignment(SwingConstants.LEFT);
			lblFullName.setFont(new Font("Sylfaen", Font.BOLD, 14));
			lblFullName.setBounds(10, 71, 48, 14);
			contentPanel.add(lblFullName);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Sylfaen", Font.BOLD, 14));
			textField.setBounds(68, 27, 278, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Sylfaen", Font.BOLD, 14));
			textField_1.setBounds(68, 68, 278, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
			buttonPane.setForeground(Color.ORANGE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setForeground(Color.ORANGE);
				okButton.setBackground(Color.BLACK);
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
				cancelButton.setForeground(Color.ORANGE);
				cancelButton.setBackground(Color.BLACK);
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						ok = true;
						setVisible(false);
					}
				});
				cancelButton.setFont(new Font("Sylfaen", Font.BOLD, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public GroupProductDialog(Object data) {
		this();
		GroupProductInfo ai = (GroupProductInfo)data;
		textField.setText(ai.name);
		textField_1.setText(ai.grpprdType);
		
	}

	@Override
	public Object createObject() throws Exception {
		if(!ok) {
			return null;
		}
		String name = textField.getText();
		String type = textField_1.getText();
		return new GroupProductInfo(name, type);
	}

}

