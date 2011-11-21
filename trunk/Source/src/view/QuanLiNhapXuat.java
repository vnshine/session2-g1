package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
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

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.Button;
import java.awt.Label;
import javax.swing.JRadioButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class QuanLiNhapXuat extends JInternalFrame implements ActionListener {

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private JTable table;
	private JTextField textField;
	private JLabel maDoiTac;
	private JLabel maNhanVien;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	public Integer a;
	private NhapXuat NhapXuat;
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
					QuanLiNhapXuat frame = new QuanLiNhapXuat();
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
	public QuanLiNhapXuat() throws Exception {
		setFrameIcon(new ImageIcon("media/images/import_export-icon.png"));
		setTitle("Quản lý Nhập xuất");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_DuLieu = new JPanel();
		panel_DuLieu.setBorder(new TitledBorder(null, "D\u1EEF li\u1EC7u", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_DuLieu, BorderLayout.NORTH);
		GridBagLayout gbl_panel_DuLieu = new GridBagLayout();
		gbl_panel_DuLieu.columnWidths = new int[]{0, 117, 0, 85, 100, 100, 0};
		gbl_panel_DuLieu.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_DuLieu.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_DuLieu.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_DuLieu.setLayout(gbl_panel_DuLieu);
		
		JLabel lblId = new JLabel("ID: ");
		lblId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel_DuLieu.add(lblId, gbc_lblId);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_DuLieu.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNgyNhpXut = new JLabel("Ngày Nhập/ Xuất: ");
		lblNgyNhpXut.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblNgyNhpXut = new GridBagConstraints();
		gbc_lblNgyNhpXut.insets = new Insets(0, 0, 5, 5);
		gbc_lblNgyNhpXut.gridx = 2;
		gbc_lblNgyNhpXut.gridy = 0;
		panel_DuLieu.add(lblNgyNhpXut, gbc_lblNgyNhpXut);
		
		final JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 3;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 3;
		gbc_dateChooser.gridy = 0;
		panel_DuLieu.add(dateChooser, gbc_dateChooser);
		
		JLabel lblTniTc = new JLabel("Tên đối tác: ");
		lblTniTc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblTniTc = new GridBagConstraints();
		gbc_lblTniTc.anchor = GridBagConstraints.EAST;
		gbc_lblTniTc.insets = new Insets(0, 0, 5, 5);
		gbc_lblTniTc.gridx = 0;
		gbc_lblTniTc.gridy = 1;
		panel_DuLieu.add(lblTniTc, gbc_lblTniTc);
		
		JTextField tenDoiTac = new JTextField();
		GridBagConstraints gbc_tenDoiTac = new GridBagConstraints();
		gbc_tenDoiTac.insets = new Insets(0, 0, 5, 5);
		gbc_tenDoiTac.fill = GridBagConstraints.HORIZONTAL;
		gbc_tenDoiTac.gridx = 1;
		gbc_tenDoiTac.gridy = 1;
		panel_DuLieu.add(tenDoiTac, gbc_tenDoiTac);
		
		JLabel lblMiTc = new JLabel("Mã đối tác: ");
		lblMiTc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblMiTc = new GridBagConstraints();
		gbc_lblMiTc.anchor = GridBagConstraints.EAST;
		gbc_lblMiTc.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiTc.gridx = 2;
		gbc_lblMiTc.gridy = 1;
		panel_DuLieu.add(lblMiTc, gbc_lblMiTc);
		
		maDoiTac = new JLabel();
		maDoiTac.setText("Mã Đối tác");
		GridBagConstraints gbc_maDoiTac = new GridBagConstraints();
		gbc_maDoiTac.insets = new Insets(0, 0, 5, 5);
		gbc_maDoiTac.fill = GridBagConstraints.HORIZONTAL;
		gbc_maDoiTac.gridx = 3;
		gbc_maDoiTac.gridy = 1;
		panel_DuLieu.add(maDoiTac, gbc_maDoiTac);
		
		JLabel lblGhiCh = new JLabel("Ghi chú: ");
		lblGhiCh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblGhiCh = new GridBagConstraints();
		gbc_lblGhiCh.anchor = GridBagConstraints.EAST;
		gbc_lblGhiCh.insets = new Insets(0, 0, 5, 5);
		gbc_lblGhiCh.gridx = 4;
		gbc_lblGhiCh.gridy = 1;
		panel_DuLieu.add(lblGhiCh, gbc_lblGhiCh);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 5;
		gbc_scrollPane_1.gridy = 1;
		panel_DuLieu.add(scrollPane_1, gbc_scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblTnNhnVin = new JLabel("Tên nhân viên: ");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblTnNhnVin = new GridBagConstraints();
		gbc_lblTnNhnVin.anchor = GridBagConstraints.EAST;
		gbc_lblTnNhnVin.insets = new Insets(0, 0, 5, 5);
		gbc_lblTnNhnVin.gridx = 0;
		gbc_lblTnNhnVin.gridy = 2;
		panel_DuLieu.add(lblTnNhnVin, gbc_lblTnNhnVin);
		
		JLabel tenNhanVien = new JLabel();
		tenNhanVien.setText("Tên Nhân Viên");
		GridBagConstraints gbc_tenNhanVien = new GridBagConstraints();
		gbc_tenNhanVien.insets = new Insets(0, 0, 5, 5);
		gbc_tenNhanVien.fill = GridBagConstraints.HORIZONTAL;
		gbc_tenNhanVien.gridx = 1;
		gbc_tenNhanVien.gridy = 2;
		panel_DuLieu.add(tenNhanVien, gbc_tenNhanVien);
		
		JLabel lblMNhnVin = new JLabel("Mã nhân viên: ");
		lblMNhnVin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblMNhnVin = new GridBagConstraints();
		gbc_lblMNhnVin.anchor = GridBagConstraints.EAST;
		gbc_lblMNhnVin.insets = new Insets(0, 0, 5, 5);
		gbc_lblMNhnVin.gridx = 2;
		gbc_lblMNhnVin.gridy = 2;
		panel_DuLieu.add(lblMNhnVin, gbc_lblMNhnVin);
		
		maNhanVien = new JLabel();
		maNhanVien.setText("Mã");
		GridBagConstraints gbc_maNhanVien = new GridBagConstraints();
		gbc_maNhanVien.insets = new Insets(0, 0, 5, 5);
		gbc_maNhanVien.fill = GridBagConstraints.HORIZONTAL;
		gbc_maNhanVien.gridx = 3;
		gbc_maNhanVien.gridy = 2;
		panel_DuLieu.add(maNhanVien, gbc_maNhanVien);
		
		JLabel lblTngTin = new JLabel("Tổng tiền: ");
		lblTngTin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblTngTin = new GridBagConstraints();
		gbc_lblTngTin.anchor = GridBagConstraints.EAST;
		gbc_lblTngTin.insets = new Insets(0, 0, 5, 5);
		gbc_lblTngTin.gridx = 0;
		gbc_lblTngTin.gridy = 3;
		panel_DuLieu.add(lblTngTin, gbc_lblTngTin);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 3;
		panel_DuLieu.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCnN = new JLabel("Còn nợ :");
		lblCnN.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblCnN = new GridBagConstraints();
		gbc_lblCnN.anchor = GridBagConstraints.EAST;
		gbc_lblCnN.insets = new Insets(0, 0, 5, 5);
		gbc_lblCnN.gridx = 2;
		gbc_lblCnN.gridy = 3;
		panel_DuLieu.add(lblCnN, gbc_lblCnN);
		
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 3;
		gbc_textField_7.gridy = 3;
		panel_DuLieu.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		JPanel panel_HoaDon = new JPanel();
		panel_HoaDon.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_HoaDon = new GridBagConstraints();
		gbc_panel_HoaDon.gridheight = 2;
		gbc_panel_HoaDon.insets = new Insets(0, 0, 5, 0);
		gbc_panel_HoaDon.fill = GridBagConstraints.BOTH;
		gbc_panel_HoaDon.gridx = 5;
		gbc_panel_HoaDon.gridy = 3;
		panel_DuLieu.add(panel_HoaDon, gbc_panel_HoaDon);
		GridBagLayout gbl_panel_HoaDon = new GridBagLayout();
		gbl_panel_HoaDon.columnWidths = new int[]{99, 0, 0};
		gbl_panel_HoaDon.rowHeights = new int[]{23, 0, 0};
		gbl_panel_HoaDon.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_HoaDon.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_HoaDon.setLayout(gbl_panel_HoaDon);
		
		JRadioButton rdbtnLyHan = new JRadioButton("Lấy hóa đơn đỏ");
		rdbtnLyHan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_rdbtnLyHan = new GridBagConstraints();
		gbc_rdbtnLyHan.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnLyHan.anchor = GridBagConstraints.NORTHEAST;
		gbc_rdbtnLyHan.gridx = 0;
		gbc_rdbtnLyHan.gridy = 0;
		panel_HoaDon.add(rdbtnLyHan, gbc_rdbtnLyHan);
		rdbtnLyHan.setSelected(true);
		
		JRadioButton rdbtnLyHan_1 = new JRadioButton("Lấy hóa đơn thường");
		rdbtnLyHan_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_rdbtnLyHan_1 = new GridBagConstraints();
		gbc_rdbtnLyHan_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnLyHan_1.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnLyHan_1.gridx = 1;
		gbc_rdbtnLyHan_1.gridy = 0;
		panel_HoaDon.add(rdbtnLyHan_1, gbc_rdbtnLyHan_1);
		
		JLabel lblVat = new JLabel("VAT(%):");
		lblVat.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblVat = new GridBagConstraints();
		gbc_lblVat.anchor = GridBagConstraints.EAST;
		gbc_lblVat.insets = new Insets(0, 0, 0, 5);
		gbc_lblVat.gridx = 0;
		gbc_lblVat.gridy = 1;
		panel_HoaDon.add(lblVat, gbc_lblVat);
		
		textField_8 = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.anchor = GridBagConstraints.WEST;
		gbc_textField_8.gridx = 1;
		gbc_textField_8.gridy = 1;
		panel_HoaDon.add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 4;
		panel_DuLieu.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{68, 20, 94, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{22, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTngPhiTr = new JLabel("         Tổng Phải trả:");
		lblTngPhiTr.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblTngPhiTr = new GridBagConstraints();
		gbc_lblTngPhiTr.anchor = GridBagConstraints.WEST;
		gbc_lblTngPhiTr.insets = new Insets(0, 0, 0, 5);
		gbc_lblTngPhiTr.gridx = 0;
		gbc_lblTngPhiTr.gridy = 0;
		panel.add(lblTngPhiTr, gbc_lblTngPhiTr);
		
		textField_9 = new JTextField();
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.anchor = GridBagConstraints.WEST;
		gbc_textField_9.insets = new Insets(0, 0, 0, 5);
		gbc_textField_9.gridx = 1;
		gbc_textField_9.gridy = 0;
		panel.add(textField_9, gbc_textField_9);
		textField_9.setColumns(10);
		
		Label label = new Label("         Tiền khách trả:");
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTHWEST;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.anchor = GridBagConstraints.NORTHEAST;
		gbc_textField_5.insets = new Insets(0, 0, 0, 5);
		gbc_textField_5.gridx = 3;
		gbc_textField_5.gridy = 0;
		panel.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		JLabel lblTinTrLi = new JLabel("         Tiền trả lại: ");
		lblTinTrLi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblTinTrLi = new GridBagConstraints();
		gbc_lblTinTrLi.anchor = GridBagConstraints.WEST;
		gbc_lblTinTrLi.insets = new Insets(0, 0, 0, 5);
		gbc_lblTinTrLi.gridx = 4;
		gbc_lblTinTrLi.gridy = 0;
		panel.add(lblTinTrLi, gbc_lblTinTrLi);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.anchor = GridBagConstraints.NORTHWEST;
		gbc_textField_6.gridx = 5;
		gbc_textField_6.gridy = 0;
		panel.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		JPanel panel_TacVu = new JPanel();
		panel_TacVu.setForeground(new Color(0, 0, 255));
		panel_TacVu.setBorder(new TitledBorder(null, "T\u00E1c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_TacVu = new GridBagConstraints();
		gbc_panel_TacVu.fill = GridBagConstraints.BOTH;
		gbc_panel_TacVu.gridwidth = 6;
		gbc_panel_TacVu.gridx = 0;
		gbc_panel_TacVu.gridy = 7;
		panel_DuLieu.add(panel_TacVu, gbc_panel_TacVu);
		panel_TacVu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JMenuBar menuBar = new JMenuBar();
		panel_TacVu.add(menuBar);
		
		JButton button_3 = new JButton("");
		menuBar.add(button_3);
		
		
		
		
		
		JMenu mnThm = new JMenu("Thêm mặt hàng");
		mnThm.setForeground(new Color(0, 0, 255));
		mnThm.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnThm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					formNhapXuat();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		mnThm.setIcon(new ImageIcon("media/images/add.png"));
		menuBar.add(mnThm);
		
		JButton button_2 = new JButton("");
		menuBar.add(button_2);
		
		JMenu mnSa = new JMenu("Sửa");
		mnSa.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnSa.setForeground(new Color(0, 0, 255));
		mnSa.setIcon(new ImageIcon("media/images/Edit.png"));
		menuBar.add(mnSa);
		
		JButton button_4 = new JButton("");
		menuBar.add(button_4);
		
		JMenu mnXa = new JMenu("Xóa");
		mnXa.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnXa.setForeground(new Color(0, 0, 255));
		mnXa.setIcon(new ImageIcon("media/images/delete.png"));
		menuBar.add(mnXa);
		
		JButton button_5 = new JButton("");
		menuBar.add(button_5);
		
		JMenu mnXutRacl = new JMenu("Xuất Phiếu");
		mnXutRacl.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnXutRacl.setForeground(new Color(0, 0, 255));
		mnXutRacl.setIcon(new ImageIcon("media/images/excel.png"));
		menuBar.add(mnXutRacl);
		
		JButton button_7 = new JButton("");
		menuBar.add(button_7);
		
		
		table = new JTable();
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"", "ID", "STT", "ID H\u00E0ng h\u00F3a", "T\u00EAn h\u00E0ng h\u00F3a", "S\u1ED1 l\u01B0\u1EE3ng", "\u0110\u01A1n gi\u00E1", "VAT(%)", "Th\u00E0nh ti\u1EC1n"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Integer.class, Object.class, String.class, Float.class, Float.class, Object.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(0).setMinWidth(60);
		table.getColumnModel().getColumn(0).setMaxWidth(999);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(0);
		table.getColumnModel().getColumn(1).setMinWidth(0);
		table.getColumnModel().getColumn(1).setMaxWidth(0);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setMinWidth(60);
		table.getColumnModel().getColumn(2).setMaxWidth(999);
		table.getColumnModel().getColumn(3).setPreferredWidth(70);
		table.getColumnModel().getColumn(3).setMinWidth(150);
		table.getColumnModel().getColumn(3).setMaxWidth(999);
		table.getColumnModel().getColumn(4).setPreferredWidth(250);
		table.getColumnModel().getColumn(4).setMinWidth(250);
		table.getColumnModel().getColumn(4).setMaxWidth(999);
		table.getColumnModel().getColumn(5).setPreferredWidth(150);
		table.getColumnModel().getColumn(5).setMinWidth(150);
		table.getColumnModel().getColumn(5).setMaxWidth(999);
		table.getColumnModel().getColumn(6).setPreferredWidth(150);
		table.getColumnModel().getColumn(6).setMinWidth(150);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setMinWidth(150);
		table.getColumnModel().getColumn(7).setMaxWidth(950);
		table.getColumnModel().getColumn(8).setPreferredWidth(150);
		table.getColumnModel().getColumn(8).setMinWidth(150);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
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
	}

	public void formNhapXuat() throws Exception {
		NhapXuat = new NhapXuat(this);
		NhapXuat.setModal(true);
		NhapXuat.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
