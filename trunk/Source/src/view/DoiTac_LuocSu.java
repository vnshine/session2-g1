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

public class DoiTac_LuocSu extends JDialog {

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JPanel panel_NhanVien;
	private JButton button_1;
	private JComboBox comboBoxpt;
	private JScrollPane scrollPane;
	private JLabel lblMMtHng;
	private JTextField txtMMtHng;
	private Integer loi;
	private JLabel lblGhiCh;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblTngSGiao;
	private JTextField textField_5;
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
			QuanLiDoiTac quanLiNhapXuat = new QuanLiDoiTac();
			DoiTac_LuocSu dialog = new DoiTac_LuocSu(quanLiNhapXuat);
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
	public DoiTac_LuocSu(QuanLiDoiTac quanLiDoiTac) throws Exception {
		setModal(true);
		setTitle("Lịch sử giao dịch");
		setIconImage(Toolkit.getDefaultToolkit().getImage("media/images/wall_clock_1_green_T.png"));
		setBounds(200, 200, 803, 496);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		lblMMtHng = new JLabel("Mã đối tác:");
		lblMMtHng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblMMtHng = new GridBagConstraints();
		gbc_lblMMtHng.anchor = GridBagConstraints.EAST;
		gbc_lblMMtHng.insets = new Insets(0, 0, 5, 5);
		gbc_lblMMtHng.gridx = 0;
		gbc_lblMMtHng.gridy = 0;
		contentPanel.add(lblMMtHng, gbc_lblMMtHng);
		
		txtMMtHng = new JTextField();
		txtMMtHng.setText("text");
		txtMMtHng.setEditable(false);
		txtMMtHng.setDisabledTextColor(Color.BLACK);
		GridBagConstraints gbc_txtMMtHng = new GridBagConstraints();
		gbc_txtMMtHng.gridwidth = 4;
		gbc_txtMMtHng.insets = new Insets(0, 0, 5, 0);
		gbc_txtMMtHng.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMMtHng.gridx = 1;
		gbc_txtMMtHng.gridy = 0;
		contentPanel.add(txtMMtHng, gbc_txtMMtHng);
		
		JLabel lblTnMtHng = new JLabel("Tên đối tác:");
		lblTnMtHng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblTnMtHng = new GridBagConstraints();
		gbc_lblTnMtHng.insets = new Insets(0, 0, 5, 5);
		gbc_lblTnMtHng.anchor = GridBagConstraints.EAST;
		gbc_lblTnMtHng.gridx = 0;
		gbc_lblTnMtHng.gridy = 1;
		contentPanel.add(lblTnMtHng, gbc_lblTnMtHng);
		
		textField = new JTextField();
		textField.setText("text");
		textField.setEditable(false);
		textField.setDisabledTextColor(Color.BLACK);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		contentPanel.add(textField, gbc_textField);
		
		JLabel lblSLng = new JLabel("Người liên hệ : ");
		lblSLng.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblSLng = new GridBagConstraints();
		gbc_lblSLng.anchor = GridBagConstraints.EAST;
		gbc_lblSLng.insets = new Insets(0, 0, 5, 5);
		gbc_lblSLng.gridx = 0;
		gbc_lblSLng.gridy = 2;
		contentPanel.add(lblSLng, gbc_lblSLng);
		
		textField_1 = new JTextField();
		textField_1.setText("text");
		textField_1.setEditable(false);
		textField_1.setDisabledTextColor(Color.BLACK);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		contentPanel.add(textField_1, gbc_textField_1);
		
		JLabel lblnGi = new JLabel("Số điện thoại : ");
		lblnGi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblnGi = new GridBagConstraints();
		gbc_lblnGi.anchor = GridBagConstraints.EAST;
		gbc_lblnGi.insets = new Insets(0, 0, 5, 5);
		gbc_lblnGi.gridx = 0;
		gbc_lblnGi.gridy = 3;
		contentPanel.add(lblnGi, gbc_lblnGi);
		
		textField_2 = new JTextField();
		textField_2.setText("text");
		textField_2.setEditable(false);
		textField_2.setDisabledTextColor(Color.BLACK);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 4;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 3;
		contentPanel.add(textField_2, gbc_textField_2);
		
		JLabel lblTngTin = new JLabel("Địa chỉ :");
		lblTngTin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblTngTin = new GridBagConstraints();
		gbc_lblTngTin.anchor = GridBagConstraints.EAST;
		gbc_lblTngTin.insets = new Insets(0, 0, 5, 5);
		gbc_lblTngTin.gridx = 0;
		gbc_lblTngTin.gridy = 4;
		contentPanel.add(lblTngTin, gbc_lblTngTin);
		
		textField_3 = new JTextField();
		textField_3.setText("text");
		textField_3.setEditable(false);
		textField_3.setDisabledTextColor(Color.BLACK);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 4;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 4;
		contentPanel.add(textField_3, gbc_textField_3);
		
		lblGhiCh = new JLabel("Ghi chú :");
		lblGhiCh.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblGhiCh = new GridBagConstraints();
		gbc_lblGhiCh.anchor = GridBagConstraints.EAST;
		gbc_lblGhiCh.insets = new Insets(0, 0, 5, 5);
		gbc_lblGhiCh.gridx = 0;
		gbc_lblGhiCh.gridy = 5;
		contentPanel.add(lblGhiCh, gbc_lblGhiCh);
		
		textField_4 = new JTextField();
		textField_4.setText("text");
		textField_4.setEditable(false);
		textField_4.setDisabledTextColor(Color.BLACK);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 4;
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 5;
		contentPanel.add(textField_4, gbc_textField_4);
		
		lblTngSGiao = new JLabel("Tổng số giao dịch :");
		lblTngSGiao.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		GridBagConstraints gbc_lblTngSGiao = new GridBagConstraints();
		gbc_lblTngSGiao.anchor = GridBagConstraints.EAST;
		gbc_lblTngSGiao.insets = new Insets(0, 0, 5, 5);
		gbc_lblTngSGiao.gridx = 0;
		gbc_lblTngSGiao.gridy = 6;
		contentPanel.add(lblTngSGiao, gbc_lblTngSGiao);
		
		textField_5 = new JTextField();
		textField_5.setText("text");
		textField_5.setEditable(false);
		textField_5.setDisabledTextColor(Color.BLACK);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 4;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 1;
		gbc_textField_5.gridy = 6;
		contentPanel.add(textField_5, gbc_textField_5);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 7;
		contentPanel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID", "STT", "Ng\u00E0y giao d\u1ECBch", "M\u00E3 phi\u1EBFu thu/chi", "Gi\u00E1 tr\u1ECB phi\u00EAn giao d\u1ECBch"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, Object.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(1).setMinWidth(30);
		table.getColumnModel().getColumn(1).setMaxWidth(999);
		table.getColumnModel().getColumn(2).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setMinWidth(150);
		table.getColumnModel().getColumn(2).setMaxWidth(950);
		table.getColumnModel().getColumn(3).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setMinWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(250);
		table.getColumnModel().getColumn(4).setMinWidth(150);
		table.getColumnModel().getColumn(4).setMaxWidth(990);
		scrollPane.setRowHeaderView(table);
		

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
		gbc_panel8.gridy = 8;
		contentPanel.add(panel_NhanVien, gbc_panel8);
	}
}
