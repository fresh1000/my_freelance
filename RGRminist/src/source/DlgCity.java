package source;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DlgCity extends Dlg {
	private JTextField textFieldCity;

	public DlgCity() {
		super();
		setBounds(100, 100, 331, 119);

		JLabel lblCity = new JLabel("City");
		contentPanel.add(lblCity);

		textFieldCity = new JTextField();
		contentPanel.add(textFieldCity);
		textFieldCity.setColumns(10);
	}

	public DlgCity(Object data) {
		this();
		City c = (City) data;
		textFieldMinistry.setText(c.name);
		textFieldCity.setText(c.cityName);
	}
	public Object createObject() throws Exception {
		if (!ok)
			return null;
		String name = textFieldMinistry.getText();
		String cityName = textFieldCity.getText();
		return new City(name, cityName);
	}

}