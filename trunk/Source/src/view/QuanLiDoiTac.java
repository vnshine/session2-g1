package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import myobject.DoiTac;
import process.QLDoiTacProcess;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.HierarchyListener;
import java.awt.event.HierarchyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLiDoiTac extends JInternalFrame {

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private JTable table;
	private JTextField textField_MaDT;
	private JTextField textField_TenDT;
	private JTextField textField_NLH;
	private JTextField textField_SoDT;
	private JTextField textField_DiaChiDT;
	private JTextField textField_GhiChuDT;
	private JComboBox box_SoTrang;
	private Integer soTrang = 1;
	private Integer sTT = 1;
	private String[] columname = new String[] { "STT",
															"M\u00E3 \u0111\u1ED1i t\u00E1c",
															"T\u00EAn \u0111\u1ED1i t\u00E1c",
															"Ng\u01B0\u1EDDi li\u00EAn h\u1EC7",
															"\u0110\u1ECBa ch\u1EC9",
															"S\u1ED1 \u0111i\u1EC7n tho\u1EA1i"
															};
	DefaultTableModel model;
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public QuanLiDoiTac() throws SQLException {
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight());  


		setTitle("Qu\u1EA3n l\u00ED \u0111\u1ED1i t\u00E1c");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		Box verticalBox = Box.createVerticalBox();
		panel_1.add(verticalBox);
		
		JPanel panel_DuLieu = new JPanel();
		panel_DuLieu.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "D\u1EEF li\u1EC7u", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		verticalBox.add(panel_DuLieu);
		
		Box verticalBox_1 = Box.createVerticalBox();
		panel_DuLieu.add(verticalBox_1);
		
		JPanel panel_DL1 = new JPanel();
		verticalBox_1.add(panel_DL1);
		
		JLabel lblMiTc = new JLabel("M\u00E3 \u0111\u1ED1i t\u00E1c: ");
		panel_DL1.add(lblMiTc);
		
		textField_MaDT = new JTextField();
		panel_DL1.add(textField_MaDT);
		textField_MaDT.setColumns(10);
		
		JLabel lblTniTc = new JLabel("T\u00EAn \u0111\u1ED1i t\u00E1c: ");
		panel_DL1.add(lblTniTc);
		
		textField_TenDT = new JTextField();
		panel_DL1.add(textField_TenDT);
		textField_TenDT.setColumns(15);
		
		JLabel lblNgiLinH_1 = new JLabel("Ng\u01B0\u1EDDi li\u00EAn h\u1EC7: ");
		panel_DL1.add(lblNgiLinH_1);
		
		textField_NLH = new JTextField();
		panel_DL1.add(textField_NLH);
		textField_NLH.setColumns(15);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i: ");
		panel_DL1.add(lblSinThoi);
		
		textField_SoDT = new JTextField();
		panel_DL1.add(textField_SoDT);
		textField_SoDT.setColumns(15);
		
		JPanel panel_DL2 = new JPanel();
		verticalBox_1.add(panel_DL2);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9: ");
		panel_DL2.add(lblaCh);
		
		textField_DiaChiDT = new JTextField();
		panel_DL2.add(textField_DiaChiDT);
		textField_DiaChiDT.setColumns(30);
		
		JLabel lblGhiCh = new JLabel("Ghi ch\u00FA: ");
		panel_DL2.add(lblGhiCh);
		
		textField_GhiChuDT = new JTextField();
		panel_DL2.add(textField_GhiChuDT);
		textField_GhiChuDT.setColumns(30);
		
		JPanel panel_TacVu = new JPanel();
		panel_TacVu.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T\u00E1c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		verticalBox.add(panel_TacVu);
		
		JButton btnThm = new JButton("Th\u00EAm");
		panel_TacVu.add(btnThm);
		
		JButton btnSa = new JButton("S\u1EEDa");
		panel_TacVu.add(btnSa);
		
		JButton btnXa = new JButton("X\u00F3a");
		panel_TacVu.add(btnXa);
		
		JButton btnTmKim = new JButton("T\u00ECm ki\u1EBFm");
		panel_TacVu.add(btnTmKim);
		
		JButton btnLu = new JButton("L\u01B0u");
		panel_TacVu.add(btnLu);
		
		JButton btnHy = new JButton("H\u1EE7y");
		panel_TacVu.add(btnHy);
		
		JPanel panel_DanhSach = new JPanel();
		panel_DanhSach.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch \u0111\u1ED1i t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		verticalBox.add(panel_DanhSach);
		panel_DanhSach.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_DanhSach.add(scrollPane);
		
		table = new JTable();
		model = (new DefaultTableModel(
				new Object[][] {
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
						{null, null, null, null, null, null},
					},
					columname
				) {
					boolean[] columnEditables = new boolean[] {
						true, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		table.setModel(model);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(350);
		table.getColumnModel().getColumn(3).setPreferredWidth(350);
		table.getColumnModel().getColumn(4).setPreferredWidth(400);
		table.getColumnModel().getColumn(5).setPreferredWidth(300);
		scrollPane.setViewportView(table);
		
		JPanel panel_XemTrang = new JPanel();
		verticalBox.add(panel_XemTrang);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				box_SoTrang.setSelectedItem(soTrang-1);
			}
		});
		panel_XemTrang.add(btnBack);
		
		box_SoTrang = new JComboBox<Integer>();
		box_SoTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(box_SoTrang.getSelectedItem());
				soTrang = (Integer) box_SoTrang.getSelectedItem();
				try {
					loaddata();
					box_SoTrang.setSelectedItem(soTrang);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		panel_XemTrang.add(box_SoTrang);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				box_SoTrang.setSelectedItem(soTrang+1);
			}
		});
		panel_XemTrang.add(btnNext);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{643, 63, 0};
		gbl_panel_2.rowHeights = new int[]{14, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblCreateBy = new JLabel("Create by ...");
		GridBagConstraints gbc_lblCreateBy = new GridBagConstraints();
		gbc_lblCreateBy.insets = new Insets(0, 0, 0, 5);
		gbc_lblCreateBy.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCreateBy.gridx = 0;
		gbc_lblCreateBy.gridy = 0;
		panel_2.add(lblCreateBy, gbc_lblCreateBy);
		
		
		
		
		loaddata();

	}
	
	private static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}
	public void loaddata() throws SQLException {
		QLDoiTacProcess dtac = new QLDoiTacProcess();
		Integer soDT = dtac.getsoDoiTac();
				
		System.out.println((soDT / 25));
		if (((soDT / 25) % 2) == 0 ) {
			Combo((soDT / 25));
		}else Combo((soDT / 25)+1);
		
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		
		Vector<DoiTac> dsDoiTac = dtac.getListDoiTac(soTrang);
		sTT = (soTrang-1)*25+1;
		System.out.println("So thu tu: "+sTT);
		System.out.println("So trang: "+soTrang);
		System.out.println("So doi tac trong trang: "+dsDoiTac.size());
		for (int i = 0; i < dsDoiTac.size(); i++) {
			Object[] oPerson = {sTT,
								dsDoiTac.get(i).getPK_sDoiTacID(),
								dsDoiTac.get(i).getsTenDoiTac(),
								dsDoiTac.get(i).getsNguoiLienHe(),
								dsDoiTac.get(i).getsDiaChi(),
								dsDoiTac.get(i).getsSoDienThoai()
								};
			sTT++;
			model.insertRow(i, oPerson);
		}
		model.fireTableDataChanged();
	}
	
	public void Combo(int numItems)
	{
		Vector v = new Vector(numItems);
		for (int i = 1; i <= numItems; i++) {
			v.add(new Integer(i));
		}
		DefaultComboBoxModel model = new DefaultComboBoxModel(v);
		box_SoTrang.setModel(model);
	}
	
	public void insert()
	{
		DoiTac doiTac = new DoiTac();
		doiTac.setiTrangThai(1);
		doiTac.setPK_sDoiTacID(textField_MaDT.getText());
		doiTac.setsDiaChi(textField_DiaChiDT.getText());
		doiTac.setsGhiChu(textField_GhiChuDT.getText());
		doiTac.setsNguoiLienHe(textField_NLH.getText());
		doiTac.setsSoDienThoai(textField_SoDT.getText());
		doiTac.setsTenDoiTac(textField_TenDT.getText());
		doiTac.setsTenDoiTacEng()
		QLDoiTacProcess dtac = new QLDoiTacProcess();
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		installLnF();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiDoiTac frame = new QuanLiDoiTac();
					frame.setVisible(true);
					frame.pack();
					JFrame mainf = new JFrame();
					mainf.getContentPane().add(frame);
					mainf.setVisible(true);
					mainf.pack();
					
					mainf.setDefaultCloseOperation(EXIT_ON_CLOSE);
					mainf.setExtendedState(Frame.MAXIMIZED_BOTH);  // full screen
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
