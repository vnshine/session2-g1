package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.LookAndFeel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import module.SetCenter;
import javax.swing.JTable;

import admin.LoginForm;

import process.QuyenProcess;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewQuanLyQuyen extends JFrame 
{

	private JPanel contentPane;
	private JTextField textField;
	private JTable tblDanhSach;

	/*
	 * User Define
	 */
	
	DefaultTableModel model = null;
    Object[][] rowData = {};
    String[] columnNames = {};
    
    String action; //Biến ghi nhận người dùng nhấn vào nút nào

    QuyenProcess processAction;
    String ten, ghichu;
    String old_name;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ViewQuanLyQuyen frame = new ViewQuanLyQuyen();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewQuanLyQuyen() {
		
		try 
		{
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
		catch (Exception unused) 
		{
	        JOptionPane.showMessageDialog(this,"Không thể áp dụng giao diện: \"System Look and Feel\"", "Lỗi giao diện",JOptionPane.ERROR_MESSAGE);
	    }
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panHead = new JPanel();
		panHead.setBackground(new Color(255, 255, 224));
		panHead.setBorder(null);
		panHead.setBounds(0, 0, 784, 100);
		contentPane.add(panHead);
		
		JPanel panBody = new JPanel();
		panBody.setBackground(new Color(230, 230, 250));
		panBody.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(128, 128, 128)));
		panBody.setBounds(0, 100, 784, 424);
		contentPane.add(panBody);
		panBody.setLayout(null);
		
		JPanel panAction = new JPanel();
		panAction.setBorder(new MatteBorder(2, 0, 2, 0, (Color) new Color(192, 192, 192)));
		panAction.setBackground(new Color(230, 230, 250));
		panAction.setBounds(0, 116, 784, 43);
		panBody.add(panAction);
		panAction.setLayout(null);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBounds(10, 11, 70, 23);
		panAction.add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBounds(90, 11, 70, 23);
		panAction.add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBounds(170, 11, 70, 23);
		panAction.add(btnXoa);
		
		JButton btnTim = new JButton("Tìm kiếm");
		btnTim.setBounds(250, 11, 79, 23);
		panAction.add(btnTim);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBounds(339, 11, 79, 23);
		panAction.add(btnCapNhat);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setBounds(428, 11, 70, 23);
		panAction.add(btnLuu);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBounds(508, 11, 70, 23);
		panAction.add(btnHuy);
		
		JPanel panTieuDeDanhSach = new JPanel();
		panTieuDeDanhSach.setBorder(new TitledBorder(null, "Danh sách quyền", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panTieuDeDanhSach.setBackground(new Color(230, 230, 250));
		panTieuDeDanhSach.setBounds(0, 167, 784, 257);
		panBody.add(panTieuDeDanhSach);
		panTieuDeDanhSach.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(391, 21, 2, 2);
		panTieuDeDanhSach.add(scrollPane);
		
		JScrollPane panDanhSach = new JScrollPane();
		panDanhSach.setBounds(10, 21, 764, 231);
		panDanhSach.setLayout(null);
		panTieuDeDanhSach.add(panDanhSach);
		
		JPanel panFoot = new JPanel();
		panFoot.setBackground(new Color(255, 255, 224));
		panFoot.setBounds(0, 523, 784, 39);
		contentPane.add(panFoot);
		panFoot.setLayout(null);
		
		JButton btnThot = new JButton("Thoát");
		btnThot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn kết thúc chương trình?", "Kết thúc chương trình", JOptionPane.OK_CANCEL_OPTION) == 0)
				{
					dispose();
				}
			}
		});
		btnThot.setBounds(685, 11, 89, 23);
		panFoot.add(btnThot);
		
		JLabel lblTrangThai = new JLabel("");
		lblTrangThai.setForeground(Color.BLACK);
		lblTrangThai.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblTrangThai.setBounds(10, 15, 659, 14);
		panFoot.add(lblTrangThai);
		
		/*
		 * User INIT
		 */
				
		new SetCenter(this);
//        OnOffEdit(false);
        columnNames = new String[] {"Quyền", "Ghi chú"};
        model = new DefaultTableModel(rowData, columnNames);
        tblDanhSach = new JTable(model)
        {
            public boolean isCellEditable(int rowIndex, int colIndex) 
            {
                    return false; //Disallow the editing of any cell
            }
        };
        tblDanhSach.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblDanhSach.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        tblDanhSach.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        tblDanhSach.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        tblDanhSach.getColumnModel().getColumn(0).setPreferredWidth(100);
        
        panDanhSach.setViewportView(tblDanhSach);
        
        tblDanhSach = new JTable();
        panDanhSach.setColumnHeaderView(tblDanhSach);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 11, 784, 94);
        panBody.add(panel);
        panel.setBorder(null);
        panel.setLayout(null);
        panel.setBackground(new Color(230, 230, 250));
        
        JLabel lblTnQuyn = new JLabel("Tên quyền: * ");
        lblTnQuyn.setBounds(10, 11, 79, 14);
        panel.add(lblTnQuyn);
        
        textField = new JTextField();
        textField.setBounds(99, 8, 283, 20);
        panel.add(textField);
        textField.setColumns(10);
        
        JLabel lblGhiCh = new JLabel("Ghi chú:");
        lblGhiCh.setBounds(392, 11, 46, 14);
        panel.add(lblGhiCh);
        
        JTextArea txtaGhiChu = new JTextArea();
        txtaGhiChu.setBounds(448, 6, 326, 55);
        txtaGhiChu.setBorder(new LineBorder(new Color(192,192,192), 1));
        panel.add(txtaGhiChu);
        
        JLabel lblThongBao = new JLabel("* bắt buộc");
        lblThongBao.setFont(new Font("Tahoma", Font.ITALIC, 11));
        lblThongBao.setForeground(Color.BLACK);
        lblThongBao.setBounds(99, 72, 675, 14);
        panel.add(lblThongBao);

        processAction = new QuyenProcess();

        //Hien du lieu ra bang
//        FillToTable();
	}
}
