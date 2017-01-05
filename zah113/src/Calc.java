
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Calc extends JPanel {
	JTextField tfInputA, tfInputB;
	JLabel lInputA, lInputB, lAnswer;
	JButton bAdd, bSub, bMult, bDiv;
	JPanel inputA, inputB, operations, collection;

	public Calc() {
		tfInputA = new JTextField(15);
		tfInputB = new JTextField(15);
		lInputA = new JLabel("Введіть число");
		lInputB = new JLabel("Введіть друге");
		lAnswer = new JLabel("Результат");
		inputA = new JPanel();
		inputA.setBackground(Color.PINK);
		inputB = new JPanel();
		inputB.setBackground(Color.PINK);
		operations = new JPanel(new GridLayout(0, 2));
		collection = new JPanel();
		collection.setBackground(Color.PINK);
		collection.setLayout(new BoxLayout(collection, BoxLayout.Y_AXIS));
		CalcListener myListener = new CalcListener();
		inputA.add(lInputA);
		inputA.add(tfInputA);
		inputB.add(lInputB);
		inputB.add(tfInputB);

		collection.add(inputA);
		collection.add(inputB);
		collection.add(operations);
		bAdd = new JButton(" + ");
		collection.add(bAdd);
		bAdd.setSize(50, 20);
		bAdd.addActionListener(myListener);

		bSub = new JButton(" - ");
		collection.add(bSub);
		bSub.setSize(50, 20);
		bSub.addActionListener(myListener);
		bDiv = new JButton(" / ");
		collection.add(bDiv);
		bDiv.setSize(50, 20);
		bDiv.addActionListener(myListener);
		bMult = new JButton(" * ");
		collection.add(bMult);
		bMult.setSize(50, 20);
		bMult.addActionListener(myListener);
		collection.add(lAnswer);
		add(collection);
	}

	class CalcListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (tfInputA.getText().matches("[-+]?\\d+") && tfInputB.getText().matches("[-+]?\\d+")) {
				int a = Integer.parseInt(tfInputA.getText());
				int b = Integer.parseInt(tfInputB.getText());
				double answer = 0;
				String operation = "";
				String message = "";
				if (e.getSource() == bAdd) {
					answer = (double)a + b;
					operation = "+";
				} else if (e.getSource() == bSub) {
					answer = (double)a - b;
					operation = "-";
				} else if (e.getSource() == bMult) {
					answer = (double)a * b;
					operation = "*";
				} else if (e.getSource() == bDiv) {
					answer = (double)a / b;
					operation = "/";
				}
				tfInputA.setText("");
				tfInputB.setText("");
				tfInputA.requestFocus();
				lAnswer.setText("Відповідь " + answer);
				
				message += "Перше число: " + a + "\n";
				message += "Друге число: " + b + "\n";
				message += "Операція: " + operation + "\n";
				message += "Відповідь: " + answer + "\n";
				JOptionPane.showMessageDialog(null, message, "Вікно відповіді", JOptionPane.PLAIN_MESSAGE);
			} else {
				tfInputA.setText("");
				tfInputB.setText("");
				tfInputA.requestFocus();
				JOptionPane.showMessageDialog(null, "Неправильні дані", "Помилка", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
