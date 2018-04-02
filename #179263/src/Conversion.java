import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JFrame;

public class Conversion extends JFrame implements ActionListener {
	private JButton buttonCalculate = new JButton("Calculate");
	private JTextField inputAUDamount;
	private JLabel labelHDKamount = new JLabel("");

	public Conversion() {
		this.setBounds(100, 100, 222, 107);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().setLayout(null);

		inputAUDamount = new JTextField();
		inputAUDamount.setBounds(0, 0, 122, 31);
		getContentPane().add(inputAUDamount);
		inputAUDamount.setColumns(10);

		buttonCalculate.setBounds(0, 32, 206, 36);
		getContentPane().add(buttonCalculate);

		labelHDKamount.setBounds(132, 0, 71, 31);
		getContentPane().add(labelHDKamount);

		buttonCalculate.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		try {
			double amountHDK = Double.parseDouble(inputAUDamount.getText()) * 5.9;
			labelHDKamount.setText(Double.toString(amountHDK));
		} catch (NumberFormatException e1) {
			labelHDKamount.setText("Invalid!!");
		}
	}

	public static void main(String[] args) {
		Conversion app = new Conversion();
		app.setVisible(true);
	}
}
