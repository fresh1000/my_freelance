import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TestBox {
	public static void main(String[] args) {
		Box boxA = new Box();
		System.out.println("An object boxA of class Box has been created");
		int volume = 0;
		do {
			volume = Integer.parseInt(JOptionPane.showInputDialog("Input a value for volume (>0):"));
			if(volume <= 0) {
				JOptionPane.showMessageDialog(new JFrame(),"Volume must be > 0", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}while(volume <= 0);
		
		boxA.setVolume(volume);
		System.out.println("Category: " + boxA.category());
	}
}
