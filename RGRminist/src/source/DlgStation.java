package source;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class DlgStation extends  Dlg {
	private JTextField textFieldStationAddress;
	
	public DlgStation() {
		super();
		setTitle("Station");
		setBounds (100, 100, 331, 183);
		
		JLabel lblStation = new JLabel("Address");
		lblStation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStation.setBounds(54, 65, 48, 20);
		contentPanel.add(lblStation);
		
		textFieldStationAddress = new JTextField();
		textFieldStationAddress.setBounds(109, 67, 86, 20);
		contentPanel.add(textFieldStationAddress);
		textFieldStationAddress.setColumns(10);
	}
	
	public DlgStation(Object data) {
		this();
		Station s = (Station) data;
		textFieldAnyName.setText(s.name);
		textFieldStationAddress.setText(s.addressStation);
	}
	public Object createObject() throws Exception {
		if(!ok) return null;
		String name = textFieldAnyName.getText();
		String addressStation = textFieldStationAddress.getText();
		return new Station(name, addressStation);
	}

}
