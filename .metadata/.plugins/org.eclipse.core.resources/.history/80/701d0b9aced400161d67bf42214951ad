package source;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DlgStation extends  Dlg {
	private JTextField textFieldStation;
	
	public DlgStation() {
		super();
		setBounds (100, 100, 331, 119);
		
		JLabel lblStation = new JLabel("Station");
		contentPanel.add(lblStation);
		
		textFieldStation = new JTextField();
		contentPanel.add(textFieldStation);
		textFieldStation.setColumns(10);
	}
	
	public DlgStation(Object data) {
		this();
		Station s = (Station) data;
		textFieldMinistry.setText(s.name);
		textFieldStation.setText(s.nameStation);
	}
	public Object createObject() throws Exception {
		if(!ok) return null;
		String name = textFieldMinistry.getText();
		String nameStation = textFieldStation.getText();
		return new Station(name, nameStation);
	}

}
