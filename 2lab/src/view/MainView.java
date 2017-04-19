package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.IController;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JMenuBar menuBar;
	private JMenu mnTable;
	private JMenu mnOperation;
	private JMenu mnQuery;
	private JMenuItem mntmCreatedb;
	private JMenuItem mntmVisitor;
	private JMenuItem mntmRoom;
	private JMenuItem mntmAdmin;
	private JMenuItem mntmAdd;
	private JMenuItem mntmEdit;
	private JMenuItem mntmDelete;
	private JMenuItem mntmQuery2;
	private JMenuItem mntmQuery1;

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
	IController controller;
	String className;


	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public void setMnTable(JMenu mnTable) {
		this.mnTable = mnTable;
	}

	public void setMnOperation(JMenu mnOperation) {
		this.mnOperation = mnOperation;
	}

	public void setMnQuery(JMenu mnQuery) {
		this.mnQuery = mnQuery;
	}

	public void setMntmCreatedb(JMenuItem mntmCreatedb) {
		this.mntmCreatedb = mntmCreatedb;
	}

	public void setMntmVisitor(JMenuItem mntmVisitor) {
		this.mntmVisitor = mntmVisitor;
	}

	public void setMntmRoom(JMenuItem mntmRoom) {
		this.mntmRoom = mntmRoom;
	}

	public void setMntmAdmin(JMenuItem mntmAdmin) {
		this.mntmAdmin = mntmAdmin;
	}

	public void setMntmAdd(JMenuItem mntmAdd) {
		this.mntmAdd = mntmAdd;
	}

	public void setMntmEdit(JMenuItem mntmEdit) {
		this.mntmEdit = mntmEdit;
	}

	public void setMntmDelete(JMenuItem mntmDelete) {
		this.mntmDelete = mntmDelete;
	}

	public void setMntmQuery2(JMenuItem mntmQuery2) {
		this.mntmQuery2 = mntmQuery2;
	}

	public void setMntmQuery1(JMenuItem mntmQuery1) {
		this.mntmQuery1 = mntmQuery1;
	}

	public void setController(IController controller) {
		this.controller = controller;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnTable = new JMenu("Table");
		menuBar.add(mnTable);
		
		mntmCreatedb = new JMenuItem("CreateDB");
		mntmCreatedb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onCreateDB();
			}
		});
		mnTable.add(mntmCreatedb);
		
		mntmVisitor = new JMenuItem("Visitor");
		mntmVisitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowVisitor();
			}
		});
		mnTable.add(mntmVisitor);
		
		mntmRoom = new JMenuItem("Room");
		mntmRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowRoom();
			}
		});
		mnTable.add(mntmRoom);
		
		mntmAdmin = new JMenuItem("Admin");
		mntmAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ShowAdmin();
			}
		});
		mnTable.add(mntmAdmin);
		
		mnOperation = new JMenu("Operation");
		menuBar.add(mnOperation);
		
		mntmAdd = new JMenuItem("Add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onAdd();
			}
		});
		mnOperation.add(mntmAdd);
		
		mntmEdit = new JMenuItem("Edit");
		mntmEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onEdit();
			}
		});
		mnOperation.add(mntmEdit);
		
		mntmDelete = new JMenuItem("Delete");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onDelete();
			}
		});
		mnOperation.add(mntmDelete);
		
		mnQuery = new JMenu("Query");
		menuBar.add(mnQuery);
		
		mntmQuery1 = new JMenuItem("Query1");
		mntmQuery1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onQuery1();
			}
		});
		mnQuery.add(mntmQuery1);
		
		mntmQuery2 = new JMenuItem("Quety2");
		mntmQuery2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onQuery2();
			}
		});
		mnQuery.add(mntmQuery2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

	public JTable getTable() {
		return table;
	}
}
