package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class QuanLiNhanVien extends JInternalFrame implements ActionListener {

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private JTable table;
	private JTextField textField;
	private JTextField textField_4;
	//private NhapXuat NhapXuat = new NhapXuat();
	private JPasswordField textField_10;
	private JPasswordField textField_11;
	private JTextField textField_1;
	private JTextField textField_2;
	private JCheckBox checkBox;
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
	public QuanLiNhanVien() throws Exception {
		setFrameIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\import_export-icon.png"));
		setTitle("Quản lý Nhân Viên");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_DuLieu = new JPanel();
		panel_DuLieu.setBorder(new TitledBorder(null, "D\u1EEF li\u1EC7u", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_DuLieu, BorderLayout.NORTH);
		GridBagLayout gbl_panel_DuLieu = new GridBagLayout();
		gbl_panel_DuLieu.columnWidths = new int[]{0, 117, 0, 0, 85, 0};
		gbl_panel_DuLieu.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_DuLieu.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_DuLieu.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_DuLieu.setLayout(gbl_panel_DuLieu);
		
		JLabel lblId = new JLabel("Mã nhân viên : ");
		lblId.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel_DuLieu.add(lblId, gbc_lblId);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_DuLieu.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNgyNhpXut = new JLabel("Ngày sinh : ");
		lblNgyNhpXut.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblNgyNhpXut = new GridBagConstraints();
		gbc_lblNgyNhpXut.insets = new Insets(0, 0, 5, 5);
		gbc_lblNgyNhpXut.gridx = 3;
		gbc_lblNgyNhpXut.gridy = 0;
		panel_DuLieu.add(lblNgyNhpXut, gbc_lblNgyNhpXut);
		
		final JDateChooser dateChooser = new JDateChooser();
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 4;
		gbc_dateChooser.gridy = 0;
		panel_DuLieu.add(dateChooser, gbc_dateChooser);
		
		JLabel lblTniTc = new JLabel("Mật khẩu : ");
		lblTniTc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblTniTc = new GridBagConstraints();
		gbc_lblTniTc.anchor = GridBagConstraints.EAST;
		gbc_lblTniTc.insets = new Insets(0, 0, 5, 5);
		gbc_lblTniTc.gridx = 0;
		gbc_lblTniTc.gridy = 1;
		panel_DuLieu.add(lblTniTc, gbc_lblTniTc);
		
		textField_10 = new JPasswordField();
		textField_10.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_textField_10 = new GridBagConstraints();
		gbc_textField_10.insets = new Insets(0, 0, 5, 5);
		gbc_textField_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_10.gridx = 1;
		gbc_textField_10.gridy = 1;
		panel_DuLieu.add(textField_10, gbc_textField_10);
		textField_10.setColumns(10);
		
		checkBox = new JCheckBox("123456");
		checkBox.setSelected(true);
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (checkBox.isSelected()) {
					textField_10.setEditable(false);
					textField_11.setEditable(false);
					textField_10.setText("123456");
					textField_11.setText("123456");
				}else {
					textField_10.setEditable(true);
					textField_10.setText("");
					textField_11.setEditable(true);
					textField_11.setText("");
				}
			}
		});
		textField_10.setEditable(false);
		
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox.gridx = 2;
		gbc_checkBox.gridy = 1;
		panel_DuLieu.add(checkBox, gbc_checkBox);
		
		JLabel lblMiTc = new JLabel("Giới tính: ");
		lblMiTc.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblMiTc = new GridBagConstraints();
		gbc_lblMiTc.anchor = GridBagConstraints.EAST;
		gbc_lblMiTc.insets = new Insets(0, 0, 5, 5);
		gbc_lblMiTc.gridx = 3;
		gbc_lblMiTc.gridy = 1;
		panel_DuLieu.add(lblMiTc, gbc_lblMiTc);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 4;
		gbc_comboBox_1.gridy = 1;
		panel_DuLieu.add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblTnNhnVin = new JLabel("Nhắc lại MK : ");
		lblTnNhnVin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblTnNhnVin = new GridBagConstraints();
		gbc_lblTnNhnVin.anchor = GridBagConstraints.EAST;
		gbc_lblTnNhnVin.insets = new Insets(0, 0, 5, 5);
		gbc_lblTnNhnVin.gridx = 0;
		gbc_lblTnNhnVin.gridy = 2;
		panel_DuLieu.add(lblTnNhnVin, gbc_lblTnNhnVin);
		
		textField_11 = new JPasswordField();
		textField_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_textField_11 = new GridBagConstraints();
		gbc_textField_11.insets = new Insets(0, 0, 5, 5);
		gbc_textField_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_11.gridx = 1;
		gbc_textField_11.gridy = 2;
		panel_DuLieu.add(textField_11, gbc_textField_11);
		textField_11.setColumns(10);
		textField_11.setEditable(false);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại : ");
		lblSinThoi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblSinThoi = new GridBagConstraints();
		gbc_lblSinThoi.anchor = GridBagConstraints.EAST;
		gbc_lblSinThoi.insets = new Insets(0, 0, 5, 5);
		gbc_lblSinThoi.gridx = 3;
		gbc_lblSinThoi.gridy = 2;
		panel_DuLieu.add(lblSinThoi, gbc_lblSinThoi);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 2;
		panel_DuLieu.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTngTin = new JLabel("Họ và tên : ");
		lblTngTin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblTngTin = new GridBagConstraints();
		gbc_lblTngTin.anchor = GridBagConstraints.EAST;
		gbc_lblTngTin.insets = new Insets(0, 0, 5, 5);
		gbc_lblTngTin.gridx = 0;
		gbc_lblTngTin.gridy = 3;
		panel_DuLieu.add(lblTngTin, gbc_lblTngTin);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 2;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 3;
		panel_DuLieu.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblGhiCh = new JLabel("Ghi chú: ");
		lblGhiCh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblGhiCh = new GridBagConstraints();
		gbc_lblGhiCh.anchor = GridBagConstraints.EAST;
		gbc_lblGhiCh.insets = new Insets(0, 0, 5, 5);
		gbc_lblGhiCh.gridx = 3;
		gbc_lblGhiCh.gridy = 3;
		panel_DuLieu.add(lblGhiCh, gbc_lblGhiCh);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridheight = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.gridx = 4;
		gbc_scrollPane_1.gridy = 3;
		panel_DuLieu.add(scrollPane_1, gbc_scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblaCh = new JLabel("Địa chỉ : ");
		lblaCh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblaCh = new GridBagConstraints();
		gbc_lblaCh.anchor = GridBagConstraints.EAST;
		gbc_lblaCh.insets = new Insets(0, 0, 5, 5);
		gbc_lblaCh.gridx = 0;
		gbc_lblaCh.gridy = 4;
		panel_DuLieu.add(lblaCh, gbc_lblaCh);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		panel_DuLieu.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_TacVu = new JPanel();
		panel_TacVu.setForeground(new Color(0, 0, 255));
		panel_TacVu.setBorder(new TitledBorder(null, "T\u00E1c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_TacVu = new GridBagConstraints();
		gbc_panel_TacVu.fill = GridBagConstraints.BOTH;
		gbc_panel_TacVu.gridwidth = 5;
		gbc_panel_TacVu.gridx = 0;
		gbc_panel_TacVu.gridy = 6;
		panel_DuLieu.add(panel_TacVu, gbc_panel_TacVu);
		panel_TacVu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JMenuBar menuBar = new JMenuBar();
		panel_TacVu.add(menuBar);
		
		JButton button_3 = new JButton("");
		menuBar.add(button_3);
		
		JMenu mnThm = new JMenu("Thêm");
		mnThm.setForeground(new Color(0, 0, 255));
		mnThm.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnThm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//NhapXuat.setModal(true);
				//NhapXuat.setVisible(true);
			}
		});
		
		mnThm.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\add.png"));
		menuBar.add(mnThm);
		
		JButton button_2 = new JButton("");
		menuBar.add(button_2);
		
		JMenu mnSa = new JMenu("Sửa");
		mnSa.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnSa.setForeground(new Color(0, 0, 255));
		mnSa.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\Edit.png"));
		menuBar.add(mnSa);
		
		JButton button_4 = new JButton("");
		menuBar.add(button_4);
		
		JMenu mnXa = new JMenu("Xóa");
		mnXa.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnXa.setForeground(new Color(0, 0, 255));
		mnXa.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\delete.png"));
		menuBar.add(mnXa);
		
		JButton button_5 = new JButton("");
		menuBar.add(button_5);
		
		JMenu mnTmKim = new JMenu("Tìm kiếm");
		mnTmKim.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnTmKim.setForeground(new Color(0, 0, 255));
		mnTmKim.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\search-icon.png"));
		menuBar.add(mnTmKim);
		
		JButton button_6 = new JButton("");
		menuBar.add(button_6);
		
		JMenu mnXutRacl = new JMenu("Xuất Danh Sách");
		mnXutRacl.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnXutRacl.setForeground(new Color(0, 0, 255));
		mnXutRacl.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\excel.png"));
		menuBar.add(mnXutRacl);
		
		JButton button_7 = new JButton("");
		menuBar.add(button_7);
		
		
		table = new JTable();
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"", "ID", "STT", "ID", "T\u00EAn nh\u00E2n vi\u00EAn", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Ghi ch\u00FA"
			}
		) {
			Class[] columnTypes = new Class[] {
				Boolean.class, Integer.class, Object.class, String.class, Float.class, Float.class, Object.class, String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setMinWidth(50);
		table.getColumnModel().getColumn(0).setMaxWidth(999);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(0);
		table.getColumnModel().getColumn(1).setMinWidth(0);
		table.getColumnModel().getColumn(1).setMaxWidth(0);
		table.getColumnModel().getColumn(2).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setMinWidth(50);
		table.getColumnModel().getColumn(2).setMaxWidth(999);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		table.getColumnModel().getColumn(3).setMinWidth(50);
		table.getColumnModel().getColumn(3).setMaxWidth(999);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setMinWidth(150);
		table.getColumnModel().getColumn(4).setMaxWidth(999);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setMinWidth(100);
		table.getColumnModel().getColumn(5).setMaxWidth(999);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(6).setMinWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(150);
		table.getColumnModel().getColumn(7).setMinWidth(150);
		table.getColumnModel().getColumn(7).setMaxWidth(950);
		table.getColumnModel().getColumn(8).setPreferredWidth(80);
		table.getColumnModel().getColumn(8).setMinWidth(80);
		table.getColumnModel().getColumn(9).setMinWidth(250);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
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
		
		textField_10.setText("123456");
		textField_11.setText("123456");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
