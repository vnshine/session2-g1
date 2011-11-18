package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;

import ch.rakudave.suggest.JSuggestField;

import com.toedter.calendar.JDateChooser;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

import myobject.NhomHang;

import process.QLHangHoaProcess;
import process.QLNhomHangProcess;

import validate.CheckString;
import java.awt.Color;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class QuanLiHangHoa extends JInternalFrame implements ActionListener {

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private JTextField textField_ID;
	private JTextField textField_TenHang;
	private JTextField textField_GiaMua;
	private JTextField textField_GiaBanB;
	private JTextField textField_GiaBanLe;
	private JComboBox comboBox_DoiTac,comboBox_DonViTInh,comboBox_NSX;
	private JComboBox comboBox_NhomHang;
	private JDateChooser dateChooser_NgayHetHan,dateChooser_NgayNhap;
	private JButton btnThoi,btnLuu,btnThem,btnSua,btnXoa,btnTimKiem,btnKtXutExcel;
	private JPanel panel_TacVu;
	private Integer iThem = 0;
	private String err = null;
	private JTable table;
	private Integer loi,numItems;
	private JTextField textField_6;
	private QLHangHoaProcess QLHangHoaProcess = new QLHangHoaProcess();
	private JButton btniTc;
	private JTextField textField;
	private JTextField textField_1;
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
		setFrameIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\hanghoa -icon.png"));
		setTitle("Quản lý hàng hóa");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_DuLieu = new JPanel();
		panel_DuLieu.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				comboNhomHang();
			}
		});
		panel_DuLieu.setBorder(new TitledBorder(null, "D\u1EEF li\u1EC7u", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_DuLieu, BorderLayout.NORTH);
		GridBagLayout gbl_panel_DuLieu = new GridBagLayout();
		gbl_panel_DuLieu.columnWidths = new int[]{0, 100, 100, 100, 0, 100, 100, 0, 0};
		gbl_panel_DuLieu.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_DuLieu.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_DuLieu.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_DuLieu.setLayout(gbl_panel_DuLieu);
		
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
		gbc_textField_ID.insets = new Insets(0, 0, 5, 5);
		gbc_textField_ID.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_ID.gridx = 2;
		gbc_textField_ID.gridy = 0;
		panel_DuLieu.add(textField_ID, gbc_textField_ID);
		textField_ID.setColumns(10);
		
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
		gbc_textField_TenHang.gridwidth = 6;
		gbc_textField_TenHang.insets = new Insets(0, 0, 5, 0);
		gbc_textField_TenHang.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_TenHang.gridx = 2;
		gbc_textField_TenHang.gridy = 1;
		panel_DuLieu.add(textField_TenHang, gbc_textField_TenHang);
		textField_TenHang.setColumns(10);
		
		JLabel lblNhmHng = new JLabel("Nhóm Hàng: ");
		GridBagConstraints gbc_lblNhmHng = new GridBagConstraints();
		gbc_lblNhmHng.anchor = GridBagConstraints.EAST;
		gbc_lblNhmHng.insets = new Insets(0, 0, 5, 5);
		gbc_lblNhmHng.gridx = 1;
		gbc_lblNhmHng.gridy = 2;
		panel_DuLieu.add(lblNhmHng, gbc_lblNhmHng);
		comboBox_NhomHang = new JComboBox();
		//JTextComponent editor = (JTextComponent) comboBox_NhomHang.getEditor().getEditorComponent();
		comboBox_NhomHang.setEnabled(false);
		
		GridBagConstraints gbc_comboBox_NhomHang = new GridBagConstraints();
		gbc_comboBox_NhomHang.gridwidth = 2;
		gbc_comboBox_NhomHang.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_NhomHang.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_NhomHang.gridx = 2;
		gbc_comboBox_NhomHang.gridy = 2;
		panel_DuLieu.add(comboBox_NhomHang, gbc_comboBox_NhomHang);
		
		textField = new JTextField();
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 2;
		panel_DuLieu.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblnVTnh = new JLabel("Đơn vị tính: ");
		GridBagConstraints gbc_lblnVTnh = new GridBagConstraints();
		gbc_lblnVTnh.anchor = GridBagConstraints.EAST;
		gbc_lblnVTnh.insets = new Insets(0, 0, 5, 5);
		gbc_lblnVTnh.gridx = 5;
		gbc_lblnVTnh.gridy = 2;
		panel_DuLieu.add(lblnVTnh, gbc_lblnVTnh);
		
		comboBox_DonViTInh = new JComboBox();
		comboBox_DonViTInh.setEnabled(false);
		comboBox_DonViTInh.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
		GridBagConstraints gbc_comboBox_DonViTInh = new GridBagConstraints();
		gbc_comboBox_DonViTInh.gridwidth = 2;
		gbc_comboBox_DonViTInh.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_DonViTInh.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_DonViTInh.gridx = 6;
		gbc_comboBox_DonViTInh.gridy = 2;
		panel_DuLieu.add(comboBox_DonViTInh, gbc_comboBox_DonViTInh);
		
		JLabel lbliTc = new JLabel("Đối tác: ");
		GridBagConstraints gbc_lbliTc = new GridBagConstraints();
		gbc_lbliTc.anchor = GridBagConstraints.EAST;
		gbc_lbliTc.insets = new Insets(0, 0, 5, 5);
		gbc_lbliTc.gridx = 1;
		gbc_lbliTc.gridy = 3;
		panel_DuLieu.add(lbliTc, gbc_lbliTc);
		
		comboBox_DoiTac = new JComboBox();
		comboBox_DoiTac.setEnabled(false);
		comboBox_DoiTac.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
		GridBagConstraints gbc_comboBox_DoiTac = new GridBagConstraints();
		gbc_comboBox_DoiTac.gridwidth = 2;
		gbc_comboBox_DoiTac.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_DoiTac.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_DoiTac.gridx = 2;
		gbc_comboBox_DoiTac.gridy = 3;
		panel_DuLieu.add(comboBox_DoiTac, gbc_comboBox_DoiTac);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 3;
		panel_DuLieu.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNhSnXut = new JLabel("Nhà sản xuất: ");
		GridBagConstraints gbc_lblNhSnXut = new GridBagConstraints();
		gbc_lblNhSnXut.anchor = GridBagConstraints.EAST;
		gbc_lblNhSnXut.insets = new Insets(0, 0, 5, 5);
		gbc_lblNhSnXut.gridx = 5;
		gbc_lblNhSnXut.gridy = 3;
		panel_DuLieu.add(lblNhSnXut, gbc_lblNhSnXut);
		
		comboBox_NSX = new JComboBox();
		comboBox_NSX.setEnabled(false);
		comboBox_NSX.setModel(new DefaultComboBoxModel(new String[] {"Chọn"}));
		GridBagConstraints gbc_comboBox_NSX = new GridBagConstraints();
		gbc_comboBox_NSX.gridwidth = 2;
		gbc_comboBox_NSX.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_NSX.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_NSX.gridx = 6;
		gbc_comboBox_NSX.gridy = 3;
		panel_DuLieu.add(comboBox_NSX, gbc_comboBox_NSX);
		
		btniTc = new JButton("Thêm đối tác mới nếu chưa có trong danh sách");
		btniTc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btniTc.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\arrow_down.png"));
		GridBagConstraints gbc_btniTc = new GridBagConstraints();
		gbc_btniTc.insets = new Insets(0, 0, 5, 5);
		gbc_btniTc.gridx = 2;
		gbc_btniTc.gridy = 4;
		panel_DuLieu.add(btniTc, gbc_btniTc);
		
		JLabel lblGiBnBun = new JLabel("Giá Bán buôn: ");
		GridBagConstraints gbc_lblGiBnBun = new GridBagConstraints();
		gbc_lblGiBnBun.anchor = GridBagConstraints.EAST;
		gbc_lblGiBnBun.insets = new Insets(0, 0, 5, 5);
		gbc_lblGiBnBun.gridx = 3;
		gbc_lblGiBnBun.gridy = 4;
		panel_DuLieu.add(lblGiBnBun, gbc_lblGiBnBun);
		
		textField_GiaBanB = new JTextField();
		textField_GiaBanB.setEnabled(false);
		GridBagConstraints gbc_textField_GiaBanB = new GridBagConstraints();
		gbc_textField_GiaBanB.gridwidth = 2;
		gbc_textField_GiaBanB.insets = new Insets(0, 0, 5, 5);
		gbc_textField_GiaBanB.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_GiaBanB.gridx = 4;
		gbc_textField_GiaBanB.gridy = 4;
		panel_DuLieu.add(textField_GiaBanB, gbc_textField_GiaBanB);
		textField_GiaBanB.setColumns(10);
		
		JLabel lblGiBnL = new JLabel("Giá Bán lẻ:");
		GridBagConstraints gbc_lblGiBnL = new GridBagConstraints();
		gbc_lblGiBnL.anchor = GridBagConstraints.EAST;
		gbc_lblGiBnL.insets = new Insets(0, 0, 5, 5);
		gbc_lblGiBnL.gridx = 6;
		gbc_lblGiBnL.gridy = 4;
		panel_DuLieu.add(lblGiBnL, gbc_lblGiBnL);
		
		textField_GiaBanLe = new JTextField();
		textField_GiaBanLe.setEnabled(false);
		GridBagConstraints gbc_textField_GiaBanLe = new GridBagConstraints();
		gbc_textField_GiaBanLe.insets = new Insets(0, 0, 5, 0);
		gbc_textField_GiaBanLe.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_GiaBanLe.gridx = 7;
		gbc_textField_GiaBanLe.gridy = 4;
		panel_DuLieu.add(textField_GiaBanLe, gbc_textField_GiaBanLe);
		textField_GiaBanLe.setColumns(10);
		
		JLabel lblNgyNhp = new JLabel("Ngày Nhập: ");
		GridBagConstraints gbc_lblNgyNhp = new GridBagConstraints();
		gbc_lblNgyNhp.anchor = GridBagConstraints.EAST;
		gbc_lblNgyNhp.insets = new Insets(0, 0, 5, 5);
		gbc_lblNgyNhp.gridx = 1;
		gbc_lblNgyNhp.gridy = 5;
		panel_DuLieu.add(lblNgyNhp, gbc_lblNgyNhp);
		
		dateChooser_NgayNhap = new JDateChooser();
		GridBagConstraints gbc_dateChooser_NgayNhap = new GridBagConstraints();
		gbc_dateChooser_NgayNhap.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_NgayNhap.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_NgayNhap.gridx = 2;
		gbc_dateChooser_NgayNhap.gridy = 5;
		panel_DuLieu.add(dateChooser_NgayNhap, gbc_dateChooser_NgayNhap);
		dateChooser_NgayNhap.setEnabled(false);
		
		JLabel lblNgyHtHn = new JLabel("Ngày hết hạn: ");
		GridBagConstraints gbc_lblNgyHtHn = new GridBagConstraints();
		gbc_lblNgyHtHn.anchor = GridBagConstraints.EAST;
		gbc_lblNgyHtHn.insets = new Insets(0, 0, 5, 5);
		gbc_lblNgyHtHn.gridx = 3;
		gbc_lblNgyHtHn.gridy = 5;
		panel_DuLieu.add(lblNgyHtHn, gbc_lblNgyHtHn);
		
		dateChooser_NgayHetHan = new JDateChooser();
		GridBagConstraints gbc_dateChooser_NgayHetHan = new GridBagConstraints();
		gbc_dateChooser_NgayHetHan.gridwidth = 2;
		gbc_dateChooser_NgayHetHan.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_NgayHetHan.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_NgayHetHan.gridx = 4;
		gbc_dateChooser_NgayHetHan.gridy = 5;
		panel_DuLieu.add(dateChooser_NgayHetHan, gbc_dateChooser_NgayHetHan);
		dateChooser_NgayHetHan.setEnabled(false);
		
		JLabel lblGiMua = new JLabel("Giá Mua: ");
		GridBagConstraints gbc_lblGiMua = new GridBagConstraints();
		gbc_lblGiMua.anchor = GridBagConstraints.EAST;
		gbc_lblGiMua.insets = new Insets(0, 0, 5, 5);
		gbc_lblGiMua.gridx = 6;
		gbc_lblGiMua.gridy = 5;
		panel_DuLieu.add(lblGiMua, gbc_lblGiMua);
		
		textField_GiaMua = new JTextField();
		textField_GiaMua.setEnabled(false);
		GridBagConstraints gbc_textField_GiaMua = new GridBagConstraints();
		gbc_textField_GiaMua.insets = new Insets(0, 0, 5, 0);
		gbc_textField_GiaMua.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_GiaMua.gridx = 7;
		gbc_textField_GiaMua.gridy = 5;
		panel_DuLieu.add(textField_GiaMua, gbc_textField_GiaMua);
		textField_GiaMua.setColumns(10);
		
		panel_TacVu = new JPanel();
		panel_TacVu.setBorder(new TitledBorder(null, "T\u00E1c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_TacVu = new GridBagConstraints();
		gbc_panel_TacVu.fill = GridBagConstraints.BOTH;
		gbc_panel_TacVu.gridwidth = 8;
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
		btnThem.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\add.png"));
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
		btnSua.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\Edit.png"));
		panel_TacVu.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\delete.png"));
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
		btnLuu.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\Save.png"));
		btnLuu.setEnabled(false);
		
		
		btnThoi = new JButton("Thôi");
		btnThoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				thoi();
			}
		});
		panel_TacVu.add(btnThoi);
		btnThoi.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\cancel.png"));
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
		btnTimKiem.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\search-icon.png"));
		panel_TimKiem.add(btnTimKiem);
		
		btnKtXutExcel = new JButton("Kết xuất Excel");
		btnKtXutExcel.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\excel.png"));
		panel_TacVu.add(btnKtXutExcel);
		
		JPanel panel_DanhSach = new JPanel();
		panel_DanhSach.setBorder(new TitledBorder(null, "Danh S\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_DanhSach, BorderLayout.CENTER);
		
		
		table = new JTable();
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{Boolean.FALSE, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"", "ID", "T\u00EAn m\u1EB7t h\u00E0ng", "\u0110\u01A1n v\u1ECB t\u00EDnh", "Gi\u00E1 mua", "Gi\u00E1 b\u00E1n bu\u00F4n", "Gi\u00E1 b\u00E1n l\u1EBB", "VAT", "Ng\u00E0y nh\u1EADp", "Ng\u00E0y h\u1EBFt h\u1EA1n", "Nh\u00F3m h\u00E0ng", "\u0110\u1ED1i t\u00E1c", "Nh\u00E0 s\u1EA3n xu\u1EA5t"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Integer.class, String.class, String.class, Float.class, Float.class, Float.class, Float.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getColumnModel().getColumn(0).setMinWidth(30);
		table.getColumnModel().getColumn(0).setMaxWidth(30);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(0);
		table.getColumnModel().getColumn(1).setMinWidth(0);
		table.getColumnModel().getColumn(1).setMaxWidth(0);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setMinWidth(150);
		table.getColumnModel().getColumn(2).setMaxWidth(999);
		table.getColumnModel().getColumn(3).setMinWidth(1);
		table.getColumnModel().getColumn(3).setMaxWidth(999);
		table.getColumnModel().getColumn(4).setMinWidth(75);
		table.getColumnModel().getColumn(4).setMaxWidth(999);
		table.getColumnModel().getColumn(5).setMinWidth(75);
		table.getColumnModel().getColumn(5).setMaxWidth(999);
		table.getColumnModel().getColumn(6).setMinWidth(75);
		table.getColumnModel().getColumn(6).setMaxWidth(975);
		table.getColumnModel().getColumn(7).setMinWidth(75);
		table.getColumnModel().getColumn(7).setMaxWidth(975);
		table.getColumnModel().getColumn(8).setPreferredWidth(100);
		table.getColumnModel().getColumn(8).setMinWidth(100);
		table.getColumnModel().getColumn(8).setMaxWidth(900);
		table.getColumnModel().getColumn(9).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setMinWidth(100);
		table.getColumnModel().getColumn(9).setMaxWidth(900);
		table.getColumnModel().getColumn(10).setPreferredWidth(150);
		table.getColumnModel().getColumn(10).setMinWidth(150);
		table.getColumnModel().getColumn(10).setMaxWidth(950);
		table.getColumnModel().getColumn(11).setPreferredWidth(150);
		table.getColumnModel().getColumn(11).setMinWidth(150);
		table.getColumnModel().getColumn(11).setMaxWidth(950);
		table.getColumnModel().getColumn(12).setPreferredWidth(150);
		table.getColumnModel().getColumn(12).setMinWidth(150);
		table.getColumnModel().getColumn(12).setMaxWidth(990);
		panel_DanhSach.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane(table);
		panel_DanhSach.add(scrollPane);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		JPanel panel_NhanVien = new JPanel();
		getContentPane().add(panel_NhanVien, BorderLayout.SOUTH);
		
		JButton button = new JButton("");
		
		button.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\prev.png"));
		panel_NhanVien.add(button);
		
		JComboBox comboBox = new JComboBox();
		panel_NhanVien.add(comboBox);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\next.png"));
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
			textField_GiaBanLe.setText("");
			textField_GiaMua.setText("");
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
		textField_GiaMua.setEnabled(true);
		textField_GiaBanB.setEnabled(true);
		textField_GiaBanLe.setEnabled(true);
		dateChooser_NgayHetHan.setEnabled(true);
		dateChooser_NgayNhap.setEnabled(true);
		comboBox_NhomHang.setEnabled(true);
		comboBox_DoiTac.setEnabled(true);
		comboBox_DonViTInh.setEnabled(true);
		comboBox_NSX.setEnabled(true);
	}
	public void setDisibleDuLieu() {
		textField_TenHang.setEnabled(false);
		textField_GiaMua.setEnabled(false);
		textField_GiaBanB.setEnabled(false);
		textField_GiaBanLe.setEnabled(false);
		dateChooser_NgayHetHan.setEnabled(false);;
		dateChooser_NgayNhap.setEnabled(false);
		comboBox_NhomHang.setEnabled(false);
		comboBox_DoiTac.setEnabled(false);
		comboBox_DonViTInh.setEnabled(false);
		comboBox_NSX.setEnabled(false);
		
	}
	public void comboNhomHang() {
		try{
			String selected = (String) comboBox_NhomHang.getSelectedItem();
			QLNhomHangProcess QLNhomHangProcess = new QLNhomHangProcess();
			Vector<NhomHang> VNhomHang =QLNhomHangProcess.getListNhomHangcombo();
			Vector<String> vSNhomHang = new Vector<String>();
			comboBox_NhomHang.removeAll();
			for (int i = 0; i < VNhomHang.size(); i++) {
				vSNhomHang.add(VNhomHang.get(i).getsTenNhomHang());
			}
			DefaultComboBoxModel model = new DefaultComboBoxModel(vSNhomHang);
			comboBox_NhomHang.setModel(model);
			comboBox_NhomHang.setSelectedItem(selected);
		}catch (Exception e) {
			// TODO: handle exception
		}
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
		if (CheckString.Floatnumber(textField_GiaMua.getText()) 
				&& CheckString.Floatnumber(textField_GiaBanB.getText()) 
				&& CheckString.Floatnumber(textField_GiaBanLe.getText() )){	
		}else {
			loi = 1;
			err = err+"Giá hoặc VAT nhập vào không đúng định dạng số\n";
		}
		
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
