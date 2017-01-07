package source;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class DlgCity extends Dlg {
	private JTextField textFieldCityMinister;

	public DlgCity() {
		setTitle("City");
		setBounds(100, 100, 273, 195);
		contentPanel.setLayout(null);

		textFieldCityMinister = new JTextField();
		textFieldCityMinister.setBounds(109, 72, 86, 20);
		contentPanel.add(textFieldCityMinister);
		textFieldCityMinister.setColumns(10);
		
		JLabel lblMinisterInCity = new JLabel("Minister");
		lblMinisterInCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMinisterInCity.setBounds(54, 73, 45, 14);
		contentPanel.add(lblMinisterInCity);
	}

	public DlgCity(Object data) {
		this();
		City c = (City) data;
		textFieldAnyName.setText(c.name);
		textFieldCityMinister.setText(c.ministerName);
	}
	public Object createObject() throws Exception {
		if (!ok)
			return null;
		String name = textFieldAnyName.getText();
		String cityName = textFieldCityMinister.getText();
		return new City(name, cityName);
	}
}
