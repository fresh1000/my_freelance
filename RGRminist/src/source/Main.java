package source;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.Color;
import java.awt.Point;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;

public class Main {

	private JFrame frame;
	private JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		initialize();
		onWindowOpened();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 367, 311);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 234, 250);
		frame.getContentPane().add(scrollPane);
		
		tree = new JTree();
		scrollPane.setViewportView(tree);
		
		Panel panel = new Panel();
		panel.setBounds(250, 10, 102, 251);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBounds(6, 0, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.setBounds(6, 33, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Edit");
		btnNewButton_2.setBounds(6, 61, 89, 23);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Store");
		btnNewButton_3.setBounds(6, 89, 89, 23);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Restore");
		btnNewButton_4.setBounds(6, 117, 89, 23);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Calculate");
		btnNewButton_5.setBounds(6, 145, 89, 23);
		panel.add(btnNewButton_5);
	}
	
	protected TreeModel getStartModel() throws Exception {
		Ministry m = new Ministry("̳���������", "������� �.�.");
		City c = new City("�������", "��������� �.�.");
		Station s = new Station("ϳ������� ������", "������ �.�.");
		Trip t = new Trip("��11", "1221", "�������", "���");
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(m);
		DefaultMutableTreeNode cNode = new DefaultMutableTreeNode(c);
		DefaultMutableTreeNode sNode = new DefaultMutableTreeNode(s);
		DefaultMutableTreeNode tNode = new DefaultMutableTreeNode(t);
		root.add(cNode);
		cNode.add(sNode);
		sNode.add(tNode);
		return (new JTree(root).getModel());
		
	}
	
	protected void onWindowOpened() {
		try {
			tree.setModel(getStartModel());
			for(int i = 0; i < tree.getRowCount(); i++)
				tree.expandRow(i);
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public JTree getTree() {
		return tree;
	}
}
