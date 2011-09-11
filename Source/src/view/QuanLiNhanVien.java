package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

import module.ThongBao;
import module.TiengVietToEg;
import myobject.DoiTac;
import process.QLDoiTacProcess;
import validate.CheckString;
import validate.XuLiTen;
import UsingExcelTemplates.WriteExcel;
import ch.rakudave.suggest.JSuggestField;

public class QuanLiNhanVien extends JInternalFrame implements ActionListener {

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private JTable table;
	private JTextField textField_MaDT;
	private JTextField textField_TenDT;
	private JTextField textField_NLH;
	private JTextField textField_SoDT;
	private JTextField textField_DiaChiDT;
	private JTextField textField_GhiChuDT;
	private JButton btnAdd,btnEdit,btnDelete,btnSave,btnFind,btnCancel,btnBack,btnNext,btnExport;
	private JLabel lblThongBao;
	private JComboBox box_SoTrang;
	private Integer soTrang = 1;
	private Integer sTT = 1;
	private Integer insertb = 0;
	private Integer deleteb = 0;
	private Integer updateb = 0;
	private Integer findb = 0;
	private Integer loi=0;
	private Integer loiMaDT=0;
	private Integer loiTenDT=0;
	private Integer loiNLH=0;
	private Integer loiSDT=0;
	private Integer loiDiaChi=0;
	private Integer loiGhiChu=0;
	private Integer onClickTable = 0;
	private JSuggestField textfJSuggestField;
	private String[] columname = new String[] { "STT",
															"M\u00E3 \u0111\u1ED1i t\u00E1c",
															"T\u00EAn \u0111\u1ED1i t\u00E1c",
															"Ng\u01B0\u1EDDi li\u00EAn h\u1EC7",
															"\u0110\u1ECBa ch\u1EC9",
															"S\u1ED1 \u0111i\u1EC7n tho\u1EA1i"
															};
	DefaultTableModel model;
	private CheckString CheckString = new CheckString();
	private JTextField textField;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public QuanLiNhanVien() throws SQLException {
		lblThongBao = new JLabel();
		lblThongBao.setText("Kh\u00F4ng t\u1ED3n t\u1EA1i \u0111\u1ED1i t\u00E1c mu\u1ED1n x\u00F3a !");
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight());  


		setTitle("Qu\u1EA3n l\u00ED Nh\u00E2n Vi\u00EAn\r\n");
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
		
		JLabel lblMaNV = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn: ");
		panel_DL1.add(lblMaNV);
		
