package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import myobject.TienTe;

import process.TienTe_Process;


public class TienTe_View extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	DefaultTableModel model;
	private JScrollPane danhSach;
	private JTable tbl;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTabbedPane tabbedPane;
	private Integer row = null;
	private String id = null;
	private JButton[] btnSua;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TienTe_View frame = new TienTe_View();
					frame.setVisible(true);
					frame.loadData();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TienTe_View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Font f = new Font("Tahoma", 0, 20);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setPreferredSize(new Dimension(800,100));
		
		JLabel lblNewLabel = new JLabel("Tien Te");
		lblNewLabel.setFont(f);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
//		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(650, 420));
//		tabbedPane.addTab("Them", null, panel_3, null);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		Object[][] rowData = {};
		String[] columnNames = {"ID","MÃƒ TIá»€N Tá»†","MUA VÃ€O","BÃ�N RA","Sá»¬A","XÃ“A"};
		model = new DefaultTableModel(rowData, columnNames); // assign data for table
		
		danhSach = new JScrollPane();
		tbl = new JTable(model);
		tbl.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tbl.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		danhSach.setColumnHeaderView(tbl);
		danhSach.setBounds(10,11,593,189);
		panel_3.add(danhSach);
		
		JLabel lblMTinT = new JLabel("MÃ£ tiá»�n tá»‡");
		lblMTinT.setBounds(209, 216, 86, 14);
		panel_3.add(lblMTinT);
		
		textField = new JTextField();
		textField.setBounds(391, 213, 86, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblMuaVo = new JLabel("Mua vÃ o");
		lblMuaVo.setBounds(209, 247, 46, 14);
		panel_3.add(lblMuaVo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(380, 244, 86, 20);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBnRa = new JLabel("BÃ¡n ra");
		lblBnRa.setBounds(209, 340, 46, 14);
		panel_3.add(lblBnRa);
		
		textField_2 = new JTextField();
		textField_2.setBounds(324, 334, 86, 20);
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnThm = new JButton("ThÃªm");
		btnThm.addActionListener(this);
		btnThm.setActionCommand("ThÃªm");
		btnThm.setBounds(179, 386, 89, 23);
		panel_3.add(btnThm);
		
		JButton btnHy = new JButton("Há»§y");
		btnHy.addActionListener(this);
		btnHy.setActionCommand("Há»§y");
		btnHy.setBounds(337, 386, 89, 23);
		panel_3.add(btnHy);
		
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(650, 420));
//		tabbedPane.addTab("XÃ³a", null, panel_4, null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(650, 420));
		panel_5.setLayout(new BorderLayout());
//		tabbedPane.addTab("Sá»­a", null, panel_5, null);
//		tabbedPane.setSelectedIndex(0);
		
		JPanel panel_6 = new JPanel();
		panel_6.setPreferredSize(new Dimension(650, 220));
		panel_5.add(panel_6, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		
		JTree tree = new JTree();
		panel_2.add(tree);
		tree.setPreferredSize(new Dimension(100,500));
		
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(null);
		panel_7.setPreferredSize(new Dimension(650, 220));
		
		JLabel lblTimkiem = new JLabel("TÃ¬m kiáº¿m");
		lblTimkiem.setBounds(145, 37, 46, 14);
		panel_7.add(lblTimkiem);
		
		textField_3 = new JTextField();
		textField_3.setBounds(247, 34, 86, 20);
		panel_7.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnTim = new JButton("Tra");
		btnTim.addActionListener(this);
		btnTim.setActionCommand("Tra");
		btnTim.setBounds(405, 33, 89, 23);
		panel_7.add(btnTim);
		
		JButton btnLaysolieu = new JButton("Láº¥y sá»‘ liá»‡u");
		btnLaysolieu.addActionListener(this);
		btnLaysolieu.setActionCommand("Láº¥y sá»‘ liá»‡u");
		btnLaysolieu.setBounds(306, 65, 89, 23);
		panel_7.add(btnLaysolieu);
		
		JLabel lblMa = new JLabel("MÃ£");
		lblMa.setBounds(145, 99, 46, 14);
		panel_7.add(lblMa);
		
		textField_5 = new JTextField();
		textField_5.setBounds(201, 96, 86, 20);
		panel_7.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblMua = new JLabel("Mua vÃ o");
		lblMua.setBounds(297, 99, 46, 14);
		panel_7.add(lblMua);
		
		textField_6 = new JTextField();
		textField_6.setBounds(350, 96, 86, 20);
		panel_7.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblBan = new JLabel("BÃ¡n ra");
		lblBan.setBounds(448, 99, 46, 14);
		panel_7.add(lblBan);
		
		textField_7 = new JTextField();
		textField_7.setBounds(525, 96, 86, 20);
		panel_7.add(textField_7);
		textField_7.setColumns(10);
		
//		JButton btnSua = new JButton("Sá»­a");
//		btnSua.addActionListener(this);
//		btnSua.setActionCommand("Sá»­a");
//		btnSua.setBounds(306, 127, 89, 23);
//		panel_7.add(btnSua);
		
	}
	
	public void loadData(){
			DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
			dtm.getDataVector().removeAllElements();
			dtm.fireTableChanged(null);
			TienTe_Process process = new TienTe_Process();
			Vector<TienTe> u = new Vector<TienTe>();
			u = process.showList();
			btnSua = new JButton[u.size()];
			for (int i = 0; i < u.size(); i++) {
				TienTe tienTe =(TienTe) u.get(i);
				btnSua[i] = new JButton("Sá»­a");
				Object[] rowData = {tienTe.getIdTienTe(),tienTe.getTenTienTe(),tienTe.getTyGiaMuaVao(),tienTe.getTyGiaBanRa()};
				model.insertRow(i, rowData);
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Há»§y")) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
		}
		if (e.getActionCommand().equals("ThÃªm")) {
			if (textField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(this, "Cáº§n pháº£i nháº­p cÃ¢u mÃ£ tiá»�n tá»‡");
				return;
			}
			TienTe_Process process = new TienTe_Process();
			process.insertTienTe(textField.getText(),Float.parseFloat(textField_1.getText()),Float.parseFloat(textField_2.getText()));
			loadData();
		}
		if (e.getActionCommand().equals("Láº¥y sá»‘ liá»‡u")) {
			row = tbl.getSelectedRow();
			id = (String) tbl.getValueAt(row, 0);
			textField_5.setText((String)tbl.getValueAt(row, 1));
			String mua = String.valueOf(tbl.getValueAt(row, 2));
			String ban = String.valueOf(tbl.getValueAt(row, 3));
			textField_6.setText(mua);
			textField_7.setText(ban);
		}
		if (e.getActionCommand().equals("Sá»­a")) {
			TienTe_Process process = new TienTe_Process();
			process.updateTienTe(id,textField_5.getText(),Float.parseFloat(textField_6.getText()),Float.parseFloat(textField_7.getText()));
			loadData();
		}
		
		
	}
}
