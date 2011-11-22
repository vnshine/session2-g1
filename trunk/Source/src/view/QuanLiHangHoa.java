package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
import javax.swing.table.DefaultTableModel;

import main.HangHoa;
import myobject.DonViTinh;
import myobject.NhaSanXuat;
import myobject.NhomHang;
import process.QLHangHoaProcess;
import validate.CheckString;
import ch.rakudave.suggest.JSuggestField;

public class QuanLiHangHoa extends JInternalFrame implements ActionListener {

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private JTextField textField_ID;
	private JTextField textField_TenHang;
	private JTextField textField_GiaBanB;
	private JSuggestField comboBox_NhomHang,comboBox_DonViTInh,comboBox_NSX;
	private JButton btnThoi,btnLuu,btnThem,btnSua,btnXoa,btnTimKiem,btnKtXutExcel;
	private JPanel panel_TacVu;
	private Integer iThem = 0;
	private String err = null;
	private JTable table;
	private Integer loi,numItems,sTT;
	private JTextField textField_6;
	private QLHangHoaProcess QLHangHoaProcess = new QLHangHoaProcess();
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JCheckBox checkBox_4;
	private Vector<String> tenNhomH,tenNSX,tenDonViTinh;
	private Vector<NhomHang> a;
	private Vector<NhaSanXuat> c;
	private Vector<DonViTinh> b;
	private Vector<HangHoa> danhSach;
	private Integer soLuongNH;
	private DefaultTableModel model;
	private JButton btnThmHngHa;
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
	public static void main(String[] args) {
		installLnF();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiHangHoa frame = new QuanLiHangHoa();
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
	public QuanLiHangHoa() throws Exception {
		setFrameIcon(new ImageIcon("media/images/hanghoa -icon.png"));
		setTitle("Quản lý hàng hóa");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_DuLieu = new JPanel();
		panel_DuLieu.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
			}
		});
		panel_DuLieu.setBorder(new TitledBorder(null, "D\u1EEF li\u1EC7u", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_DuLieu, BorderLayout.NORTH);
		GridBagLayout gbl_panel_DuLieu = new GridBagLayout();
		gbl_panel_DuLieu.columnWidths = new int[]{0, 100, 100, 100, 0, 100, 0, 0};
		gbl_panel_DuLieu.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_DuLieu.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_DuLieu.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_DuLieu.setLayout(gbl_panel_DuLieu);
		
		checkBox_4 = new JCheckBox("");
		checkBox_4.setEnabled(false);
		GridBagConstraints gbc_checkBox_4 = new GridBagConstraints();
		gbc_checkBox_4.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_4.gridx = 0;
		gbc_checkBox_4.gridy = 0;
		panel_DuLieu.add(checkBox_4, gbc_checkBox_4);
		
		JLabel lblId = new JLabel("ID: ");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 0;
		panel_DuLieu.add(lblId, gbc_lblId);
		
		textField_ID = new JTextField();
		textField_ID.setEnabled(false);
		textField_ID.setEditable(false);
		GridBagConstraints gbc_textField_ID = new GridBagConstraints();
		gbc_textField_ID.gridwidth = 5;
		gbc_textField_ID.insets = new Insets(0, 0, 5, 0);
		gbc_textField_ID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_ID.gridx = 2;
		gbc_textField_ID.gridy = 0;
		panel_DuLieu.add(textField_ID, gbc_textField_ID);
		textField_ID.setColumns(10);
		
		chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setEnabled(false);
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 1;
		panel_DuLieu.add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JLabel lblTnHng = new JLabel("Tên hàng: ");
		GridBagConstraints gbc_lblTnHng = new GridBagConstraints();
		gbc_lblTnHng.anchor = GridBagConstraints.EAST;
		gbc_lblTnHng.insets = new Insets(0, 0, 5, 5);
		gbc_lblTnHng.gridx = 1;
		gbc_lblTnHng.gridy = 1;
		panel_DuLieu.add(lblTnHng, gbc_lblTnHng);
		
		textField_TenHang = new JTextField();
		textField_TenHang.setEnabled(false);
		GridBagConstraints gbc_textField_TenHang = new GridBagConstraints();
		gbc_textField_TenHang.gridwidth = 5;
		gbc_textField_TenHang.insets = new Insets(0, 0, 5, 0);
		gbc_textField_TenHang.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_TenHang.gridx = 2;
		gbc_textField_TenHang.gridy = 1;
		panel_DuLieu.add(textField_TenHang, gbc_textField_TenHang);
		textField_TenHang.setColumns(10);
		
		checkBox = new JCheckBox("");
		checkBox.setEnabled(false);
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox.gridx = 0;
		gbc_checkBox.gridy = 2;
		panel_DuLieu.add(checkBox, gbc_checkBox);
		
		JLabel lblNhmHng = new JLabel("Nhóm Hàng: ");
		GridBagConstraints gbc_lblNhmHng = new GridBagConstraints();
		gbc_lblNhmHng.anchor = GridBagConstraints.EAST;
		gbc_lblNhmHng.insets = new Insets(0, 0, 5, 5);
		gbc_lblNhmHng.gridx = 1;
		gbc_lblNhmHng.gridy = 2;
		panel_DuLieu.add(lblNhmHng, gbc_lblNhmHng);
		
		tenNhomH = new Vector<String>();
		a = QLHangHoaProcess.getListNhomHang();
		for (int i = 0; i < QLHangHoaProcess.getListNhomHang().size(); i++) {
			tenNhomH.add(a.get(i).getsTenNhomHang());
		}
		comboBox_NhomHang = new JSuggestField(new Frame(), tenNhomH);
		//JTextComponent editor = (JTextComponent) comboBox_NhomHang.getEditor().getEditorComponent();
		comboBox_NhomHang.setEnabled(false);
		
		GridBagConstraints gbc_comboBox_NhomHang = new GridBagConstraints();
		gbc_comboBox_NhomHang.gridwidth = 5;
		gbc_comboBox_NhomHang.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_NhomHang.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_NhomHang.gridx = 2;
		gbc_comboBox_NhomHang.gridy = 2;
		panel_DuLieu.add(comboBox_NhomHang, gbc_comboBox_NhomHang);
		
		checkBox_1 = new JCheckBox("");
		checkBox_1.setEnabled(false);
		GridBagConstraints gbc_checkBox_1 = new GridBagConstraints();
		gbc_checkBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_1.gridx = 0;
		gbc_checkBox_1.gridy = 3;
		panel_DuLieu.add(checkBox_1, gbc_checkBox_1);
		
		JLabel lblNhSnXut = new JLabel("Nhà sản xuất: ");
		GridBagConstraints gbc_lblNhSnXut = new GridBagConstraints();
		gbc_lblNhSnXut.anchor = GridBagConstraints.EAST;
		gbc_lblNhSnXut.insets = new Insets(0, 0, 5, 5);
		gbc_lblNhSnXut.gridx = 1;
		gbc_lblNhSnXut.gridy = 3;
		panel_DuLieu.add(lblNhSnXut, gbc_lblNhSnXut);
		
		
		c = QLHangHoaProcess.getListNhaSanXuat();
		tenNSX = new  Vector<String>();
		for (int i = 0; i < QLHangHoaProcess.getListNhaSanXuat().size(); i++) {
			tenNSX.add(c.get(i).getsTenNhaSanXuat());
		}
		
		comboBox_NSX = new JSuggestField(new Frame(),tenNSX);
		comboBox_NSX.setEnabled(false);
		GridBagConstraints gbc_comboBox_NSX = new GridBagConstraints();
		gbc_comboBox_NSX.gridwidth = 5;
		gbc_comboBox_NSX.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_NSX.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_NSX.gridx = 2;
		gbc_comboBox_NSX.gridy = 3;
		panel_DuLieu.add(comboBox_NSX, gbc_comboBox_NSX);
		
		checkBox_2 = new JCheckBox("");
		checkBox_2.setEnabled(false);
		GridBagConstraints gbc_checkBox_2 = new GridBagConstraints();
		gbc_checkBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_2.gridx = 0;
		gbc_checkBox_2.gridy = 4;
		panel_DuLieu.add(checkBox_2, gbc_checkBox_2);
		
		JLabel lblnVTnh = new JLabel("Đơn vị tính: ");
		GridBagConstraints gbc_lblnVTnh = new GridBagConstraints();
		gbc_lblnVTnh.anchor = GridBagConstraints.EAST;
		gbc_lblnVTnh.insets = new Insets(0, 0, 5, 5);
		gbc_lblnVTnh.gridx = 1;
		gbc_lblnVTnh.gridy = 4;
		panel_DuLieu.add(lblnVTnh, gbc_lblnVTnh);
		
		b = QLHangHoaProcess.getListDonViTinh();
		tenDonViTinh = new  Vector<String>();
		for (int i = 0; i < QLHangHoaProcess.getListNhaSanXuat().size(); i++) {
			tenDonViTinh.add(b.get(i).getsTenDonViTinh());
		}
		comboBox_DonViTInh = new JSuggestField(new Frame(),tenDonViTinh);
		comboBox_DonViTInh.setEnabled(false);
		GridBagConstraints gbc_comboBox_DonViTInh = new GridBagConstraints();
		gbc_comboBox_DonViTInh.gridwidth = 5;
		gbc_comboBox_DonViTInh.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_DonViTInh.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_DonViTInh.gridx = 2;
		gbc_comboBox_DonViTInh.gridy = 4;
		panel_DuLieu.add(comboBox_DonViTInh, gbc_comboBox_DonViTInh);
		
		checkBox_3 = new JCheckBox("");
		checkBox_3.setEnabled(false);
		GridBagConstraints gbc_checkBox_3 = new GridBagConstraints();
		gbc_checkBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox_3.gridx = 0;
		gbc_checkBox_3.gridy = 5;
		panel_DuLieu.add(checkBox_3, gbc_checkBox_3);
		
		
		
		JLabel lblGiBnBun = new JLabel("Đơn giá : ");
		GridBagConstraints gbc_lblGiBnBun = new GridBagConstraints();
		gbc_lblGiBnBun.anchor = GridBagConstraints.EAST;
		gbc_lblGiBnBun.insets = new Insets(0, 0, 5, 5);
		gbc_lblGiBnBun.gridx = 1;
		gbc_lblGiBnBun.gridy = 5;
		panel_DuLieu.add(lblGiBnBun, gbc_lblGiBnBun);
		
		textField_GiaBanB = new JTextField();
		textField_GiaBanB.setEnabled(false);
		GridBagConstraints gbc_textField_GiaBanB = new GridBagConstraints();
		gbc_textField_GiaBanB.gridwidth = 5;
		gbc_textField_GiaBanB.insets = new Insets(0, 0, 5, 0);
		gbc_textField_GiaBanB.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_GiaBanB.gridx = 2;
		gbc_textField_GiaBanB.gridy = 5;
		panel_DuLieu.add(textField_GiaBanB, gbc_textField_GiaBanB);
		textField_GiaBanB.setColumns(10);
		
		panel_TacVu = new JPanel();
		panel_TacVu.setBorder(new TitledBorder(null, "T\u00E1c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_TacVu = new GridBagConstraints();
		gbc_panel_TacVu.fill = GridBagConstraints.BOTH;
		gbc_panel_TacVu.gridwidth = 7;
		gbc_panel_TacVu.gridx = 0;
		gbc_panel_TacVu.gridy = 7;
		panel_DuLieu.add(panel_TacVu, gbc_panel_TacVu);
		panel_TacVu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				them();
			}
		});
		btnThem.setIcon(new ImageIcon("media/images/add.png"));
		panel_TacVu.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					QuanLiHangHoa_Edit QuanLiHangHoa_Edit = new QuanLiHangHoa_Edit();
					QuanLiHangHoa_Edit.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSua.setIcon(new ImageIcon("media/images/Edit.png"));
		panel_TacVu.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("media/images/delete.png"));
		panel_TacVu.add(btnXoa);
		
		btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					luu();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		panel_TacVu.add(btnLuu);
		btnLuu.setIcon(new ImageIcon("media/images/Save.png"));
		btnLuu.setEnabled(false);
		
		
		btnThoi = new JButton("Thôi");
		btnThoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				thoi();
			}
		});
		panel_TacVu.add(btnThoi);
		btnThoi.setIcon(new ImageIcon("media/images/cancel.png"));
		btnThoi.setEnabled(false);
		
		JPanel panel_TimKiem = new JPanel();
		panel_TimKiem.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "T\u00ECm ki\u1EBFm", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_TacVu.add(panel_TimKiem);
		
		textField_6 = new JTextField();
		panel_TimKiem.add(textField_6);
		textField_6.setColumns(10);
		
		btnTimKiem = new JButton("");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnTimKiem.setIcon(new ImageIcon("media/images/search-icon.png"));
		panel_TimKiem.add(btnTimKiem);
		
		btnKtXutExcel = new JButton("Kết xuất Excel");
		btnKtXutExcel.setIcon(new ImageIcon("media/images/excel.png"));
		panel_TacVu.add(btnKtXutExcel);
		
		btnThmHngHa = new JButton("Thêm hàng hóa từ file Excel");
		btnThmHngHa.setIcon(new ImageIcon("media/images/excel.png"));
		panel_TacVu.add(btnThmHngHa);
		
		JPanel panel_DanhSach = new JPanel();
		panel_DanhSach.setBorder(new TitledBorder(null, "Danh S\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_DanhSach, BorderLayout.CENTER);
		
		
		table = new JTable();
		
		model =	new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"", "STT", "T\u00EAn m\u1EB7t h\u00E0ng", "Nh\u00F3m H\u00E0ng", "Nh\u00E0 s\u1EA3n xu\u1EA5t", "\u0110\u01A1n v\u1ECB t\u00EDnh", "\u0110\u01A1n gi\u00E1", "S\u1ED1 l\u01B0\u1EE3ng"
				}
			) {
				Class[] columnTypes = new Class[] {
					Boolean.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					true, false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		table.setModel(model);
		table.getColumnModel().getColumn(0).setMinWidth(75);
		table.getColumnModel().getColumn(1).setMinWidth(75);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setMinWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setMinWidth(250);
		table.getColumnModel().getColumn(4).setPreferredWidth(250);
		table.getColumnModel().getColumn(4).setMinWidth(250);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setMinWidth(100);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
		table.getColumnModel().getColumn(7).setMinWidth(100);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		panel_DanhSach.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel_DanhSach.add(scrollPane);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JPanel panel_NhanVien = new JPanel();
		getContentPane().add(panel_NhanVien, BorderLayout.SOUTH);
		
		JButton button = new JButton("");
		
		button.setIcon(new ImageIcon("media/images/prev.png"));
		panel_NhanVien.add(button);
		
		JComboBox comboBox = new JComboBox();
		panel_NhanVien.add(comboBox);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("media/images/next.png"));
		panel_NhanVien.add(button_1);
		//comboNhomHang();
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub	
	}
	public void thoi() {
		if (iThem == 1) {
			btnLuu.setEnabled(false);
			btnThoi.setEnabled(false);
			btnSua.setEnabled(true);
			btnXoa.setEnabled(true);
			btnTimKiem.setEnabled(true);
			btnKtXutExcel.setEnabled(true);
			setDisibleDuLieu();
			textField_6.setText("");
			textField_GiaBanB.setText("");
			textField_ID.setText("");
			textField_TenHang.setText("");
		}
	}
	public void them() {
		iThem = 1;
		
		btnLuu.setEnabled(true);
		btnThoi.setEnabled(true);
		btnSua.setEnabled(false);
		btnXoa.setEnabled(false);
		btnTimKiem.setEnabled(false);
		btnKtXutExcel.setEnabled(false);
		setEnableDuLieu();
	}
	public void setEnableDuLieu() {
		textField_TenHang.setEnabled(true);
		textField_GiaBanB.setEnabled(true);
		comboBox_NhomHang.setEnabled(true);
		comboBox_DonViTInh.setEnabled(true);
		comboBox_NSX.setEnabled(true);
	}
	public void setDisibleDuLieu() {
		textField_TenHang.setEnabled(false);
		textField_GiaBanB.setEnabled(false);
		comboBox_NhomHang.setEnabled(false);
		comboBox_DonViTInh.setEnabled(false);
		comboBox_NSX.setEnabled(false);
		
	}

	public void check() throws Exception {
		loi = 0;
		err = "";
		if (CheckString.Address(textField_TenHang.getText(), 100, 4))  {
			
		}else {
			loi = 1;
			err = err+"Tên Hàng không đúng kiểu hoặc độ dài không phù hợp\n";
		}
		if (QLHangHoaProcess.checkTenHangHoa(textField_TenHang.getText())) {
			
		}else {
			loi = 1;
			err = err+"Tên Hàng không được trùng tên hàng đã có\n";
		}
//		if (CheckString.Floatnumber(textField_GiaMua.getText()) 
//				&& CheckString.Floatnumber(textField_GiaBanB.getText()) 
//				&& CheckString.Floatnumber(textField_GiaBanLe.getText() )){	
//		}else {
//			loi = 1;
//			err = err+"Giá hoặc VAT nhập vào không đúng định dạng số\n";
//		}
		
	}

	public void luu() throws Exception {
		check();
		if (loi == 0) {
			JOptionPane.showMessageDialog(new JFrame(), "Dữ liệu nhập Thành công !", "Thành công", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(this, "Lỗi dữ liệu nhập vào !\n"+err, "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}
}
