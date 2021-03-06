package source;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DlgMinistry extends Dlg{
	private JTextField textFieldNameMinister;

	public DlgMinistry() {
		super();
		setTitle("Ministry");
		setBounds (100, 100, 331, 119);
		
		JLabel lblNewLabel = new JLabel("Name minister");
		contentPanel.add(lblNewLabel);
		
		textFieldNameMinister = new JTextField();
		contentPanel.add(textFieldNameMinister);
		textFieldNameMinister.setColumns(10);
	}
	
	public DlgMinistry(Object data) {
		this();
		Ministry m = (Ministry) data;
		textFieldAnyName.setText(m.name);
		textFieldNameMinister.setText(m.ministerName);
	}

	public Object createObject() throws Exception {
		if(!ok) return null;
		String name = textFieldAnyName.getText();
		String fioMinister = textFieldNameMinister.getText();
		return new Ministry(name, fioMinister);
	}

}
