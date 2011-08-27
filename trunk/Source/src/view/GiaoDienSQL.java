package view;
	
	import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import process.SQL;

public class GiaoDienSQL extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JScrollPane danhSach;
	private JTable nhanVien;
	private JRadioButtonMenuItem lenUS,lviVN;
	private Integer loaddata = 0; // neu bang 1 thi load database vao table
	static Locale locale;
	ResourceBundle bundle;
	
	DefaultTableModel model;
	private JTextField textField_SQL;
	
	
	/**
	 * Create the frame.
	 */
	public GiaoDienSQL() {
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
		
		JLabel lblSql = new JLabel("SQL:");
		banner.add(lblSql);
		
		textField_SQL = new JTextField(50);
		banner.add(textField_SQL);
		
		JButton btnExcute = new JButton("Excute !");
		btnExcute.setActionCommand("exe");
		btnExcute.addActionListener(this);
		banner.add(btnExcute);
		
		JProgressBar progressBar = new JProgressBar();
		banner.add(progressBar);
		
		danhSach = new JScrollPane();
		Object[][] rowData = {};
		
		String[] columnNames = {"-","-","-","-","-","-"};
		model = new DefaultTableModel(rowData, columnNames); // assign data for table
		nhanVien = new JTable(model);
		nhanVien.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		nhanVien.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		danhSach.setViewportView(nhanVien);
		contentPane.add(danhSach, BorderLayout.CENTER);
		
		String[] sexStrings = { "Nam", "Nu"};
		//nhanVien.getColumnModel().getColumn(0).setHeaderValue("Khoa Chinh");
		/*
		if (loaddata == 1) {
			loaddata();
			loaddata = 0;
		}*/
	}
	
	public void loaddata(String sql) {
		SQL nhanVien = new SQL();
		Vector<Object> nhanVien2 = nhanVien.getListNhanVien(sql);
		//String sex;
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		model.setDataVector(nhanVien2, nhanVien.columnName(sql));
		/*
		for (int i = 0; i < nhanVien2.size(); i++) {
			if (nhanVien2.get(i).getSex() == 1) {
				sex = "Nam";
			}else sex = "Nu";
		*/
			//Object[] oPerson = {nhanVien2.get(i).getpK(),nhanVien2.get(i).getName(),sex,nhanVien2.get(i).getDate(),nhanVien2.get(i).getPhone(),nhanVien2.get(i).getTrangthai()};

			//model.insertRow(0, oPerson);
		//}
		
	}
	public void ChangeLanguage() {
		//nhanVien.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("name"));
		//nhanVien.getColumnModel().getColumn(0).setHeaderValue(bundle.getString("age"));
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getActionCommand().equals("exe")) {
			String cauSQL = textField_SQL.getText();
			cauSQL = cauSQL.trim();
			//int index;
			//System.out.println(cauSQL);
			//index = cauSQL.indexOf(" ");
			String cau = cauSQL.substring(0, 7);
			cau = cau.toUpperCase();
			SQL run = new SQL();
			if (cau.contains("SELECT")) {
				System.out.println(cauSQL);
				//run.getListNhanVien(cauSQL);
				loaddata(cauSQL);
			}else
			{
				run.runNhanVien(cauSQL);
				loaddata("SELECT * FROM dbo.tbl_NhanVien");
			}
			textField_SQL.setText("");
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
					GiaoDienSQL frame = new GiaoDienSQL();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

}
