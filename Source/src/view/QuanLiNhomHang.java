package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;

import module.ThongBao;
import module.TiengVietToEg;
import myobject.NhomHang;
import process.QLNhomHangProcess;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLiNhomHang extends JInternalFrame implements ActionListener {
	public QuanLiNhomHang() throws Exception {
		setFrameIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\nhomhang-icon.png"));
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
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_DuLieu.add(textField, gbc_textField);
		textField.setColumns(10);
		
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
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		lblThongBao = new JLabel("");
		GridBagConstraints gbc_lblThongBao = new GridBagConstraints();
		gbc_lblThongBao.insets = new Insets(0, 0, 5, 0);
		gbc_lblThongBao.gridx = 1;
		gbc_lblThongBao.gridy = 3;
		panel_DuLieu.add(lblThongBao, gbc_lblThongBao);
		
		JPanel panel_TacVu = new JPanel();
		panel_TacVu.setBorder(new TitledBorder(null, "T\u00E1c V\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_TacVu = new GridBagConstraints();
		gbc_panel_TacVu.gridwidth = 2;
		gbc_panel_TacVu.fill = GridBagConstraints.BOTH;
		gbc_panel_TacVu.gridx = 0;
		gbc_panel_TacVu.gridy = 4;
		panel_DuLieu.add(panel_TacVu, gbc_panel_TacVu);
		
		btnThm = new JButton("Th\u00EAm");
		btnThm.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\add.png"));
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iThem = 1;
				button();
			}
		});
		panel_TacVu.add(btnThm);
		
		btnSa = new JButton("S\u1EEDa");
		btnSa.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\Edit.png"));
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iSua = 1;
				button();
			}
		});
		panel_TacVu.add(btnSa);
		
		btnXa = new JButton("X\u00F3a");
		btnXa.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\delete.png"));
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iXoa = 1;
				button();
			}
			
		});
		panel_TacVu.add(btnXa);
		
		btnLu = new JButton("L\u01B0u");
		btnLu.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\Save.png"));
		btnLu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Check();
					if(iLoi == 0){
						luu();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel_TacVu.add(btnLu);
		
		btnHy = new JButton("H\u1EE7y");
		btnHy.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\cancel.png"));
		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				huy();
			}
		});
		panel_TacVu.add(btnHy);
		
		btnXuat = new JButton("Xuất Excel");
		btnXuat.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\excel.png"));
		panel_TacVu.add(btnXuat);
		
		JPanel panel_DanhSach = new JPanel();
		panel_DanhSach.setBorder(new TitledBorder(null, "Danh s\u00E1ch", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_DanhSach, BorderLayout.CENTER);
		GridBagLayout gbl_panel_DanhSach = new GridBagLayout();
		gbl_panel_DanhSach.columnWidths = new int[]{0, 0};
		gbl_panel_DanhSach.rowHeights = new int[]{0, 0};
		gbl_panel_DanhSach.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_DanhSach.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_DanhSach.setLayout(gbl_panel_DanhSach);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panel_DanhSach.add(scrollPane_1, gbc_scrollPane_1);
		
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
				Boolean.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, true
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
		scrollPane_1.setViewportView(table);
		
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
		btnTrc.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\prev.png"));
		btnTrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_SoTrang.setSelectedItem(soTrang-1);
			}
		});
		panel_PhanTrang.add(btnTrc);
		panel_PhanTrang.add(comboBox_SoTrang);
		
		btnSau = new JButton("");
		btnSau.setIcon(new ImageIcon("T:\\BT\\PJQLBH\\Source\\media\\images\\next.png"));
		btnSau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_SoTrang.setSelectedItem(soTrang+1);
			}
		});
		panel_PhanTrang.add(btnSau);
		huy();
		loaddata();
	}

	public void button() {
		if (iThem == 1) {
			btnHy.setEnabled(true);
			btnLu.setEnabled(true);
			btnSa.setEnabled(false);
			btnXa.setEnabled(false);
			textArea.setEnabled(true);
			textField.setEnabled(true);
		}
		if (iSua == 1) {
			btnHy.setEnabled(true);
			btnLu.setEnabled(true);
			btnThm.setEnabled(false);
			btnXa.setEnabled(false);
		}
		if (iXoa == 1) {
			btnHy.setEnabled(true);
			btnLu.setEnabled(true);
			btnSa.setEnabled(false);
			btnThm.setEnabled(false);
		}
	}
	public void huy() {
		btnHy.setEnabled(false);
		btnLu.setEnabled(false);
		iThem = 0;
		iSua = 0;
		iXoa = 0;
		btnThm.setEnabled(true);
		btnSa.setEnabled(true);
		btnXa.setEnabled(true);
		textArea.setEnabled(false);
		textField.setEnabled(false);
		new ThongBao(lblThongBao, Color.RED, "");
	}
	public void luu() throws Exception {

		if (iThem == 1) {
			Check();
			if (iLoi == 1) {
				JOptionPane dlg = new JOptionPane("cbff");
			}
			else {
				JOptionPane dlg = new JOptionPane("Complete !");
			}
			NhomHang nhomHang = new NhomHang();
			nhomHang.setsTenNhomHang(textField.getText());
			nhomHang.setsTenNhomHangEng(TiengVietToEg.convert(textField.getText()));
			nhomHang.setsGhiChu(textArea.getText());
			QLNhomHangProcess.ThemNhomHang(nhomHang);
			comboBox_SoTrang.setSelectedItem(1);
		}
	}
	public void Check() {
		iLoi = 0;
		try {
			if ((textField.getText().length() >50)||((QLNhomHangProcess.checkTenNhomHang(textField.getText()))== false)) {
				new ThongBao(lblThongBao, Color.RED, "Ten Nhom hang qua dai hoac da ton tai !");
				iLoi = 1;
			}else {
				//new ThongBao(lblThongBao, Color.BLUE, "Ten Nhom hang hop le !");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (textArea.getText().length() > 100) {
			new ThongBao(lblThongBao, Color.RED, "Ghi chu qua dai dong !");
			iLoi = 1;
		}
		
		if (iLoi == 1) {
			
		}else {
			btnLu.setEnabled(true);
			new ThongBao(lblThongBao, Color.RED, "");
		}
	}
	public void loaddata() throws Exception {
		
		soLuongNH = QLNhomHangProcess.getsoNhomHang();
		if ((soLuongNH % 10) == 0 ) {
			Combo((soLuongNH / 10));
		}else Combo((soLuongNH / 10)+1);
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		Vector<NhomHang> danhSach;
		danhSach = QLNhomHangProcess.getListNhomHang(soTrang);
		System.out.println(danhSach.size());
		sTT = (soTrang-1)*10+1;
		for (int i = 0; i < danhSach.size(); i++) {
			Object[] oPerson = {false,sTT,
								danhSach.get(i).getsTenNhomHang(),
								danhSach.get(i).getsGhiChu(),
								danhSach.get(i).getID(),
								};
			sTT++;
			model.insertRow(i, oPerson);
		}
		model.fireTableDataChanged();
	}
	public void loadLuoiTable(){
		int col = table.getSelectedColumn();  
		int row = table.getSelectedRow();  
		textField.setText(((String)table.getModel().getValueAt(row, 2)));
		textArea.setText(((String)table.getModel().getValueAt(row, 3)));
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
	
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private JTextField textField;
	private JTextArea textArea;
	private JTable table;
	private JButton btnSau,btnTrc,btnThm,btnSa,btnXa,btnLu,btnHy;
	private JComboBox comboBox_SoTrang;
	private Integer soTrang =0,iThem,iSua,iXoa,sTT,soLuongNH = null,iLoi = 0;
	private JLabel lblThongBao;
	private QLNhomHangProcess QLNhomHangProcess = new QLNhomHangProcess();
	private JButton btnXuat;
	DefaultTableModel model;
	
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
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub	
	}
}
