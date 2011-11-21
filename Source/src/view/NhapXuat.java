package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JComboBox;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NhapXuat extends JDialog {

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private final JPanel contentPanel = new JPanel();
	private JTextField textField,comboBox;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;
	private JPanel panel_NhanVien,panel;
	private JButton btnng,btnBQua,btnTmKim,button_1;
	private JComboBox comboBox_2,comboBoxpt;
	private JScrollPane scrollPane;
	private JLabel lblMMtHng;
	private JTextField txtMMtHng;
	private Integer loi;
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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			installLnF();
			QuanLiNhapXuat quanLiNhapXuat = new QuanLiNhapXuat();
			NhapXuat dialog = new NhapXuat(quanLiNhapXuat);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void closeDialog(){
		this.setVisible(false);
	}
	public void check() {
		loi = 0;
		if (loi == 0) {
			closeDialog();
		}else {
			JOptionPane.showMessageDialog(this, "Lỗi dữ liệu nhập vào !\n", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public void loaddata() {
		
	}
	public NhapXuat(QuanLiNhapXuat quanLiNhapXuat) throws Exception {
		setTitle("Thêm hàng vào danh sách Nhập/Xuất");
		setIconImage(Toolkit.getDefaultToolkit().getImage("media/images/add.png"));
		setBounds(200, 200, 803, 496);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		lblMMtHng = new JLabel("Mã mặt hàng:");
		lblMMtHng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblMMtHng = new GridBagConstraints();
		gbc_lblMMtHng.anchor = GridBagConstraints.EAST;
		gbc_lblMMtHng.insets = new Insets(0, 0, 5, 5);
		gbc_lblMMtHng.gridx = 0;
		gbc_lblMMtHng.gridy = 0;
		contentPanel.add(lblMMtHng, gbc_lblMMtHng);
		
		txtMMtHng = new JTextField();
		txtMMtHng.setText("Mã mặt hàng");
		txtMMtHng.setEditable(false);
		txtMMtHng.setDisabledTextColor(Color.BLACK);
		GridBagConstraints gbc_txtMMtHng = new GridBagConstraints();
		gbc_txtMMtHng.gridwidth = 4;
		gbc_txtMMtHng.insets = new Insets(0, 0, 5, 5);
		gbc_txtMMtHng.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMMtHng.gridx = 1;
		gbc_txtMMtHng.gridy = 0;
		contentPanel.add(txtMMtHng, gbc_txtMMtHng);
		
		JLabel lblTnMtHng = new JLabel("Tên mặt hàng:");
		lblTnMtHng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblTnMtHng = new GridBagConstraints();
		gbc_lblTnMtHng.insets = new Insets(0, 0, 5, 5);
		gbc_lblTnMtHng.anchor = GridBagConstraints.EAST;
		gbc_lblTnMtHng.gridx = 0;
		gbc_lblTnMtHng.gridy = 1;
		contentPanel.add(lblTnMtHng, gbc_lblTnMtHng);
		
		comboBox = new JTextField();
		comboBox.setText("Tên mặt hàng");
		comboBox.setEditable(false);
		comboBox.setDisabledTextColor(new Color(0, 0, 0));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		contentPanel.add(comboBox, gbc_comboBox);
		
		JLabel lblSLng = new JLabel("Số lượng: ");
		lblSLng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblSLng = new GridBagConstraints();
		gbc_lblSLng.anchor = GridBagConstraints.EAST;
		gbc_lblSLng.insets = new Insets(0, 0, 5, 5);
		gbc_lblSLng.gridx = 0;
		gbc_lblSLng.gridy = 2;
		contentPanel.add(lblSLng, gbc_lblSLng);
		
		textField = new JTextField();
		textField.setDisabledTextColor(new Color(0, 0, 0));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		contentPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblnGi = new JLabel("Đơn giá: ");
		lblnGi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblnGi = new GridBagConstraints();
		gbc_lblnGi.anchor = GridBagConstraints.EAST;
		gbc_lblnGi.insets = new Insets(0, 0, 5, 5);
		gbc_lblnGi.gridx = 0;
		gbc_lblnGi.gridy = 3;
		contentPanel.add(lblnGi, gbc_lblnGi);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Giá bán lẻ", "Giá bán buôn", "Giá mua"}));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 3;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 3;
		contentPanel.add(comboBox_1, gbc_comboBox_1);
		
		textField_1 = new JTextField();
		textField_1.setDisabledTextColor(new Color(0, 0, 0));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 3;
		contentPanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTngTin = new JLabel("Tổng tiền:");
		lblTngTin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblTngTin = new GridBagConstraints();
		gbc_lblTngTin.anchor = GridBagConstraints.EAST;
		gbc_lblTngTin.insets = new Insets(0, 0, 5, 5);
		gbc_lblTngTin.gridx = 0;
		gbc_lblTngTin.gridy = 4;
		contentPanel.add(lblTngTin, gbc_lblTngTin);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setDisabledTextColor(new Color(0, 0, 0));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridwidth = 4;
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 4;
		contentPanel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		btnng = new JButton("Đồng ý");
		btnng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				check();
				if (loi == 0) {
					
				}
			}
		});
		btnng.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnng.setForeground(new Color(0, 0, 255));
		btnng.setIcon(new ImageIcon("media/images/apply.png"));
		GridBagConstraints gbc_btnng = new GridBagConstraints();
		gbc_btnng.anchor = GridBagConstraints.EAST;
		gbc_btnng.insets = new Insets(0, 0, 5, 5);
		gbc_btnng.gridx = 0;
		gbc_btnng.gridy = 5;
		contentPanel.add(btnng, gbc_btnng);
		
		btnBQua = new JButton("Bỏ qua");
		btnBQua.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBQua.setForeground(new Color(0, 0, 255));
		btnBQua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				closeDialog();
			}
		});
		btnBQua.setIcon(new ImageIcon("media/images/Cancel2.png"));
		GridBagConstraints gbc_btnBQua = new GridBagConstraints();
		gbc_btnBQua.anchor = GridBagConstraints.WEST;
		gbc_btnBQua.insets = new Insets(0, 0, 5, 5);
		gbc_btnBQua.gridx = 1;
		gbc_btnBQua.gridy = 5;
		contentPanel.add(btnBQua, gbc_btnBQua);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 5;
		contentPanel.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		textField_3 = new JTextField();
		textField_3.setDisabledTextColor(new Color(0, 0, 0));
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.gridx = 0;
		gbc_textField_3.gridy = 0;
		panel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		btnTmKim = new JButton("Tìm kiếm");
		btnTmKim.setForeground(new Color(0, 0, 255));
		btnTmKim.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnTmKim.setIcon(new ImageIcon("media/images/search-icon.png"));
		btnTmKim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_2.showPopup();
			}
		});
		GridBagConstraints gbc_btnTmKim = new GridBagConstraints();
		gbc_btnTmKim.insets = new Insets(0, 0, 5, 5);
		gbc_btnTmKim.gridx = 1;
		gbc_btnTmKim.gridy = 0;
		panel.add(btnTmKim, gbc_btnTmKim);
		
		comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loaddata();
			}
		});
		comboBox_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		comboBox_2.setEnabled(false);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Theo tên hàng hóa", "Theo nhà sản xuất", "Theo đối tác", "Theo giá"}));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_2.gridx = 1;
		gbc_comboBox_2.gridy = 1;
		panel.add(comboBox_2, gbc_comboBox_2);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 6;
		contentPanel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "T\u00EAn m\u1EB7t h\u00E0ng", "Nh\u00F3m h\u00E0ng", "Nh\u00E0 s\u1EA3n xu\u1EA5t", "\u0110\u1ED1i t\u00E1c", "Gi\u00E1 mua", "Gi\u00E1 b\u00E1n bu\u00F4n", "Gi\u00E1 b\u00E1n l\u1EBB", "\u0110\u01A1n v\u1ECB t\u00EDnh", "Ng\u00E0y nh\u1EADp", "Ng\u00E0y h\u1EBFt h\u1EA1n", "S\u1ED1 l\u01B0\u1EE3ng c\u00F2n"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class, Float.class, Float.class, Float.class, String.class, String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setMinWidth(150);
		table.getColumnModel().getColumn(1).setMaxWidth(999);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setMinWidth(150);
		table.getColumnModel().getColumn(2).setMaxWidth(950);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setMinWidth(150);
		table.getColumnModel().getColumn(3).setMaxWidth(990);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setMinWidth(150);
		table.getColumnModel().getColumn(4).setMaxWidth(950);
		table.getColumnModel().getColumn(5).setMinWidth(75);
		table.getColumnModel().getColumn(5).setMaxWidth(999);
		table.getColumnModel().getColumn(6).setMinWidth(75);
		table.getColumnModel().getColumn(6).setMaxWidth(999);
		table.getColumnModel().getColumn(7).setMinWidth(75);
		table.getColumnModel().getColumn(7).setMaxWidth(975);
		table.getColumnModel().getColumn(8).setMinWidth(1);
		table.getColumnModel().getColumn(8).setMaxWidth(999);
		table.getColumnModel().getColumn(9).setPreferredWidth(100);
		table.getColumnModel().getColumn(9).setMinWidth(100);
		table.getColumnModel().getColumn(9).setMaxWidth(900);
		table.getColumnModel().getColumn(10).setPreferredWidth(100);
		table.getColumnModel().getColumn(10).setMinWidth(100);
		table.getColumnModel().getColumn(10).setMaxWidth(900);
		scrollPane.setViewportView(table);
		

		panel_NhanVien = new JPanel();
		JButton button = new JButton("");
		
		button.setIcon(new ImageIcon("media/images/prev.png"));
		panel_NhanVien.add(button);
		
		comboBoxpt = new JComboBox();
		panel_NhanVien.add(comboBoxpt);
		
		button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("media/images/next.png"));
		panel_NhanVien.add(button_1);
		GridBagConstraints gbc_panel8 = new GridBagConstraints();
		gbc_panel8.gridwidth = 5;
		gbc_panel8.fill = GridBagConstraints.BOTH;
		gbc_panel8.gridx = 0;
		gbc_panel8.gridy = 7;
		contentPanel.add(panel_NhanVien, gbc_panel8);
	}
}
