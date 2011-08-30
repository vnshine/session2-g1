package chucnang;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;



import trangchu.TrangChu;

public class LuanChuyen extends JPanel {

	private JPanel plNorth,plCenter,plSouth;
	private JComboBox txtTenNPP;
	private JTextField txtGhiChu;
	private JComboBox txtMa;
	private JTextField txtNgay;
	private JTextField txtTenNV;
	private JTextField txtThanhToan;
	private JTextField txtHanThanhToan;
	private JTextField txtTong;
	private JButton btnThem,btnSua,btnXoa;
	String[][] data = {{"","","","","","","",""}};
    String[] colunms = {"Mã Hàng","Hàng Hóa","Đơn Vị","Từ Kho","Đến Kho","Đơn Giá","Số Lượng","Thành Tiền"};
	public LuanChuyen(TrangChu trangchu) {
    	    	
    	this.setLayout(new BorderLayout(10,10));
    	plNorth = new JPanel();
		add(plNorth,BorderLayout.NORTH);
		GridBagLayout gbl_plNorth = new GridBagLayout();
		gbl_plNorth.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_plNorth.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_plNorth.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_plNorth.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		plNorth.setLayout(gbl_plNorth);
		
		//JLabel lblThongTin = new JLabel("Thông tin nhân viên");
		plNorth.setBorder(new TitledBorder("Thông tin nhân viên"));
		GridBagConstraints gbc_lblThongTin = new GridBagConstraints();
		gbc_lblThongTin.insets = new Insets(0, 0, 5, 5);
		gbc_lblThongTin.gridx = 0;
		gbc_lblThongTin.gridy = 1;
		//plNorth.add(lblThongTin, gbc_lblThongTin);
		
		JLabel lblTenNPP = new JLabel("Tên Nhân Viên: ");
		GridBagConstraints gbc_lblTenNPP = new GridBagConstraints();
		gbc_lblTenNPP.anchor = GridBagConstraints.WEST;
		gbc_lblTenNPP.insets = new Insets(0, 0, 5, 5);
		gbc_lblTenNPP.gridx = 1;
		gbc_lblTenNPP.gridy = 2;
		plNorth.add(lblTenNPP, gbc_lblTenNPP);
		
		txtTenNPP = new JComboBox();
		GridBagConstraints gbc_txtTenNPP = new GridBagConstraints();
		gbc_txtTenNPP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenNPP.gridwidth = 17;
		gbc_txtTenNPP.insets = new Insets(0, 0, 5, 5);
		gbc_txtTenNPP.gridx = 2;
		gbc_txtTenNPP.gridy = 2;
		plNorth.add(txtTenNPP, gbc_txtTenNPP);
		//txtTenNPP.setColumns(10);
		
		
		JLabel lblMa = new JLabel("Mã: ");
		GridBagConstraints gbc_lblMa = new GridBagConstraints();
		gbc_lblMa.anchor = GridBagConstraints.WEST;
		gbc_lblMa.insets = new Insets(0, 0, 5, 5);
		gbc_lblMa.gridx = 20;
		gbc_lblMa.gridy = 2;
		plNorth.add(lblMa, gbc_lblMa);
		
		txtMa = new JComboBox();
		GridBagConstraints gbc_txtMa = new GridBagConstraints();
		gbc_txtMa.gridwidth = 1;
		gbc_txtMa.insets = new Insets(0, 0, 5, 5);
		gbc_txtMa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMa.gridx = 21;
		gbc_txtMa.gridy = 2;
		plNorth.add(txtMa, gbc_txtMa);
		//txtMa.setColumns(10);
		
		JLabel lblGhiChu = new JLabel("Ghi Chú: ");
		GridBagConstraints gbc_lblGhiChu = new GridBagConstraints();
		gbc_lblGhiChu.anchor = GridBagConstraints.WEST;
		gbc_lblGhiChu.insets = new Insets(0, 0, 5, 5);
		gbc_lblGhiChu.gridx = 1;
		gbc_lblGhiChu.gridy = 3;
		plNorth.add(lblGhiChu, gbc_lblGhiChu);
		
		txtGhiChu = new JTextField();
		GridBagConstraints gbc_txtGhiChu = new GridBagConstraints();
		gbc_txtGhiChu.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGhiChu.gridwidth = 17;
		gbc_txtGhiChu.insets = new Insets(0, 0, 5, 5);
		gbc_txtGhiChu.gridx = 2;
		gbc_txtGhiChu.gridy = 3;
		plNorth.add(txtGhiChu, gbc_txtGhiChu);
		txtGhiChu.setColumns(10);
		
		JLabel lblNgay = new JLabel("Ngày: ");
		GridBagConstraints gbc_lblNgay = new GridBagConstraints();
		gbc_lblNgay.anchor = GridBagConstraints.WEST;
		gbc_lblNgay.insets = new Insets(0, 0, 5, 5);
		gbc_lblNgay.gridx = 20;
		gbc_lblNgay.gridy = 3;
		plNorth.add(lblNgay, gbc_lblNgay);
		

		GridBagConstraints gbc_txtNgay = new GridBagConstraints();
		gbc_txtNgay.gridwidth = 1;
		gbc_txtNgay.insets = new Insets(0, 0, 5, 5);
		gbc_txtNgay.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNgay.gridx = 21;
		gbc_txtNgay.gridy = 3;
		//Lay gio he thong
        Date todayD=new Date(System.currentTimeMillis()); 
        //Khai bao dinh dang ngay thang
        SimpleDateFormat dayFormat= new SimpleDateFormat("dd/MM/yyyy"); 
        //parse ngay thang sang dinh dang va chuyen thanh string.
        String todayS=dayFormat.format(todayD.getTime());
        JFormattedTextField defaultDateField = new JFormattedTextField(todayS);
        this.plNorth.add(defaultDateField,gbc_txtNgay);
        
        
        
		
    	
		plCenter = new JPanel();
		add(plCenter,BorderLayout.CENTER);
		plCenter.setLayout(new BorderLayout());
    	JScrollPane scrollPane = new JScrollPane();
    	plCenter.add(scrollPane);
		
		JTable table = new JTable(data,colunms);
		table.getColumn("Hàng Hóa").setCellRenderer(new ComboxRenderer());
		table.getColumn("Hàng Hóa").setCellEditor(new ComboxEditor(new JCheckBox()));
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(150);
		scrollPane.setViewportView(table);
		
		plSouth = new JPanel();
		plSouth.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(plSouth,BorderLayout.SOUTH);
		btnThem = new JButton("Thêm");
		plSouth.add(btnThem);
		btnSua = new JButton("Sửa");
		plSouth.add(btnSua);
		btnXoa = new JButton("Xóa");
		plSouth.add(btnXoa);
		JLabel lblTong = new JLabel("Thanh Toán: ");
		plSouth.add(lblTong);
		txtTong = new JTextField(50);
		plSouth.add(txtTong);
		
		
    }

}
