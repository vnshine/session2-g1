package chucnang;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.TitledBorder;

import trangchu.TrangChu;

public class BanHang extends JPanel {
	
	private JPanel plNorth,plCenter,plSouth;
	private JTextField txtTenNPP;
	private JTextField txtDiaChi;
	private JTextField txtMa;
	private JTextField txtDienThoai;
	private JTextField txtTenNV;
	private JTextField txtThanhToan;
	private JTextField txtHanThanhToan;
	private JTextField txtTong;
	private JButton btnThem,btnSua,btnXoa;
	String[][] data = {{"","(Gõ vào đây)","","","","",""}};
    String[] colunms = {"Mã Hàng","Tên Hàng","Kho Hàng","Đơn Vị","Đơn Giá","Số Lượng","Thành Tiền"};
	public BanHang(TrangChu trangchu) {
    	    	
    	this.setLayout(new BorderLayout(15,15));
    	plNorth = new JPanel();
		add(plNorth,BorderLayout.NORTH);
		GridBagLayout gbl_plNorth = new GridBagLayout();
		gbl_plNorth.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_plNorth.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_plNorth.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_plNorth.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		plNorth.setLayout(gbl_plNorth);
		
		//JLabel lblThongTin = new JLabel("Thông tin xuất hàng");
		plNorth.setBorder(new TitledBorder("Thông tin xuất hàng"));
		GridBagConstraints gbc_lblThongTin = new GridBagConstraints();
		gbc_lblThongTin.insets = new Insets(0, 0, 5, 5);
		gbc_lblThongTin.gridx = 0;
		gbc_lblThongTin.gridy = 1;
		//plNorth.add(lblThongTin, gbc_lblThongTin);
		
		JLabel lblTenNPP = new JLabel("Tên Khách Hàng: ");
		GridBagConstraints gbc_lblTenNPP = new GridBagConstraints();
		gbc_lblTenNPP.anchor = GridBagConstraints.WEST;
		gbc_lblTenNPP.insets = new Insets(0, 0, 5, 5);
		gbc_lblTenNPP.gridx = 1;
		gbc_lblTenNPP.gridy = 2;
		plNorth.add(lblTenNPP, gbc_lblTenNPP);
		
		txtTenNPP = new JTextField();
		GridBagConstraints gbc_txtTenNPP = new GridBagConstraints();
		gbc_txtTenNPP.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenNPP.gridwidth = 17;
		gbc_txtTenNPP.insets = new Insets(0, 0, 5, 5);
		gbc_txtTenNPP.gridx = 2;
		gbc_txtTenNPP.gridy = 2;
		plNorth.add(txtTenNPP, gbc_txtTenNPP);
		txtTenNPP.setColumns(10);
		
		
		JLabel lblMa = new JLabel("Mã: ");
		GridBagConstraints gbc_lblMa = new GridBagConstraints();
		gbc_lblMa.anchor = GridBagConstraints.WEST;
		gbc_lblMa.insets = new Insets(0, 0, 5, 5);
		gbc_lblMa.gridx = 20;
		gbc_lblMa.gridy = 2;
		plNorth.add(lblMa, gbc_lblMa);
		
		txtMa = new JTextField();
		GridBagConstraints gbc_txtMa = new GridBagConstraints();
		gbc_txtMa.gridwidth = 1;
		gbc_txtMa.insets = new Insets(0, 0, 5, 5);
		gbc_txtMa.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMa.gridx = 21;
		gbc_txtMa.gridy = 2;
		plNorth.add(txtMa, gbc_txtMa);
		txtMa.setColumns(10);
		
		JLabel lblDiaChi = new JLabel("Địa Chỉ: ");
		GridBagConstraints gbc_lblDiaChi = new GridBagConstraints();
		gbc_lblDiaChi.anchor = GridBagConstraints.WEST;
		gbc_lblDiaChi.insets = new Insets(0, 0, 5, 5);
		gbc_lblDiaChi.gridx = 1;
		gbc_lblDiaChi.gridy = 3;
		plNorth.add(lblDiaChi, gbc_lblDiaChi);
		
		txtDiaChi = new JTextField();
		GridBagConstraints gbc_txtDiaChi = new GridBagConstraints();
		gbc_txtDiaChi.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiaChi.gridwidth = 17;
		gbc_txtDiaChi.insets = new Insets(0, 0, 5, 5);
		gbc_txtDiaChi.gridx = 2;
		gbc_txtDiaChi.gridy = 3;
		plNorth.add(txtDiaChi, gbc_txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblDienThoai = new JLabel("Điện Thoại: ");
		GridBagConstraints gbc_lblDienThoai = new GridBagConstraints();
		gbc_lblDienThoai.anchor = GridBagConstraints.WEST;
		gbc_lblDienThoai.insets = new Insets(0, 0, 5, 5);
		gbc_lblDienThoai.gridx = 20;
		gbc_lblDienThoai.gridy = 3;
		plNorth.add(lblDienThoai, gbc_lblDienThoai);
		
		txtDienThoai = new JTextField();
		GridBagConstraints gbc_txtDienThoai = new GridBagConstraints();
		gbc_txtDienThoai.gridwidth = 1;
		gbc_txtDienThoai.insets = new Insets(0, 0, 5, 5);
		gbc_txtDienThoai.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDienThoai.gridx = 21;
		gbc_txtDienThoai.gridy = 3;
		plNorth.add(txtDienThoai, gbc_txtDienThoai);
		txtDienThoai.setColumns(10);
		
		JLabel lblTenNN = new JLabel("Nhân Viên Nhận Hàng: ");
		GridBagConstraints gbc_lblTenNN = new GridBagConstraints();
		gbc_lblTenNN.anchor = GridBagConstraints.WEST;
		gbc_lblTenNN.insets = new Insets(0, 0, 5, 5);
		gbc_lblTenNN.gridx = 1;
		gbc_lblTenNN.gridy = 4;
		plNorth.add(lblTenNN, gbc_lblTenNN);
		
		txtTenNV = new JTextField();
		GridBagConstraints gbc_txtTenNV = new GridBagConstraints();
		gbc_txtTenNV.gridwidth = 17;
		gbc_txtTenNV.insets = new Insets(0, 0, 5, 5);
		gbc_txtTenNV.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenNV.gridx = 2;
		gbc_txtTenNV.gridy = 4;
		plNorth.add(txtTenNV, gbc_txtTenNV);
		txtTenNV.setColumns(10);
		
		JLabel lblNgay = new JLabel("Ngày: ");
		GridBagConstraints gbc_lblNgay = new GridBagConstraints();
		gbc_lblNgay.anchor = GridBagConstraints.WEST;
		gbc_lblNgay.insets = new Insets(0, 0, 5, 5);
		gbc_lblNgay.gridx = 20;
		gbc_lblNgay.gridy = 4;
		plNorth.add(lblNgay, gbc_lblNgay);
			
		GridBagConstraints gbc_txtNgay = new GridBagConstraints();
		gbc_txtNgay.gridwidth = 1;
		gbc_txtNgay.insets = new Insets(0, 0, 5, 5);
		gbc_txtNgay.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNgay.gridx = 21;
		gbc_txtNgay.gridy = 4;
		//Lay gio he thong
        Date todayD=new Date(System.currentTimeMillis()); 
        //Khai bao dinh dang ngay thang
        SimpleDateFormat dayFormat= new SimpleDateFormat("dd/MM/yyyy"); 
        //parse ngay thang sang dinh dang va chuyen thanh string.
        String todayS=dayFormat.format(todayD.getTime());
        JFormattedTextField defaultDateField = new JFormattedTextField(todayS);
        this.plNorth.add(defaultDateField,gbc_txtNgay);
		
		
		
		
		JLabel lblThanhToan = new JLabel("Điều Khoản Thanh Toán:");
		GridBagConstraints gbc_lblThanhToan = new GridBagConstraints();
		gbc_lblThanhToan.anchor = GridBagConstraints.WEST;
		gbc_lblThanhToan.insets = new Insets(0, 0, 0, 5);
		gbc_lblThanhToan.gridx = 1;
		gbc_lblThanhToan.gridy = 5;
		plNorth.add(lblThanhToan, gbc_lblThanhToan);
		
		txtThanhToan = new JTextField();
		GridBagConstraints gbc_txtThanhToan = new GridBagConstraints();
		gbc_txtThanhToan.gridwidth = 17;
		gbc_txtThanhToan.insets = new Insets(0, 0, 0, 5);
		gbc_txtThanhToan.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtThanhToan.gridx = 2;
		gbc_txtThanhToan.gridy = 5;
		plNorth.add(txtThanhToan, gbc_txtThanhToan);
		txtThanhToan.setColumns(10);
		
		JLabel lblHanThanhToan = new JLabel("Hạn Thanh Toán:");
		GridBagConstraints gbc_lblHanThanhToan = new GridBagConstraints();
		gbc_lblHanThanhToan.anchor = GridBagConstraints.WEST;
		gbc_lblHanThanhToan.insets = new Insets(0, 0, 0, 5);
		gbc_lblHanThanhToan.gridx = 20;
		gbc_lblHanThanhToan.gridy = 5;
		plNorth.add(lblHanThanhToan, gbc_lblHanThanhToan);
		
		txtHanThanhToan = new JTextField();
		GridBagConstraints gbc_txtHanThanhToan = new GridBagConstraints();
		gbc_txtHanThanhToan.gridwidth = 1;
		gbc_txtHanThanhToan.insets = new Insets(0, 0, 0, 5);
		gbc_txtHanThanhToan.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtHanThanhToan.gridx = 21;
		gbc_txtHanThanhToan.gridy = 5;
		plNorth.add(txtHanThanhToan, gbc_txtHanThanhToan);
		txtHanThanhToan.setColumns(10);
    	
		plCenter = new JPanel();
		plCenter.setLayout(new BorderLayout());
		add(plCenter,BorderLayout.CENTER);
		
		JTable table = new JTable(data,colunms);
		
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		
		plCenter.add(new JScrollPane(table));
		
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
