package source;

import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.AbstractButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.util.Enumeration;
import java.awt.Color;
import java.awt.Point;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuItem;

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
		frame.setTitle("̳���������� ����������");
		frame.setBounds(100, 100, 410, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 234, 250);
		frame.getContentPane().add(scrollPane);

		tree = new JTree();
		tree.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				onMouseClicked(e);
			}

			private void onMouseClicked(MouseEvent e) {
				if (e.getClickCount() != 3 || e.getButton() != MouseEvent.BUTTON3)
					return;
				DefaultMutableTreeNode node = getSelectedNode();
				if (node == null)
					return;
				AnyData data = (AnyData) node.getUserObject();
				Dlg dlg = data.showDialog(false);
				((JDialog) dlg).dispose();
			}
		});
		scrollPane.setViewportView(tree);

		Panel panel = new Panel();
		panel.setBounds(250, 10, 134, 251);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAdd();
			}

			private void onAdd() {
				DefaultMutableTreeNode parent = getSelectedNode();
				if (parent == null)
					return;
				AnyData parentData = (AnyData) parent.getUserObject();
				Dlg dlg = parentData.showSonDialog();
				if (dlg == null)
					return;
				Object obj;
				try {
					obj = dlg.createObject();

				} catch (Exception e) {
					JOptionPane.showMessageDialog(tree, e.getMessage(), frame.getTitle(), JOptionPane.ERROR_MESSAGE);
					return;
				}
				((JDialog) dlg).dispose();
				if (obj == null)
					return;
				DefaultMutableTreeNode newSon = new DefaultMutableTreeNode(obj);
				parent.add(newSon);
				tree.updateUI();
				expandAll();
			}
		});
		btnAdd.setBounds(6, 0, 118, 23);
		panel.add(btnAdd);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onRemove();
			}

			private void onRemove() {
				DefaultMutableTreeNode node = getSelectedNode();
				if (node == null) {
					return;
				}
				node.removeFromParent();
				tree.setSelectionPath(null);
				tree.updateUI();
			}
		});
		btnRemove.setBounds(6, 27, 118, 23);
		panel.add(btnRemove);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onEdit();
			}

			private void onEdit() {
				DefaultMutableTreeNode node = getSelectedNode();
				if (node == null) {
					return;
				}
				AnyData data = (AnyData) node.getUserObject();
				Dlg maindialog = data.showDialog(true);
				Object obj;
				try {
					obj = maindialog.createObject();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(tree, e.getMessage(), frame.getTitle(), JOptionPane.ERROR_MESSAGE);
					return;
				}
				((JDialog) maindialog).dispose();
				if (obj == null) {
					return;
				}
				node.setUserObject(obj);
				tree.updateUI();
			}
		});
		btnEdit.setBounds(6, 55, 118, 23);
		panel.add(btnEdit);

		JButton btnStore = new JButton("Store");
		btnStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onStore();
			}

			private void onStore() {
				if (tree.getModel() == null)
					return;
				JFileChooser fileChooser = new JFileChooser("���������� ����� ������");
				fileChooser.showSaveDialog(frame);
				try {
					File f = fileChooser.getSelectedFile();
					String fName = f.getAbsolutePath();
					FileOutputStream fileStream = new FileOutputStream(fName);
					ObjectOutputStream out = new ObjectOutputStream(fileStream);
					out.writeObject(tree.getModel());
					out.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(tree, "������� �������� �����", "���������� ������ � ����",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				tree.setModel((new JTree()).getModel());
			}
		});
		btnStore.setBounds(6, 83, 118, 23);
		panel.add(btnStore);

		JButton btnRestore = new JButton("Restore");
		btnRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRestore();
			}

			private void onRestore() {
				FileDialog fileDialog = new FileDialog(frame);
				fileDialog.setMode(FileDialog.LOAD);
				fileDialog.setVisible(true);
				String dr = fileDialog.getDirectory();
				String fn = fileDialog.getFile();
				if (dr == null || fn == null)
					return;
				String fName = dr + fn;
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(fName));
					TreeModel model = (TreeModel) in.readObject();
					tree.setModel(model);
					in.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(tree, "������� � ������������ ������", "������������",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				expandAll();
			}
		});
		btnRestore.setBounds(6, 111, 118, 23);
		panel.add(btnRestore);

		JButton btnCalculate = new JButton("Find/Calculate");
		btnCalculate.setBounds(6, 140, 118, 23);
		panel.add(btnCalculate);
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setLabel("");
		addPopup(btnCalculate, popupMenu);
		
		
		JMenuItem mntmCountTrip = new JMenuItem("Count trip");
		mntmCountTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				countTrip();
			}

			private void countTrip() {
				DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
				Enumeration<DefaultMutableTreeNode> enmTeam = root.children();
				String message = "";
				int cntCity = 0;
				int cntStation = 0;
				int cntTrip = 0;
				while(enmTeam.hasMoreElements()) {
					DefaultMutableTreeNode strg = enmTeam.nextElement();
					cntCity++;
					Enumeration<DefaultMutableTreeNode> enmAmplua = strg.children();
					while(enmAmplua.hasMoreElements()) {
						DefaultMutableTreeNode grp = enmAmplua.nextElement();
						cntStation++;
						Enumeration<DefaultMutableTreeNode> enmPlayer = grp.children();
						while(enmPlayer.hasMoreElements()) {
							DefaultMutableTreeNode prdct = enmPlayer.nextElement();
							cntTrip++;
						}
					}
				}
				message += "Count city: "+ String.valueOf(cntCity) + "\n";
				message += "Count station: "+String.valueOf(cntStation) + "\n";
				message += "Count trip: " +String.valueOf(cntTrip) + "\n";
				JOptionPane.showMessageDialog(null, message, "Count trip", JOptionPane.PLAIN_MESSAGE);
			}
		});
		popupMenu.add(mntmCountTrip);
		
		JMenuItem mntmTripToCity = new JMenuItem("Max trip price");
		mntmTripToCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = getSelectedNode();
				if(node == null) {
					return;
				}
				double maxvalue = 0;
				DefaultMutableTreeNode greatest = null;
				Enumeration<DefaultMutableTreeNode> enm = node.postorderEnumeration();
				while(enm.hasMoreElements()) {
					DefaultMutableTreeNode currentNode = enm.nextElement();
					Object data = currentNode.getUserObject();
					if(!(data instanceof Trip)) {
						continue;
					}
					double value = ((Trip) data).priceTrip;
					if(value > maxvalue) {
						maxvalue = value;
						greatest = currentNode;
					}
				}
				selectNode(greatest);
				((AnyData) greatest.getUserObject()).showDialog(false);
			}
		});
		popupMenu.add(mntmTripToCity);
		
		JMenuItem mntmMinTripPrice = new JMenuItem("Min trip price");
		mntmMinTripPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultMutableTreeNode node = getSelectedNode();
				if(node == null) {
					return;
				}
				DefaultMutableTreeNode smallest = null;
				Enumeration<DefaultMutableTreeNode> enm = node.postorderEnumeration();
				double minvalue = 500;
				while(enm.hasMoreElements()) {
					DefaultMutableTreeNode currentNode = enm.nextElement();
					Object data = currentNode.getUserObject();
					if(!(data instanceof Trip)) {
						continue;
					}
					double value = ((Trip) data).priceTrip;
					if(value < minvalue) {
						minvalue = value;
						smallest = currentNode;
					}
				}
				selectNode(smallest);
				((AnyData) smallest.getUserObject()).showDialog(false);
				
			}
		});
		popupMenu.add(mntmMinTripPrice);
	}

	protected TreeModel getStartModel() throws Exception {
		Ministry m = new Ministry("̳���������", "������� �.�.");
		City c = new City("�������", "��������� �.�.");
		Station s = new Station("ϳ������� ������", "������ �.�.");
		Trip t = new Trip("��11", 1221.0, "�������", "���");
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
			for (int i = 0; i < tree.getRowCount(); i++)
				tree.expandRow(i);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public JTree getTree() {
		return tree;
	}

	private DefaultMutableTreeNode getSelectedNode() {
		Object selectNode = tree.getLastSelectedPathComponent();
		if (selectNode == null) {
			JOptionPane.showMessageDialog(tree, "Node was not selected", frame.getTitle(), JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return (DefaultMutableTreeNode) selectNode;
	}

	private void expandAll() {
		for (int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
	}

	private void selectNode(DefaultMutableTreeNode node) {
		int n = 0;
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
		Enumeration<DefaultMutableTreeNode> enm = root.children();
		while (enm.hasMoreElements()) {
			DefaultMutableTreeNode nod = enm.nextElement();
			if (nod == node) {
				tree.setSelectionRow(n);
				return;
			}
			n++;
		}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				showMenu(e);
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
