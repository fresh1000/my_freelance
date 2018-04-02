import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField investAmount;
	private JTextField years;
	private JTextField annualRate;
	JLabel futureValue = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 291, 219);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 67, 21);
		contentPane.add(menuBar);
		
		JMenu mnOperation = new JMenu("Operation");
		menuBar.add(mnOperation);
		
		JMenuItem mntmCalculate = new JMenuItem("Calculate");
		mntmCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double invest = Double.parseDouble(investAmount.getText());
				int year = Integer.parseInt(years.getText());
				double rate = Double.parseDouble(annualRate.getText());
				
				InvestCalc calc = new InvestCalc(year, invest, rate);
				double value = calc.calcFutureValue();
			
				NumberFormat formatter = new DecimalFormat("#0.00");
				futureValue.setText("$" + formatter.format(value));
				JOptionPane.showMessageDialog(GUI.this, 
		                 "Future Value: $" + formatter.format(value));
			}
		});
		mnOperation.add(mntmCalculate);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnOperation.add(mntmExit);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(GUI.this, 
		                 "futureValue = investAmount * (1 + monthlyInterestRate)^(years * 12)");
		         
			}
		});
		btnHelp.setBounds(69, -2, 89, 23);
		contentPane.add(btnHelp);
		
		JLabel lblNewLabel = new JLabel("Investment amount");
		lblNewLabel.setBounds(10, 32, 106, 23);
		contentPane.add(lblNewLabel);
		
		investAmount = new JTextField();
		investAmount.setBounds(138, 32, 112, 20);
		contentPane.add(investAmount);
		investAmount.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Years");
		lblNewLabel_1.setBounds(10, 66, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		years = new JTextField();
		years.setBounds(138, 63, 112, 20);
		contentPane.add(years);
		years.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Annual interest rate");
		lblNewLabel_2.setBounds(10, 94, 118, 14);
		contentPane.add(lblNewLabel_2);
		
		annualRate = new JTextField();
		annualRate.setBounds(138, 91, 112, 20);
		contentPane.add(annualRate);
		annualRate.setColumns(10);
		
		JLabel lblFutureValue = new JLabel("Future value");
		lblFutureValue.setBounds(10, 129, 86, 14);
		contentPane.add(lblFutureValue);
		
		futureValue.setBounds(126, 129, 86, 14);
		contentPane.add(futureValue);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				double invest = Double.parseDouble(investAmount.getText());
				int year = Integer.parseInt(years.getText());
				double rate = Double.parseDouble(annualRate.getText());
				
				InvestCalc calc = new InvestCalc(year, invest, rate);
				double value = calc.calcFutureValue();
			
				NumberFormat formatter = new DecimalFormat("#0.00");
				futureValue.setText("$" + formatter.format(value));
				JOptionPane.showMessageDialog(GUI.this, 
		                 "Future Value: $" + formatter.format(value));
			}
		});
		btnCalculate.setBounds(0, 154, 285, 36);
		contentPane.add(btnCalculate);
	}
}
