package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import UsingExcelTemplates.WriteExcel;

import main.LoginForm;
import module.TiengVietToEg;
import myobject.NhomHang;
import process.QLNhomHangProcess;
import process.ThongTinProcess;
import validate.CheckString;
import java.awt.Font;
import javax.swing.JPasswordField;

public class ThongTaiKhoan extends JInternalFrame implements ActionListener {

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private Integer soTrang =0,sTT,soLuongNH = null,iLoi = 0;
	private QLNhomHangProcess QLNhomHangProcess = new QLNhomHangProcess();
	DefaultTableModel model;
	private String err;
	private Vector<Integer> ListChecked = new Vector<Integer>();
	private Vector<NhomHang> danhSach;
	private JLabel lblM;
	private JLabel lblHVTn;
	private JLabel lblNgySinh;
	private JLabel lblChcV;
	private JLabel lblSinThoi;
	private JLabel lblaCh;
	private JLabel lblGiiTnh;
	private JLabel lblGhiCh;
	private JLabel lblMtKhuC;
	private JLabel lblXcNhnMt;
	private JLabel lblMtKhuMi;
	private JPasswordField textField;
	private JPasswordField textField_1;
	private JPasswordField textField_2;
	private JButton button;
	private JLabel lblA;
	private JLabel lblTVitTho;
	private JLabel label;
	private JLabel lblNam;
	private JLabel lblCngDnC;
	private JLabel lblanhCng;
	private JLabel label_1;
	private JLabel lblDiTrngNng;
	private JLabel lblNewLabel;
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
					ThongTaiKhoan frame = new ThongTaiKhoan();
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
	public ThongTaiKhoan() throws Exception {
		setFrameIcon(new ImageIcon("media/images/NhanVien-icon.png"));
		setTitle("Quản lý Tài khoản");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		ThongTinProcess pro = new ThongTinProcess();
		Vector<String> a = pro.Thongtin(LoginForm.userName);
		
		JPanel panel_DuLieu = new JPanel();
		getContentPane().add(panel_DuLieu, BorderLayout.CENTER);
		panel_DuLieu.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "D\u1EEF Li\u1EC7u", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_panel_DuLieu = new GridBagLayout();
		gbl_panel_DuLieu.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_DuLieu.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_DuLieu.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_DuLieu.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_DuLieu.setLayout(gbl_panel_DuLieu);
		
		lblM = new JLabel("Mã : ");
		lblM.setForeground(new Color(0, 0, 255));
		lblM.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_lblM = new GridBagConstraints();
		gbc_lblM.anchor = GridBagConstraints.EAST;
		gbc_lblM.insets = new Insets(0, 0, 5, 5);
		gbc_lblM.gridx = 1;
		gbc_lblM.gridy = 1;
		panel_DuLieu.add(lblM, gbc_lblM);
		
		
		System.out.println(a.get(0));
		lblA = new JLabel(a.get(0));
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.anchor = GridBagConstraints.WEST;
		gbc_lblA.insets = new Insets(0, 0, 5, 5);
		gbc_lblA.gridx = 2;
		gbc_lblA.gridy = 1;
		panel_DuLieu.add(lblA, gbc_lblA);
		
		lblHVTn = new JLabel("Họ và Tên : ");
		lblHVTn.setForeground(Color.BLUE);
		lblHVTn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_lblHVTn = new GridBagConstraints();
		gbc_lblHVTn.anchor = GridBagConstraints.EAST;
		gbc_lblHVTn.insets = new Insets(0, 0, 5, 5);
		gbc_lblHVTn.gridx = 1;
		gbc_lblHVTn.gridy = 2;
		panel_DuLieu.add(lblHVTn, gbc_lblHVTn);
		
		lblTVitTho = new JLabel(a.get(1));
		lblTVitTho.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblTVitTho = new GridBagConstraints();
		gbc_lblTVitTho.anchor = GridBagConstraints.WEST;
		gbc_lblTVitTho.insets = new Insets(0, 0, 5, 5);
		gbc_lblTVitTho.gridx = 2;
		gbc_lblTVitTho.gridy = 2;
		panel_DuLieu.add(lblTVitTho, gbc_lblTVitTho);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("media/images/NhanVien-icon.png"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridheight = 6;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 2;
		panel_DuLieu.add(lblNewLabel, gbc_lblNewLabel);
		
		lblNgySinh = new JLabel("Ngày sinh : ");
		lblNgySinh.setForeground(Color.BLUE);
		lblNgySinh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_lblNgySinh = new GridBagConstraints();
		gbc_lblNgySinh.anchor = GridBagConstraints.EAST;
		gbc_lblNgySinh.insets = new Insets(0, 0, 5, 5);
		gbc_lblNgySinh.gridx = 1;
		gbc_lblNgySinh.gridy = 3;
		panel_DuLieu.add(lblNgySinh, gbc_lblNgySinh);
		
		label = new JLabel(a.get(2));
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 3;
		panel_DuLieu.add(label, gbc_label);
		
		lblGiiTnh = new JLabel("Giới tính : ");
		lblGiiTnh.setForeground(Color.BLUE);
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_lblGiiTnh = new GridBagConstraints();
		gbc_lblGiiTnh.anchor = GridBagConstraints.EAST;
		gbc_lblGiiTnh.insets = new Insets(0, 0, 5, 5);
		gbc_lblGiiTnh.gridx = 1;
		gbc_lblGiiTnh.gridy = 4;
		panel_DuLieu.add(lblGiiTnh, gbc_lblGiiTnh);
		
		lblNam = new JLabel(a.get(3));
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNam = new GridBagConstraints();
		gbc_lblNam.anchor = GridBagConstraints.WEST;
		gbc_lblNam.insets = new Insets(0, 0, 5, 5);
		gbc_lblNam.gridx = 2;
		gbc_lblNam.gridy = 4;
		panel_DuLieu.add(lblNam, gbc_lblNam);
		
		lblChcV = new JLabel("Chức vụ : ");
		lblChcV.setForeground(Color.BLUE);
		lblChcV.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_lblChcV = new GridBagConstraints();
		gbc_lblChcV.anchor = GridBagConstraints.EAST;
		gbc_lblChcV.insets = new Insets(0, 0, 5, 5);
		gbc_lblChcV.gridx = 1;
		gbc_lblChcV.gridy = 5;
		panel_DuLieu.add(lblChcV, gbc_lblChcV);
		
		lblCngDnC = new JLabel("Công dân có ích");
		lblCngDnC.setFont(new Font("Dialog", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCngDnC = new GridBagConstraints();
		gbc_lblCngDnC.anchor = GridBagConstraints.WEST;
		gbc_lblCngDnC.insets = new Insets(0, 0, 5, 5);
		gbc_lblCngDnC.gridx = 2;
		gbc_lblCngDnC.gridy = 5;
		panel_DuLieu.add(lblCngDnC, gbc_lblCngDnC);
		
		lblaCh = new JLabel("Địa chỉ : ");
		lblaCh.setForeground(Color.BLUE);
		lblaCh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_lblaCh = new GridBagConstraints();
		gbc_lblaCh.anchor = GridBagConstraints.EAST;
		gbc_lblaCh.insets = new Insets(0, 0, 5, 5);
		gbc_lblaCh.gridx = 1;
		gbc_lblaCh.gridy = 6;
		panel_DuLieu.add(lblaCh, gbc_lblaCh);
		
		lblanhCng = new JLabel("116A Định Công - Hoàng Mai - Hà Nội");
		lblanhCng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblanhCng = new GridBagConstraints();
		gbc_lblanhCng.anchor = GridBagConstraints.WEST;
		gbc_lblanhCng.insets = new Insets(0, 0, 5, 5);
		gbc_lblanhCng.gridx = 2;
		gbc_lblanhCng.gridy = 6;
		panel_DuLieu.add(lblanhCng, gbc_lblanhCng);
		
		lblSinThoi = new JLabel("Số điện thoại : ");
		lblSinThoi.setForeground(Color.BLUE);
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_lblSinThoi = new GridBagConstraints();
		gbc_lblSinThoi.anchor = GridBagConstraints.EAST;
		gbc_lblSinThoi.insets = new Insets(0, 0, 5, 5);
		gbc_lblSinThoi.gridx = 1;
		gbc_lblSinThoi.gridy = 7;
		panel_DuLieu.add(lblSinThoi, gbc_lblSinThoi);
		
		label_1 = new JLabel(a.get(4));
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 7;
		panel_DuLieu.add(label_1, gbc_label_1);
		
		lblGhiCh = new JLabel("Ghi chú : ");
		lblGhiCh.setForeground(Color.BLUE);
		lblGhiCh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		GridBagConstraints gbc_lblGhiCh = new GridBagConstraints();
		gbc_lblGhiCh.anchor = GridBagConstraints.EAST;
		gbc_lblGhiCh.insets = new Insets(0, 0, 5, 5);
		gbc_lblGhiCh.gridx = 1;
		gbc_lblGhiCh.gridy = 8;
		panel_DuLieu.add(lblGhiCh, gbc_lblGhiCh);
		
		lblDiTrngNng = new JLabel(a.get(5));
		lblDiTrngNng.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDiTrngNng = new GridBagConstraints();
		gbc_lblDiTrngNng.anchor = GridBagConstraints.WEST;
		gbc_lblDiTrngNng.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiTrngNng.gridx = 2;
		gbc_lblDiTrngNng.gridy = 8;
		panel_DuLieu.add(lblDiTrngNng, gbc_lblDiTrngNng);
		
		final JPanel panel_TacVu = new JPanel();
		panel_TacVu.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u0110\u1ED5i m\u1EADt kh\u1EA9u", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_TacVu = new GridBagConstraints();
		gbc_panel_TacVu.insets = new Insets(0, 0, 5, 5);
		gbc_panel_TacVu.gridwidth = 3;
		gbc_panel_TacVu.fill = GridBagConstraints.BOTH;
		gbc_panel_TacVu.gridx = 0;
		gbc_panel_TacVu.gridy = 10;
		panel_DuLieu.add(panel_TacVu, gbc_panel_TacVu);
		GridBagLayout gbl_panel_TacVu = new GridBagLayout();
		gbl_panel_TacVu.columnWidths = new int[]{0};
		gbl_panel_TacVu.rowHeights = new int[]{0};
		gbl_panel_TacVu.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_TacVu.rowWeights = new double[]{Double.MIN_VALUE};
		panel_TacVu.setLayout(gbl_panel_TacVu);
		
		lblMtKhuC = new JLabel("Mật khẩu cũ : ");
		lblMtKhuC.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblMtKhuC = new GridBagConstraints();
		gbc_lblMtKhuC.anchor = GridBagConstraints.EAST;
		gbc_lblMtKhuC.insets = new Insets(0, 0, 5, 5);
		gbc_lblMtKhuC.gridx = 1;
		gbc_lblMtKhuC.gridy = 11;
		panel_DuLieu.add(lblMtKhuC, gbc_lblMtKhuC);
		
		textField = new JPasswordField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 11;
		panel_DuLieu.add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblMtKhuMi = new JLabel("Mật khẩu mới : ");
		lblMtKhuMi.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblMtKhuMi = new GridBagConstraints();
		gbc_lblMtKhuMi.anchor = GridBagConstraints.EAST;
		gbc_lblMtKhuMi.insets = new Insets(0, 0, 5, 5);
		gbc_lblMtKhuMi.gridx = 1;
		gbc_lblMtKhuMi.gridy = 12;
		panel_DuLieu.add(lblMtKhuMi, gbc_lblMtKhuMi);
		
		textField_1 = new JPasswordField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 12;
		panel_DuLieu.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblXcNhnMt = new JLabel("Xác nhận mật khẩu : ");
		lblXcNhnMt.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_lblXcNhnMt = new GridBagConstraints();
		gbc_lblXcNhnMt.anchor = GridBagConstraints.EAST;
		gbc_lblXcNhnMt.insets = new Insets(0, 0, 5, 5);
		gbc_lblXcNhnMt.gridx = 1;
		gbc_lblXcNhnMt.gridy = 13;
		panel_DuLieu.add(lblXcNhnMt, gbc_lblXcNhnMt);
		
		textField_2 = new JPasswordField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 13;
		panel_DuLieu.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		button = new JButton("Đổi mật khẩu");
		button.setIcon(new ImageIcon("media/images/change_pass.png"));
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 1;
		gbc_button.gridy = 14;
		panel_DuLieu.add(button, gbc_button);
		model = (new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"", "STT", "T\u00EAn nh\u00F3m h\u00E0ng", "Ghi ch\u00FA", "ID"
			}
		) {

			Class[] columnTypes = new Class[] {
				Boolean.class, Object.class, Object.class, Object.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
					true, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		if (QLNhomHangProcess.getsoNhomHang() > 0) {
			soTrang = 1;
		}
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub	
	}
}
