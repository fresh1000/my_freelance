package pizza;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.*;

public class Test extends JFrame {

	String[] size = { "10", "12", "14", "16" };
	String[] type = { "hand-tossed", "deep-dish", "thin" };

	private JButton order = new JButton("Order");
	private JButton clear = new JButton("Clear");
	private JTextArea input = new JTextArea(5, 20);
	private JLabel labelName = new JLabel("         Your name:");
	private JLabel labelCrust = new JLabel("        Crust type:");
	private JLabel labelToppings = new JLabel("       Toppings:");
	private JLabel sizePizza = new JLabel("         Size pizza:");
	private JComboBox<String> crust = new JComboBox<String>(type);
	private JComboBox<String> comboBox = new JComboBox<String>(size);
	private JCheckBox chees = new JCheckBox("Chees", false);
	private JCheckBox bacon = new JCheckBox("Bacon", false);
	private JCheckBox tomat = new JCheckBox("Tomatoes", false);
	private JCheckBox chili = new JCheckBox("Chili", false);
	private JCheckBox paper = new JCheckBox("Paper", false);
	private JCheckBox garlic = new JCheckBox("Garlic", false);

	public Test() {
		super("Pizza order");
		this.setBounds(200, 200, 500, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = this.getContentPane();
		container.setLayout(new GridLayout(4, 4, 7, 10));
		container.add(labelName);
		container.add(input);
		container.add(labelCrust);
		container.add(crust);
		container.add(sizePizza);
		container.add(comboBox);
		container.add(labelToppings);
		container.add(chees);
		container.add(bacon);
		container.add(tomat);
		container.add(chili);
		container.add(paper);
		container.add(garlic);

		order.addActionListener(new ButtonEventListener());
		order.setBackground(Color.GREEN);

		clear.addActionListener(new ClearDefault());
		clear.setBackground(Color.RED);

		container.add(clear);
		container.add(order);
	}

	class ClearDefault implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			input.setText(null);
			crust.setSelectedItem(null);
			comboBox.setSelectedItem(null);
			chees.setSelected(false);
			bacon.setSelected(false);
			tomat.setSelected(false);
			chili.setSelected(false);
			paper.setSelected(false);
			garlic.setSelected(false);
		}
	}

	class ButtonEventListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			final double TAX = 1.055;
			int size;
			DecimalFormat df = new DecimalFormat("#.00");
			double price;
			String crustType;
			String name;
			size = Integer.parseInt((String) comboBox.getSelectedItem());
			name = input.getText();
			crustType = (String) crust.getSelectedItem();
			String message = "";

			PizzaOrder pizza = new PizzaOrder(size, crustType, name);

			if (chees.isSelected()) {
				pizza.addTopping("chees");
			}
			if (tomat.isSelected()) {
				pizza.addTopping("tomat");
			}
			if (bacon.isSelected()) {
				pizza.addTopping("bacon");
			}
			if (paper.isSelected()) {
				pizza.addTopping("paper");
			}
			if (chili.isSelected()) {
				pizza.addTopping("chili");
			}
			if (garlic.isSelected()) {
				pizza.addTopping("garlic");
			}

			price = pizza.calculatePrice() * TAX;

			message += "You name: " + input.getText() + "\n";
			message += "Crust type: " + crustType + "\n";
			message += pizza.toString() + "\n";
			message += "Price: " + df.format(price);
			JOptionPane.showMessageDialog(null, message, "Your order", JOptionPane.PLAIN_MESSAGE);
		}
	}

	public static void main(String[] args) {
		Test app = new Test();
		app.setVisible(true);
	}

}
