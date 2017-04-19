package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import model.Client;
import model.Master;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import view.IDlg;
import java.awt.ScrollPane;;
public class DlgSelect extends JDialog implements IDlg{

	private final JPanel contentPanel = new JPanel();
	private TableModel model;
	private String className;
	private Object obj;
	private JScrollPane scrollPane;
	private JTable table_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgSelect dialog = new DlgSelect();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgSelect() {
		setModal(true);
		setBounds(100, 100, 450, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onCancel();
				}
			});
			cancelButton.setBounds(329, 178, 76, 23);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
		}
		{
			JButton okButton = new JButton("Select");
			okButton.setBounds(228, 178, 91, 23);
			contentPanel.add(okButton);
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					onSelect();
				}
			});
			okButton.setActionCommand("OK");
			getRootPane().setDefaultButton(okButton);
		}
		{
			scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 11, 385, 158);
			contentPanel.add(scrollPane);
			{
				table_2 = new JTable();
				scrollPane.setColumnHeaderView(table_2);
			}
		}	
	}	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	
	@Override
	public Object getObject() {
		return obj;
	}
	
	public DlgSelect(TableModel model, String className) {
		this();
		this.model = model;
		this.className = className;
		this.setTitle(className);
		table_2.setModel(model);
	}
	protected void onCancel() {
		obj = null;
		this.setVisible(false);	
}
	protected void onSelect() {
		//Class clz;
		try {
			Class clz = Class.forName("model."+className);
			obj = clz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		int row = table_2.getSelectedRow();
		String str = model.getValueAt(row, 0).toString();
		int id = Integer.parseInt(str);
		String lastname = (String) model.getValueAt(row, 1);
		String firstname = (String) model.getValueAt(row, 2);
		String email = (String) model.getValueAt(row, 3);
		if (obj instanceof Client){
			Client client = (Client)obj;	
			client.setId(id);
			client.setLastname(lastname);
			client.setFirstname(firstname);
			client.setEmail(email);
		}else if (obj instanceof Master) {
			Master master = (Master)obj;
			master.setId(id);
			master.setLastname(lastname);
			master.setFirstname(firstname);
			master.setEmail(email);
		}else{ obj = null; }
		
		if(obj != null){
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "ќб'Їкт не створено");
		}
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public JTable getTable_2() {
		return table_2;
	}
	}