		textField_MaDT = new JTextField();
		textField_MaDT.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if((deleteb ==1) || (updateb ==1) || (insertb == 1)) checkMaDT();
			}
		});

		panel_DL1.add(textField_MaDT);
		textField_MaDT.setColumns(10);
		
		JLabel lblTniTc = new JLabel("T\u00EAn \u0111\u1ED1i t\u00E1c: ");
		panel_DL1.add(lblTniTc);
		
		textField_TenDT = new JTextField();
		textField_TenDT.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if(deleteb ==1 || updateb ==1 || insertb == 1) checkTen();
			}
		});
		
		panel_DL1.add(textField_TenDT);
		textField_TenDT.setColumns(15);
		
		JLabel lblNgiLinH_1 = new JLabel(" Ng\u01B0\u1EDDi li\u00EAn h\u1EC7: ");
		panel_DL1.add(lblNgiLinH_1);
		
		textField_NLH = new JTextField();
		textField_NLH.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if(deleteb ==1 || updateb ==1 || insertb == 1) checkNLH();
			}
		});
		panel_DL1.add(textField_NLH);
		textField_NLH.setColumns(15);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i: ");
		panel_DL1.add(lblSinThoi);
		
		textField_SoDT = new JTextField();
		textField_SoDT.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if(deleteb ==1 || updateb ==1 || insertb == 1) checkSoDT();
			}
		});
		panel_DL1.add(textField_SoDT);
		textField_SoDT.setColumns(15);
		
		JPanel panel_DL2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_DL2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		verticalBox_1.add(panel_DL2);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9:            ");
		panel_DL2.add(lblaCh);
		
		textField_DiaChiDT = new JTextField();
		textField_DiaChiDT.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if(deleteb ==1 || updateb ==1 || insertb == 1) checkDiaChi();
			}
		});
		panel_DL2.add(textField_DiaChiDT);
		textField_DiaChiDT.setColumns(34);
		
		JLabel lblGhiCh = new JLabel("  Ghi ch\u00FA:          ");
		panel_DL2.add(lblGhiCh);
		
		textField_GhiChuDT = new JTextField();
		textField_GhiChuDT.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if(deleteb ==1 || updateb ==1 || insertb == 1) checkGhiChu();
			}
		});
		panel_DL2.add(textField_GhiChuDT);
		textField_GhiChuDT.setColumns(41);
		
		JPanel panel_TacVu = new JPanel();
		panel_TacVu.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T\u00E1c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		verticalBox.add(panel_TacVu);
		
		btnAdd = new JButton("Th\u00EAm");
		btnAdd.setActionCommand("Add");
		btnAdd.addActionListener(this);
		
		panel_TacVu.add(btnAdd);
		
		btnEdit = new JButton("S\u1EEDa");
		btnEdit.setActionCommand("Edit");
		btnEdit.addActionListener(this);
		panel_TacVu.add(btnEdit);
		
		btnDelete = new JButton("X\u00F3a");
		btnDelete.setActionCommand("Delete");
		btnDelete.addActionListener(this);
		panel_TacVu.add(btnDelete);
		
		JPanel panel_TimKiem = new JPanel();
		panel_TimKiem.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_TacVu.add(panel_TimKiem);
		
		final JFrame frame = new JFrame();
		//Vector<String> VectorKetQua = new Vector<String>();
		//VectorKetQua.add("abcchsjbcjsbjcbjsjcvscvjsvkcs");
		textfJSuggestField = new JSuggestField(frame);
		
		
		textfJSuggestField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				QLDoiTacProcess qlDoiTacPro = new QLDoiTacProcess();
				try {
					textfJSuggestField.setSuggestData(qlDoiTacPro.getSuggestData(textfJSuggestField.getText()));
					textfJSuggestField = new JSuggestField(frame,qlDoiTacPro.getSuggestData(textfJSuggestField.getText()));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		panel_TimKiem.add(textfJSuggestField);
		textfJSuggestField.setColumns(10);
		
		btnFind = new JButton("T\u00ECm ki\u1EBFm");
		panel_TimKiem.add(btnFind);
		btnFind.setActionCommand("Find");
		btnFind.addActionListener(this);
		
		btnSave = new JButton("L\u01B0u");
		btnSave.setActionCommand("Save");
		btnSave.addActionListener(this);
		panel_TacVu.add(btnSave);
		
		btnCancel = new JButton("H\u1EE7y");
		btnCancel.setActionCommand("Cancel");
		btnCancel.addActionListener(this);
		panel_TacVu.add(btnCancel);
		
		btnExport = new JButton("Xu\u1EA5t danh s\u00E1ch");
		btnExport.setActionCommand("Export");
		btnExport.addActionListener(this);
		panel_TacVu.add(btnExport);
		
		JPanel panel_DanhSach = new JPanel();
		panel_DanhSach.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch \u0111\u1ED1i t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		verticalBox.add(panel_DanhSach);
		panel_DanhSach.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(200,200));
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loadLuoiTable();
				
			}
		});
		model = (new DefaultTableModel(
				new Object[][] {
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						{null, null, null, null, null, null, null},
						
					},
					new String[] {
						"STT", "M\u00E3 \u0111\u1ED1i t\u00E1c", "T\u00EAn \u0111\u1ED1i t\u00E1c", "Ng\u01B0\u1EDDi li\u00EAn h\u1EC7", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Ghi ch\u00FA"
					}
				) {
					boolean[] columnEditables = new boolean[] {
						true, false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(6).setPreferredWidth(120);
		
		scrollPane.setViewportView(table);
		panel_DanhSach.add(scrollPane, BorderLayout.NORTH);
		//panel_DanhSach.add(table, BorderLayout.NORTH);
		JPanel panel_XemTrang = new JPanel();
		verticalBox.add(panel_XemTrang);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				box_SoTrang.setSelectedItem(soTrang-1);
			}
		});
		panel_XemTrang.add(btnBack);
		
		box_SoTrang = new JComboBox();
		box_SoTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(box_SoTrang.getSelectedItem());
				soTrang = (Integer) box_SoTrang.getSelectedItem();
			
				loaddata();
				box_SoTrang.setSelectedItem(soTrang);
				
			}
		});
		
		panel_XemTrang.add(box_SoTrang);
		
		btnNext = new JButton("Next");
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
		
		JLabel lblCreateBy = new JLabel("....................................");
		GridBagConstraints gbc_lblCreateBy = new GridBagConstraints();
		gbc_lblCreateBy.insets = new Insets(0, 0, 0, 5);
		gbc_lblCreateBy.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCreateBy.gridx = 0;
		gbc_lblCreateBy.gridy = 0;
		panel_2.add(lblCreateBy, gbc_lblCreateBy);
		
		textField_DiaChiDT.setEditable(false);
		textField_GhiChuDT.setEditable(false);
		textField_MaDT.setEditable(false);
		textField_NLH.setEditable(false);
		textField_SoDT.setEditable(false);
		textField_TenDT.setEditable(false);
		
		JPanel panel_Error = new JPanel();
		verticalBox_1.add(panel_Error);
		
		new ThongBao(lblThongBao, Color.RED, " ");
		panel_Error.add(lblThongBao);
		loaddata();
