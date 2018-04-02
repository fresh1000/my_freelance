import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogBox {

	public int checkAUDAmount(int amount) {
		while (amount <= 0) {
			JOptionPane.showMessageDialog(new JFrame(), "The AUD amount should be greater then zero", "Message",
					JOptionPane.INFORMATION_MESSAGE);
			amount = Integer.parseInt(JOptionPane.showInputDialog("Input an AUD Amount:"));
		}
		return amount;
	}

	public int inputAUDAmount() {
		int amount = Integer.parseInt(JOptionPane.showInputDialog("Input an AUD Amount:"));
		amount = checkAUDAmount(amount);
		int dialogResult = JOptionPane.showConfirmDialog(new JFrame(), "The input is:" + amount + " is it correct?",
				"Select an Option", JOptionPane.YES_NO_CANCEL_OPTION);
		if (dialogResult == 0) {
			return amount;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		DialogBox box = new DialogBox();
		box.inputAUDAmount();

	}

}
