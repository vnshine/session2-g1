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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import myobject.DoiTac;
import process.QLDoiTacProcess;

public class QuanLiNhomHang extends JInternalFrame implements ActionListener {
	public QuanLiNhomHang() {
		setTitle("Qu\u1EA3n l\u00ED nh\u00F3m h\u00E0ng");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_DuLieu = new JPanel();
		getContentPane().add(panel_DuLieu, BorderLayout.NORTH);
		panel_DuLieu.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "D\u1EEF Li\u1EC7u", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagLayout gbl_panel_DuLieu = new GridBagLayout();
		gbl_panel_DuLieu.columnWidths = new int[]{0, 0, 0};
		gbl_panel_DuLieu.rowHeights = new int[]{0, 50, 0, 0};
		gbl_panel_DuLieu.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_DuLieu.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_DuLieu.setLayout(gbl_panel_DuLieu);
		
		JLabel lblTnNhmHng = new JLabel("T\u00EAn nh\u00F3m h\u00E0ng :");
		GridBagConstraints gbc_lblTnNhmHng = new GridBagConstraints();
		gbc_lblTnNhmHng.anchor = GridBagConstraints.EAST;
		gbc_lblTnNhmHng.insets = new Insets(0, 0, 5, 5);
		gbc_lblTnNhmHng.gridx = 0;
		gbc_lblTnNhmHng.gridy = 0;
		panel_DuLieu.add(lblTnNhmHng, gbc_lblTnNhmHng);
		
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
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JPanel panel_TacVu = new JPanel();
		panel_TacVu.setBorder(new TitledBorder(null, "T\u00E1c V\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_TacVu = new GridBagConstraints();
		gbc_panel_TacVu.gridwidth = 2;
		gbc_panel_TacVu.fill = GridBagConstraints.BOTH;
		gbc_panel_TacVu.gridx = 0;
		gbc_panel_TacVu.gridy = 2;
		panel_DuLieu.add(panel_TacVu, gbc_panel_TacVu);
		
		btnThm = new JButton("Th\u00EAm");
		panel_TacVu.add(btnThm);
		
		btnSa = new JButton("S\u1EEDa");
		panel_TacVu.add(btnSa);
		
		btnXa = new JButton("X\u00F3a");
		panel_TacVu.add(btnXa);
		
		btnLu = new JButton("L\u01B0u");
		panel_TacVu.add(btnLu);
		
		btnHy = new JButton("H\u1EE7y");
		panel_TacVu.add(btnHy);
		
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
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"STT", "T\u00EAn nh\u00F3m h\u00E0ng", "Ghi ch\u00FA", "ID"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(450);
		table.getColumnModel().getColumn(3).setPreferredWidth(0);
		table.getColumnModel().getColumn(3).setMinWidth(0);
		table.getColumnModel().getColumn(3).setMaxWidth(0);
		scrollPane_1.setViewportView(table);
		
		JPanel panel_PhanTrang = new JPanel();
		getContentPane().add(panel_PhanTrang, BorderLayout.SOUTH);
		comboBox_SoTrang = new JComboBox();
		comboBox_SoTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(comboBox_SoTrang.getSelectedItem());
				soTrang = (Integer) comboBox_SoTrang.getSelectedItem();
				loaddata();
				comboBox_SoTrang.setSelectedItem(soTrang);
				
			}
		});
		btnTrc = new JButton("Tr\u01B0\u1EDBc");
		btnTrc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_SoTrang.setSelectedItem(soTrang-1);
			}
		});
		panel_PhanTrang.add(btnTrc);
		panel_PhanTrang.add(comboBox_SoTrang);
		
		btnSau = new JButton("Sau");
		btnSau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_SoTrang.setSelectedItem(soTrang+1);
			}
		});
		panel_PhanTrang.add(btnSau);
	}

	public void loaddata() {
		
	}
	
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private JTextField textField;
	private JTable table;
	private JButton btnSau,btnTrc,btnThm,btnSa,btnXa,btnLu,btnHy;
	private JComboBox comboBox_SoTrang;
	private Integer soTrang;

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
