package view;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;
import java.awt.Component;

public class QuanLiDoiTac extends JInternalFrame {

	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
	private JTable table;
	private JTextField textField_MaDT;
	private JTextField textField_TenDT;
	private JTextField textField_NLH;
	private JTextField textField_SoDT;
	private JTextField textField_DiaChiDT;
	private JTextField textField_GhiChuDT;
	private JTextField textField_SoTrang;

	

	/**
	 * Create the frame.
	 */
	public QuanLiDoiTac() {
		Toolkit tk = Toolkit.getDefaultToolkit();  
		int xSize = ((int) tk.getScreenSize().getWidth());  
		int ySize = ((int) tk.getScreenSize().getHeight());  
		
		
		setTitle("Qu\u1EA3n l\u00ED \u0111\u1ED1i t\u00E1c");
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		Box verticalBox = Box.createVerticalBox();
		panel_1.add(verticalBox);
		
		JPanel panel_DuLieu = new JPanel();
		panel_DuLieu.setBorder(new TitledBorder(null, "D\u1EEF li\u1EC7u", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		verticalBox.add(panel_DuLieu);
		
		Box verticalBox_1 = Box.createVerticalBox();
		panel_DuLieu.add(verticalBox_1);
		
		JPanel panel_DL1 = new JPanel();
		verticalBox_1.add(panel_DL1);
		
		JLabel lblMiTc = new JLabel("M\u00E3 \u0111\u1ED1i t\u00E1c: ");
		panel_DL1.add(lblMiTc);
		
		textField_MaDT = new JTextField();
		panel_DL1.add(textField_MaDT);
		textField_MaDT.setColumns(10);
		
		JLabel lblTniTc = new JLabel("T\u00EAn \u0111\u1ED1i t\u00E1c: ");
		panel_DL1.add(lblTniTc);
		
		textField_TenDT = new JTextField();
		panel_DL1.add(textField_TenDT);
		textField_TenDT.setColumns(15);
		
		JLabel lblNgiLinH_1 = new JLabel("Ng\u01B0\u1EDDi li\u00EAn h\u1EC7: ");
		panel_DL1.add(lblNgiLinH_1);
		
		textField_NLH = new JTextField();
		panel_DL1.add(textField_NLH);
		textField_NLH.setColumns(15);
		
		JLabel lblSinThoi = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i: ");
		panel_DL1.add(lblSinThoi);
		
		textField_SoDT = new JTextField();
		panel_DL1.add(textField_SoDT);
		textField_SoDT.setColumns(15);
		
		JPanel panel_DL2 = new JPanel();
		verticalBox_1.add(panel_DL2);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9: ");
		panel_DL2.add(lblaCh);
		
		textField_DiaChiDT = new JTextField();
		panel_DL2.add(textField_DiaChiDT);
		textField_DiaChiDT.setColumns(30);
		
		JLabel lblGhiCh = new JLabel("Ghi ch\u00FA: ");
		panel_DL2.add(lblGhiCh);
		
		textField_GhiChuDT = new JTextField();
		panel_DL2.add(textField_GhiChuDT);
		textField_GhiChuDT.setColumns(30);
		
		JPanel panel_TacVu = new JPanel();
		panel_TacVu.setBorder(new TitledBorder(null, "T\u00E1c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		verticalBox.add(panel_TacVu);
		
		JButton btnThm = new JButton("Th\u00EAm");
		panel_TacVu.add(btnThm);
		
		JButton btnSa = new JButton("S\u1EEDa");
		panel_TacVu.add(btnSa);
		
		JButton btnXa = new JButton("X\u00F3a");
		panel_TacVu.add(btnXa);
		
		JButton btnTmKim = new JButton("T\u00ECm ki\u1EBFm");
		panel_TacVu.add(btnTmKim);
		
		JButton btnLu = new JButton("L\u01B0u");
		panel_TacVu.add(btnLu);
		
		JButton btnHy = new JButton("H\u1EE7y");
		panel_TacVu.add(btnHy);
		
		JPanel panel_DanhSach = new JPanel();
		panel_DanhSach.setBorder(new TitledBorder(null, "Danh s\u00E1ch \u0111\u1ED1i t\u00E1c", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		verticalBox.add(panel_DanhSach);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_DanhSach.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, "", null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 \u0111\u1ED1i t\u00E1c", "T\u00EAn \u0111\u1ED1i t\u00E1c", "Ng\u01B0\u1EDDi li\u00EAn h\u1EC7", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(350);
		table.getColumnModel().getColumn(3).setPreferredWidth(350);
		table.getColumnModel().getColumn(4).setPreferredWidth(400);
		table.getColumnModel().getColumn(5).setPreferredWidth(300);
		scrollPane.setViewportView(table);
		
		JPanel panel_XemTrang = new JPanel();
		verticalBox.add(panel_XemTrang);
		
		JButton btnBack = new JButton("Back");
		panel_XemTrang.add(btnBack);
		
		textField_SoTrang = new JTextField();
		panel_XemTrang.add(textField_SoTrang);
		textField_SoTrang.setColumns(3);
		
		JButton btnNext = new JButton("Next");
		panel_XemTrang.add(btnNext);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{643, 63, 0};
		gbl_panel_2.rowHeights = new int[]{14, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblCreateBy = new JLabel("Create by ...");
		GridBagConstraints gbc_lblCreateBy = new GridBagConstraints();
		gbc_lblCreateBy.insets = new Insets(0, 0, 0, 5);
		gbc_lblCreateBy.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblCreateBy.gridx = 0;
		gbc_lblCreateBy.gridy = 0;
		panel_2.add(lblCreateBy, gbc_lblCreateBy);

	}
	
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
		installLnF();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLiDoiTac frame = new QuanLiDoiTac();
					frame.setVisible(true);
					frame.pack();
					JFrame mainf = new JFrame();
					mainf.getContentPane().add(frame);
					mainf.setVisible(true);
					mainf.pack();
					mainf.setExtendedState(Frame.MAXIMIZED_BOTH);  // full screen
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
