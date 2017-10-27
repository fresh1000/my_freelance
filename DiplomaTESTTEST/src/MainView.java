import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;

import javafx.application.Platform;
import yahoofinance.YahooFinance;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class MainView {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u0421\u0438\u0441\u0442\u0435\u043C\u0430 \u043A\u0435\u0440\u0443\u0432\u0430\u043D\u043D\u044F \u0430\u043A\u0446\u0456\u044F\u043C\u0438");
		frame.getContentPane().setBackground(new Color(204, 255, 204));
		frame.setBounds(100, 100, 444, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//try {
		//	frame.setContentPane(new  JPanelWithBackground("money_texture1385.jpg"));
		//} catch (IOException e2) {
			// TODO Auto-generated catch block
		//	e2.printStackTrace();
		//}
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Apple", "Yahoo", "Nike", "Microsoft", "Ebay", "Facebook", "Amazon", "Tesla", "Disney", "Google"}));
		comboBox.setBounds(147, 192, 117, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel("\u0413\u0440\u0430\u0444\u0456\u043A \u0437\u043C\u0456\u043D\u0438 \u0446\u0456\u043D\u0438 \u0430\u043A\u0446\u0456\u0439");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(102, 204, 255));
		lblNewLabel.setBounds(0, 188, 144, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u0410\u043A\u0442\u0443\u0430\u043B\u044C\u043D\u0430 \u0446\u0456\u043D\u0430 \u0430\u043A\u0446\u0456\u0439");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(0, 230, 133, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Apple", "Yahoo", "Nike", "Microsoft", "Ebay", "Facebook", "Amazon", "Tesla", "Disney", "Google"}));
		comboBox_3.setBounds(147, 237, 117, 20);
		frame.getContentPane().add(comboBox_3);
		
		
		JButton btnActualPrice = new JButton("\u0417\u043D\u0430\u0439\u0442\u0438");
		btnActualPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String stockSymbol = null;
				if(comboBox_3.getModel().getSelectedItem() == "Apple") {
					stockSymbol = "AAPL";
				}
				if(comboBox_3.getModel().getSelectedItem() == "Amazon") {
					stockSymbol = "AMZN";
				}
				if(comboBox_3.getModel().getSelectedItem() == "Disney") {
					stockSymbol = "DIS";
				}
				if(comboBox_3.getModel().getSelectedItem() == "Ebay") {
					stockSymbol = "EBAY";
				}
				if(comboBox_3.getModel().getSelectedItem() == "Facebook") {
					stockSymbol = "FB";
				}
				if(comboBox_3.getModel().getSelectedItem() == "Google") {
					stockSymbol = "GOOGL";
				}
				if(comboBox_3.getModel().getSelectedItem() == "Nike") {
					stockSymbol = "NKE";
				}
				if(comboBox_3.getModel().getSelectedItem() == "Tesla") {
					stockSymbol = "TSLA";
				}
				if(comboBox_3.getModel().getSelectedItem() == "Yahoo") {
					stockSymbol = "YHOO";
				}
				if(comboBox_3.getModel().getSelectedItem() == "Microsoft") {
					stockSymbol = "MSFT";
				}
				
				
				
				BigDecimal price = new BigDecimal(0);

				// by specifying yahoofinance here, we can use ‘Stock’ name
				// for our own class without conflict between classes named 'Stock’
				yahoofinance.Stock stock = null;
				try {

					stock = YahooFinance.get(stockSymbol);
					price = stock.getQuote().getPrice();
				} catch (IOException e1) {
					System.out.println("Couldn't connect to server.");
				}
				String message = stockSymbol + "\n";
				message +="$" + price;
				
				JOptionPane.showMessageDialog(null, message, "Price", JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		btnActualPrice.setBounds(283, 236, 133, 23);
		frame.getContentPane().add(btnActualPrice);
		
		JButton buttonChart = new JButton("\u041F\u043E\u043A\u0430\u0437\u0430\u0442\u0438 \u0433\u0440\u0430\u0444\u0456\u043A");
		buttonChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getModel().getSelectedItem() == "Apple") {
					//CChart c = new CChart();
					//c.main(null);
					LineChartApple.main(null);
//					new Thread() {
//			            @Override
//			            public void run() {
//			                javafx.application.Application.launch(LineChartApple.class);
//			            }
//			        }.start();
				}
				if(comboBox.getModel().getSelectedItem() == "Amazon") {
					LineChartAmazon.main(null);
				}
				if(comboBox.getModel().getSelectedItem() == "Disney") {
					LineChartDisney.main(null);
					
				}
				if(comboBox.getModel().getSelectedItem() == "Ebay") {
					LineChartEbay.main(null);
					System.exit(0);
				}
				if(comboBox.getModel().getSelectedItem() == "Facebook") {
					LineChartFacebook.main(null);
					System.exit(0);
				}
				if(comboBox.getModel().getSelectedItem() == "Google") {
					LineChartGoogle.main(null);
					System.exit(0);
				}
				if(comboBox.getModel().getSelectedItem() == "Nike") {
					LineChartNike.main(null);
					System.exit(0);
				}
				if(comboBox.getModel().getSelectedItem() == "Tesla") {
					LineChartTesla.main(null);
					System.exit(0);
				}
				if(comboBox.getModel().getSelectedItem() == "Yahoo") {
					LineChartYahoo.main(null);
					System.exit(0);
				}
				if(comboBox.getModel().getSelectedItem() == "Microsoft") {
					LineChartMicrosoft.main(null);
					System.exit(0);
				}
			}
		});
		buttonChart.setBounds(282, 191, 134, 23);
		frame.getContentPane().add(buttonChart);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Apple", "Yahoo", "Nike", "Microsoft", "Ebay", "Facebook", "Amazon", "Tesla", "Disney", "Google"}));
		comboBox_1.setBounds(147, 275, 117, 20);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u0413\u0440\u0430\u0444\u0456\u043A \u043F\u0440\u0438\u0431\u0443\u0442\u043A\u0443");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(0, 275, 127, 20);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u041F\u043E\u043A\u0430\u0437\u0430\u0442\u0438 \u0433\u0440\u0430\u0444\u0456\u043A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox_1.getModel().getSelectedItem() == "Apple") {
					LineChartProfitApple.main(null);
				}
				if(comboBox_1.getModel().getSelectedItem() == "Amazon") {
					LineChartProfitAmazon.main(null);
				}
				if(comboBox_1.getModel().getSelectedItem() == "Disney") {
					LineChartProfitDisney.main(null);
					System.exit(0);
				}
				if(comboBox_1.getModel().getSelectedItem() == "Ebay") {
					LineChartProfitEbay.main(null);
					System.exit(0);
				}
				if(comboBox_1.getModel().getSelectedItem() == "Facebook") {
					LineChartProfitFacebook.main(null);
					System.exit(0);
				}
				if(comboBox_1.getModel().getSelectedItem() == "Google") {
					LineChartProfitGoogle.main(null);
					System.exit(0);
				}
				if(comboBox_1.getModel().getSelectedItem() == "Nike") {
					LineChartProfitNike.main(null);
					System.exit(0);
				}
				if(comboBox_1.getModel().getSelectedItem() == "Tesla") {
					LineChartProfitTesla.main(null);
					System.exit(0);
				}
				if(comboBox_1.getModel().getSelectedItem() == "Yahoo") {
					LineChartProfitYahoo.main(null);
					System.exit(0);
				}
				if(comboBox_1.getModel().getSelectedItem() == "Microsoft") {
					LineChartProfitMicrosoft.main(null);
					System.exit(0);
				}
			}
		});
		btnNewButton.setBounds(282, 274, 134, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("\u0413\u0440\u0430\u0444\u0456\u043A \u0432\u0438\u0442\u0440\u0430\u0442");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setForeground(new Color(255, 255, 255));
		label.setBounds(0, 317, 116, 14);
		frame.getContentPane().add(label);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Apple", "Yahoo", "Nike", "Microsoft", "Ebay", "Facebook", "Amazon", "Tesla", "Disney", "Google"}));
		comboBox_2.setBounds(147, 314, 117, 20);
		frame.getContentPane().add(comboBox_2);
		
		JButton button = new JButton("\u041F\u043E\u043A\u0430\u0437\u0430\u0442\u0438 \u0433\u0440\u0430\u0444\u0456\u043A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox_2.getModel().getSelectedItem() == "Apple") {
					LineChartMinusApple.main(null);
				}
				if(comboBox_2.getModel().getSelectedItem() == "Amazon") {
					LineChartMinusAmazon.main(null);
				}
				if(comboBox_2.getModel().getSelectedItem() == "Disney") {
					LineChartMinusDisney.main(null);
					System.exit(0);
				}
				if(comboBox_2.getModel().getSelectedItem() == "Ebay") {
					LineChartMinusEbay.main(null);
					System.exit(0);
				}
				if(comboBox_2.getModel().getSelectedItem() == "Facebook") {
					LineChartMinusFacebook.main(null);
					System.exit(0);
				}
				if(comboBox_2.getModel().getSelectedItem() == "Google") {
					LineChartMinusGoogle.main(null);
					System.exit(0);
				}
				if(comboBox_2.getModel().getSelectedItem() == "Nike") {
					LineChartMinusNike.main(null);
					System.exit(0);
				}
				if(comboBox_2.getModel().getSelectedItem() == "Tesla") {
					LineChartMinusTesla.main(null);
					System.exit(0);
				}
				if(comboBox_2.getModel().getSelectedItem() == "Yahoo") {
					LineChartMinusYahoo.main(null);
					System.exit(0);
				}
				if(comboBox_2.getModel().getSelectedItem() == "Microsoft") {
					LineChartMinusMicrosoft.main(null);
					System.exit(0);
				}
			}
		});
		button.setBounds(282, 313, 134, 23);
		frame.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setBounds(147, 91, 117, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button_1 = new JButton("\u041A\u0443\u043F\u0438\u0442\u0438");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Company.constValue = Double.parseDouble(textField.getText());
			}
		});
		button_1.setBounds(147, 122, 117, 23);
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u0412\u0432\u0435\u0434\u0456\u0442\u044C \u043F\u043E\u0447\u0430\u0442\u043A\u043E\u0432\u0438\u0439 \u0431\u0430\u043B\u0430\u043D\u0441");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(106, 52, 218, 28);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Yura\\Downloads\\photo5370902160822347877.jpg"));
		lblNewLabel_4.setBounds(0, 0, 434, 370);
		frame.getContentPane().add(lblNewLabel_4);
		
		
	}
}
