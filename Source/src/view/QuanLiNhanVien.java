package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.BevelBorder;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import process.*;

public class QuanLiNhanVien extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField_PK,textField_Name,textField_Date,textField_Phone,textField_Find;
	private JButton btnDelete,btnAdd,btnUpdate,btnFind;
	private JScrollPane danhSach;
	private JTable nhanVien;
	private JRadioButtonMenuItem lenUS,lviVN;
	private Integer loaddata = 1; // neu bang 1 thi load database vao table
	static Locale locale;
	ResourceBundle bundle;
	DefaultTableModel model;
	private JTextField textField_Status;
	private JTextField textField_SoTrang;
	
	
	/**
	 * Create the frame.
	 */
	public QuanLiNhanVien() {
		//locale = new Locale("en", "US");
		//bundle = ResourceBundle.getBundle("view/Languages",locale); // NOI18N
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		JMenu mnTools = new JMenu("Tools");
		menuBar.add(mnTools);
		JRadioButtonMenuItem rdbtnmntmSortByAge = new JRadioButtonMenuItem("Sort by Age");
		mnTools.add(rdbtnmntmSortByAge);
		JRadioButtonMenuItem rdbtnmntmSortByName = new JRadioButtonMenuItem("Sort by Name");
		mnTools.add(rdbtnmntmSortByName);
		JSeparator separator_1 = new JSeparator();
		mnTools.add(separator_1);
		JMenu mnLanguages = new JMenu("Languages");
		mnTools.add(mnLanguages);
		ButtonGroup group2 = new ButtonGroup();
		lenUS = new JRadioButtonMenuItem("English",true);
		lenUS.addActionListener(this);
		lviVN = new JRadioButtonMenuItem("Tieng Viet",false);
		lviVN.addActionListener(this);
		group2.add(lenUS);
		group2.add(lviVN);
		mnLanguages.add(lenUS);
		mnLanguages.add(lviVN);
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel banner = new JPanel();
		banner.setBounds(100, 100, 800, 300);
		contentPane.add(banner, BorderLayout.NORTH);
		
		JEditorPane editorPane = new JEditorPane();
		
		banner.add(editorPane);
		
		danhSach = new JScrollPane();
		danhSach.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Object[][] rowData = {};
		String[] columnNames = {"PK","Name","Sex","Date","Phone Number","Status Number"};
		model = new DefaultTableModel(rowData, columnNames); // assign data for table
		nhanVien = new JTable(model);
		nhanVien.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		/*
		nhanVien.getColumnModel().getColumn(0).setPreferredWidth(60);
		nhanVien.getColumnModel().getColumn(1).setPreferredWidth(220);
		nhanVien.getColumnModel().getColumn(2).setPreferredWidth(60);
		nhanVien.getColumnModel().getColumn(3).setPreferredWidth(210);
		nhanVien.getColumnModel().getColumn(4).setPreferredWidth(110);
		nhanVien.getColumnModel().getColumn(5).setPreferredWidth(92);
		*/
		nhanVien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		danhSach.setViewportView(nhanVien);
		contentPane.add(danhSach, BorderLayout.CENTER);
		
		JPanel tools = new JPanel();
		contentPane.add(tools, BorderLayout.SOUTH);
		tools.setLayout(new BorderLayout(0, 0));
		
		JPanel toolsChonTrang = new JPanel();
		tools.add(toolsChonTrang, BorderLayout.NORTH);
		
		JButton btnPrev = new JButton("<< Previous");
		btnPrev.addActionListener(this);
		btnPrev.setActionCommand("btnPrev");
		toolsChonTrang.add(btnPrev);
		
		JLabel lblTrangS = new JLabel("Trang s\u1ED1 :");
		toolsChonTrang.add(lblTrangS);
		
		textField_SoTrang = new JTextField("1");
		toolsChonTrang.add(textField_SoTrang);
		textField_SoTrang.setColumns(2);

		textField_SoTrang.disable();
		
		JButton btnNext = new JButton("  Next >> ");
		btnNext.addActionListener(this);
		btnNext.setActionCommand("btnNext");
		toolsChonTrang.add(btnNext);
		
		JPanel tools1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) tools1.getLayout();
		tools.add(tools1, BorderLayout.CENTER);
		
		JLabel lbl_PK = new JLabel("PK:");
		tools1.add(lbl_PK);
		
		textField_PK = new JTextField();
		tools1.add(textField_PK);
		textField_PK.setColumns(10);
		
		JLabel lblDate = new JLabel("Name:");
		tools1.add(lblDate);
		
		textField_Name = new JTextField();
		tools1.add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblSex = new JLabel("Sex:");
		tools1.add(lblSex);
		
		String[] sexStrings = { "Nam", "Nu"};
		JComboBox comboBox = new JComboBox(sexStrings);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setSelectedIndex(0);
		tools1.add(comboBox);
		
		JLabel lblDate_1 = new JLabel("Date:");
		tools1.add(lblDate_1);
		
		textField_Date = new JTextField();
		tools1.add(textField_Date);
		textField_Date.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone:");
		tools1.add(lblPhone);
		
		textField_Phone = new JTextField();
		tools1.add(textField_Phone);
		textField_Phone.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status:");
		tools1.add(lblStatus);
		
		textField_Status = new JTextField();
		tools1.add(textField_Status);
		textField_Status.setColumns(10);
		
		JPanel tools2 = new JPanel();
		tools.add(tools2, BorderLayout.SOUTH);
		
		btnAdd = new JButton("Add");
		btnAdd.setActionCommand("Add");
		btnAdd.addActionListener(this);
		tools2.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setActionCommand("Update");
		btnUpdate.addActionListener(this);
		tools2.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setActionCommand("Delete");
		btnDelete.addActionListener(this);
		tools2.add(btnDelete);
		
		textField_Find = new JTextField();
		tools2.add(textField_Find);
		textField_Find.setColumns(10);
		
		btnFind = new JButton("Find");
		btnFind.setActionCommand("Find");
		btnFind.addActionListener(this);
		tools2.add(btnFind);
		//nhanVien.getColumnModel().getColumn(0).setHeaderValue("Khoa Chinh");
		
//		if (loaddata == 1) {
			loaddata();
//			loaddata = 0;
//		}
	}
	
	public void loaddata() {
		NhanVienProcess nhanVien = new NhanVienProcess();
		Vector<ObjQuyen> nhanVien2 = nhanVien.getListNhanVien();
		String sex;
		model.getDataVector().removeAllElements();
		for (int i = 0; i < nhanVien2.size(); i++) {
			if (nhanVien2.get(i).getSex() == 1) {
				sex = "Nam";
			}else sex = "Nu";
			Object[] oPerson = {nhanVien2.get(i).getpK(),nhanVien2.get(i).getName(),sex,nhanVien2.get(i).getDate(),nhanVien2.get(i).getPhone(),nhanVien2.get(i).getTrangthai()};
			model.insertRow(0, oPerson);
		}
		model.fireTableDataChanged();	
	}
	public void ChangeLanguage() {
		//nhanVien.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("name"));
		//nhanVien.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("age"));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String action = arg0.getActionCommand();
	    if (action.equalsIgnoreCase("Add")) {
	    	
		}
	    if (action.equalsIgnoreCase("Update")) {
	    	
		}
	    if (action.equalsIgnoreCase("Delete")) {
	    	
		}
		if (lviVN.isSelected()) {
			ChangeLanguage();
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiNhanVien frame = new QuanLiNhanVien();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

}
