package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import controller.IController;
import controller.JdbcController;
import controller.JdbcTableModel;
import controller.MyConnector;
import view.DlgRegistration;

import java.awt.ScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.awt.MenuBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import view.*;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	IController controller;
	String className;
	public JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 524, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 0, 392, 21);
		contentPane.add(menuBar);
		
		JMenu mnTable = new JMenu("Table");
		menuBar.add(mnTable);
		
		JMenuItem mntmCreateDB = new JMenuItem("Create DB");
		mntmCreateDB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCreateDB();
			}
		});
		mnTable.add(mntmCreateDB);
		
		JMenuItem mntmMaster = new JMenuItem("Master");
		mntmMaster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMaster();
			}
		});
		mnTable.add(mntmMaster);
		
		JMenuItem mntmClient = new JMenuItem("Client");
		mntmClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showClient();
			}
		});
		mnTable.add(mntmClient);
		
		JMenuItem mntmRegistr = new JMenuItem("Registration");
		mntmRegistr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showRegistration();
			}
		});
		mnTable.add(mntmRegistr);
		
		JMenu mnOperation = new JMenu("Operation");
		menuBar.add(mnOperation);
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onDelete();
			}
		});
		mnOperation.add(mntmDelete);
		
		JMenuItem mntmAdd = new JMenuItem("Add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAdd(className);
			}
		});
		mnOperation.add(mntmAdd);
		
		JMenuItem mntmEdit = new JMenuItem("Edit");
		mntmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onEdit();
			}
		});
		mnOperation.add(mntmEdit);
		
		JMenu mnQuery = new JMenu("Query");
		menuBar.add(mnQuery);
		
		JMenuItem mntmQry1 = new JMenuItem("Query1");
		mntmQry1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onQuery1();
			}
		});
		mnQuery.add(mntmQry1);
		
		JMenuItem mntmQry2 = new JMenuItem("Query2");
		mntmQry2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onQuery2();
			}
		});
		mnQuery.add(mntmQry2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 488, 212);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
	}
	public JTable getTable() {
		return table;
	}

	private boolean checkClassName() {
		return className.equals("Client") 
				|| className.equals("Master")
				|| className.equals("Registration");
	}
	
	private int getSelectedRow() {
		int row = table.getSelectedRow();
		if (row == -1)
			JOptionPane.showMessageDialog(frame, "Row is not selected",
	"Table " + className, JOptionPane.WARNING_MESSAGE);
		return row;
	}
	protected void onCreateDB() {
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		try {
			Statement st = conn.createStatement();
			st.addBatch("create table MASTER (" 
					+ " ID integer generated always as identity," 
					+ " LASTNAME varchar(30) default '' not null," 
					+ " FIRSTNAME varchar(30) default '' not null,"
					+ " ACTIVITY varchar(30) default '' not null,"
					+ " EMAIL varchar(30) default '' not null,"
					+ " primary key (ID))");
			st.addBatch("create table REGISTRATION (" 
					+ " ID integer generated always as identity," 
					+ " IDCLIENT integer, IDMASTER integer," 
					+ " DATE date , TIME time,"
					+ " SERVICE varchar(30) default '' not null,"
					+ " primary key (ID))");
			st.addBatch("alter table REGISTRATION " 
					+ " add constraint FK_REGISTRATION_MASTER " 
					+ "	foreign key (IDMASTER)"
					+ " references MASTER (ID) on delete cascade");
			st.addBatch("alter table REGISTRATION " 
					+ " add constraint FK_REGISTRATION_CLIENT " 
					+ " foreign key (IDCLIENT) "
					+ " references CLIENT (ID)  on delete cascade");
			st.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connector.closeConnection();
		}
		}
	protected void showMaster() {
    	className = "Master";
    	table.setModel(controller.getModel(className));
	}
	protected void showClient() {
    	className = "Client";
    	table.setModel(controller.getModel(className));
	}
	protected void showRegistration() {
//		MyConnector connector = new MyConnector();
//		Connection conn = connector.getConnection();
//		className = "Registration";
//		try {
//			String sql = "select * from REGISTRATION";
//			Statement st = conn.createStatement();
//			ResultSet rs = st.executeQuery(sql);
//			JdbcTableModel model  = new JdbcTableModel(rs);
//			table.setModel(model);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			connector.closeConnection();
//	}
   	className = "Registration";
    	table.setModel(controller.getModel(className));
	}

	public void setController(IController controller) {
		this.controller = controller;

	}

	protected void onAdd(String className) {
//		if(!checkClassName()) return;
		
			IDlg dlg = null;
			if (className.equals("Client")) dlg = new DlgClient();
			if (className.equals("Master")) dlg = new DlgMaster();
			if (className.equals("Registration")) {
				dlg = new DlgRegistration();
				((DlgRegistration) dlg).setController(controller);
}
			if (dlg == null)
				return;
			// Активізуємо потрібний діалог
			((JDialog) dlg).setVisible(true);
			//Передаємо створений об'єкт контролеру
			try {
				controller.add(dlg.getObject());
				table.setModel(controller.getModel(className));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, e, "Створення об'єкту "
		 								+ className, JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
	protected void onEdit() {
		if(!checkClassName()) return;
		TableModel model =  table.getModel();
		int row = getSelectedRow();
		if (row == -1) return;
		String str = model.getValueAt(row, 0).toString();
		int id = Integer.parseInt((str) );
		IDlg dlg = null;
		if (className.equals("Client")) {
			dlg = new DlgClient();
			String oldClientLast = (String) model.getValueAt(row, 1);
			String oldClientFirst = (String) model.getValueAt(row, 2);
			String oldClientDiscount = model.getValueAt(row, 3).toString();
			String oldClientEmail = (String) model.getValueAt(row, 4);
			((DlgClient) dlg).setLastname(oldClientLast);
			((DlgClient) dlg).setFirstname(oldClientFirst);
			((DlgClient) dlg).setDiscountCard(oldClientDiscount);
			((DlgClient) dlg).setEmail(oldClientEmail);
			
		} else if (className.equals("Master")) {
			dlg = new DlgMaster();
			String oldMasterLast = (String) model.getValueAt(row, 1);
			String oldMasterFirst = (String) model.getValueAt(row, 2);
			String oldMasterActivity = (String) model.getValueAt(row, 3);
			String oldMasterEmail = (String) model.getValueAt(row, 4);
			((DlgMaster) dlg).setLastname(oldMasterLast);
			((DlgMaster) dlg).setFirstname(oldMasterFirst);
			((DlgMaster) dlg).setActivity(oldMasterActivity);
			((DlgMaster) dlg).setEmail(oldMasterEmail);
			
		} else if (className.equals("Registration")) {
			dlg = new DlgRegistration();
			((DlgRegistration) dlg).setController(controller);
			String oldClient = (String) model.getValueAt(row, 1);
			String oldMaster = (String) model.getValueAt(row, 2);
			String oldDate = model.getValueAt(row, 3).toString();
			String oldService = (String) model.getValueAt(row, 4);
			((DlgRegistration) dlg).setClientName(oldClient);
			((DlgRegistration) dlg).setMasterName(oldMaster);
			((DlgRegistration) dlg).setRegistration(oldDate);
			((DlgRegistration) dlg).setService(oldService);
		}
		// Активізуємо потрібний діалог
		((JDialog) dlg).setVisible(true);
		//Передаємо скориговані дані контролеру
		try {
			controller.edit(id, dlg.getObject());
			table.setModel(controller.getModel(className));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e, "Створення об'єкту " 
	+ className, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	protected void onDelete() {
		if (!checkClassName()) return;
		TableModel model =  table.getModel();
		int row = getSelectedRow();
				String str = model.getValueAt(row, 0).toString();
		int id = Integer.parseInt((str) );
		controller.delete(id, className);
		model = controller.getModel(className);
		table.setModel(model);
	}
	protected void onQuery1() {
		className = "";
		table.setModel(controller.doQuery1());	
	}
	protected void onQuery2() {
		className = "";
		table.setModel(controller.doQuery2());	
	}
}
