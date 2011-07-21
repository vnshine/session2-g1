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

public class QuanLiNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField textField_PK;
	private JTextField textField_Name;
	private JTextField textField_Date;
	private JTextField textField_Phone;
	private JTextField textField_Find;
	private JScrollPane danhSach;
	private JTable nhanVien;
	private Integer loaddata = 1; // neu bang 1 thi load database vao table
	static Locale locale;
	ResourceBundle bundle;
	
	DefaultTableModel model;
	
	
	/**
	 * Create the frame.
	 */
	public QuanLiNhanVien() {
		locale = new Locale("vi", "VN");
		bundle = ResourceBundle.getBundle("Project1/Languages",locale); // NOI18N
		
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
		
		
		ButtonGroup group2 = new ButtonGroup();
		anh = new JRadioButtonMenuItem("English",false);
		viet = new JRadioButtonMenuItem("Tieng Viet",true);
		
		
		JRadioButtonMenuItem rdbtnmntmSortByAge = new JRadioButtonMenuItem("Sort by Age");
		mnTools.add(rdbtnmntmSortByAge);
		
		JRadioButtonMenuItem rdbtnmntmSortByName = new JRadioButtonMenuItem("Sort by Name");
		mnTools.add(rdbtnmntmSortByName);
		
		JSeparator separator_1 = new JSeparator();
		mnTools.add(separator_1);
		
		JMenu mnLanguages = new JMenu("Languages");
		mnTools.add(mnLanguages);
		
		JRadioButtonMenuItem rdbtnmntmEnglish = new JRadioButtonMenuItem("English");
		mnLanguages.add(rdbtnmntmEnglish);
		
		JRadioButtonMenuItem rdbtnmntmVietnam = new JRadioButtonMenuItem("VietNam");
		mnLanguages.add(rdbtnmntmVietnam);
		
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
		Object[][] rowData = {};
		String[] columnNames = {"PK","Name","Sex","Date","Phone Number","Status Number"};
		model = new DefaultTableModel(rowData, columnNames); // assign data for table
		nhanVien = new JTable(model);
		nhanVien.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		nhanVien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		danhSach.setViewportView(nhanVien);
		contentPane.add(danhSach, BorderLayout.CENTER);
		
		JPanel tools = new JPanel();
		contentPane.add(tools, BorderLayout.SOUTH);
		tools.setLayout(new BorderLayout(0, 0));
		
		JPanel tools1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) tools1.getLayout();
		tools.add(tools1, BorderLayout.NORTH);
		
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
		
		JPanel tools2 = new JPanel();
		tools.add(tools2, BorderLayout.SOUTH);
		
		JButton btnAdd = new JButton("Add");
		tools2.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		tools2.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		tools2.add(btnDelete);
		
		textField_Find = new JTextField();
		tools2.add(textField_Find);
		textField_Find.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		tools2.add(btnFind);
		nhanVien.getColumnModel().getColumn(0).setHeaderValue("Khoa Chinh");
	}
	public void ChangeLanguage() {
		nhanVien.getColumnModel().getColumn(0).setHeaderValue("Khoa Chinh");
		nhanVien.getColumnModel().getColumn(0).setHeaderValue("Khoa Chinh");
		nhanVien.getColumnModel().getColumn(0).setHeaderValue("Khoa Chinh");
		nhanVien.getColumnModel().getColumn(0).setHeaderValue("Khoa Chinh");
		nhanVien.getColumnModel().getColumn(0).setHeaderValue("Khoa Chinh");
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