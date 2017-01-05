package graphics;

import java.awt.EventQueue;
import java.awt.FileDialog;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Main {

	private JFrame fTrdCmp;
	private JTree tree;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.fTrdCmp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected TreeModel getStartModel() throws Exception {
		TradingCompInfo tci = new TradingCompInfo("Вена", "Чернигов 77-й Гвардейской дивизии, 1", "Гипермаркет");
		StorageInfo si = new StorageInfo("Склад №1", "Чернигов 77-й Гвардейской дивизии, 1", 751);
		GroupProductInfo gpi = new GroupProductInfo("Душевые кабины", "Сантехника");
		ProductInfo pi = new ProductInfo("AQUASTREAM Simple 99 HW", 3500, "Китай", 34);
		ProductInfo pi2 = new ProductInfo("AQUASTREAM Pro 212 HW", 4800, "Китай", 12);
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(tci);
		DefaultMutableTreeNode sNod = new DefaultMutableTreeNode(si);
		DefaultMutableTreeNode gNod = new DefaultMutableTreeNode(gpi);
		DefaultMutableTreeNode pNod = new DefaultMutableTreeNode(pi);
		DefaultMutableTreeNode pNod2 = new DefaultMutableTreeNode(pi2);
		root.add(sNod); sNod.add(gNod); gNod.add(pNod);
		gNod.add(pNod2);
		return (new JTree(root)).getModel();
	}
	
	private DefaultMutableTreeNode getSelectedNode() {
		Object selectNode = tree.getLastSelectedPathComponent();
		if(selectNode == null) {
			JOptionPane.showMessageDialog(tree, "Node was not selected", fTrdCmp.getTitle(), JOptionPane.ERROR_MESSAGE);
			return null;
		}
		return (DefaultMutableTreeNode) selectNode;
	}
	
	protected void onWindowOpened() {
		try {
			tree.setModel(getStartModel());
			for(int i = 0; i < tree.getRowCount(); i++) {
				tree.expandRow(i);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void expandAll() {
		for(int i = 0; i < tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
	}
	
	private void selectNode(DefaultMutableTreeNode node) {
		int n = 0;
		DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
		Enumeration<DefaultMutableTreeNode> enm = root.children();
		while(enm.hasMoreElements()) {
			DefaultMutableTreeNode nod = enm.nextElement();
			if(nod == node) {
				tree.setSelectionRow(n);
				return;
			}
			n++;
		}
	}
	
	public Main() {
		initialize();
		onWindowOpened();
	}

	private void initialize() {
		fTrdCmp = new JFrame();
		fTrdCmp.setResizable(false);
		fTrdCmp.getContentPane().setBackground(Color.ORANGE);
		fTrdCmp.setTitle("Trading Company");
		fTrdCmp.setBounds(100, 100, 400, 455);
		fTrdCmp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fTrdCmp.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 371, 315);
		fTrdCmp.getContentPane().add(scrollPane);
		
		tree = new JTree();
		tree.setForeground(Color.WHITE);
		tree.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		tree.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		tree.setBackground(Color.WHITE);
		tree.setEditable(true);
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onMouseClicked(e);
			}

			private void onMouseClicked(MouseEvent e) {
				if(e.getClickCount() != 1 || e.getButton() != MouseEvent.BUTTON3) {
					return;
				}
				DefaultMutableTreeNode node = getSelectedNode();
				if(node == null) {
					return;
				}
				AnyData data = (AnyData) node.getUserObject();
				MainDialog main_dialog = data.showDialog(false);
				((JDialog) main_dialog).dispose();
			}
		});
		scrollPane.setViewportView(tree);
		
		JPanel panel = 	new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBackground(Color.ORANGE);
		panel.setBounds(10, 11, 371, 61);
		fTrdCmp.getContentPane().add(panel);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.setFont(new Font("ObelixPro", btnNewButton_1.getFont().getStyle(), 13));
		btnNewButton_1.setForeground(Color.ORANGE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(10, 11, 110, 36);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onAdd();
			}

			private void onAdd() {
				DefaultMutableTreeNode parent = getSelectedNode();
				if(parent == null) {
					return;
				}
				AnyData parentData = (AnyData) parent.getUserObject();
				MainDialog maindialog = parentData.showSonDialog();
				if(maindialog == null) {
					return;
				}
				Object obj;
				try {
					obj = maindialog.createObject();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(tree, e.getMessage(), fTrdCmp.getTitle(), JOptionPane.ERROR_MESSAGE);
					return;
				}
				((JDialog) maindialog).dispose();
				if(obj == null) {
					return;
				}
				DefaultMutableTreeNode newSon = new DefaultMutableTreeNode(obj);
				parent.add(newSon);
				tree.updateUI();
				expandAll();
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Edit");
		btnNewButton.setFont(new Font("ObelixPro", btnNewButton_1.getFont().getStyle(), 13));
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(130, 11, 110, 36);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onEdit();
			}

			private void onEdit() {
				DefaultMutableTreeNode node = getSelectedNode();
				if(node == null) {
					return;
				}
				AnyData data = (AnyData) node.getUserObject();
				MainDialog maindialog = data.showDialog(true);
				Object obj;
				try {
					obj = maindialog.createObject();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(tree, e.getMessage(), fTrdCmp.getTitle(), JOptionPane.ERROR_MESSAGE);
					return;
				}
				((JDialog) maindialog).dispose();
				if(obj == null) {
					return;
				}
				node.setUserObject(obj);
				tree.updateUI();
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Remove");
		btnNewButton_2.setFont(new Font("ObelixPro", btnNewButton_1.getFont().getStyle(), 13));
		btnNewButton_2.setForeground(Color.ORANGE);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(250, 11, 110, 36);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				onRemove();
			}

			private void onRemove() {
				DefaultMutableTreeNode node = getSelectedNode();
				if(node == null) {
					return;
				}
				node.removeFromParent();
				tree.setSelectionPath(null);
				tree.updateUI();
			}
		});
		panel.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(58, 443, 30, 20);
		fTrdCmp.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(193, 443, 30, 20);
		fTrdCmp.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(351, 443, 30, 20);
		fTrdCmp.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblStrg = new JLabel("Storage");
		lblStrg.setBounds(10, 446, 40, 14);
		fTrdCmp.getContentPane().add(lblStrg);
		
		JLabel lblGroup = new JLabel("Groups");
		lblGroup.setBounds(152, 446, 46, 14);
		fTrdCmp.getContentPane().add(lblGroup);
		
		JLabel lblProducts = new JLabel("Products");
		lblProducts.setBounds(295, 446, 46, 14);
		fTrdCmp.getContentPane().add(lblProducts);
		
		JButton btnNewButton_3 = new JButton("!!!");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fTrdCmp.setBounds(100, 100, 400, 455);
				
			}
		});
		btnNewButton_3.setFont(new Font("ObelixPro", btnNewButton_3.getFont().getStyle(), btnNewButton_3.getFont().getSize() + 2));
		btnNewButton_3.setForeground(Color.ORANGE);
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setBounds(10, 409, 371, 23);
		fTrdCmp.getContentPane().add(btnNewButton_3);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 0, 0));
		fTrdCmp.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		mnNewMenu.setBackground(Color.BLACK);
		mnNewMenu.setForeground(Color.ORANGE);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(tree.getModel() == null) {
					return;
				}
				JFileChooser fileChooser = new JFileChooser("Serialization model of tree");
				fileChooser.showSaveDialog(fTrdCmp);
				try {
					File f = fileChooser.getSelectedFile();
					String fName = f.getAbsolutePath();
					FileOutputStream fileStream = new FileOutputStream(fName);
					ObjectOutputStream out = new ObjectOutputStream(fileStream);
					out.writeObject(tree.getModel());
					out.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(tree, "Fail with open file", "Store file in tree", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
			}
		
			
		});
		mntmSave.setForeground(Color.ORANGE);
		mntmSave.setBackground(Color.BLACK);
		mnNewMenu.add(mntmSave);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileDialog fileDialog = new FileDialog(fTrdCmp);
				fileDialog.setMode(FileDialog.LOAD);
				fileDialog.setVisible(true);
				String dr = fileDialog.getDirectory();
				String fn = fileDialog.getFile();
				if(dr == null || fn == null) {
					return;
				}
				String fName = dr + fn;
				try {
					ObjectInputStream in = new ObjectInputStream(new FileInputStream(fName));
					TreeModel model = (TreeModel) in.readObject();
					tree.setModel(model);
					in.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(tree, "Fail with deserialization tree", "Deserelazition", JOptionPane.ERROR_MESSAGE);
					return;
				}
				expandAll();
				
			}
		});
		mntmOpen.setForeground(Color.ORANGE);
		mntmOpen.setBackground(Color.BLACK);
		mnNewMenu.add(mntmOpen);
		
		JMenu mnSpecial = new JMenu("Special");
		mnSpecial.setBackground(Color.BLACK);
		mnSpecial.setForeground(Color.ORANGE);
		menuBar.add(mnSpecial);
		
		JMenuItem mntmSmallestNumberOf = new JMenuItem("Smallest number of product");
		mntmSmallestNumberOf.setBackground(Color.BLACK);
		mntmSmallestNumberOf.setForeground(Color.ORANGE);
		mntmSmallestNumberOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultMutableTreeNode node = getSelectedNode();
				if(node == null) {
					return;
				}
				DefaultMutableTreeNode smallest = null;
				Enumeration<DefaultMutableTreeNode> enm = node.postorderEnumeration();
				int minvalue = 500;
				while(enm.hasMoreElements()) {
					DefaultMutableTreeNode currentNode = enm.nextElement();
					Object data = currentNode.getUserObject();
					if(!(data instanceof ProductInfo)) {
						continue;
					}
					int value = ((ProductInfo) data).prdctValue;
					if(value < minvalue) {
						minvalue = value;
						smallest = currentNode;
					}
				}
				selectNode(smallest);
				((AnyData) smallest.getUserObject()).showDialog(false);
				
			}
		});
		mnSpecial.add(mntmSmallestNumberOf);
		
		JMenuItem mntmGreatestNumberOf = new JMenuItem("Greatest number of product");
		mntmGreatestNumberOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultMutableTreeNode node = getSelectedNode();
				if(node == null) {
					return;
				}
				int maxvalue = 0;
				DefaultMutableTreeNode greatest = null;
				Enumeration<DefaultMutableTreeNode> enm = node.postorderEnumeration();
				while(enm.hasMoreElements()) {
					DefaultMutableTreeNode currentNode = enm.nextElement();
					Object data = currentNode.getUserObject();
					if(!(data instanceof ProductInfo)) {
						continue;
					}
					int value = ((ProductInfo) data).prdctValue;
					if(value > maxvalue) {
						maxvalue = value;
						greatest = currentNode;
					}
				}
				selectNode(greatest);
				((AnyData) greatest.getUserObject()).showDialog(false);
				
				
			}
		});
		mntmGreatestNumberOf.setBackground(Color.BLACK);
		mntmGreatestNumberOf.setForeground(Color.ORANGE);
		mnSpecial.add(mntmGreatestNumberOf);
		
		JMenuItem mntmCount = new JMenuItem("Count");
		mntmCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fTrdCmp.setBounds(100, 100, 400, 530);
				
				DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
				Enumeration<DefaultMutableTreeNode> enmTeam = root.children();
				int cntSt = 0;
				int cntGr = 0;
				int cntPr = 0;
				while(enmTeam.hasMoreElements()) {
					DefaultMutableTreeNode strg = enmTeam.nextElement();
					cntSt++;
					Enumeration<DefaultMutableTreeNode> enmAmplua = strg.children();
					while(enmAmplua.hasMoreElements()) {
						DefaultMutableTreeNode grp = enmAmplua.nextElement();
						cntGr++;
						Enumeration<DefaultMutableTreeNode> enmPlayer = grp.children();
						while(enmPlayer.hasMoreElements()) {
							DefaultMutableTreeNode prdct = enmPlayer.nextElement();
							cntPr++;
						}
					}
				}
				
				textField.setText(String.valueOf(cntSt));
				textField_1.setText(String.valueOf(cntGr));
				textField_2.setText(String.valueOf(cntPr));
				
				
				
				
			}
		});
		mntmCount.setBackground(Color.BLACK);
		mntmCount.setForeground(Color.ORANGE);
		mnSpecial.add(mntmCount);
	}
	public JTree getTree() {
		return tree;
	}
}

