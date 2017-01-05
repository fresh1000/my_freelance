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

public class StorageDialog extends MainDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StorageDialog dialog = new StorageDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public StorageDialog() {
		setTitle("Storage");
		setBounds(100, 100, 341, 213);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.ORANGE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblShortName = new JLabel("Number of storage");
			lblShortName.setHorizontalAlignment(SwingConstants.LEFT);
			lblShortName.setFont(new Font("Sylfaen", Font.BOLD, 14));
			lblShortName.setBounds(10, 23, 132, 14);
			contentPanel.add(lblShortName);
		}
		{
			JLabel lblFullName = new JLabel("Storage Adress");
			lblFullName.setHorizontalAlignment(SwingConstants.LEFT);
			lblFullName.setFont(new Font("Sylfaen", Font.BOLD, 14));
			lblFullName.setBounds(10, 61, 132, 14);
			contentPanel.add(lblFullName);
		}
		{
			JLabel lblCountry = new JLabel("Area");
			lblCountry.setHorizontalAlignment(SwingConstants.LEFT);
			lblCountry.setFont(new Font("Sylfaen", Font.BOLD, 14));
			lblCountry.setBounds(10, 95, 95, 14);
			contentPanel.add(lblCountry);
		}
		{
			textField = new JTextField();
			textField.setFont(new Font("Sylfaen", Font.BOLD, 14));
			textField.setBounds(152, 20, 163, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setFont(new Font("Sylfaen", Font.BOLD, 14));
			textField_1.setBounds(152, 58, 163, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setFont(new Font("Sylfaen", Font.BOLD, 14));
			textField_2.setBounds(152, 92, 163, 20);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.ORANGE);
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
	
	public StorageDialog(Object data) {
		this();
		StorageInfo ti = (StorageInfo)data;
		textField.setText(ti.name);
		textField_1.setText(ti.strgAdr);
		textField_2.setText(String.valueOf(ti.strgArea));
	}

	@Override
	public Object createObject() throws Exception {
		if(!ok) {
			return null;
		}
		String name = textField.getText();
		String adr = textField_1.getText();
		double area = Double.parseDouble(textField_2.getText()) ;
		return new StorageInfo(name, adr, area);
	}

}