//		JFrame ad = new JFrame();
//		ad.add(panel_XemTrang);
//		ad.setVisible(true);
//		JOptionPane.showConfirmDialog(panel_DL1, "ko co j");
	}
	
	
	
	
	
	public void huy(){
		
		textField_DiaChiDT.setText("");
		textField_GhiChuDT.setText("");
		textField_MaDT.setText("");
		textField_NLH.setText("");
		textField_SoDT.setText("");
		textField_TenDT.setText("");
		
//		insertb = 0;
//		deleteb = 0;
//		updateb = 0;
	}

	
	public void export(){
		
		WriteExcel test = new WriteExcel();
		QLDoiTacProcess ql = new QLDoiTacProcess();
		Vector<Vector<String>> duLieu = new Vector<Vector<String>>();
		Vector<DoiTac> doiTac;
		try {
			doiTac = ql.getListDoiTac(1);
			for (int k = 0; k < doiTac.size(); k++) {
				Vector<String> phanTu = new Vector<String>();
				phanTu.add(doiTac.get(k).getsTenDoiTac());
				System.out.println(doiTac.get(k).getPK_sDoiTacID().toString());
				phanTu.add(doiTac.get(k).getPK_sDoiTacID().toString());
				phanTu.add(doiTac.get(k).getsSoDienThoai());
				phanTu.add(doiTac.get(k).getsDiaChi());
				phanTu.add(doiTac.get(k).getsNguoiLienHe());
				phanTu.add(doiTac.get(k).getsGhiChu());
				duLieu.add(phanTu);
			}
			test.write(8, 1, duLieu, "Temp.xls");
			System.out.println(doiTac.get(0).getClass().getCanonicalName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	

	
	public void openText() {
			textField_DiaChiDT.setEditable(true);
			textField_GhiChuDT.setEditable(true);
			textField_MaDT.setEditable(true);
			textField_NLH.setEditable(true);
			textField_SoDT.setEditable(true);
			textField_TenDT.setEditable(true);
		

	}
	public void closeText() {
			textField_DiaChiDT.setEditable(false);
			textField_GhiChuDT.setEditable(false);
			textField_MaDT.setEditable(false);
			textField_NLH.setEditable(false);
			textField_SoDT.setEditable(false);
			textField_TenDT.setEditable(false);
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
	
	
	
	
	
	public void loaddata() {
		try {
			
			Integer soDT;
		QLDoiTacProcess dtac = new QLDoiTacProcess();
		if (findb == 0) {
			soDT = dtac.getsoDoiTac();
			
		} else {
			findb = 0;
			soDT = dtac.getSoLuongKQ(textfJSuggestField.getText());
		}
			//System.out.println("dguvbdikbgkdbgkdkbgkdbkgdobgodogndolngkdngdogodngdgndkngkkdgnd "+soDT);
		if ((soDT % 10) == 0 ) {
			Combo((soDT / 10));
		}else Combo((soDT / 10)+1);
		
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		
		Vector<DoiTac> dsDoiTac;
		if (findb == 1) {
			dsDoiTac = dtac.getListSearched(soTrang,textfJSuggestField.getText());
		} else {
			dsDoiTac = dtac.getListDoiTac(soTrang);
		}
		sTT = (soTrang-1)*10+1;
		System.out.println("So thu tu: "+sTT);
		System.out.println("So trang: "+soTrang);
		System.out.println("So doi tac trong trang: "+dsDoiTac.size());
		for (int i = 0; i < dsDoiTac.size(); i++) {
			Object[] oPerson = {sTT,
								dsDoiTac.get(i).getPK_sDoiTacID(),
								dsDoiTac.get(i).getsTenDoiTac(),
								dsDoiTac.get(i).getsNguoiLienHe(),
								dsDoiTac.get(i).getsDiaChi(),
								dsDoiTac.get(i).getsSoDienThoai(),
								dsDoiTac.get(i).getsGhiChu()
								};
			sTT++;
			model.insertRow(i, oPerson);
		}
		model.fireTableDataChanged();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	public void loadLuoiTable(){
		 onClickTable = 1;
		 if (updateb == 1) {
			openText();
		}
		//int col = table.getSelectedColumn();  
		int row = table.getSelectedRow();  
		textField_MaDT.setText(((String)table.getModel().getValueAt(row, 1)));
		textField_TenDT.setText(((String)table.getModel().getValueAt(row, 2)));
		textField_NLH.setText(((String)table.getModel().getValueAt(row, 3)));
		textField_DiaChiDT.setText(((String)table.getModel().getValueAt(row, 4)));
		textField_SoDT.setText(((String)table.getModel().getValueAt(row, 5))); 
		textField_GhiChuDT.setText(((String)table.getModel().getValueAt(row, 6))); 
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
		try {
		QLDoiTacProcess dtac = new QLDoiTacProcess();
		if (dtac.checkPK(textField_MaDT.getText()) == true && insertb == 1 && loi == 0 && loiDiaChi == 0 && loiGhiChu == 0 && loiMaDT ==0 && loiNLH==0 && loiSDT==0 && loiTenDT ==0) {
			
				XuLiTen a = new XuLiTen();
//				CheckTen checkTen = new CheckTen();
				DoiTac doiTac = new DoiTac();

				//textField_MaDT.setText("Chuyen thanh: "+a.xuLiTen(textField_TenDT.getText()));
				doiTac.setiTrangThai(1);
				doiTac.setPK_sDoiTacID(textField_MaDT.getText());
				doiTac.setsDiaChi(textField_DiaChiDT.getText());
				doiTac.setsGhiChu(textField_GhiChuDT.getText());
				doiTac.setsNguoiLienHe(a.xuLiTen(textField_NLH.getText()));
				doiTac.setsSoDienThoai(textField_SoDT.getText());
				doiTac.setsTenDoiTac(a.xuLiTen(textField_TenDT.getText()));
				doiTac.setsTenDoiTacEng(TiengVietToEg.convert(textField_TenDT.getText()));
				
				Integer soDT = dtac.getsoDoiTac();
				boolean kiemTra = dtac.ThemDoiTac(doiTac);
				System.out.println(kiemTra);
				if (kiemTra==true) {
					
					
					System.out.println((soDT / 10));
					
					if ((soDT % 10) == 0 ) {
						Combo((soDT / 10));
						soTrang = (soDT / 10);
						
						loaddata();
						box_SoTrang.setSelectedItem(soTrang);
						
					}else 
					{	
						Combo((soDT / 10)+1);
						soTrang = (soDT / 10)+1;
						loaddata();
						box_SoTrang.setSelectedItem(soTrang);
					}
					new ThongBao(lblThongBao, Color.BLUE, "Insert ngon !!!");
				}
				
		} else {

			if (insertb == 1) {
				String error;
				error = "C\u00F3 l\u1ED7i x\u1EA3 ra : ";
				if (loiDiaChi == 1) {error = error+ "DC ,";}
				if (loiGhiChu == 1) {error = error+ "GC ,";}
				if (loiMaDT == 1) {error = error+ "MDT ,";}
				if (loiNLH == 1) {error = error+ "NLH ,";}
				if (loiSDT == 1) {error = error+ "SDT ,";}
				if (loiTenDT == 1) {error = error+ "TDT ,";}
				error = error+"kh\u00F4ng h\u1EE3p l\u1EC7";
				new ThongBao(lblThongBao, Color.RED, error);
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//insertb == 1 && loi == 0 && loiDiaChi == 0 && loiGhiChu == 0 && loiMaDT ==0 && loiNLH==0 && loiSDT==0 && loiTenDT ==0
	}

	
//tao themmnut xoa nhieu nguoi va tao mang cong don cac Ma muon xoa	
	public void delete(){
		QLDoiTacProcess dtac = new QLDoiTacProcess();
		if (deleteb == 1) {
			
			
			try {
				if (dtac.checkPK(textField_MaDT.getText())) {
					// khoa chinh ko trung
					new ThongBao(lblThongBao, Color.RED,"Kh\u00F4ng t\u1ED3n t\u1EA1i \u0111\u1ED1i t\u00E1c mu\u1ED1n x\u00F3a !");
				} else {
					
					if (JOptionPane.showConfirmDialog(new JFrame(),
					        "Do you want to delete "+textField_MaDT.getText()+" ?", "Delete",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					      
					 {
						dtac.XoaDoiTac((textField_MaDT.getText()));
						new ThongBao(lblThongBao, Color.BLUE,"Delete ngon !");
						Integer soDT = dtac.getsoDoiTac();
						if ((soDT % 10) == 0 ) {
							Combo((soDT / 10));
							soTrang = (soDT / 10);
							
							loaddata();
							box_SoTrang.setSelectedItem(soTrang);
							
						}else 
						{	
							Combo((soDT / 10)+1);
							soTrang = (soDT / 10)+1;
							loaddata();
							box_SoTrang.setSelectedItem(soTrang);
						}
					} else {

					}
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	public void update(){
		try {
			onClickTable = 0;
			for (int i = 0; i < 10; i++) {
				 if (table.isRowSelected(i)) {
					onClickTable = 1;
				}
			}
			
			if ((updateb == 1) && (onClickTable ==1)) {//quan trong
				checkMaDT();
			
			QLDoiTacProcess dtac = new QLDoiTacProcess();
			if (updateb == 1 && loi == 0 && loiDiaChi == 0 && loiGhiChu == 0 && loiMaDT ==0 && loiNLH==0 && loiSDT==0 && loiTenDT ==0) {
				
					XuLiTen a = new XuLiTen();
//					CheckTen checkTen = new CheckTen();
					DoiTac doiTac = new DoiTac();
					int row = table.getSelectedRow();  
					
					//textField_MaDT.setText("Chuyen thanh: "+a.xuLiTen(textField_TenDT.getText()));
					doiTac.setiTrangThai(1);
					doiTac.setPK_sDoiTacID(textField_MaDT.getText());
					doiTac.setsDiaChi(textField_DiaChiDT.getText());
					doiTac.setsGhiChu(textField_GhiChuDT.getText());
					doiTac.setsNguoiLienHe(a.xuLiTen(textField_NLH.getText()));
					doiTac.setsSoDienThoai(textField_SoDT.getText());
					doiTac.setsTenDoiTac(a.xuLiTen(textField_TenDT.getText()));
					doiTac.setsTenDoiTacEng(TiengVietToEg.convert(textField_TenDT.getText()));
					
					Integer soDT = dtac.getsoDoiTac();
					boolean kiemTra = dtac.SuaDoiTac(doiTac,(((String)table.getModel().getValueAt(row, 1))));
					System.out.println(kiemTra);
					if (kiemTra==true) {
						
						
//						System.out.println((soDT / 10));
						new ThongBao(lblThongBao, Color.BLUE, "Update ngon !!!");
						if ((soDT % 10) == 0 ) {
							Combo((soDT / 10));
							soTrang = (soDT / 10);
							
							loaddata();
							box_SoTrang.setSelectedItem(soTrang);
							
						}else 
						{	
							Combo((soDT / 10)+1);
							soTrang = (soDT / 10)+1;
							loaddata();
							box_SoTrang.setSelectedItem(soTrang);
						}
					}
					
			} else {
	
			}
			}else {
				
				if (updateb ==1) {
					if (JOptionPane.showConfirmDialog(new JFrame(),
					        "You must Click to table to Edit ?", "Edit",
					        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
					
				}      
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public void find(){
		
	}
	
	public void checkTen(){
		
		if (deleteb == 0) {
			loiTenDT = 0; 
			if ((CheckString.Onlytext(textField_TenDT.getText(), 45, 6))==false) {
				loiTenDT = 1;
				new ThongBao(lblThongBao, Color.RED,"K\u00FD t\u1EF1 nh\u1EADp v\u00E0o kh\u00F4ng " +
						"h\u1EE3p l\u1EC7 ho\u1EB7c \u0111\u1ED9 d\u00E0i kh\u00F4ng ph\u00F9 h\u1EE3p !");
			} else {
				loiTenDT = 0;
				new ThongBao(lblThongBao, Color.BLUE, "T\u00EAn \u0111\u1ED1i t\u00E1c: K\u00FD t\u1EF1 nh\u1EADp v\u00E0o h\u1EE3p l\u1EC7 !");
			}
		}
		
	}
	
	public void checkNLH(){
		
		if (deleteb == 0) {
			loiNLH = 0; 
			if ((CheckString.Onlytext(textField_NLH.getText(), 45, 6))==false) {
				loiNLH = 1;
				new ThongBao(lblThongBao, Color.RED,"K\u00FD t\u1EF1 nh\u1EADp v\u00E0o kh\u00F4ng " +
						"h\u1EE3p l\u1EC7 ho\u1EB7c \u0111\u1ED9 d\u00E0i kh\u00F4ng ph\u00F9 h\u1EE3p !");
			} else {
				loiNLH = 0;
				new ThongBao(lblThongBao, Color.BLUE, "Ng\u01B0\u1EDDi li\u00EAn h\u1EC7: K\u00FD t\u1EF1 nh\u1EADp v\u00E0o h\u1EE3p l\u1EC7 !");
			}
		}
		
	}

	public void checkSoDT(){
		
		if (deleteb == 0) {
			loiSDT = 0; 
			if ((CheckString.PhoneNumber(textField_SoDT.getText()))==false) {
				loiSDT = 1;
				new ThongBao(lblThongBao, Color.RED, "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:  kh\u00F4ng h\u1EE3p l\u1EC7 ! ");
			} else {
				loiSDT = 0;
				new ThongBao(lblThongBao, Color.BLUE, "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i: h\u1EE3p l\u1EC7 ! ");
			}
		}
		
	}

	public void checkDiaChi(){
		
		if (deleteb == 0) {
			loiDiaChi = 0; 
			if ((CheckString.Address(textField_DiaChiDT.getText(), 100, 6))==false) {
				loiDiaChi = 1;
				new ThongBao(lblThongBao, Color.RED, "\u0110\u1ECBa ch\u1EC9: K\u00FD t\u1EF1 nh\u1EADp v\u00E0o kh\u00F4ng h\u1EE3p l\u1EC7 !");
				
			} else {
				loiDiaChi = 0;
				new ThongBao(lblThongBao, Color.BLUE, "\u0110\u1ECBa ch\u1EC9: K\u00FD t\u1EF1 nh\u1EADp v\u00E0o h\u1EE3p l\u1EC7 !");
			}
		}
		
	}

	public void checkGhiChu(){
		
		if (deleteb == 0) {
			loiGhiChu = 0; 
			if ((CheckString.Address(textField_GhiChuDT.getText(), 100, 0))==false) {
				loiGhiChu = 1;
				new ThongBao(lblThongBao, Color.RED, "Ghi ch\u00FA: K\u00FD t\u1EF1 nh\u1EADp v\u00E0o kh\u00F4ng h\u1EE3p l\u1EC7 !");
			} else {
				loiGhiChu = 0;
				new ThongBao(lblThongBao, Color.BLUE, "Ghi ch\u00FA: K\u00FD t\u1EF1 nh\u1EADp v\u00E0o h\u1EE3p l\u1EC7 !");
			}
		}
		
	}

	public void checkMaDT(){
		
		loiMaDT = 0; 
		try {
		
		QLDoiTacProcess dtac = new QLDoiTacProcess();
//
//		System.out.println("------------------------------------------------------------------");
//		System.out.println(textField_MaDT.getText() +"\n"+ ((String)table.getModel().getValueAt(table.getSelectedRow(), 1)));
//		String st1 = textField_MaDT.getText();
//		String st2 = (String)table.getModel().getValueAt(table.getSelectedRow(), 1);
//		if (st1.equals(st2)) {
//			System.out.println(st1);
//			System.out.println(st2);
//		}
//		System.out.println( "\n");
//		System.out.println("------------------------------------------------------------------");
		if (updateb ==1) {
			if (textField_MaDT.getText().equals((String)table.getModel().getValueAt(table.getSelectedRow(), 1))) {
				if ((CheckString.OnlytextAndNumber(textField_MaDT.getText(), 6, 1, lblThongBao,"M\u00E3 \u0111\u1ED1i t\u00E1c: "))==false) {
					loiMaDT = 1;
					} else {
					loiMaDT = 0;
					new ThongBao(lblThongBao, Color.BLUE, "M\u00E3 \u0111\u1ED1i t\u00E1c: K\u00FD t\u1EF1 nh\u1EADp v\u00E0o h\u1EE3p l\u1EC7 !");
				}
			} else {

				if (dtac.checkPK(textField_MaDT.getText())==false){
					loiMaDT = 1; 
					new ThongBao(lblThongBao, Color.RED, "M\u00E3 \u0111\u1ED1i t\u00E1c kh\u00F4ng \u0111\u01B0\u1EE3c tr\u00F9ng");
					
				}
				else
				{
					if ((CheckString.OnlytextAndNumber(textField_MaDT.getText(), 6, 1, lblThongBao,"M\u00E3 \u0111\u1ED1i t\u00E1c: "))==false) {
						loiMaDT = 1;
						} else {
						loiMaDT = 0;
						new ThongBao(lblThongBao, Color.BLUE, "M\u00E3 \u0111\u1ED1i t\u00E1c: K\u00FD t\u1EF1 nh\u1EADp v\u00E0o h\u1EE3p l\u1EC7 !");
					}
				}
			}
		}
		if ((updateb ==0) && (deleteb == 0)) {
			if (dtac.checkPK(textField_MaDT.getText())==false){
				loiMaDT = 1; 
				new ThongBao(lblThongBao, Color.RED, "M\u00E3 \u0111\u1ED1i t\u00E1c kh\u00F4ng \u0111\u01B0\u1EE3c tr\u00F9ng");
				
			}
			else
			{
				if ((CheckString.OnlytextAndNumber(textField_MaDT.getText(), 6, 1, lblThongBao,"M\u00E3 \u0111\u1ED1i t\u00E1c: "))==false) {
					loiMaDT = 1;
					} else {
					loiMaDT = 0;
					new ThongBao(lblThongBao, Color.BLUE, "M\u00E3 \u0111\u1ED1i t\u00E1c: K\u00FD t\u1EF1 nh\u1EADp v\u00E0o h\u1EE3p l\u1EC7 !");
				}
			}
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		btnThm.setText("Th\u00EAm");
//		btnThm.hide();
//		btnThm.show();
		if (e.getActionCommand().equals("Add")) {
			if (insertb == 1) {
				insertb = 0;
				//btnAdd.setText("Th\u00EAm");
				btnEdit.setEnabled(true);
				btnDelete.setEnabled(true);
				btnFind.setEnabled(true);
				closeText();
			} else {
				insertb = 1;
				updateb = 0;
				deleteb = 0;

				//btnAdd.setText("V\u1EC1 ch\u1ECDn t\u00E1c v\u1EE5 kh\u00E1c");
				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				btnFind.setEnabled(false);
				openText();
			}
		}
		if (e.getActionCommand().equals("Edit")) {
			if (updateb == 1) {
				updateb = 0;
				btnAdd.setEnabled(true);
//				btnEdit.setEnabled(true);
				btnDelete.setEnabled(true);
				btnFind.setEnabled(true);
				closeText();

			} else {
				insertb = 0;
				updateb = 1;
				deleteb = 0;

				btnAdd.setEnabled(false);
//				btnEdit.setEnabled(false);
				btnDelete.setEnabled(false);
				btnFind.setEnabled(false);
//				btnThm.hide();
//				btnSa.setText("V\u1EC1 ch\u1ECDn t\u00E1c v\u1EE5 kh\u00E1c");
//				btnXa.hide();
//				btnTmKim.hide();
//				openText();
				closeText();
				new ThongBao(lblThongBao, Color.RED, "Click chu\u1ED9t v\u00E0o \u0111\u1ED1i t\u01B0\u1EE3ng mu\u1ED1n s\u1EEDa trong b\u1EA3ng !");
				
				if (onClickTable == 1) {
					openText();
				}
				
				
			}
		}
		if (e.getActionCommand().equals("Delete")) {
			if (deleteb == 1) {
				deleteb = 0;
				btnAdd.setEnabled(true);
				btnEdit.setEnabled(true);
//				btnDelete.setEnabled(true);
				btnFind.setEnabled(true);
//				btnThm.show();
//				btnSa.show();
//				btnXa.setText("X\u00F3a");
//				btnTmKim.show();
				closeText();
			} else {
				deleteb = 1;
				insertb = 0;
				updateb = 0;
				btnAdd.setEnabled(false);
				btnEdit.setEnabled(false);
//				btnDelete.setEnabled(false);
				btnFind.setEnabled(false);
//				btnThm.hide();
//				btnSa.hide();
//				btnXa.setText("V\u1EC1 ch\u1ECDn t\u00E1c v\u1EE5 kh\u00E1c");
//				btnTmKim.hide();
//				textField_DiaChiDT.setEditable(true);
//				textField_GhiChuDT.setEditable(true);
				textField_MaDT.setEditable(true);
//				textField_NLH.setEditable(true);
//				textField_SoDT.setEditable(true);
				textField_TenDT.setEditable(true);
				new ThongBao(lblThongBao, Color.RED, "Click vao doi tuong muon xoa trong bang !!!");
			}
		}
		if (e.getActionCommand().equals("Find")) {
			QLDoiTacProcess a = new QLDoiTacProcess();
			Integer soDT;
			try {
				soDT = a.getSoLuongKQ(textfJSuggestField.getText());
			
			if ((soDT % 10) == 0 ) {
				Combo((soDT / 10));
				soTrang = (soDT / 10);
				
				loaddata();
				box_SoTrang.setSelectedItem(soTrang);
				
			}else 
			{	
				Combo((soDT / 10)+1);
				soTrang = (soDT / 10)+1;
				loaddata();
				box_SoTrang.setSelectedItem(soTrang);
			}
			findb =1;
			loaddata();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getActionCommand().equals("Save")) {
			insert();
			delete();
			update();
			find();
		}
		
		if (e.getActionCommand().equals("Cancel")) {
			huy();
		}

		if (e.getActionCommand().equals("Export")) {
			export();
		}
		
	}

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		installLnF();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiNhanVien frame = new QuanLiNhanVien();
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
