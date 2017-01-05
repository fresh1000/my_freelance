package source;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DlgTrip extends Dlg{
	private JTextField textFieldNumberTrip;
	private JTextField textFieldStartCity;
	private JTextField textFieldFinishCity;

	
	
	public DlgTrip() {
		super();
		setBounds (100, 100, 331, 173);
		
		JLabel lblNumberTrip = new JLabel("Number trip");
		contentPanel.add(lblNumberTrip);
		
		textFieldNumberTrip = new JTextField();
		contentPanel.add(textFieldNumberTrip);
		textFieldNumberTrip.setColumns(10);
		
		JLabel lblStartCity = new JLabel("Start city");
		contentPanel.add(lblStartCity);
		
		textFieldStartCity = new JTextField();
		contentPanel.add(textFieldStartCity);
		textFieldStartCity.setColumns(10);
		
		JLabel lblFinishCity = new JLabel("Finish city");
		contentPanel.add(lblFinishCity);
		
		textFieldFinishCity = new JTextField();
		contentPanel.add(textFieldFinishCity);
		textFieldFinishCity.setColumns(10);
	}
	public DlgTrip(Object data) {
		this();
		Trip t = (Trip) data;
		textFieldMinistry.setText(t.name);
		textFieldNumberTrip.setText(t.numberTrip);
		textFieldStartCity.setText(t.startCity);
		textFieldFinishCity.setText(t.finishCity);
	}
	public Object createObject() throws Exception {
		if(!ok) return null;
		String name = textFieldMinistry.getText();
		String numberTrip = textFieldNumberTrip.getText();
		String startCity = textFieldStartCity.getText();
		String finishCity = textFieldFinishCity.getText();
		return new Trip(name, numberTrip, startCity, finishCity);
	}

}