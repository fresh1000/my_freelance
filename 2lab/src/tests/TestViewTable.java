package tests;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTable;

import controller.JdbcTableModel;
import controller.MyConnector;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TestViewTable {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestViewTable window = new TestViewTable();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestViewTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onRowClick(e); }
		});
		scrollPane.setViewportView(table);
		
		
		JButton btnShowtable = new JButton("ShowTable");
		btnShowtable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showTable();
			}
		});
		frame.getContentPane().add(btnShowtable, BorderLayout.SOUTH);
	}
	void onRowClick(MouseEvent e) {
		JTable table = (JTable) e.getSource();
		JdbcTableModel model = (JdbcTableModel) table.getModel();
		int row = table.getSelectedRow();
		String sid = (String) model.getValueAt(row, 0);
		int id = Integer.parseInt(sid);
		String name = (String) model.getValueAt(row, 1);
		System.out.printf("id =%3d,  name = %s\n", id, name);
	}

	protected void showTable() {
		MyConnector connector = new MyConnector();
		Connection conn = connector.getConnection();
		try {
			String sql = "select * from ROOM order by NAME";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			JdbcTableModel model  = new JdbcTableModel(rs);
			table.setModel(model);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connector.closeConnection();
		}
	}


	public JTable getTable() {
		return table;
	}
}
