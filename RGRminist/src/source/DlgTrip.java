package source;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class DlgTrip extends Dlg {
	private JTextField textFieldNumberTrip;
	private JTextField textFieldStartCity;
	private JTextField textFieldFinishCity;

	public DlgTrip() {
		super();
		setTitle("Trip");
		setBounds(100, 100, 269, 277);

		JLabel lblNumberTrip = new JLabel("Price trip");
		lblNumberTrip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumberTrip.setSize(73, 29);
		lblNumberTrip.setLocation(26, 70);
		contentPanel.add(lblNumberTrip);

		textFieldNumberTrip = new JTextField();
		textFieldNumberTrip.setSize(86, 20);
		textFieldNumberTrip.setLocation(109, 74);
		contentPanel.add(textFieldNumberTrip);
		textFieldNumberTrip.setColumns(10);

		JLabel lblStartCity = new JLabel("Start city");
		lblStartCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStartCity.setSize(63, 20);
		lblStartCity.setLocation(36, 105);
		contentPanel.add(lblStartCity);

		textFieldStartCity = new JTextField();
		textFieldStartCity.setBounds(109, 105, 86, 20);
		contentPanel.add(textFieldStartCity);
		textFieldStartCity.setColumns(10);

		JLabel lblFinishCity = new JLabel("Finish city");
		lblFinishCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFinishCity.setBounds(36, 136, 63, 20);
		contentPanel.add(lblFinishCity);

		textFieldFinishCity = new JTextField();
		textFieldFinishCity.setBounds(109, 136, 86, 20);
		contentPanel.add(textFieldFinishCity);
		textFieldFinishCity.setColumns(10);
	}

	public DlgTrip(Object data) {
		this();
		Trip t = (Trip) data;
		textFieldAnyName.setText(t.name);
		textFieldNumberTrip.setText(String.valueOf(t.priceTrip));
		textFieldStartCity.setText(t.startCity);
		textFieldFinishCity.setText(t.finishCity);
	}

	public Object createObject() throws Exception {
		if (!ok)
			return null;
		String name = textFieldAnyName.getText();
		double priceTrip = Double.parseDouble(textFieldNumberTrip.getText());
		String startCity = textFieldStartCity.getText();
		String finishCity = textFieldFinishCity.getText();
		return new Trip(name, priceTrip, startCity, finishCity);
	}

}
