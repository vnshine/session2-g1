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

import module.TiengVietToEg;
import myobject.NhomHang;
import process.QLNhomHangProcess;
import validate.CheckString;

public class QuanLiNhomHang extends JInternalFrame implements ActionListener {

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private JTextField textField_TenNhomHang;
	private JTextArea textArea_GhiChu;
	private JTable table;
	private JButton btnSau,btnTrc;
	private JComboBox comboBox_SoTrang;
	private Integer soTrang =0,sTT,soLuongNH = null,iLoi = 0;
	private JLabel lblThongBao;
	private QLNhomHangProcess QLNhomHangProcess = new QLNhomHangProcess();
	DefaultTableModel model;
	private JPopupMenu popupMenu;
	private JMenuItem mntmXa;
	private String err;
	private JCheckBox chckbxCheckall;
	private JMenu mnSa;
	private JLabel lblTnNhmHng;
	private JTextField textField_TenNHS2;
	private JSeparator separator;
	private JLabel lblGhiCh_1;
	private JTextArea textArea_GhiChuS2;
	private JSeparator separator_1;
	private JButton btnluups;
	private JSeparator separator_2;
	private JMenuBar menuBar;
	private JMenu menu;
	private JLabel label;
	private JTextField textField_TenNhomHS;
	private JSeparator separator_3;
	private JLabel label_1;
	private JSeparator separator_4;
	private JTextArea textArea_GhiChuS;
	private JSeparator separator_5;
	private JButton button;
	private JMenu mnXutExcel;
	private JButton spr;
	private JButton spr2;
	private JButton spr3;
	private JButton spr4;
	private JButton spr5;
	private JMenu mnThm;
	private JLabel label_2;
	private JTextField textField_TenNhomHT;
	private JSeparator separator_6;
	private JLabel label_3;
	private JSeparator separator_7;
	private JTextArea textArea_GHiChuNHT;
	private JSeparator separator_8;
	private JButton button_8;
	private JMenu mnThm_1;
	private JLabel label_4;
	private JTextField textField_TenNhomHT2;
	private JSeparator separator_9;
	private JLabel label_5;
	private JSeparator separator_10;
	private JTextArea textArea_GHiChuNHT2;
	private JSeparator separator_11;
	private JButton button_luupt;
	private JMenu mnXa;
	private Vector<Integer> ListChecked = new Vector<Integer>();
	private Vector<NhomHang> danhSach;
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
					QuanLiNhomHang frame = new QuanLiNhomHang();
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
	public QuanLiNhomHang() throws Exception {
		setFrameIcon(new ImageIcon("media/images/nhomhang-icon.png"));
		setTitle("Qu\u1EA3n l\u00ED nh\u00F3m h\u00E0ng");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_DuLieu = new JPanel();
		getContentPane().add(panel_DuLieu, BorderLayout.NORTH);
		panel_DuLieu.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "D\u1EEF Li\u1EC7u", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_panel_DuLieu = new GridBagLayout();
		gbl_panel_DuLieu.columnWidths = new int[]{0, 0, 0};
		gbl_panel_DuLieu.rowHeights = new int[]{0, 50, 0, 0, 0, 0};
		gbl_panel_DuLieu.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_DuLieu.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_DuLieu.setLayout(gbl_panel_DuLieu);
		textField_TenNhomHang = new JTextField();
		GridBagConstraints gbc_textField_TenNhomHang = new GridBagConstraints();
		gbc_textField_TenNhomHang.insets = new Insets(0, 0, 5, 0);
		gbc_textField_TenNhomHang.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_TenNhomHang.gridx = 1;
		gbc_textField_TenNhomHang.gridy = 0;
		panel_DuLieu.add(textField_TenNhomHang, gbc_textField_TenNhomHang);
		textField_TenNhomHang.setColumns(10);
		
		JLabel lblGhiCh = new JLabel("Ghi ch\u00FA:");
		GridBagConstraints gbc_lblGhiCh = new GridBagConstraints();
		gbc_lblGhiCh.anchor = GridBagConstraints.WEST;
		gbc_lblGhiCh.insets = new Insets(0, 0, 5, 5);
		gbc_lblGhiCh.gridx = 0;
		gbc_lblGhiCh.gridy = 1;
		panel_DuLieu.add(lblGhiCh, gbc_lblGhiCh);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		panel_DuLieu.add(scrollPane, gbc_scrollPane);
		
		textArea_GhiChu = new JTextArea();
		scrollPane.setViewportView(textArea_GhiChu);
		
		lblThongBao = new JLabel("");
		GridBagConstraints gbc_lblThongBao = new GridBagConstraints();
		gbc_lblThongBao.insets = new Insets(0, 0, 5, 0);
		gbc_lblThongBao.gridx = 1;
		gbc_lblThongBao.gridy = 3;
		panel_DuLieu.add(lblThongBao, gbc_lblThongBao);
		
		final JPanel panel_TacVu = new JPanel();
		panel_TacVu.setBorder(new TitledBorder(null, "T\u00E1c V\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_TacVu = new GridBagConstraints();
		gbc_panel_TacVu.gridwidth = 2;
		gbc_panel_TacVu.fill = GridBagConstraints.BOTH;
		gbc_panel_TacVu.gridx = 0;
		gbc_panel_TacVu.gridy = 4;
		panel_DuLieu.add(panel_TacVu, gbc_panel_TacVu);
		panel_TacVu.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		menuBar = new JMenuBar();
		panel_TacVu.add(menuBar);
		
		spr = new JButton("");
		menuBar.add(spr);
		
		mnThm = new JMenu("Thêm");
		mnThm.setIcon(new ImageIcon("media/images/add.png"));
		menuBar.add(mnThm);
		
		label_2 = new JLabel("Tên nhóm hàng:");
		label_2.setAlignmentX(1.0f);
		mnThm.add(label_2);
		
		textField_TenNhomHT = new JTextField();
		textField_TenNhomHT.setColumns(50);
		mnThm.add(textField_TenNhomHT);
		
		separator_6 = new JSeparator();
		mnThm.add(separator_6);
		
		label_3 = new JLabel("Ghi chú:      ");
		label_3.setAlignmentX(1.0f);
		mnThm.add(label_3);
		
		separator_7 = new JSeparator();
		mnThm.add(separator_7);
		
		textArea_GHiChuNHT = new JTextArea();
		textArea_GHiChuNHT.setRows(2);
		mnThm.add(textArea_GHiChuNHT);
		
		separator_8 = new JSeparator();
		mnThm.add(separator_8);
		
		button_8 = new JButton("Lưu");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					luuT1();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_8.setIcon(new ImageIcon("media/images/Save.png"));
		button_8.setAlignmentX(1.0f);
		mnThm.add(button_8);
		
		spr2 = new JButton("");
		menuBar.add(spr2);
		
		menu = new JMenu("Sửa");
		menu.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		menu.setIcon(new ImageIcon("media/images/Edit.png"));
		menuBar.add(menu);
		
		label = new JLabel("Tên nhóm hàng:");
		label.setAlignmentX(1.0f);
		menu.add(label);
		
		textField_TenNhomHS = new JTextField();
		textField_TenNhomHS.setColumns(50);
		menu.add(textField_TenNhomHS);
		
		separator_3 = new JSeparator();
		menu.add(separator_3);
		
		label_1 = new JLabel("Ghi chú:      ");
		label_1.setAlignmentX(1.0f);
		menu.add(label_1);
		
		separator_4 = new JSeparator();
		menu.add(separator_4);
		
		textArea_GhiChuS = new JTextArea();
		textArea_GhiChuS.setRows(2);
		menu.add(textArea_GhiChuS);
		
		separator_5 = new JSeparator();
		menu.add(separator_5);
		
		button = new JButton("Lưu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					sua1();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button.setIcon(new ImageIcon("media/images/Save.png"));
		button.setAlignmentX(1.0f);
		menu.add(button);
		
		spr3 = new JButton("");
		menuBar.add(spr3);
		
		mnXa = new JMenu("Xóa");
		mnXa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					xoa();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnXa.setIcon(new ImageIcon("media/images/delete.png"));
		menuBar.add(mnXa);
		spr4 = new JButton("");
		menuBar.add(spr4);
		mnXutExcel = new JMenu("Xuất Excel");
		mnXutExcel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					xuatExcel();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		mnXutExcel.setIcon(new ImageIcon("media/images/excel.png"));
		menuBar.add(mnXutExcel);
		spr5 = new JButton("");
		menuBar.add(spr5);
		
		JPanel panel_DanhSach = new JPanel();
		panel_DanhSach.setBorder(new TitledBorder(null, "Danh s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_DanhSach, BorderLayout.CENTER);
		GridBagLayout gbl_panel_DanhSach = new GridBagLayout();
		gbl_panel_DanhSach.columnWidths = new int[]{0, 0};
		gbl_panel_DanhSach.rowHeights = new int[]{0, 0, 0};
		gbl_panel_DanhSach.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_DanhSach.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_DanhSach.setLayout(gbl_panel_DanhSach);
		
		chckbxCheckall = new JCheckBox("Chọn tất cả");
		chckbxCheckall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CheckRow();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_chckbxCheckall = new GridBagConstraints();
		gbc_chckbxCheckall.anchor = GridBagConstraints.WEST;
		gbc_chckbxCheckall.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxCheckall.gridx = 0;
		gbc_chckbxCheckall.gridy = 0;
		panel_DanhSach.add(chckbxCheckall, gbc_chckbxCheckall);
		
		JScrollPane scrollPane_DanhSach = new JScrollPane();
		
		
		GridBagConstraints gbc_scrollPane_DanhSach = new GridBagConstraints();
		gbc_scrollPane_DanhSach.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_DanhSach.gridx = 0;
		gbc_scrollPane_DanhSach.gridy = 1;
		panel_DanhSach.add(scrollPane_DanhSach, gbc_scrollPane_DanhSach);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				loadLuoiTable();
			}
		});
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
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(450);
		table.getColumnModel().getColumn(4).setPreferredWidth(0);
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getColumnModel().getColumn(4).setMaxWidth(0);
		scrollPane_DanhSach.setViewportView(table);
		JPanel panel_PhanTrang = new JPanel();
		getContentPane().add(panel_PhanTrang, BorderLayout.SOUTH);
		if (QLNhomHangProcess.getsoNhomHang() > 0) {
			soTrang = 1;
		}
		comboBox_SoTrang = new JComboBox();
		comboBox_SoTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(comboBox_SoTrang.getSelectedItem());
				soTrang = (Integer) comboBox_SoTrang.getSelectedItem();
				try {
					loaddata();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				comboBox_SoTrang.setSelectedItem(soTrang);
				
			}
		});
		btnTrc = new JButton("");
		btnTrc.setIcon(new ImageIcon("media/images/prev.png"));
		btnTrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_SoTrang.setSelectedItem(soTrang-1);
			}
		});
		panel_PhanTrang.add(btnTrc);
		panel_PhanTrang.add(comboBox_SoTrang);
		
		btnSau = new JButton("");
		btnSau.setIcon(new ImageIcon("media/images/next.png"));
		btnSau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_SoTrang.setSelectedItem(soTrang+1);
			}
		});
		popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);
		addPopup(scrollPane_DanhSach, popupMenu);
		
		mntmXa = new JMenuItem("Xóa");
		mntmXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					xoa();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		mnThm_1 = new JMenu("Thêm");
		mnThm_1.setIcon(new ImageIcon("media/images/add.png"));
		popupMenu.add(mnThm_1);
		
		label_4 = new JLabel("Tên nhóm hàng:");
		label_4.setAlignmentX(1.0f);
		mnThm_1.add(label_4);
		
		textField_TenNhomHT2 = new JTextField();
		textField_TenNhomHT2.setColumns(50);
		mnThm_1.add(textField_TenNhomHT2);
		
		separator_9 = new JSeparator();
		mnThm_1.add(separator_9);
		
		label_5 = new JLabel("Ghi chú:      ");
		label_5.setAlignmentX(1.0f);
		mnThm_1.add(label_5);
		
		separator_10 = new JSeparator();
		mnThm_1.add(separator_10);
		
		textArea_GHiChuNHT2 = new JTextArea();
		textArea_GHiChuNHT2.setRows(2);
		mnThm_1.add(textArea_GHiChuNHT2);
		
		separator_11 = new JSeparator();
		mnThm_1.add(separator_11);
		
		button_luupt = new JButton("Lưu");
		button_luupt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					luuT2();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		button_luupt.setIcon(new ImageIcon("media/images/Save.png"));
		button_luupt.setAlignmentX(1.0f);
		mnThm_1.add(button_luupt);
		
		mnSa = new JMenu("Sửa");
		mnSa.setIcon(new ImageIcon("media/images/Edit.png"));
		popupMenu.add(mnSa);
		
		lblTnNhmHng = new JLabel("Tên nhóm hàng:");
		lblTnNhmHng.setAlignmentX(Component.RIGHT_ALIGNMENT);
		mnSa.add(lblTnNhmHng);
		
		textField_TenNHS2 = new JTextField();
		mnSa.add(textField_TenNHS2);
		textField_TenNHS2.setColumns(50);
		
		separator = new JSeparator();
		mnSa.add(separator);
		
		lblGhiCh_1 = new JLabel("Ghi chú:      ");
		lblGhiCh_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		mnSa.add(lblGhiCh_1);
		
		separator_1 = new JSeparator();
		mnSa.add(separator_1);
		
		textArea_GhiChuS2 = new JTextArea();
		textArea_GhiChuS2.setRows(2);
		mnSa.add(textArea_GhiChuS2);
		
		separator_2 = new JSeparator();
		mnSa.add(separator_2);
		
		btnluups = new JButton("Lưu");
		btnluups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					sua2();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnluups.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnluups.setIcon(new ImageIcon("media/images/Save.png"));
		mnSa.add(btnluups);
		mntmXa.setIcon(new ImageIcon("media/images/delete.png"));
		mntmXa.setAccelerator(KeyStroke.getKeyStroke("DELETE"));
		popupMenu.add(mntmXa);
		panel_PhanTrang.add(btnSau);
		loaddata();
		textField_TenNhomHang.setEditable(false);
		textArea_GhiChu.setEditable(false);
	}

	public void xuatExcel() throws Exception {
		WriteExcel test = new WriteExcel();
		danhSach = QLNhomHangProcess.getListNhomHang(soTrang);
		Vector<Vector<String>> duLieu = new Vector<Vector<String>>();
		for (int i = 0; i < danhSach.size(); i++) {
			Vector<String> phanTu = new Vector<String>();
			phanTu.add(danhSach.get(i).getsTenNhomHang());
			phanTu.add(danhSach.get(i).getID().toString());
			phanTu.add(danhSach.get(i).getsGhiChu());
			duLieu.add(phanTu);
		}
		test.write(8, 1, duLieu, "TempNhomHang.xls");
	}
	public void CheckRow() throws Exception{
		/*
		if (chckbxCheckall.isSelected()) {
			for (int i = 0; i < 10; i++) {
				Integer coCheck =0;
				 if (ListChecked.size() ==0) {
					 ListChecked.add((Integer) table.getModel().getValueAt(i, 4));
				}else{
					for (int j = 0; j < ListChecked.size(); j++) {
						if (ListChecked.get(j) ==((Integer) table.getModel().getValueAt(i, 4))) {
							coCheck = 1;
						}
					}
					if (coCheck == 0) {
						ListChecked.add((Integer) table.getModel().getValueAt(i, 4));
					}
				}
			}
		}
		loaddata();
		*/
	}
	public void saveChecked() {
		Integer coCheck =0;
		if ((Boolean) table.getModel().getValueAt(table.getSelectedRow(), 0)) {
			 if (ListChecked.size() ==0) {
				 ListChecked.add((Integer) table.getModel().getValueAt(table.getSelectedRow(), 4));
			}else{
				for (int i = 0; i < ListChecked.size(); i++) {
					if (ListChecked.get(i) ==((Integer) table.getModel().getValueAt(table.getSelectedRow(), 4))) {
						coCheck = 1;
					}
				}
				if (coCheck == 0) {
					ListChecked.add((Integer) table.getModel().getValueAt(table.getSelectedRow(), 4));
				}
			}
		}else {
			if (ListChecked.size() != 0) {
				for (int i = 0; i < ListChecked.size(); i++) {
					if (ListChecked.get(i) ==(Integer) table.getModel().getValueAt(table.getSelectedRow(), 4)) {
						ListChecked.removeElementAt(i);
					}
				}
			}
		}	
	}

	public void  xoa() throws Exception {
		if (ListChecked.size() == 0) {
			JOptionPane.showMessageDialog(new JFrame(), "Bạn phải chọn đối tượng muốn xóa !", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}else {
			int yN = JOptionPane.showConfirmDialog(new JFrame(), "Bạn có chắc là muốn xóa: "+ListChecked.size()+"Nhom hang vua chon ?", "Xóa", JOptionPane.YES_NO_OPTION);
			if (yN == 0) {
				for (int i = 0; i < ListChecked.size(); i++) {
					QLNhomHangProcess.XoaNhomHang(ListChecked.get(i));
				}
				comboBox_SoTrang.setSelectedItem(1);
			}
		}
//		if (	table.isRowSelected(0) ||
//				table.isRowSelected(1) ||
//				table.isRowSelected(2) ||
//				table.isRowSelected(3) ||
//				table.isRowSelected(4) ||
//				table.isRowSelected(5) ||
//				table.isRowSelected(6) ||
//				table.isRowSelected(7) ||
//				table.isRowSelected(8) ||
//				table.isRowSelected(9) ) {
//		int yN = JOptionPane.showConfirmDialog(new JFrame(), "Bạn có chắc là muốn xóa:"+textField_TenNhomHang.getText()+" ?", "Xóa", JOptionPane.YES_NO_OPTION);
//		if (yN == 0) {
//
//			QLNhomHangProcess.XoaNhomHang((Integer) table.getModel().getValueAt(table.getSelectedRow(), 4));
//			comboBox_SoTrang.setSelectedItem(1);
//		}
//		}else{
//			
//		
//		}
	}
	public void luuT1() throws Exception {
		iLoi = 0;
		err = "\n";
		if ((CheckString.Address(textField_TenNhomHT.getText(), 50, 1)) == false) {
			iLoi = 1;
			err = err+"Độ dài tên nhóm hàng hoặc ký tự sai \n";
		}
		if (((QLNhomHangProcess.checkTenNhomHang(textField_TenNhomHT.getText()))== false)) {
			iLoi = 1;
			err = err+"Tên nhóm hàng đã tồn tại \n";
		}	
		if (textArea_GHiChuNHT.getText().length() > 100) {
			iLoi = 1;
			err = err+"Độ dài ghichus quá lớn";
		}
		if (iLoi == 1) {
			JOptionPane.showMessageDialog(new JFrame(), "Lỗi dữ liệu nhập vào:"+err, "Không thực hiện được thao tác!", JOptionPane.ERROR_MESSAGE);
		}
		if (iLoi == 0) {
			JOptionPane.showMessageDialog(new JFrame(), "thành công !", "Thành công", JOptionPane.INFORMATION_MESSAGE);
			NhomHang nhomHang = new NhomHang();
			nhomHang.setsTenNhomHang(textField_TenNhomHT.getText());
			nhomHang.setsTenNhomHangEng(TiengVietToEg.convert(textField_TenNhomHT.getText()));
			nhomHang.setsGhiChu(textArea_GHiChuNHT.getText());
			QLNhomHangProcess.ThemNhomHang(nhomHang);
			comboBox_SoTrang.setSelectedItem(1);
			textField_TenNhomHT.setText("");
			textArea_GHiChuNHT.setText("");
			soTrang = 1;
			loaddata();
		}
	}
	public void luuT2() throws Exception {
		iLoi = 0;
		err = "\n";
		if ((CheckString.Address(textField_TenNhomHT2.getText(), 50, 1)) == false) {
			iLoi = 1;
			err = err+"Độ dài tên nhóm hàng hoặc ký tự sai \n";
		}
		if (((QLNhomHangProcess.checkTenNhomHang(textField_TenNhomHT2.getText()))== false)) {
			iLoi = 1;
			err = err+"Tên nhóm hàng đã tồn tại \n";
		}	
		if (textArea_GHiChuNHT2.getText().length() > 100) {
			iLoi = 1;
			err = err+"Độ dài ghichus quá lớn";
		}
		if (iLoi == 1) {
			JOptionPane.showMessageDialog(new JFrame(), "Lỗi dữ liệu nhập vào:"+err, "Không thực hiện được thao tác!", JOptionPane.ERROR_MESSAGE);
		}
		if (iLoi == 0) {
			JOptionPane.showMessageDialog(new JFrame(), "thành công !", "Thành công", JOptionPane.INFORMATION_MESSAGE);
			NhomHang nhomHang = new NhomHang();
			nhomHang.setsTenNhomHang(textField_TenNhomHT2.getText());
			nhomHang.setsTenNhomHangEng(TiengVietToEg.convert(textField_TenNhomHT2.getText()));
			nhomHang.setsGhiChu(textArea_GHiChuNHT2.getText());
			QLNhomHangProcess.ThemNhomHang(nhomHang);
			comboBox_SoTrang.setSelectedItem(1);
			textField_TenNhomHT2.setText("");
			textArea_GHiChuNHT2.setText("");
			soTrang = 1;
			loaddata();
		}
	}
	public void sua1() throws Exception {
		if (	table.isRowSelected(0) ||
				table.isRowSelected(1) ||
				table.isRowSelected(2) ||
				table.isRowSelected(3) ||
				table.isRowSelected(4) ||
				table.isRowSelected(5) ||
				table.isRowSelected(6) ||
				table.isRowSelected(7) ||
				table.isRowSelected(8) ||
				table.isRowSelected(9) ) {
			iLoi = 0;
			err = "\n";
			if ((CheckString.Address(textField_TenNhomHS.getText(), 50, 1)) == false) {
				iLoi = 1;
				err = err+"Độ dài tên nhóm hàng hoặc ký tự sai \n";
			}
			if (((QLNhomHangProcess.checkTenNhomHangEdit(textField_TenNhomHang.getText(),textField_TenNhomHS.getText()))== false)) {
				iLoi = 1;
				err = err+"Tên nhóm hàng đã tồn tại \n";
			}	
			if (textArea_GhiChuS.getText().length() > 100) {
				iLoi = 1;
				err = err+"Độ dài ghi chú quá lớn";
			}
			if (iLoi == 1) {
				JOptionPane.showMessageDialog(new JFrame(), "Lỗi dữ liệu nhập vào:"+err, "Không thực hiện được thao tác!", JOptionPane.ERROR_MESSAGE);
			}
			if (iLoi == 0) {
				JOptionPane.showMessageDialog(new JFrame(), "thành công !", "Thành công", JOptionPane.INFORMATION_MESSAGE);
				NhomHang nhomHang = new NhomHang();
				nhomHang.setsTenNhomHang(textField_TenNhomHS.getText());
				nhomHang.setsTenNhomHangEng(TiengVietToEg.convert(textField_TenNhomHS.getText()));
				nhomHang.setsGhiChu(textArea_GhiChuS.getText());
				QLNhomHangProcess.SuaNhomHang(nhomHang, ((Integer)table.getModel().getValueAt(table.getSelectedRow(), 4)));
				comboBox_SoTrang.setSelectedItem(1);
				loaddata();
			}
			
		}else{
		JOptionPane.showMessageDialog(new JFrame(), "Bạn phải chọn đối tượng muốn sửa trrong bảng !", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void sua2() throws Exception {
		if (	table.isRowSelected(0) ||
				table.isRowSelected(1) ||
				table.isRowSelected(2) ||
				table.isRowSelected(3) ||
				table.isRowSelected(4) ||
				table.isRowSelected(5) ||
				table.isRowSelected(6) ||
				table.isRowSelected(7) ||
				table.isRowSelected(8) ||
				table.isRowSelected(9) ) {
			iLoi = 0;
			err = "\n";
			if ((CheckString.Address(textField_TenNHS2.getText(), 50, 1)) == false) {
				iLoi = 1;
				err = err+"Độ dài tên nhóm hàng hoặc ký tự sai \n";
			}
			if (((QLNhomHangProcess.checkTenNhomHangEdit(textField_TenNhomHang.getText(),textField_TenNHS2.getText()))== false)) {
				iLoi = 1;
				err = err+"Tên nhóm hàng đã tồn tại \n";
			}	
			if (textArea_GhiChuS2.getText().length() > 100) {
				iLoi = 1;
				err = err+"Độ dài ghi chú quá lớn";
			}
			if (iLoi == 1) {
				JOptionPane.showMessageDialog(new JFrame(), "Lỗi dữ liệu nhập vào:"+err, "Không thực hiện được thao tác!", JOptionPane.ERROR_MESSAGE);
			}
			if (iLoi == 0) {
				JOptionPane.showMessageDialog(new JFrame(), "thành công !", "Thành công", JOptionPane.INFORMATION_MESSAGE);
				NhomHang nhomHang = new NhomHang();
				nhomHang.setsTenNhomHang(textField_TenNHS2.getText());
				nhomHang.setsTenNhomHangEng(TiengVietToEg.convert(textField_TenNHS2.getText()));
				nhomHang.setsGhiChu(textArea_GhiChuS2.getText());
				QLNhomHangProcess.SuaNhomHang(nhomHang, ((Integer)table.getModel().getValueAt(table.getSelectedRow(), 4)));
				comboBox_SoTrang.setSelectedItem(1);
				loaddata();
			}
			
		}else{
		JOptionPane.showMessageDialog(new JFrame(), "Bạn phải chọn đối tượng muốn sửa trrong bảng !", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void loaddata() throws Exception {
		
		soLuongNH = QLNhomHangProcess.getsoNhomHang();
		if ((soLuongNH % 10) == 0 ) {
			Combo((soLuongNH / 10));
		}else Combo((soLuongNH / 10)+1);
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		danhSach = QLNhomHangProcess.getListNhomHang(soTrang);
		//System.out.println(danhSach.size());
		sTT = (soTrang-1)*10+1;
		if (ListChecked.size() == 0) {
			for (int i = 0; i < danhSach.size(); i++) {
				Object[] oPerson = {false,sTT,
									danhSach.get(i).getsTenNhomHang(),
									danhSach.get(i).getsGhiChu(),
									danhSach.get(i).getID(),
									};
				sTT++;
				model.insertRow(i, oPerson);
			}
		}else {
			for (int i = 0; i < danhSach.size(); i++) {
				Integer coCheck = 0;
				for (int j = 0; j < ListChecked.size(); j++) {
					if (ListChecked.get(j) == danhSach.get(i).getID()) {
						Object[] oPerson = {true,sTT,
								danhSach.get(i).getsTenNhomHang(),
								danhSach.get(i).getsGhiChu(),
								danhSach.get(i).getID(),
								};
						sTT++;
						model.insertRow(i, oPerson);
						coCheck = 1;
						break;
					}
				}
			if (coCheck == 0) {
				Object[] oPerson = {false,sTT,
						danhSach.get(i).getsTenNhomHang(),
						danhSach.get(i).getsGhiChu(),
						danhSach.get(i).getID(),
						};
				sTT++;
				model.insertRow(i, oPerson);
			}
			}
		}
		model.fireTableDataChanged();
	}
	public void loadLuoiTable(){ 
		int row = table.getSelectedRow();  
		String i = (table.getModel().getValueAt(row, 2)).toString();
		textField_TenNhomHang.setText(i);
		textArea_GhiChu.setText(((String)table.getModel().getValueAt(row, 3)));
		saveChecked();
	}
	public void Combo(int numItems)
	{
		Vector v = new Vector(numItems);
		for (int i = 1; i <= numItems; i++) {
			v.add(new Integer(i));
		}
		DefaultComboBoxModel model = new DefaultComboBoxModel(v);
		comboBox_SoTrang.setModel(model);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub	
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
			
		});
	}
}
